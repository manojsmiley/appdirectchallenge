package com.appdirect.client.action;

import com.appdirect.client.AppDirectClient;
import com.appdirect.domain.event.access.UserUnassignedEvent;

public class GetUserUnassignedEventAction extends GetEventAction {

	public GetUserUnassignedEventAction(final AppDirectClient client) {
		super(client);
	}

	public ActionResult<UserUnassignedEvent> execute() {
		return super.execute(UserUnassignedEvent.class);
	}
}
