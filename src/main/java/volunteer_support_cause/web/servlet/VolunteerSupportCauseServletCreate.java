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

import volunteer_support_cause.domain.VolunteerSupportCause;
import volunteer_support_cause.service.VolunteerSupportCauseException;
import volunteer_support_cause.service.VolunteerSupportCauseService;


/**
 * Servlet implementation class UserServlet
 */

public class VolunteerSupportCauseServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunteerSupportCauseServletCreate() {
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
		VolunteerSupportCauseService entity1service = new VolunteerSupportCauseService();
		Map<String,String[]> paramMap = request.getParameterMap();
		VolunteerSupportCause form = new VolunteerSupportCause();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setVolunteer_id(Integer.parseInt(info.get(0)));
		form.setSupport_cause_id(Integer.parseInt(info.get(1)));
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | VolunteerSupportCauseException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
