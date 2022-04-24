package resource_store.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource_store.dao.ResourceStoreDao;
import resource_store.domain.ResourceStore;


/**
 * Servlet implementation class UserServlet
 */

public class ResourceStoreServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceStoreServletDelete() {
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
		ResourceStoreDao resource_storeDao = new ResourceStoreDao();
		ResourceStore resource_store = null;
		if(method.equals("search"))
		{
			try {
				resource_store = resource_storeDao.findByResource_Id(Integer.parseInt(request.getParameter("resource_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(resource_store.getResource_id()!= null){
						System.out.println(resource_store);
						request.setAttribute("resource_store", resource_store);
						request.getRequestDispatcher("/jsps/resource_store/resource_store_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "ResourceStore not found");
				request.getRequestDispatcher("/jsps/resource_store/resource_store_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				resource_storeDao.delete(Integer.parseInt(request.getParameter("resource_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "ResourceStore Deleted");
			request.getRequestDispatcher("/jsps/resource_store/resource_store_read_output.jsp").forward(request, response);
		}
	}
}



