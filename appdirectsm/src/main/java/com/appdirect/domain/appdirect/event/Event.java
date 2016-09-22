package com.appdirect.domain.appdirect.event;

import com.appdirect.domain.Marketplace;
import com.appdirect.domain.User;

public abstract class Event {
	private EventType type;
	private Marketplace marketplace;
	private User creator;

	public Event(EventType type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}

	/**
	 * @return the marketplace
	 */
	public Marketplace getMarketplace() {
		return marketplace;
	}

	/**
	 * @param marketplace
	 *            the marketplace to set
	 */
	public void setMarketplace(Marketplace marketplace) {
		this.marketplace = marketplace;
	}

	/**
	 * @return the creator
	 */
	public User getCreator() {
		return creator;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	public void setCreator(User creator) {
		this.creator = creator;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Event [type=" + type + ", marketplace=" + marketplace + ", creator=" + creator + "]";
	}
}
