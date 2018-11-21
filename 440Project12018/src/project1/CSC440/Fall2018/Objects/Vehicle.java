package project1.CSC440.Fall2018.Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehicle {
	public static void createVehicle(Connection conn, String plate, String make, String model, String miles) throws SQLException{
		String qstr = "INSERT INTO Vehicle ( plate, make, model, miles ) VALUES (?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, plate);
		st.setString(2, make);
		st.setString(3, model);
		st.setString(4, miles);
		st.executeUpdate();
	}
	public static ResultSet getVehicle(Connection conn, String plate) throws SQLException{
		String qstr = "SELECT * FROM Vehicle WHERE plate = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, plate);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static ResultSet getPlatesForOwner(Connection conn, String cid) throws SQLException{
		String qstr = "SELECT * FROM OWNS WHERE cid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, cid);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void registerVehicle(Connection conn, String cid, String plate, String since) throws SQLException{
		String qstr = "INSERT INTO OWNS ( cid, plate, since ) VALUES (?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, cid);
		st.setString(2, plate);
		st.setString(3, since);
		st.executeUpdate();
	}
	public static void updateVehicle(Connection conn, String plate, String make, String model, String miles) throws SQLException{
		String qstr = "UPDATE Vehicle SET";
		int[] track = {0,0,0,0};
		if (!(plate == null) && !(plate.length() == 0)){
			qstr += " plate = ?,";
			track[0] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[1] = 1;
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = ?,";
			track[2] = 1;
		}
		if (!(miles == null) && !(miles.length() == 0)){
			qstr += " miles = ?,";
			track[3] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE plate = ?";
		//Shows what qstr looks like before populated with data
		//System.out.println(qstr);
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, plate);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, model);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, miles);
			count++;
		}
		st.setString(count, plate);
		st.executeUpdate();
	}
}
