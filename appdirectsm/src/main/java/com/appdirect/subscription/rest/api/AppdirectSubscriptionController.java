package com.appdirect.subscription.rest.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appdirect.client.AppDirectClient;
import com.appdirect.client.action.ActionResult;
import com.appdirect.client.action.GetSubscriptionCancelEventAction;
import com.appdirect.client.action.GetSubscriptionOrderEventAction;
import com.appdirect.domain.User;
import com.appdirect.domain.appdirect.event.EventResult;
import com.appdirect.domain.event.subscription.SubscriptionCancelEvent;
import com.appdirect.domain.event.subscription.SubscriptionOrderEvent;
import com.appdirect.domain.myapp.Profile;
import com.appdirect.service.impl.UserService;
/**
 * 
 * @author Manoj.kumar
 *
 */
@RestController
@RequestMapping("/appdirect")
public class AppdirectSubscriptionController {

	private static final Logger LOG = Logger.getLogger(AppdirectSubscriptionController.class);

	@Autowired
	private AppDirectClient appDirectClient;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/subscription/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createSubscription(HttpServletRequest request, @RequestParam(value = "url", required = false) String url,
			@RequestParam(value = "token", required = false) String token) {
		Profile profile = null;
		try {
			GetSubscriptionOrderEventAction action = new GetSubscriptionOrderEventAction(appDirectClient);
			action.setUrl(url);
			action.setToken(token);
			ActionResult<SubscriptionOrderEvent> actionResult = action.execute();

			SubscriptionOrderEvent event = actionResult.getEntity();
			User user = event.getCreator();

			profile = userService.createProfile(user);
		} catch (Exception e) {
			LOG.error(e);
		}
		// return result XML
		EventResult result = new EventResult();
		result.setAccountIdentifier("appdirecttech");
		result.setMessage("Welcome to AppDirect!");
		result.setSuccess(profile != null);

		return new ResponseEntity<EventResult>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/subscription/cancel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> cancelSubscription(HttpServletRequest request, @RequestParam(value = "url", required = false) String url,
			@RequestParam(value = "token", required = false) String token) {
		SubscriptionCancelEvent event = null;
		try {
			// get event details
			GetSubscriptionCancelEventAction action = new GetSubscriptionCancelEventAction(appDirectClient);
			action.setUrl(url);
			action.setToken(token);
			event = action.execute().getEntity();

			// TODO: delete all accounts in system tied to this accountId
		} catch (Exception e) {
			LOG.error(e);
			event = new SubscriptionCancelEvent();
		}
		// return result XML
		EventResult result = new EventResult();
		result.setMessage(event == null ? "NA" : event.toString());
		result.setSuccess(true);

		return new ResponseEntity<EventResult>(result, HttpStatus.OK);
	}

}
