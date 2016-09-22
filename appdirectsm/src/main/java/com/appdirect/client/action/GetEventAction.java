package com.appdirect.client.action;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appdirect.client.AppDirectClient;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class GetEventAction extends AppDirectAction {

	private static Logger log = LoggerFactory.getLogger(GetEventAction.class);

	private String token;
	private String url;

	public GetEventAction(final AppDirectClient client) {
		super(client);
	}

	@Override
	public <T> ActionResult<T> execute(Class<T> resultType) {
		ActionResult<T> result = new ActionResult();

		try {
			T event = getEvent(url, resultType);
			result.setEntity(event);
			result.setSuccess(true);

		} catch (JAXBException | IOException | OAuthExpectationFailedException | OAuthCommunicationException | OAuthMessageSignerException e) {
			log.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setErrorMessage(e.getMessage());
		}

		return result;
	}

	protected <T> T getEvent(final String url, final Class<T> clazz)
			throws JAXBException, OAuthExpectationFailedException, OAuthCommunicationException, OAuthMessageSignerException, IOException {
		return client.signAndGet(url, clazz);
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
