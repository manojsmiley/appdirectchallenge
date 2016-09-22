package com.appdirect.client.action;

import com.appdirect.client.AppDirectClient;

public abstract class AppDirectAction implements IAppDirectAction {

    protected AppDirectClient client;

    public AppDirectAction(AppDirectClient client) {
        this.client = client;
    }
}
