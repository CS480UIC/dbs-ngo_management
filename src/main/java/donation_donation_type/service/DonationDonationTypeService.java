package donation_donation_type.service;


import donation_donation_type.dao.DonationDonationTypeDao;
import donation_donation_type.domain.DonationDonationType;

/**
 * logic functions such as register, login
 *
 *
 */
public class DonationDonationTypeService {
	private DonationDonationTypeDao donation_donation_typeDao = new DonationDonationTypeDao();
	
	/**
	 * register a DonationDonationType
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(DonationDonationType form) throws DonationDonationTypeException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		DonationDonationType donation_donation_type = donation_donation_typeDao.findByDonationDonationTypeId(form.getTransaction_id(), form.getDonation_type());
		if((donation_donation_type.getTransaction_id()!= null && donation_donation_type.getTransaction_id() == form.getTransaction_id()) && (donation_donation_type.getDonation_type() != null && donation_donation_type.getDonation_type() == form.getDonation_type())) throw new DonationDonationTypeException("This donation_donation_type name has been registered before!");
		donation_donation_typeDao.add(form);
	}
}
