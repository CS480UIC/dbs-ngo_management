package volunteer.domain;

/**
 * User object
 * 
 *
 * 
 */
public class VolunteerCause {
	/*
	 * Correspond to the user table
	 */
	
	private Integer volunteer_id;
	private String first_name;
	private Integer num_causes; 
	private String cause_name;

	public Integer getVolunteer_id() {
		return volunteer_id;
	}

	public void setVolunteer_id(Integer volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Integer getNum_causes() {
		return num_causes;
	}

	public void setNum_causes(Integer num_causes) {
		this.num_causes = num_causes;
	}

	public String getCause_name() {
		return cause_name;
	}

	public void setCause_name(String cause_name) {
		this.cause_name = cause_name;
	}

	@Override
	public String toString() {
		return "VolunteerCause [volunteer_id=" + volunteer_id + ", first_name=" + first_name + ", num_causes="
				+ num_causes + ", cause_name=" + cause_name + "]";
	}
}
