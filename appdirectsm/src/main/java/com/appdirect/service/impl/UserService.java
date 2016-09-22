package com.appdirect.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.appdirect.domain.User;
import com.appdirect.domain.myapp.Profile;

/**
 * AppDirect user service
 */
@Service
public class UserService {

	/**
	 * Creates a profile from an AppDirect User
	 *
	 * @param user
	 *            an AppDirect user
	 * @return
	 */
	public Profile createProfile(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User can not be null");
		}

		if (StringUtils.isEmpty(user.getOpenId())) {
			throw new IllegalArgumentException("User's OpenId can not be empty");
		}

		Profile profile = new Profile();
		profile.setFirstName(user.getFirstName());
		profile.setLastName(user.getLastName());
		profile.setEmail(user.getEmail());
		profile.setOpenId(user.getOpenId());

		return profile;
	}
}
