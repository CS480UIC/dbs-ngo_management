package cause_organization.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cause_organization.dao.Cause_organizationDao;
import cause_organization.domain.Cause_organization;


/**
 * Servlet implementation class UserServlet
 */

public class Cause_organizationServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cause_organizationServletRead() {
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
		Cause_organization cause_organization = null;
		Cause_organizationDao cause_organizationDao = new Cause_organizationDao();
		
		try {
			cause_organization = cause_organizationDao.findByCause_organizationId(Integer.parseInt(request.getParameter("cause_id")), Integer.parseInt(request.getParameter("organization_id")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(cause_organization.getCause_id()!=null && cause_organization.getOrganization_id()!=null){
					System.out.println(cause_organization);
					request.setAttribute("cause_organization", cause_organization);
					request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Entity not found");
			request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
		}
	}
}



