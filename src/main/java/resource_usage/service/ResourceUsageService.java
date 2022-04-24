package resource_usage.service;


import resource_usage.dao.ResourceUsageDao;
import resource_usage.domain.ResourceUsage;

/**
 * logic functions such as register, login
 *
 *
 */
public class ResourceUsageService {
	private ResourceUsageDao resource_usageDao = new ResourceUsageDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(ResourceUsage form) throws ResourceUsageException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		ResourceUsage resource_usage = resource_usageDao.findByResourceUsageId(form.getUsage_id());
		if(resource_usage.getUsage_id()!= null && resource_usage.getUsage_id() == form.getUsage_id()) throw new ResourceUsageException("This resource_usage name has been registered before!");
		resource_usageDao.add(form);
	}
}
