package donor.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor.dao.DonorDao;
import donor.domain.Donor;

/**
 * Servlet implementation class UserServlet
 */

public class DonorServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonorServletUpdate() {
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
		DonorDao donordao = new DonorDao();
		Donor donor = null;

		if(method.equals("search"))
		{
			try {
				donor = donordao.findByDonorId(Integer.parseInt(request.getParameter("donor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(donor.getDonor_id()!=null){
				request.setAttribute("donor", donor);
				request.getRequestDispatcher("/jsps/donor/donor_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Donor not found");
				request.getRequestDispatcher("/jsps/donor/donor_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Donor form = new Donor();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(values[0]);
			}

			form.setDonor_id(Integer.parseInt(request.getParameter("donor_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			form.setBirth_date(info.get(4));
			form.setAddress(info.get(5));
			form.setEmail(info.get(6));
			form.setPhone(info.get(7));
			form.setNum_of_donations(Integer.parseInt(info.get(8)));
			form.setLast_donation(info.get(9));

			try {
				donordao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "donor Updated");
			request.getRequestDispatcher("/jsps/donor/donor_read_output.jsp").forward(request, response);
		}
	}
}



