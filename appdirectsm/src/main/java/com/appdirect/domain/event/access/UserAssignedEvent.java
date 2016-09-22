package com.appdirect.domain.event.access;

import javax.xml.bind.annotation.XmlRootElement;

import com.appdirect.domain.appdirect.event.Event;
import com.appdirect.domain.appdirect.event.EventType;

@XmlRootElement(name = "event")
public class UserAssignedEvent extends Event {

	private AssignmentPayload payload;

	public UserAssignedEvent() {
		super(EventType.USER_ASSIGNED);
	}

	public AssignmentPayload getPayload() {
		// TODO Auto-generated method stub
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(AssignmentPayload payload) {
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
		UserAssignedEvent other = (UserAssignedEvent) obj;
		if (payload == null) {
			if (other.payload != null)
				return false;
		} else if (!payload.equals(other.payload))
			return false;
		return true;
	}

}
