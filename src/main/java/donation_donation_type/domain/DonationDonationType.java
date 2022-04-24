package donation_donation_type.domain;

/**
 * User object
 * 
 *
 * 
 */
public class DonationDonationType {
	/*
	 * Correspond to the user table
	 */
	
	private Integer transaction_id;
	private String donation_type;

	public Integer getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getDonation_type() {
		return donation_type;
	}

	public void setDonation_type(String donation_type) {
		this.donation_type = donation_type;
	}

	@Override
	public String toString() {
		return "DonationDonationType [transaction_id=" + transaction_id + ", donation_type=" + donation_type + "]";
	}
}
