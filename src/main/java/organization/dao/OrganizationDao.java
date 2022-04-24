package organization.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employee.domain.Employee;

//import java.util.ArrayList;
//import java.util.List;

import organization.domain.Organization;
import organization.domain.EmployeeOrganization;

/**
 * DDL functions performed in database
 */
public class OrganizationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Organization findByOrganizationId(Integer organizationid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Organization organization = new Organization();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from organization where organization_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,organizationid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer organization_id = resultSet.getInt("organization_id");
		    	if(organization_id == organizationid){
		    		organization.setOrganization_id(organization_id);
		    		organization.setOrganization_name(resultSet.getString("organization_name"));
		    		organization.setAddress(resultSet.getString("address"));
		    		organization.setEmail(resultSet.getString("email"));
		    		organization.setPhone(resultSet.getString("phone"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return organization;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Organization form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into organization(organization_id, organization_name, address, email, phone) values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getOrganization_id());
		    preparestatement.setString(2,form.getOrganization_name());
		    preparestatement.setString(3,form.getAddress());
		    preparestatement.setString(4,form.getEmail());
		    preparestatement.setString(5,form.getPhone());

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
	public void update(Organization form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE organization SET organization_name = ?, address = ?, email = ?, phone = ? where organization_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getOrganization_name());
		    preparestatement.setString(2,form.getAddress());
		    preparestatement.setString(3,form.getEmail());
		    preparestatement.setString(4,form.getPhone());
		    preparestatement.setInt(5,form.getOrganization_id());
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
	public void delete(Integer organization_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from organization where organization_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,organization_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findEmployeeOrg() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "create or replace view emp_org AS\r\n"
					+ "select E.employee_id, E.first_name, O.organization_name\r\n"
					+ "from ngo_management_system.employee E\r\n"
					+ "inner join ngo_management_system.organization O ON O.organization_id = E.organization_id\r\n"
					+ "group by E.organization_id\r\n"
					+ "order by E.first_name asc";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			sql = "select * from emp_org";
			preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				EmployeeOrganization emporg = new EmployeeOrganization();
				emporg.setEmployee_id(Integer.parseInt(resultSet.getString("employee_id")));
				emporg.setFirst_name(resultSet.getString("first_name"));
				emporg.setOrganization_name(resultSet.getString("organization_name"));
				list.add(emporg);
			}
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
}
