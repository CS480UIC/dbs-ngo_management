package cause_organization.service;


import cause_organization.dao.CauseOrganizationDao;
import cause_organization.domain.CauseOrganization;

/**
 * logic functions such as register, login
 *
 *
 */
public class CauseOrganizationService {
	private CauseOrganizationDao cause_organizationDao = new CauseOrganizationDao();
	
	/**
	 * register a CauseOrganization
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(CauseOrganization form) throws CauseOrganizationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		CauseOrganization cause_organization = cause_organizationDao.findByCauseOrganizationId(form.getCause_id(), form.getOrganization_id());
		if((cause_organization.getCause_id()!= null && cause_organization.getCause_id() == form.getCause_id()) && (cause_organization.getOrganization_id() != null && cause_organization.getOrganization_id() == form.getOrganization_id())) throw new CauseOrganizationException("This cause_organization name has been registered before!");
		cause_organizationDao.add(form);
	}
}
