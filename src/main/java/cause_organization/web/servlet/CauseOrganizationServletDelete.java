package cause_organization.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cause_organization.dao.CauseOrganizationDao;
import cause_organization.domain.CauseOrganization;


/**
 * Servlet implementation class UserServlet
 */

public class CauseOrganizationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CauseOrganizationServletDelete() {
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
		CauseOrganizationDao cause_organizationDao = new CauseOrganizationDao();
		CauseOrganization cause_organization = null;
		if(method.equals("search"))
		{
			try {
				cause_organization = cause_organizationDao.findByCauseOrganizationId(Integer.parseInt(request.getParameter("cause_id")), Integer.parseInt(request.getParameter("organization_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(cause_organization.getCause_id()!= null && cause_organization.getOrganization_id()!=null){
						System.out.println(cause_organization);
						request.setAttribute("cause_organization", cause_organization);
						request.getRequestDispatcher("/jsps/cause_organization/cause_organization_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "CauseOrganization not found");
				request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				cause_organizationDao.delete(Integer.parseInt(request.getParameter("cause_id")), Integer.parseInt(request.getParameter("organization_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "CauseOrganization Deleted");
			request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
		}
	}
}



