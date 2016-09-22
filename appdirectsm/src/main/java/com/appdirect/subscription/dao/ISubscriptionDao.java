package com.appdirect.subscription.dao;

import com.appdirect.request.SubscriptionTransaction;

public interface ISubscriptionDao {

	boolean insert(SubscriptionTransaction subscriptionTransaction);

	boolean update(SubscriptionTransaction subscriptionTransaction);

	boolean cancel(String transactionId);

	SubscriptionTransaction get(String transactionId);
}
