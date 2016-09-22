package com.appdirect.subscription.enums;

public enum SubscriptionStatus {

	FREE_TRIAL(1, "free trial"), FREE_TRIAL_EXPIRED(2, "free trial expired"), ACTIVE(3, "active"), SUSPENDED(4, "suspended"), CANCELLED(5,
			"cancelled");

	private int statusCode;
	private String msg;

	private SubscriptionStatus(int statusCode, String msg) {
		this.statusCode = statusCode;
		this.msg = msg;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @return the statusCode
	 */
	public String getMsg() {
		return msg;
	}

}
