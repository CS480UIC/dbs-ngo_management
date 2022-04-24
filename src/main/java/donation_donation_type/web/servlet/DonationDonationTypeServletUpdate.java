package donation_donation_type.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation_donation_type.dao.DonationDonationTypeDao;
import donation_donation_type.domain.DonationDonationType;
import donation_donation_type.service.DonationDonationTypeException;
import donation_donation_type.service.DonationDonationTypeService;

/**
 * Servlet implementation class UserServlet
 */

public class DonationDonationTypeServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationDonationTypeServletUpdate() {
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
		DonationDonationTypeDao donation_donation_typedao = new DonationDonationTypeDao();
		DonationDonationType donation_donation_type = null;

		if(method.equals("search"))
		{
			try {
				donation_donation_type = donation_donation_typedao.findByDonationDonationTypeId(Integer.parseInt(request.getParameter("transaction_id")), request.getParameter("donation_type"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(donation_donation_type.getTransaction_id()!=null && donation_donation_type.getDonation_type()!=null){
				request.setAttribute("donation_donation_type", donation_donation_type);
				request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "DonationDonationType not found");
				request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_read_output.jsp").forward(request, response);
			}
			try {
				donation_donation_typedao.delete(Integer.parseInt(request.getParameter("transaction_id")), request.getParameter("donation_type"));
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
			DonationDonationType form = new DonationDonationType();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			form.setTransaction_id(Integer.parseInt(request.getParameter("transaction_id")));
			form.setDonation_type(request.getParameter("donation_type"));
			DonationDonationTypeService entity1service = new DonationDonationTypeService();
			
			try {
				entity1service.create(form);
				
			} catch (ClassNotFoundException | DonationDonationTypeException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} 
			request.setAttribute("msg", "DonationDonationType Updated");
			request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_read_output.jsp").forward(request, response);
		}
	}
}



