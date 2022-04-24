package volunteer_support_cause.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volunteer_support_cause.dao.VolunteerSupportCauseDao;
import volunteer_support_cause.domain.VolunteerSupportCause;
import volunteer_support_cause.service.VolunteerSupportCauseException;
import volunteer_support_cause.service.VolunteerSupportCauseService;

/**
 * Servlet implementation class UserServlet
 */

public class VolunteerSupportCauseServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VolunteerSupportCauseServletUpdate() {
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
		VolunteerSupportCauseDao volunteer_support_causedao = new VolunteerSupportCauseDao();
		VolunteerSupportCause volunteer_support_cause = null;

		if(method.equals("search"))
		{
			try {
				volunteer_support_cause = volunteer_support_causedao.findByVolunteerSupportCauseId(Integer.parseInt(request.getParameter("volunteer_id")), Integer.parseInt(request.getParameter("support_cause_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(volunteer_support_cause.getVolunteer_id()!=null && volunteer_support_cause.getSupport_cause_id()!=null){
				request.setAttribute("volunteer_support_cause", volunteer_support_cause);
				request.getRequestDispatcher("/jsps/volunteer_support_cause/volunteer_support_cause_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "VolunteerSupportCause not found");
				request.getRequestDispatcher("/jsps/volunteer_support_cause/volunteer_support_cause_read_output.jsp").forward(request, response);
			}
			try {
				volunteer_support_causedao.delete(volunteer_support_cause.getVolunteer_id(), volunteer_support_cause.getSupport_cause_id());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			VolunteerSupportCause form = new VolunteerSupportCause();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			form.setVolunteer_id(Integer.parseInt(request.getParameter("volunteer_id")));
			form.setSupport_cause_id(Integer.parseInt(request.getParameter("support_cause_id")));

			VolunteerSupportCauseService entity1service = new VolunteerSupportCauseService();
			try {
				entity1service.create(form);				
			} catch (ClassNotFoundException | VolunteerSupportCauseException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			request.setAttribute("msg", "VolunteerSupportCause Updated");
			request.getRequestDispatcher("/jsps/volunteer_support_cause/volunteer_support_cause_read_output.jsp").forward(request, response);
		}
	}
}



