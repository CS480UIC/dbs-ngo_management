package cause.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import cause.domain.Cause;

/**
 * DDL functions performed in database
 */
public class CauseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Cause findByCauseId(Integer causeid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Cause cause = new Cause();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from cause where cause_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,causeid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer cause_id = resultSet.getInt("cause_id");
		    	if(cause_id.equals(causeid)){
		    		cause.setCause_id(cause_id);
		    		cause.setCause_name(resultSet.getString("cause_name"));
		    		cause.setCause_supported(resultSet.getString("cause_supported"));
		    		cause.setCause_funds_raised(resultSet.getFloat("cause_funds_raised"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return cause;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Cause form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into cause(cause_id, cause_name, cause_supported, cause_funds_raised) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCause_id());
		    preparestatement.setString(2,form.getCause_name());
		    preparestatement.setString(3,form.getCause_supported());
		    preparestatement.setFloat(4,form.getCause_funds_raised()); 
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
	public void update(Cause form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE cause SET cause_name = ?, cause_supported = ?, cause_funds_raised = ? where cause_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getCause_name());
			preparestatement.setString(2,form.getCause_supported());
		    preparestatement.setFloat(3,form.getCause_funds_raised());
		    preparestatement.setInt(4,form.getCause_id());
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
	public void delete(Integer cause_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from cause where cause_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,cause_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
