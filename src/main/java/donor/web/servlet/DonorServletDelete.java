package donor.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donor.dao.DonorDao;
import donor.domain.Donor;


/**
 * Servlet implementation class UserServlet
 */

public class DonorServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorServletDelete() {
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
		DonorDao donorDao = new DonorDao();
		Donor donor = null;
		if(method.equals("search"))
		{
			try {
				donor = donorDao.findByDonorId(Integer.parseInt(request.getParameter("donor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(donor.getDonor_id()!= null){
						System.out.println(donor);
						request.setAttribute("donor", donor);
						request.getRequestDispatcher("/jsps/donor/donor_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Donor not found");
				request.getRequestDispatcher("/jsps/donor/donor_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				donorDao.delete(Integer.parseInt(request.getParameter("donor_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Donor Deleted");
			request.getRequestDispatcher("/jsps/donor/donor_read_output.jsp").forward(request, response);
		}
	}
}



