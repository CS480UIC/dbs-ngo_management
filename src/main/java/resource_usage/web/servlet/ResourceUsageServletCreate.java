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

import resource_usage.domain.ResourceUsage;
import resource_usage.service.ResourceUsageException;
import resource_usage.service.ResourceUsageService;


/**
 * Servlet implementation class UserServlet
 */

public class ResourceUsageServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceUsageServletCreate() {
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
		ResourceUsageService resource_usageService = new ResourceUsageService();
		Map<String,String[]> paramMap = request.getParameterMap();
		ResourceUsage form = new ResourceUsage();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setUsage_id(Integer.parseInt(info.get(0)));
		form.setResource_id(Integer.parseInt(info.get(1)));
		form.setOrganization_id(Integer.parseInt(info.get(2)));
		form.setUsage_count(Float.parseFloat(info.get(3)));
		
		try {
			resource_usageService.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | ResourceUsageException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
