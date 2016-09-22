package com.appdirect.domain.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.appdirect.domain.Company;
import com.appdirect.domain.Order;

@XmlRootElement(name = "payload")
public class SubscriptionOrderPayload {
	private Company company;
	private Order order;
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SubscriptionOrderPayload [company=" + company + ", order=" + order + "]";
	}
}
