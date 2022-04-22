package cause_organization.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cause_organization.dao.CauseOrganizationDao;
import cause_organization.domain.CauseOrganization;
import cause_organization.service.CauseOrganizationException;
import cause_organization.service.CauseOrganizationService;

/**
 * Servlet implementation class UserServlet
 */

public class CauseOrganizationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CauseOrganizationServletUpdate() {
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
		CauseOrganizationDao cause_organizationdao = new CauseOrganizationDao();
		CauseOrganization cause_organization = null;

		if(method.equals("search"))
		{
			try {
				cause_organization = cause_organizationdao.findByCauseOrganizationId(Integer.parseInt(request.getParameter("cause_id")), Integer.parseInt(request.getParameter("organization_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(cause_organization.getCause_id()!=null && cause_organization.getOrganization_id()!=null){
				request.setAttribute("cause_organization", cause_organization);
				request.getRequestDispatcher("/jsps/cause_organization/cause_organization_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "CauseOrganization not found");
				request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
			}
			try {
				cause_organizationdao.delete(cause_organization.getCause_id(), cause_organization.getOrganization_id());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}	
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			CauseOrganization form = new CauseOrganization();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setCause_id(Integer.parseInt(request.getParameter("cause_id")));
			form.setOrganization_id(Integer.parseInt(request.getParameter("organization_id")));
			CauseOrganizationService entity1service = new CauseOrganizationService();
			try {
				entity1service.create(form);
				
			} catch (ClassNotFoundException | CauseOrganizationException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			
			request.setAttribute("msg", "CauseOrganization Updated");
			request.getRequestDispatcher("/jsps/cause_organization/cause_organization_read_output.jsp").forward(request, response);
		}
	}
}



