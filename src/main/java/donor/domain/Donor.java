package donor.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Donor {
	/*
	 * Correspond to the user table
	 */
	
	private Integer donor_id;
	private String first_name;
	private String last_name; 
	private String birth_date;
	private String address;
	private String email;
	private String phone;
	private Integer num_of_donations;
	private String last_donation;

	public Integer getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Integer donor_id) {
		this.donor_id = donor_id;
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

	public Integer getNum_of_donations() {
		return num_of_donations;
	}

	public void setNum_of_donations(Integer num_of_donations) {
		this.num_of_donations = num_of_donations;
	}

	public String getLast_donation() {
		return last_donation;
	}

	public void setLast_donation(String last_donation) {
		this.last_donation = last_donation;
	}

	@Override
	public String toString() {
		return "Donor [donor_id=" + donor_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", birth_date=" + birth_date + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ ", num_of_donations=" + num_of_donations + ", last_donation=" + last_donation + "]";
	}
}
