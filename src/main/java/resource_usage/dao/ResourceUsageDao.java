package resource_usage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import resource_usage.domain.ResourceUsage;

/**
 * DDL functions performed in database
 */
public class ResourceUsageDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public ResourceUsage findByResourceUsageId(Integer resource_usageid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		ResourceUsage resource_usage = new ResourceUsage();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from resource_usage where usage_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,resource_usageid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer resource_usage_id = resultSet.getInt("usage_id");
		    	if(resource_usage_id == resource_usageid){
		    		resource_usage.setUsage_id(resource_usage_id);
		    		resource_usage.setResource_id(Integer.parseInt(resultSet.getString("resource_id")));
		    		resource_usage.setOrganization_id(Integer.parseInt(resultSet.getString("organization_id")));
		    		resource_usage.setUsage_count(Float.parseFloat(resultSet.getString("usage_count")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return resource_usage;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(ResourceUsage form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into resource_usage(usage_id, resource_id, organization_id, usage_count) values(?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getUsage_id());
		    preparestatement.setInt(2,form.getResource_id());
		    preparestatement.setInt(3,form.getOrganization_id());
		    preparestatement.setFloat(4,form.getUsage_count());

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
	public void update(ResourceUsage form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE resource_usage SET resource_id = ?, organization_id = ?, usage_count = ? where usage_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getResource_id());
		    preparestatement.setInt(2, form.getOrganization_id());
		    preparestatement.setFloat(3,form.getUsage_count());
		    preparestatement.setInt(4, form.getUsage_id());
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
	public void delete(Integer usage_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from resource_usage where usage_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,usage_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
