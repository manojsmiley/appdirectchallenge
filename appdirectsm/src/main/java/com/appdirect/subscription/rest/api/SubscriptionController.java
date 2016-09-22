package com.appdirect.subscription.rest.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.request.AppdirectRequest;
import com.appdirect.request.SubscriptionTransaction;
import com.appdirect.response.AppdirectResponse;
import com.appdirect.response.Response;
import com.appdirect.response.ServerError;
import com.appdirect.service.SubscriptionService;
import com.appdirect.subscription.constants.Constants;
import com.appdirect.subscription.utility.AppdirectUtils;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	private final Logger LOG = Logger.getLogger(SubscriptionController.class);

	@RequestMapping(value = "/subscription/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AppdirectResponse<?>> create(@RequestBody AppdirectRequest<SubscriptionTransaction> request,
			@RequestHeader HttpHeaders header) {

		LOG.info("Request Body" + request.getRequest().toString());
		boolean status = false;

		Response response = new Response();
		try {
			if (request.getRequest() != null) {
				status = subscriptionService.insert(request.getRequest());
				response.setMessage(AppdirectUtils.getStatusMessage(status) + ":transactionId=" + request.getRequest().getTransactionid());
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.OK);
			} else {
				response.setMessage(AppdirectUtils.getStatusMessage(status));
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<AppdirectResponse<?>>(
					new AppdirectResponse<ServerError>(
							new ServerError(Constants.SERVER_ERROR_CODE, Constants.SERVER_ERROR_MSG, Constants.SERVER_ERROR_MSG)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/subscription/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody AppdirectRequest<SubscriptionTransaction> request, @RequestHeader HttpHeaders header) {
		boolean status = false;
		LOG.info("Request Body" + request.getRequest().toString());
		Response response = new Response();
		try {
			if (request.getRequest() != null) {
				status = subscriptionService.update(request.getRequest());
				response.setMessage(AppdirectUtils.getStatusMessage(status));
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.OK);
			} else {
				response.setMessage(AppdirectUtils.getStatusMessage(status));
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<AppdirectResponse<?>>(
					new AppdirectResponse<ServerError>(
							new ServerError(Constants.SERVER_ERROR_CODE, Constants.SERVER_ERROR_MSG, Constants.SERVER_ERROR_MSG)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/subscription/cancel/{transactionId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> cancel(@PathVariable String transactionId, @RequestHeader HttpHeaders header) {
		boolean status = false;

		Response response = new Response();
		try {
			if (!StringUtils.isEmpty(transactionId)) {
				status = subscriptionService.cancel(transactionId);
				response.setMessage(AppdirectUtils.getStatusMessage(status));
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.OK);
			} else {
				response.setMessage(AppdirectUtils.getStatusMessage(status));
				response.setCode(AppdirectUtils.getStatusCode(status));
				return new ResponseEntity<AppdirectResponse<?>>(new AppdirectResponse<Response>(response), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<AppdirectResponse<?>>(
					new AppdirectResponse<ServerError>(
							new ServerError(Constants.SERVER_ERROR_CODE, Constants.SERVER_ERROR_MSG, Constants.SERVER_ERROR_MSG)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/subscription/get/{transactionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable String transactionId, @RequestHeader HttpHeaders header) {
		SubscriptionTransaction transaction = null;

		try {
			if (transactionId != null)
				transaction = subscriptionService.get(transactionId);
			else
				new IllegalArgumentException("transactionId");

		} catch (Exception e) {
			return new ResponseEntity<ServerError>(new ServerError(Constants.SERVER_ERROR_CODE, Constants.SERVER_ERROR_MSG, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SubscriptionTransaction>(transaction, HttpStatus.OK);

	}
}
