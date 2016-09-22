package com.appdirect.subscription.enums;

public enum UserActionStatus {

	REGISTERATION(0), ACT(1), DEACT(2), CANCEL(3), RENEWAL(4);
	private int statusCode;
	private UserActionStatus(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

}
