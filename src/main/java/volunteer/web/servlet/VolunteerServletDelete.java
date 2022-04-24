package volunteer.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volunteer.dao.VolunteerDao;
import volunteer.domain.Volunteer;


/**
 * Servlet implementation class UserServlet
 */

public class VolunteerServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerServletDelete() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		VolunteerDao volunteerDao = new VolunteerDao();
		Volunteer volunteer = null;
		if(method.equals("search"))
		{
			try {
				volunteer = volunteerDao.findByVolunteerId(Integer.parseInt(request.getParameter("volunteer_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(volunteer.getVolunteer_id()!= null){
						System.out.println(volunteer);
						request.setAttribute("volunteer", volunteer);
						request.getRequestDispatcher("/jsps/volunteer/volunteer_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Volunteer not found");
				request.getRequestDispatcher("/jsps/volunteer/volunteer_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				volunteerDao.delete(Integer.parseInt(request.getParameter("volunteer_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Volunteer Deleted");
			request.getRequestDispatcher("/jsps/volunteer/volunteer_read_output.jsp").forward(request, response);
		}
	}
}



