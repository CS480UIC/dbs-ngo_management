package cause.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cause.dao.CauseDao;
import cause.domain.Cause;


/**
 * Servlet implementation class UserServlet
 */

public class CauseServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CauseServletDelete() {
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
		CauseDao causeDao = new CauseDao();
		Cause cause = null;
		if(method.equals("search"))
		{
			try {
				cause = causeDao.findByCauseId(Integer.parseInt(request.getParameter("cause_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(cause.getCause_id()!= null){
						System.out.println(cause);
						request.setAttribute("cause", cause);
						request.getRequestDispatcher("/jsps/cause/cause_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Cause not found");
				request.getRequestDispatcher("/jsps/cause/cause_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				causeDao.delete(Integer.parseInt(request.getParameter("cause_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Cause Deleted");
			request.getRequestDispatcher("/jsps/cause/cause_read_output.jsp").forward(request, response);
		}
	}
}



