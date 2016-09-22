package com.appdirect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdirect.request.SubscriptionTransaction;
import com.appdirect.service.SubscriptionService;
import com.appdirect.subscription.dao.ISubscriptionDao;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private ISubscriptionDao subscriptionDao;

	@Override
	public boolean insert(SubscriptionTransaction subscriptionTransaction) {
		// TODO Auto-generated method stub
		return subscriptionDao.insert(subscriptionTransaction);
	}

	@Override
	public boolean update(SubscriptionTransaction subscriptionTransaction) {
		// TODO Auto-generated method stub
		return subscriptionDao.update(subscriptionTransaction);
	}

	@Override
	public boolean cancel(String transactionId) {
		// TODO Auto-generated method stub
		return subscriptionDao.cancel(transactionId);
	}

	@Override
	public SubscriptionTransaction get(String transactionId) {
		// TODO Auto-generated method stub
		return subscriptionDao.get(transactionId);
	}

}
