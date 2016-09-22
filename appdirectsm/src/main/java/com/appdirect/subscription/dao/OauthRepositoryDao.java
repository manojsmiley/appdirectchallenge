package com.appdirect.subscription.dao;

import org.springframework.security.oauth2.provider.BaseClientDetails;

public interface OauthRepositoryDao {

	BaseClientDetails getByClientId(String clientId);

}
