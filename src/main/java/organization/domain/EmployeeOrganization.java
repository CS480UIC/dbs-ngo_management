package organization.domain;

/**
 * User object
 * 
 *
 * 
 */
public class EmployeeOrganization {
	/*
	 * Correspond to the user table
	 */
	
	private Integer employee_id;
	private String first_name;
	private String organization_name;

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	@Override
	public String toString() {
		return "EmployeeOrganization [employee_id=" + employee_id + ", first_name=" + first_name
				+ ", organization_name=" + organization_name + "]";
	}
}
