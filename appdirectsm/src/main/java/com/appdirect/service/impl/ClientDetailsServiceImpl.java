package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.BaseClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import com.appdirect.subscription.dao.OauthRepositoryDao;

@Component(value = "clientDetails")
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private OauthRepositoryDao oauthRepository;

	@Override
	public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
		BaseClientDetails clientDetails = oauthRepository.getByClientId(s);
		return clientDetails;
	}
}
