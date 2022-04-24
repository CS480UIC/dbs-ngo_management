package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import employee.domain.Employee;
import user.domain.User;

/**
 * DDL functions performed in database
 */
public class EmployeeDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Employee findByEmployeeId(Integer employeeid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Employee employee = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from employee where employee_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,employeeid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer employee_id = resultSet.getInt("employee_id");
		    	if(employee_id == employeeid){
		    		employee.setEmployee_id(employee_id);
		    		employee.setFirst_name(resultSet.getString("first_name"));
		    		employee.setLast_name(resultSet.getString("last_name"));
		    		employee.setSsn(resultSet.getString("ssn"));
		    		employee.setOrganization_id(Integer.parseInt(resultSet.getString("organization_id")));
		    		employee.setSalary(Float.parseFloat(resultSet.getString("salary")));
		    		employee.setBirth_date(resultSet.getString("birth_date"));
		    		employee.setAddress(resultSet.getString("address"));
		    		employee.setEmail(resultSet.getString("email"));
		    		employee.setPhone(resultSet.getString("phone"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return employee;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Employee form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into employee(employee_id, first_name, last_name, ssn, organization_id, salary, birth_date, address, email, phone) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getEmployee_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setString(4,form.getSsn());
		    preparestatement.setInt(5,form.getOrganization_id());
		    preparestatement.setFloat(6,form.getSalary());
		    preparestatement.setDate(7, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(8,form.getAddress());
		    preparestatement.setString(9,form.getEmail());
		    preparestatement.setString(10,form.getPhone());
		    
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Employee form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE employee SET first_name = ?, last_name = ?, ssn = ?, organization_id = ?, salary = ?, birth_date = ?, address = ?, email = ?, phone = ? where employee_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setString(3,form.getSsn());
		    preparestatement.setInt(4,form.getOrganization_id());
		    preparestatement.setFloat(5,form.getSalary());
		    preparestatement.setDate(6, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(7,form.getAddress());
		    preparestatement.setString(8,form.getEmail());
		    preparestatement.setString(9,form.getPhone());
		    preparestatement.setInt(10,form.getEmployee_id());

		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer employee_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from employee where employee_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,employee_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Object> findEmployees() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select employee_id, first_name from employee where salary >= 50000 and salary <= 100000";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Employee employee = new Employee();
				employee.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
				employee.setFirst_name(resultSet.getString("first_name"));
				list.add(employee);
			}
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
	
	public List<Object> findExpense() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select SUM(salary) AS TOTAL_EXPENSE from employee where address like \\'%Chicago%\\'";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("TOTAL_EXPENSE"));
	    		list.add(resultSet.getString("TOTAL_EXPENSE"));
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
}
