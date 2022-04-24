package donation.domain;

/**
 * User object
 * 
 *
 * 
 */
public class Donation {
	/*
	 * Correspond to the user table
	 */
	
	private Integer transaction_id;
	private Integer donor_id;
	private Integer resource_id;
	private Integer organization_id;
	private String time; 
	private Float amount;

	public Integer getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}

	public Integer getDonor_id() {
		return donor_id;
	}

	public void setDonor_id(Integer donor_id) {
		this.donor_id = donor_id;
	}

	public Integer getResource_id() {
		return resource_id;
	}

	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	public Integer getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Donation [transaction_id=" + transaction_id + ", donor_id=" + donor_id + ", resource_id=" + resource_id
				+ ", organization_id=" + organization_id + ", time=" + time + ", amount=" + amount + "]";
	}
}
