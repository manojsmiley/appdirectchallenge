package com.appdirect.response;

public class AppdirectResponse<T> {

	private T response;

	public AppdirectResponse(T response) {
		this.response = response;
	}

	/**
	 * @return the response
	 */
	public T getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(T response) {
		this.response = response;
	}

}
