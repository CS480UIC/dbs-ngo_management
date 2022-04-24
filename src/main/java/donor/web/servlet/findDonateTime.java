package donor.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor.service.DonorService;

/**
 * Servlet implementation class findAll
 */

public class findDonateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DonorService donorservice = new DonorService();
		try {
			request.setAttribute("DonorTimeList", donorservice.findDonorsTime());
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			List<Object> li = donorservice.findNumberDonations();
			for(int i = 0; i < li.size();i++){
				System.out.println(li.get(i).toString());
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/jsps/donor/q9_donors_time_query.jsp").forward(request, response);
	}

}
