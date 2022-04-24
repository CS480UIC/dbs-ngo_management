package donation.service;


import java.util.List;

import donation.dao.DonationDao;
import donation.domain.Donation;

/**
 * logic functions such as register, login
 *
 *
 */
public class DonationService {
	private DonationDao donationDao = new DonationDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Donation form) throws DonationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Donation donation = donationDao.findByDonationId(form.getTransaction_id());
		if(donation.getTransaction_id()!= null && donation.getTransaction_id() == form.getTransaction_id()) throw new DonationException("This donation name has been registered before!");
		donationDao.add(form);
	}
	
	public List<Object> findDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return donationDao.findDonations();

	}
	
	public List<Object> findTotalDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return donationDao.findTotalDonations();

	}
}
