package com.appdirect.domain.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.appdirect.domain.User;
import com.appdirect.domain.appdirect.event.Event;
import com.appdirect.domain.appdirect.event.EventType;

@XmlRootElement(name = "event")
public class SubscriptionOrderEvent extends Event {

	private SubscriptionOrderPayload payload;

	public SubscriptionOrderEvent() {
		super(EventType.SUBSCRIPTION_ORDER);
	}

	@Override
	public User getCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the payload
	 */
	public SubscriptionOrderPayload getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(SubscriptionOrderPayload payload) {
		this.payload = payload;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode() */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((payload == null) ? 0 : payload.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubscriptionOrderEvent other = (SubscriptionOrderEvent) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		return true;
	}
}
