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

import donation.domain.Donation;
import donation.service.DonationException;
import donation.service.DonationService;


/**
 * Servlet implementation class UserServlet
 */

public class DonationServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationServletCreate() {
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
		DonationService donationService = new DonationService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Donation form = new Donation();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setTransaction_id(Integer.parseInt(info.get(0)));
		form.setDonor_id(Integer.parseInt(info.get(1)));
		form.setResource_id(Integer.parseInt(info.get(2)));
		form.setOrganization_id(Integer.parseInt(info.get(3)));
		form.setTime(info.get(4));
		form.setAmount(Float.parseFloat(info.get(5)));
		
		try {
			donationService.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | DonationException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
