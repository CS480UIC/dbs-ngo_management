package organization.service;


import java.util.List;

import organization.dao.OrganizationDao;
import organization.domain.Organization;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class OrganizationService {
	private OrganizationDao organizationDao = new OrganizationDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Organization form) throws OrganizationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Organization organization = organizationDao.findByOrganizationId(form.getOrganization_id());
		if(organization.getOrganization_id()!= null && organization.getOrganization_id() == form.getOrganization_id()) throw new OrganizationException("This organization name has been registered before!");
		organizationDao.add(form);
	}
}
