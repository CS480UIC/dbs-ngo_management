package volunteer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;

//import java.util.ArrayList;
//import java.util.List;

import volunteer.domain.Volunteer;
import volunteer.domain.VolunteerCause;

/**
 * DDL functions performed in database
 */
public class VolunteerDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Volunteer findByVolunteerId(Integer volunteerid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Volunteer volunteer = new Volunteer();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from volunteer where volunteer_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,volunteerid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer volunteer_id = resultSet.getInt("volunteer_id");
		    	if(volunteer_id == volunteerid){
		    		volunteer.setVolunteer_id(volunteer_id);
		    		volunteer.setFirst_name(resultSet.getString("first_name"));
		    		volunteer.setLast_name(resultSet.getString("last_name"));
		    		volunteer.setBirth_date(resultSet.getString("birth_date"));
		    		volunteer.setAddress(resultSet.getString("address"));
		    		volunteer.setEmail(resultSet.getString("email"));
		    		volunteer.setPhone(resultSet.getString("phone"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return volunteer;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Volunteer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into volunteer(volunteer_id, first_name, last_name, birth_date, address, email, phone) values(?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getVolunteer_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setDate(4, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(5,form.getAddress());
		    preparestatement.setString(6,form.getEmail());
		    preparestatement.setString(7,form.getPhone());
		    
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
	public void update(Volunteer form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE volunteer SET first_name = ?, last_name = ?, birth_date = ?, address = ?, email = ?, phone = ? where volunteer_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(4,form.getAddress());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getPhone());
		    preparestatement.setInt(7,form.getVolunteer_id());

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
	public void delete(Integer volunteer_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from volunteer where volunteer_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,volunteer_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findVolunteers() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select volunteer_id, first_name from volunteer where birth_date <= \"1980-01-01\"";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Volunteer volunteer = new Volunteer();
				volunteer.setVolunteer_id(Integer.parseInt(resultSet.getString("volunteer_id")));
				volunteer.setFirst_name(resultSet.getString("first_name"));
				list.add(volunteer);
			}
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
	
	public List<Object> findVolunteerCause() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "CREATE OR REPLACE VIEW cause_volunteer AS\n"
					+"SELECT v.volunteer_id, v.first_name, num_causes, c.cause_name\n"
					+"FROM volunteer v INNER JOIN\n"
					+"(SELECT volunteer_id, count(support_cause_id) AS num_causes\n"
					+"FROM volunteer_support_cause GROUP BY volunteer_id) AS num_cause_table\n"
					+"ON v.volunteer_id = num_cause_table.volunteer_id\n"
					+"INNER JOIN volunteer_support_cause vs ON v.volunteer_id = vs.volunteer_id\n"
					+"INNER JOIN cause c ON c.cause_id = vs.support_cause_id\n"
					+"ORDER BY v.first_name ASC";

			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			sql = "SELECT * FROM cause_volunteer";
			preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				VolunteerCause volunteercause = new VolunteerCause();
				volunteercause.setVolunteer_id(Integer.parseInt(resultSet.getString("volunteer_id")));
				volunteercause.setFirst_name(resultSet.getString("first_name"));
				volunteercause.setNum_causes(Integer.parseInt(resultSet.getString("num_causes")));
				volunteercause.setCause_name(resultSet.getString("cause_name"));

	    		list.add(volunteercause);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
}
