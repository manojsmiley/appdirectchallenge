package com.appdirect.client;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * The AppDirectClient handles all communication with AppDirect's APIs. It's primary purpose is to handle the low-level
 * communication details such as transport protocols and marshalling/unmarshalling.
 */

@Component
public class AppDirectClient {

	private static Logger log = Logger.getLogger(AppDirectClient.class);

	private OAuthConsumer oAuthConsumer;

	@Value(value = "${consumer.key:\"\"}")
	private String consumerKey;
	@Value(value = "${consumer.secret:\"\"}")
	private String secret;

	/**
	 * Signs a URL using client's OAuth credentials and performs a GET request
	 *
	 * @param url
	 *            the unsigned URL
	 * @param resultType
	 *            the result type returned
	 *
	 * @return the result
	 *
	 * @throws OAuthCommunicationException
	 * @throws OAuthExpectationFailedException
	 * @throws OAuthMessageSignerException
	 * @throws IOException
	 * @throws JAXBException
	 */
	public <T> T signAndGet(String url, Class<T> resultType)
			throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException, IOException, JAXBException {
		log.info("signed url = " + url);
		String signedUrl = signUrl(url);

		log.info("signed url = " + signedUrl);

		InputStream content = doGet(signedUrl);

		T result = null;

		if (content != null) {

			if (log.isDebugEnabled()) {
				String strContent = IOUtils.toString(content);
				log.debug(strContent);
				content = IOUtils.toInputStream(strContent);
			}

			result = parseResponse(content, resultType);
		} else {
			log.debug("Content from doGet() was null");
		}

		log.debug("result is: " + result);

		return result;
	}

	/**
	 * Good candidate to be extracted to its own class
	 */
	protected <T> T parseResponse(final InputStream content, final Class<T> resultType) throws JAXBException, IOException {

		T result = null;

		if (resultType.isAnnotationPresent(XmlRootElement.class)) {
			JAXBContext context = JAXBContext.newInstance(resultType);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			result = (T) unmarshaller.unmarshal(content);
		} else if (String.class.isAssignableFrom(resultType)) {
			result = (T) IOUtils.toString(content);
		}

		return result;
	}

	/**
	 * Good candidate to be extracted to its own class
	 */
	protected InputStream doGet(final String signedUrl) throws IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(signedUrl);
		HttpResponse response = client.execute(getRequest);

		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	public String signUrl(String url) throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException {
		return oAuthConsumer.sign(url);
	}

	@PostConstruct
	public void init() {
		if (StringUtils.isAnyBlank(consumerKey, secret)) {
			throw new IllegalArgumentException("No parameter can be null");
		}

		this.oAuthConsumer = new DefaultOAuthConsumer(consumerKey, secret);
	}
}
