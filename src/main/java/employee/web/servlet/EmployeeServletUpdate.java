package employee.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee.dao.EmployeeDao;
import employee.domain.Employee;

/**
 * Servlet implementation class UserServlet
 */

public class EmployeeServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServletUpdate() {
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
		EmployeeDao employeedao = new EmployeeDao();
		Employee employee = null;

		if(method.equals("search"))
		{
			try {
				employee = employeedao.findByEmployeeId(Integer.parseInt(request.getParameter("employee_id")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(employee.getEmployee_id()!=null){
				request.setAttribute("employee", employee);
				request.getRequestDispatcher("/jsps/employee/employee_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Employee not found");
				request.getRequestDispatcher("/jsps/employee/employee_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Employee form = new Employee();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
				System.out.println(values[0]);
			}

			form.setEmployee_id(Integer.parseInt(request.getParameter("employee_id")));
			form.setFirst_name(info.get(2));
			form.setLast_name(info.get(3));
			form.setSsn(info.get(4));
			form.setOrganization_id(Integer.parseInt(info.get(5)));
			form.setSalary(Float.parseFloat(info.get(6)));
			form.setBirth_date(info.get(7));
			form.setAddress(info.get(8));
			form.setEmail(info.get(9));
			form.setPhone(info.get(10));

			try {
				employeedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "employee Updated");
			request.getRequestDispatcher("/jsps/employee/employee_read_output.jsp").forward(request, response);
		}
	}
}



