package com.appdirect.client.action;

import com.appdirect.client.AppDirectClient;
import com.appdirect.domain.event.access.UserAssignedEvent;

public class GetUserAssignedEventAction extends GetEventAction {

	public GetUserAssignedEventAction(final AppDirectClient client) {
		super(client);
	}

	public ActionResult<UserAssignedEvent> execute() {
		return super.execute(UserAssignedEvent.class);
	}
}
