package com.appdirect.service;

import com.appdirect.request.SubscriptionTransaction;

/**
 * 
 * @author Manoj.kumar
 *
 */
public interface SubscriptionService {

	boolean insert(SubscriptionTransaction subscriptionTransaction);

	boolean update(SubscriptionTransaction subscriptionTransaction);

	boolean cancel(String transactionId);

	SubscriptionTransaction get(String transactionId);
}
