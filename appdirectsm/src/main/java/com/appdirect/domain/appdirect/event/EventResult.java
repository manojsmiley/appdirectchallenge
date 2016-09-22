package com.appdirect.domain.appdirect.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "result")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class EventResult {

	private boolean success;
	private String message;
	private String errorCode;
	private String accountIdentifier;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the accountIdentifier
	 */
	public String getAccountIdentifier() {
		return accountIdentifier;
	}
	/**
	 * @param accountIdentifier
	 *            the accountIdentifier to set
	 */
	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "EventResult [success=" + success + ", message=" + message + ", errorCode=" + errorCode + ", accountIdentifier=" + accountIdentifier
				+ "]";
	}

}