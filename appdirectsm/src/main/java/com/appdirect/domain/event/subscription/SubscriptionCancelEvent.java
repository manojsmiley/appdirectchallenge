package com.appdirect.domain.event.subscription;

import javax.xml.bind.annotation.XmlRootElement;

import com.appdirect.domain.appdirect.event.Event;
import com.appdirect.domain.appdirect.event.EventType;

@XmlRootElement(name = "event")
public class SubscriptionCancelEvent extends Event {

	private SubscriptionCancelPayload payload;

	public SubscriptionCancelEvent() {
		super(EventType.SUBSCRIPTION_CANCEL);
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
		SubscriptionCancelEvent other = (SubscriptionCancelEvent) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SubscriptionCancelEvent [payload=" + payload + "]";
	}

}
