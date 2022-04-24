package donation.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDao;
import donation.domain.Donation;

/**
 * Servlet implementation class UserServlet
 */

public class DonationServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonationServletUpdate() {
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
		DonationDao donationdao = new DonationDao();
		Donation donation = null;

		if(method.equals("search"))
		{
			try {
				donation = donationdao.findByDonationId(Integer.parseInt(request.getParameter("transaction_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(donation.getTransaction_id()!=null){
				request.setAttribute("donation", donation);
				request.getRequestDispatcher("/jsps/donation/donation_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Donation not found");
				request.getRequestDispatcher("/jsps/donation/donation_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Donation form = new Donation();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(values[0]);
			}
			form.setTransaction_id(Integer.parseInt(request.getParameter("transaction_id")));
			form.setDonor_id(Integer.parseInt(info.get(2)));
			form.setResource_id(Integer.parseInt(info.get(3)));
			form.setOrganization_id(Integer.parseInt(info.get(4)));
			form.setTime(info.get(5));
			form.setAmount(Float.parseFloat(info.get(6)));
			
			try {
				donationdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "donation Updated");
			request.getRequestDispatcher("/jsps/donation/donation_read_output.jsp").forward(request, response);
		}
	}
}



