package com.appdirect.client.action;

import com.appdirect.client.AppDirectClient;
import com.appdirect.domain.event.subscription.SubscriptionOrderEvent;

public class GetSubscriptionOrderEventAction extends GetEventAction {

	public GetSubscriptionOrderEventAction(final AppDirectClient client) {
		super(client);
	}

	public ActionResult<SubscriptionOrderEvent> execute() {
		return execute(SubscriptionOrderEvent.class);
	}
}
