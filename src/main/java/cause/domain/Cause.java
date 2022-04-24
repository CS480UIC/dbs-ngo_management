package cause.domain;

/**
 * User object
 * 
 *
 * 
 */
public class Cause {
	/*
	 * Correspond to the user table
	 */
	
	private Integer cause_id;
	private String cause_name;
	private String cause_supported; 
	private Float cause_funds_raised;

	public Integer getCause_id() {
		return cause_id;
	}

	public void setCause_id(Integer cause_id) {
		this.cause_id = cause_id;
	}

	public String getCause_name() {
		return cause_name;
	}

	public void setCause_name(String cause_name) {
		this.cause_name = cause_name;
	}

	public String getCause_supported() {
		return cause_supported;
	}

	public void setCause_supported(String cause_supported) {
		this.cause_supported = cause_supported;
	}

	public Float getCause_funds_raised() {
		return cause_funds_raised;
	}

	public void setCause_funds_raised(Float cause_funds_raised) {
		this.cause_funds_raised = cause_funds_raised;
	}

	@Override
	public String toString() {
		return "Cause [cause_id=" + cause_id + ", cause_name=" + cause_name + ", cause_supported=" + cause_supported
				+ ", cause_funds_raised=" + cause_funds_raised + "]";
	}
}
