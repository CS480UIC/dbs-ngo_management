package volunteer_support_cause.domain;

/**
 * User object
 * 
 *
 * 
 */
public class VolunteerSupportCause {
	/*
	 * Correspond to the user table
	 */
	
	private Integer volunteer_id;
	private Integer support_cause_id;

	public Integer getVolunteer_id() {
		return volunteer_id;
	}

	public void setVolunteer_id(Integer volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public Integer getSupport_cause_id() {
		return support_cause_id;
	}

	public void setSupport_cause_id(Integer support_cause_id) {
		this.support_cause_id = support_cause_id;
	}

	@Override
	public String toString() {
		return "VolunteerSupportCause [volunteer_id=" + volunteer_id + ", support_cause_id=" + support_cause_id + "]";
	}
}
