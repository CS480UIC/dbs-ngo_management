package donation.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation.dao.DonationDao;
import donation.domain.Donation;


/**
 * Servlet implementation class UserServlet
 */

public class DonationServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationServletDelete() {
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
		DonationDao donationDao = new DonationDao();
		Donation donation = null;
		if(method.equals("search"))
		{
			try {
				donation = donationDao.findByDonationId(Integer.parseInt(request.getParameter("transaction_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(donation.getTransaction_id()!= null){
						System.out.println(donation);
						request.setAttribute("donation", donation);
						request.getRequestDispatcher("/jsps/donation/donation_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Donation not found");
				request.getRequestDispatcher("/jsps/donation/donation_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				donationDao.delete(Integer.parseInt(request.getParameter("transaction_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Donation Deleted");
			request.getRequestDispatcher("/jsps/donation/donation_read_output.jsp").forward(request, response);
		}
	}
}



