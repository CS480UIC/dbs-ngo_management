package cause_organization.service;


import cause_organization.dao.Cause_organizationDao;
import cause_organization.domain.Cause_organization;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class Cause_organizationService {
	private Cause_organizationDao cause_organizationDao = new Cause_organizationDao();
	
	/**
	 * register a Cause_organization
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Cause_organization form) throws Cause_organizationException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Cause_organization cause_organization = cause_organizationDao.findByCause_organizationId(form.getCause_id(), form.getOrganization_id());
		if((cause_organization.getCause_id()!= null && cause_organization.getCause_id() == form.getCause_id()) && (cause_organization.getOrganization_id() != null && cause_organization.getOrganization_id() == form.getOrganization_id())) throw new Cause_organizationException("This cause_organization name has been registered before!");
		cause_organizationDao.add(form);
	}
}
