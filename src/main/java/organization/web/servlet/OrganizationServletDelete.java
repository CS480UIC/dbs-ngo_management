package organization.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import organization.dao.OrganizationDao;
import organization.domain.Organization;


/**
 * Servlet implementation class UserServlet
 */

public class OrganizationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrganizationServletDelete() {
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
		OrganizationDao organizationDao = new OrganizationDao();
		Organization organization = null;
		if(method.equals("search"))
		{
			try {
				organization = organizationDao.findByOrganizationId(Integer.parseInt(request.getParameter("organization_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(organization.getOrganization_id()!= null){
						System.out.println(organization);
						request.setAttribute("organization", organization);
						request.getRequestDispatcher("/jsps/organization/organization_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Organization not found");
				request.getRequestDispatcher("/jsps/organization/organization_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				organizationDao.delete(Integer.parseInt(request.getParameter("organization_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Organization Deleted");
			request.getRequestDispatcher("/jsps/organization/organization_read_output.jsp").forward(request, response);
		}
	}
}



