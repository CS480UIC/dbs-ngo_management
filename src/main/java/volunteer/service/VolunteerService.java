package volunteer.service;


import java.util.List;

import volunteer.dao.VolunteerDao;
import volunteer.domain.Volunteer;

/**
 * logic functions such as register, login
 * @author Aayush Makharia
 *
 */
public class VolunteerService {
	private VolunteerDao volunteerDao = new VolunteerDao();
	
	/**
	 * register a Cause
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public void create(Volunteer form) throws VolunteerException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		// check the primary key of Entity1
		Volunteer volunteer = volunteerDao.findByVolunteerId(form.getVolunteer_id());
		if(volunteer.getVolunteer_id()!= null && volunteer.getVolunteer_id() == form.getVolunteer_id()) throw new VolunteerException("This volunteer name has been registered before!");
		volunteerDao.add(form);
	}
}
