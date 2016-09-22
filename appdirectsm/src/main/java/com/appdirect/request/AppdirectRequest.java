package com.appdirect.request;

public class AppdirectRequest<T> {

	private T request;

	public AppdirectRequest() {
	}
	public AppdirectRequest(T request) {
		this.request = request;
	}

	/**
	 * @return the request
	 */
	public T getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(T request) {
		this.request = request;
	}

}
