package donor.service;


import java.util.List;

import donor.dao.DonorDao;
import donor.domain.Donor;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class DonorService {
	private DonorDao donorDao = new DonorDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Donor form) throws DonorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Donor donor = donorDao.findByDonorId(form.getDonor_id());
		if(donor.getDonor_id()!= null && donor.getDonor_id() == form.getDonor_id()) throw new DonorException("This donor name has been registered before!");
		donorDao.add(form);
	}
	
	public List<Object> findNumberDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return donorDao.findNumberDonations();	
	}
}
