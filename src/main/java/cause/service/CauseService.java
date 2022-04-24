package cause.service;


import cause.dao.CauseDao;
import cause.domain.Cause;

/**
 * logic functions such as register, login
 *
 *
 */
public class CauseService {
	private CauseDao causeDao = new CauseDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Cause form) throws CauseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Cause cause = causeDao.findByCauseId(form.getCause_id());
		if(cause.getCause_id()!= null && cause.getCause_id() == form.getCause_id()) throw new CauseException("This cause name has been registered before!");
		causeDao.add(form);
	}
}
