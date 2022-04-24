package donation_donation_type.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donation_donation_type.dao.DonationDonationTypeDao;
import donation_donation_type.domain.DonationDonationType;


/**
 * Servlet implementation class UserServlet
 */

public class DonationDonationTypeServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationDonationTypeServletDelete() {
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
		DonationDonationTypeDao donation_donation_typeDao = new DonationDonationTypeDao();
		DonationDonationType donation_donation_type = null;
		if(method.equals("search"))
		{
			try {
				donation_donation_type = donation_donation_typeDao.findByDonationDonationTypeId(Integer.parseInt(request.getParameter("transaction_id")), request.getParameter("donation_type"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(donation_donation_type.getTransaction_id()!= null && donation_donation_type.getDonation_type()!=null){
						System.out.println(donation_donation_type);
						request.setAttribute("donation_donation_type", donation_donation_type);
						request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "DonationDonationType not found");
				request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				donation_donation_typeDao.delete(Integer.parseInt(request.getParameter("transaction_id")), request.getParameter("donation_type"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "DonationDonationType Deleted");
			request.getRequestDispatcher("/jsps/donation_donation_type/donation_donation_type_read_output.jsp").forward(request, response);
		}
	}
}



