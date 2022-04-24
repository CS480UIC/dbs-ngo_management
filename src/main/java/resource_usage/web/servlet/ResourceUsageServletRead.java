package resource_usage.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource_usage.dao.ResourceUsageDao;
import resource_usage.domain.ResourceUsage;


/**
 * Servlet implementation class UserServlet
 */

public class ResourceUsageServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceUsageServletRead() {
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
		ResourceUsage resource_usage = null;
		ResourceUsageDao resource_usageDao = new ResourceUsageDao();
		
		try {
			resource_usage = resource_usageDao.findByResourceUsageId(Integer.parseInt(request.getParameter("resource_usage_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(resource_usage.getUsage_id()!=null){
					System.out.println(resource_usage);
					request.setAttribute("resource_usage", resource_usage);
					request.getRequestDispatcher("/jsps/resource_usage/resource_usage_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "ResourceUsage not found");
			request.getRequestDispatcher("/jsps/resource_usage/resource_usage_read_output.jsp").forward(request, response);
		}
	}
}



