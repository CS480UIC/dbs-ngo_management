package volunteer_support_cause.service;


import volunteer_support_cause.dao.VolunteerSupportCauseDao;
import volunteer_support_cause.domain.VolunteerSupportCause;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class VolunteerSupportCauseService {
	private VolunteerSupportCauseDao volunteer_support_causeDao = new VolunteerSupportCauseDao();
	
	/**
	 * register a VolunteerSupportCause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(VolunteerSupportCause form) throws VolunteerSupportCauseException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		VolunteerSupportCause volunteer_support_cause = volunteer_support_causeDao.findByVolunteerSupportCauseId(form.getVolunteer_id(), form.getSupport_cause_id());
		if((volunteer_support_cause.getVolunteer_id()!= null && volunteer_support_cause.getVolunteer_id() == form.getVolunteer_id()) && (volunteer_support_cause.getSupport_cause_id() != null && volunteer_support_cause.getSupport_cause_id() == form.getSupport_cause_id())) throw new VolunteerSupportCauseException("This volunteer_support_cause name has been registered before!");
		volunteer_support_causeDao.add(form);
	}
}
