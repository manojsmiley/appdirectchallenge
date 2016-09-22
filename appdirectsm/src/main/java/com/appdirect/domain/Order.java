package com.appdirect.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

	@XmlElement
	private String editionCode;

	@XmlElement(name = "item")
	private List<OrderItem> orderItem;

	/**
	 * @return the editionCode
	 */
	public String getEditionCode() {
		return editionCode;
	}

	/**
	 * @param editionCode
	 *            the editionCode to set
	 */
	public void setEditionCode(String editionCode) {
		this.editionCode = editionCode;
	}

	/**
	 * @return the orderItem
	 */
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	/**
	 * @param orderItem
	 *            the orderItem to set
	 */
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Order [editionCode=" + editionCode + ", orderItem=" + orderItem + "]";
	}

}
