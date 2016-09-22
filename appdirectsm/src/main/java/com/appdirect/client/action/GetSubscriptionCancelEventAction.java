package com.appdirect.client.action;

import com.appdirect.client.AppDirectClient;
import com.appdirect.domain.event.subscription.SubscriptionCancelEvent;

public class GetSubscriptionCancelEventAction extends GetEventAction {

	public GetSubscriptionCancelEventAction(final AppDirectClient client) {
		super(client);
	}

	public ActionResult<SubscriptionCancelEvent> execute() {
		return execute(SubscriptionCancelEvent.class);
	}
}
