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

import donor.domain.Donor;
import donor.service.DonorException;
import donor.service.DonorService;


/**
 * Servlet implementation class UserServlet
 */

public class DonorServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorServletCreate() {
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
		DonorService donorService = new DonorService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Donor form = new Donor();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		form.setDonor_id(Integer.parseInt(info.get(0)));
		form.setFirst_name(info.get(1));
		form.setLast_name(info.get(2));
		form.setBirth_date(info.get(3));
		form.setAddress(info.get(4));
		form.setEmail(info.get(5));
		form.setPhone(info.get(6));
		form.setNum_of_donations(Integer.parseInt(info.get(7)));
		form.setLast_donation(info.get(8));
		
		try {
			donorService.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | DonorException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
