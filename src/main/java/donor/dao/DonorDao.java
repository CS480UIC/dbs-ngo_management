package donor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import donor.domain.Donor;
import employee.domain.Employee;

/**
 * DDL functions performed in database
 */
public class DonorDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Donor findByDonorId(Integer donorid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Donor donor = new Donor();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from donor where donor_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,donorid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer donor_id = resultSet.getInt("donor_id");
		    	if(donor_id == donorid){
		    		donor.setDonor_id(donor_id);
		    		donor.setFirst_name(resultSet.getString("first_name"));
		    		donor.setLast_name(resultSet.getString("last_name"));
		    		donor.setBirth_date(resultSet.getString("birth_date"));
		    		donor.setAddress(resultSet.getString("address"));
		    		donor.setEmail(resultSet.getString("email"));
		    		donor.setPhone(resultSet.getString("phone"));
		    		donor.setNum_of_donations(Integer.parseInt(resultSet.getString("num_of_donations")));
		    		donor.setLast_donation(resultSet.getString("last_donation"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return donor;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Donor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into donor(donor_id, first_name, last_name, birth_date, address, email, phone, num_of_donations, last_donation) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getDonor_id());
		    preparestatement.setString(2,form.getFirst_name());
		    preparestatement.setString(3,form.getLast_name());
		    preparestatement.setDate(4, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(5,form.getAddress());
		    preparestatement.setString(6,form.getEmail());
		    preparestatement.setString(7,form.getPhone());
		    preparestatement.setInt(8,form.getNum_of_donations());
		    preparestatement.setDate(9,java.sql.Date.valueOf(form.getLast_donation()));
		    
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
	public void update(Donor form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE donor SET first_name = ?, last_name = ?, birth_date = ?, address = ?, email = ?, phone = ?, num_of_donations = ?, last_donation = ? where donor_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFirst_name());
		    preparestatement.setString(2,form.getLast_name());
		    preparestatement.setDate(3, java.sql.Date.valueOf(form.getBirth_date()));
		    preparestatement.setString(4,form.getAddress());
		    preparestatement.setString(5,form.getEmail());
		    preparestatement.setString(6,form.getPhone());
		    preparestatement.setInt(7,form.getNum_of_donations());
		    preparestatement.setDate(8,java.sql.Date.valueOf(form.getLast_donation()));
		    preparestatement.setInt(9,form.getDonor_id());

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
	public void delete(Integer donor_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from donor where donor_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,donor_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findNumberDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select first_name, sum(num_of_donations) as num_donations from donor group by first_name having sum(num_of_donations) > 50";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Donor donor = new Donor();
				donor.setFirst_name(resultSet.getString("first_name"));
				donor.setNum_of_donations(Integer.parseInt(resultSet.getString("num_donations")));
				list.add(donor);
			}
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
	
	public List<Object> findDonorsTime() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "create or replace view donate_time as\\r\\n"
					+ "select d.first_name, d.last_name \\r\\n"
					+ "from donor as d\\r\\n"
					+ "where exists (select n.donor_id\\r\\n"
					+ "			  from donation as n\\r\\n"
					+ "			  where d.donor_id=n.donor_id\\r\\n"
					+ "	          and time < '2022-02-03 05:00:00')";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			preparestatement.executeUpdate();
			sql = "SELECT * FROM donate_time";
			preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
				Donor donor = new Donor();
				donor.setFirst_name(resultSet.getString("first_name"));
				donor.setLast_name(resultSet.getString("last_name"));
	    		list.add(donor);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}
}
