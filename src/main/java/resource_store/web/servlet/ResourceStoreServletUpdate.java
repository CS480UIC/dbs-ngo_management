package resource_store.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource_store.dao.ResourceStoreDao;
import resource_store.domain.ResourceStore;

/**
 * Servlet implementation class UserServlet
 */

public class ResourceStoreServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResourceStoreServletUpdate() {
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
		ResourceStoreDao resource_storedao = new ResourceStoreDao();
		ResourceStore resource_store = null;

		if(method.equals("search"))
		{
			try {
				resource_store = resource_storedao.findByResource_Id(Integer.parseInt(request.getParameter("resource_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(resource_store.getResource_id()!=null){
				request.setAttribute("resource_store", resource_store);
				request.getRequestDispatcher("/jsps/resource_store/resource_store_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "ResourceStore not found");
				request.getRequestDispatcher("/jsps/resource_store/resource_store_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			ResourceStore form = new ResourceStore();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setResource_id(Integer.parseInt(request.getParameter("resource_id")));
			form.setName(info.get(2));
			form.setType_name(info.get(3));
			form.setResource_count(Float.parseFloat(info.get(4)));

			try {
				resource_storedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "ResourceStore Updated");
			request.getRequestDispatcher("/jsps/resource_store/resource_store_read_output.jsp").forward(request, response);
		}
	}
}



