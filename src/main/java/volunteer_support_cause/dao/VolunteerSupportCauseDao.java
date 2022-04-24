package volunteer_support_cause.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import volunteer_support_cause.domain.VolunteerSupportCause;

/**
 * DDL functions performed in database
 */
public class VolunteerSupportCauseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public VolunteerSupportCause findByVolunteerSupportCauseId(Integer volunteerid, Integer support_causeid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		VolunteerSupportCause volunteer_support_cause = new VolunteerSupportCause();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from volunteer_support_cause where volunteer_id=? and support_cause_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,volunteerid);
		    preparestatement.setInt(2,support_causeid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer volunteer_id = resultSet.getInt("volunteer_id");
		    	Integer support_cause_id = resultSet.getInt("support_cause_id");
		    	if((volunteer_id == volunteerid) && (support_cause_id == support_causeid)){
		    		volunteer_support_cause.setVolunteer_id(volunteer_id);
		    		volunteer_support_cause.setSupport_cause_id(support_cause_id);
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return volunteer_support_cause;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(VolunteerSupportCause form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into volunteer_support_cause(volunteer_id, support_cause_id) values(?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getVolunteer_id());
		    preparestatement.setInt(2,form.getSupport_cause_id());
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
	public void update(VolunteerSupportCause form, VolunteerSupportCause volunteer_support_cause) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE volunteer_support_cause SET volunteer_id = ?, support_cause_id = ? where volunteer_id = ? and support_cause_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			System.out.println(form.getVolunteer_id());
			System.out.println(form.getSupport_cause_id());
		    preparestatement.setInt(1,form.getVolunteer_id());
			preparestatement.setInt(2,form.getSupport_cause_id());
			preparestatement.setInt(3,volunteer_support_cause.getVolunteer_id());
			preparestatement.setInt(4,volunteer_support_cause.getSupport_cause_id());
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
	public void delete(Integer volunteer_id, Integer support_cause_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from volunteer_support_cause where volunteer_id = ? and support_cause_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,volunteer_id);
		    preparestatement.setInt(2,support_cause_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
