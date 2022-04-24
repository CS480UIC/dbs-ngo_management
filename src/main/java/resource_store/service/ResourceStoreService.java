package resource_store.service;


import resource_store.dao.ResourceStoreDao;
import resource_store.domain.ResourceStore;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class ResourceStoreService {
	private ResourceStoreDao resource_storeDao = new ResourceStoreDao();
	
	/**
	 * register a ResourceStore
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(ResourceStore form) throws ResourceStoreException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		ResourceStore resource_store = resource_storeDao.findByResource_Id(form.getResource_id());
		if(resource_store.getResource_id()!= null && resource_store.getResource_id() == form.getResource_id()) throw new ResourceStoreException("This resource_store name has been registered before!");
		resource_storeDao.add(form);
	}
}
