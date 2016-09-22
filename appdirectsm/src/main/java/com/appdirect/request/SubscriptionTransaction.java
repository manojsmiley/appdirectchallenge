package com.appdirect.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.util.StringUtils;

public class SubscriptionTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	private String transactionid;
	private Date transDate;
	private Date updateon;
	private int userAction;
	private int transStatus;
	private double productPrice;
	private double chargePrice;
	private String mode;
	private String serviceName;
	private String channelName;
	private String segment;
	/**
	 * @return the transactionid
	 */
	public String getTransactionid() {
		return transactionid;
	}
	/**
	 * @param transactionid
	 *            the transactionid to set
	 */
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	/**
	 * @return the transDate
	 */
	public Date getTransDate() {
		return transDate;
	}
	/**
	 * @param transDate
	 *            the transDate to set
	 */
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	/**
	 * @return the userAction
	 */
	public int getUserAction() {
		return userAction;
	}
	/**
	 * @param userAction
	 *            the userAction to set
	 */
	public void setUserAction(int userAction) {
		this.userAction = userAction;
	}
	/**
	 * @return the transStatus
	 */
	public int getTransStatus() {
		return transStatus;
	}
	/**
	 * @param transStatus
	 *            the transStatus to set
	 */
	public void setTransStatus(int transStatus) {
		this.transStatus = transStatus;
	}
	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the chargePrice
	 */
	public double getChargePrice() {
		return chargePrice;
	}
	/**
	 * @param chargePrice
	 *            the chargePrice to set
	 */
	public void setChargePrice(double chargePrice) {
		this.chargePrice = chargePrice;
	}
	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * @param mode
	 *            the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}
	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/**
	 * @return the channelName
	 */
	public String getChannelName() {
		return channelName;
	}
	/**
	 * @param channelName
	 *            the channelName to set
	 */
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	/**
	 * @return the segment
	 */
	public String getSegment() {
		return segment;
	}
	/**
	 * @param segment
	 *            the segment to set
	 */
	public void setSegment(String segment) {
		this.segment = segment;
	}

	/**
	 * @return the updateon
	 */
	public Date getUpdateon() {
		return updateon;
	}
	/**
	 * @param updateon
	 *            the updateon to set
	 */
	public void setUpdateon(Date updateon) {
		this.updateon = updateon;
	}

	public SubscriptionTransaction update(SubscriptionTransaction transaction) {

		this.channelName = StringUtils.isEmpty(transaction.getChannelName()) ? this.channelName : transaction.getChannelName();
		this.userAction = transaction.getUserAction() == 0 ? this.userAction : transaction.getUserAction();
		this.transStatus = transaction.getTransStatus() == 0 ? this.transStatus : transaction.getTransStatus();
		this.productPrice = transaction.getProductPrice() == 0 ? this.productPrice : transaction.getProductPrice();
		this.chargePrice = transaction.getChargePrice() == 0 ? this.chargePrice : transaction.getChargePrice();
		this.mode = StringUtils.isEmpty(transaction.getChannelName()) ? this.mode : transaction.getChannelName();
		this.serviceName = StringUtils.isEmpty(transaction.getChannelName()) ? this.serviceName : transaction.getChannelName();
		this.channelName = StringUtils.isEmpty(transaction.getChannelName()) ? this.channelName : transaction.getChannelName();
		this.segment = StringUtils.isEmpty(transaction.getChannelName()) ? this.segment : transaction.getChannelName();
		return this;
	}
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SubscriptionTransaction [transactionid=" + transactionid + ", transDate=" + transDate + ", updateon=" + updateon + ", userAction="
				+ userAction + ", transStatus=" + transStatus + ", productPrice=" + productPrice + ", chargePrice=" + chargePrice + ", mode=" + mode
				+ ", serviceName=" + serviceName + ", channelName=" + channelName + ", segment=" + segment + "]";
	}

}
