package volunteer.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volunteer.dao.VolunteerDao;
import volunteer.domain.Volunteer;

/**
 * Servlet implementation class UserServlet
 */

public class VolunteerServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VolunteerServletUpdate() {
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
		VolunteerDao volunteerdao = new VolunteerDao();
		Volunteer volunteer = null;

		if(method.equals("search"))
		{
			try {
				volunteer = volunteerdao.findByVolunteerId(Integer.parseInt(request.getParameter("volunteer_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(volunteer.getVolunteer_id()!=null){
				request.setAttribute("volunteer", volunteer);
				request.getRequestDispatcher("/jsps/volunteer/volunteer_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Volunteer not found");
				request.getRequestDispatcher("/jsps/volunteer/volunteer_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Volunteer form = new Volunteer();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(values[0]);
			}

			form.setVolunteer_id(Integer.parseInt(request.getParameter("volunteer_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			form.setBirth_date(info.get(4));
			form.setAddress(info.get(5));
			form.setEmail(info.get(6));
			form.setPhone(info.get(7));

			try {
				volunteerdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "volunteer Updated");
			request.getRequestDispatcher("/jsps/volunteer/volunteer_read_output.jsp").forward(request, response);
		}
	}
}



