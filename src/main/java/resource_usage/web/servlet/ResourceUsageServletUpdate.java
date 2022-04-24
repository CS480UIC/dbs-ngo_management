package resource_usage.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource_usage.dao.ResourceUsageDao;
import resource_usage.domain.ResourceUsage;

/**
 * Servlet implementation class UserServlet
 */

public class ResourceUsageServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResourceUsageServletUpdate() {
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
		ResourceUsageDao resource_usagedao = new ResourceUsageDao();
		ResourceUsage resource_usage = null;

		if(method.equals("search"))
		{
			try {
				resource_usage = resource_usagedao.findByResourceUsageId(Integer.parseInt(request.getParameter("resource_usage_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(resource_usage.getUsage_id()!=null){
				request.setAttribute("resource_usage", resource_usage);
				request.getRequestDispatcher("/jsps/resource_usage/resource_usage_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "ResourceUsage not found");
				request.getRequestDispatcher("/jsps/resource_usage/resource_usage_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			ResourceUsage form = new ResourceUsage();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(values[0]);
			}
			form.setUsage_id(Integer.parseInt(request.getParameter("resource_usage_id")));
			form.setResource_id(Integer.parseInt(info.get(2)));
			form.setOrganization_id(Integer.parseInt(info.get(3)));
			form.setUsage_count(Float.parseFloat(info.get(4)));
			
			try {
				resource_usagedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "resource_usage Updated");
			request.getRequestDispatcher("/jsps/resource_usage/resource_usage_read_output.jsp").forward(request, response);
		}
	}
}



