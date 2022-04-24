package volunteer_support_cause.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volunteer_support_cause.dao.VolunteerSupportCauseDao;
import volunteer_support_cause.domain.VolunteerSupportCause;


/**
 * Servlet implementation class UserServlet
 */

public class VolunteerSupportCauseServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerSupportCauseServletRead() {
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
		VolunteerSupportCause volunteer_support_cause = null;
		VolunteerSupportCauseDao volunteer_support_causeDao = new VolunteerSupportCauseDao();
		
		try {
			volunteer_support_cause = volunteer_support_causeDao.findByVolunteerSupportCauseId(Integer.parseInt(request.getParameter("volunteer_id")), Integer.parseInt(request.getParameter("support_cause_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(volunteer_support_cause.getVolunteer_id()!=null && volunteer_support_cause.getSupport_cause_id()!=null){
					System.out.println(volunteer_support_cause);
					request.setAttribute("volunteer_support_cause", volunteer_support_cause);
					request.getRequestDispatcher("/jsps/volunteer_support_cause/volunteer_support_cause_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/volunteer_support_cause/volunteer_support_cause_read_output.jsp").forward(request, response);
		}
	}
}



