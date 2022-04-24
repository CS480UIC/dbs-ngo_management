package volunteer.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Volunteer {
	/*
	 * Correspond to the user table
	 */
	
	private Integer volunteer_id;
	private String first_name;
	private String last_name; 
	private String birth_date;
	private String address;
	private String email;
	private String phone;

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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
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
		return "Volunteer [volunteer_id=" + volunteer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", birth_date=" + birth_date + ", address=" + address + ", email=" + email + ", phone=" + phone + "]";
	}
}
