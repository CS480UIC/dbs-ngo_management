package organization.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Organization {
	/*
	 * Correspond to the user table
	 */
	
	private Integer organization_id;
	private String organization_name;
	private String address; 
	private String email;
	private String phone;

	public Integer getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Organization [organization_id=" + organization_id + ", organization_name=" + organization_name
				+ ", address=" + address + ", email=" + email + ", phone=" + phone + "]";
	}
}
