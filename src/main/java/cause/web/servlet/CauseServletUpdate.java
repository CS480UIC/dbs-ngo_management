package cause.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cause.dao.CauseDao;
import cause.domain.Cause;

/**
 * Servlet implementation class UserServlet
 */

public class CauseServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CauseServletUpdate() {
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
		CauseDao causedao = new CauseDao();
		Cause cause = null;

		if(method.equals("search"))
		{
			try {
				cause = causedao.findByCauseId(Integer.parseInt(request.getParameter("cause_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(cause.getCause_id()!=null){
				request.setAttribute("cause", cause);
				request.getRequestDispatcher("/jsps/cause/cause_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Cause not found");
				request.getRequestDispatcher("/jsps/cause/cause_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Cause form = new Cause();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setCause_id(Integer.parseInt(request.getParameter("cause_id")));
			form.setCause_name(info.get(2));
			form.setCause_supported(info.get(3));
			form.setCause_funds_raised(Float.parseFloat(info.get(4)));

			try {
				causedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Cause Updated");
			request.getRequestDispatcher("/jsps/cause/cause_read_output.jsp").forward(request, response);
		}
	}
}



