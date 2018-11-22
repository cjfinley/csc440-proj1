package project1.CSC440.Fall2018.user;

import java.sql.*;

import project1.CSC440.Fall2018.Objects.Vehicle;

public class Customer {
	public static void createCustomer(Connection conn, String cid, String address, String name, String email, String phone) throws SQLException{
		String qstr = "INSERT INTO Customer (cid, address, name, email, phone) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, cid);
		st.setString(2, address);
		st.setString(3, name);
		st.setString(4, email);
		st.setString(5, phone);
		st.executeUpdate();
	}
	public static ResultSet getCustomer(Connection conn, String cid) throws SQLException{
		String qstr = "SELECT * FROM Customer WHERE cid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, cid);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static ResultSet getCustomerByEmail(Connection conn, String email) throws SQLException{
		String qstr = "SELECT * FROM Customer WHERE email = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, email);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateCustomer(Connection conn, String cid, String address, String name, String email, String phone) throws SQLException{
		String qstr = "UPDATE Customer SET";
		int[] track = {0,0,0,0,0};
		if (!(cid == null) && !(cid.length() == 0)){
			qstr += " cid = ?,";
			track[0] = 1;
		}
		if (!(address == null) && !(address.length() == 0)){
			qstr += " address = ?,";
			track[1] = 1;
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = ?,";
			track[2] = 1;
		}
		if (!(email == null) && !(email.length() == 0)){
			qstr += " email = ?,";
			track[3] = 1;
		}
		if (!(phone == null) && !(phone.length() == 0)){
			qstr += " phone = ?,";
			track[4] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE cid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, cid);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, address);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, name);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, email);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, phone);
			count++;
		}
		st.setString(count, cid);
		st.executeUpdate();
	}
	public static String getMaxCustomerId(Statement st) throws SQLException{
		String query = "Select MAX(cid) As mcid From Customer";
		ResultSet rs = null;
		String maxcid = null;
		rs = st.executeQuery(query);
		rs.next();
		maxcid = rs.getString("mcid");
		return maxcid;
	}
	
	// adds a user/vehicle pair to the vehicle table and the owns table
	public static void registerVehicle( Connection conn, String cid, String plate, String make, String model, String miles, String since  ) throws SQLException{
		// insert the vehicle into the vehicle table
		Vehicle.createVehicle(conn, plate, make, model, miles);
		// add the vehicle and user pair to the owns table
		String qstr = "INSERT INTO OWNS ( cid, plate, since ) VALUES (?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, cid);
		st.setString(2, plate);
		st.setString(3, since);
		st.executeUpdate();
	}
	
	public static String viewServiceHistory(Connection conn, String plate, String service_date, String service_type) throws SQLException {
		return null;
	}
}
