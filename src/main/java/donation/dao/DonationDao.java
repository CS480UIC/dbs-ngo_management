package donation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import donation.domain.Donation;
import employee.domain.Employee;

/**
 * DDL functions performed in database
 */
public class DonationDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "ngo_management_system"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "s_cube"; //TODO change password

	public Donation findByDonationId(Integer donationid) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Donation donation = new Donation();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
		    String sql = "select * from donation where transaction_id=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,donationid);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer donation_id = resultSet.getInt("transaction_id");
		    	if(donation_id == donationid){
		    		donation.setTransaction_id(donation_id);
		    		donation.setDonor_id(Integer.parseInt(resultSet.getString("donor_id")));
		    		donation.setResource_id(Integer.parseInt(resultSet.getString("resource_id")));
		    		donation.setOrganization_id(Integer.parseInt(resultSet.getString("organization_id")));
		    		donation.setTime(resultSet.getString("time"));
		    		donation.setAmount(Float.parseFloat(resultSet.getString("amount")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return donation;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Donation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "insert into donation(transaction_id, donor_id, resource_id, organization_id, time, amount) values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getTransaction_id());
		    preparestatement.setInt(2,form.getDonor_id());
		    preparestatement.setInt(3,form.getResource_id());
		    preparestatement.setInt(4,form.getOrganization_id());
		    preparestatement.setTimestamp(5,java.sql.Timestamp.valueOf(form.getTime()));
		    preparestatement.setFloat(6,form.getAmount());

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
	public void update(Donation form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "UPDATE donation SET  donor_id = ?, resource_id = ?, organization_id = ?, time = ?, amount = ? where transaction_id = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getDonor_id());
		    preparestatement.setInt(2,form.getResource_id());
		    preparestatement.setInt(3, form.getOrganization_id());
		    preparestatement.setTimestamp(4,java.sql.Timestamp.valueOf(form.getTime()));
		    preparestatement.setFloat(5,form.getAmount());
		    preparestatement.setInt(6,form.getTransaction_id());
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
	public void delete(Integer transaction_id) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			
			String sql = "delete from donation where transaction_id = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,transaction_id);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select transaction_id, donor_id from donation where amount >= 1000 and amount <= 10000";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Donation donation = new Donation();
				donation.setTransaction_id(Integer.parseInt(resultSet.getString("transaction_id")));
				donation.setDonor_id(Integer.parseInt(resultSet.getString("donor_id")));
				list.add(donation);
			}
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public List<Object> findTotalDonations() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ngo_management_system", MySQL_user, MySQL_password);
			String sql = "select count(transaction_id) as TOTAL_DONATIONS from donation where time < \'2022-02-03 05:00:00\'";
			PreparedStatement preparestatement = connect.prepareStatement(sql);
			ResultSet resultSet = preparestatement.executeQuery();
			while(resultSet.next()){
	    		list.add(resultSet.getString("TOTAL_DONATIONS"));
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;

	}

}
