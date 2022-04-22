package cause_organization.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import cause_organization.domain.CauseOrganization;

/**
 * DDL functions performed in database
 */
public class CauseOrganizationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public CauseOrganization findByCauseOrganizationId(Integer causeid, Integer organizationid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		CauseOrganization cause_organization = new CauseOrganization();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from cause_organization where cause_id=? and organization_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,causeid);
		    preparestatement.setInt(2,organizationid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer cause_id = resultSet.getInt("cause_id");
		    	Integer organization_id = resultSet.getInt("organization_id");
		    	if((cause_id == causeid) && (organization_id == organizationid)){
		    		cause_organization.setCause_id(cause_id);
		    		cause_organization.setOrganization_id(organization_id);
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return cause_organization;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(CauseOrganization form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into cause_organization(cause_id, organization_id) values(?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCause_id());
		    preparestatement.setInt(2,form.getOrganization_id());
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
	public void update(CauseOrganization form, CauseOrganization cause_organization) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE cause_organization SET cause_id = ?, organization_id = ? where cause_id = ? and organization_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCause_id());
			preparestatement.setInt(2,form.getOrganization_id());
		    preparestatement.setFloat(3,cause_organization.getCause_id());
		    preparestatement.setInt(4,cause_organization.getOrganization_id());
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
	public void delete(Integer cause_id, Integer organization_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from cause_organization where cause_id = ? and organization_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,cause_id);
		    preparestatement.setInt(2,organization_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
