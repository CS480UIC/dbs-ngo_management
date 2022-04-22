package cause_organization.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class CauseOrganization {
	/*
	 * Correspond to the user table
	 */
	
	private Integer cause_id;
	private Integer organization_id;

	public Integer getCause_id() {
		return cause_id;
	}

	public void setCause_id(Integer cause_id) {
		this.cause_id = cause_id;
	}

	public Integer getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	@Override
	public String toString() {
		return "CauseOrganization [cause_id=" + cause_id + ", organization_id=" + organization_id + "]";
	}
}
