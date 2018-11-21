package project1.CSC440.Fall2018.Records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarService {
	public static void createCarService(Connection conn, String make, String service_type, String milage, String model) throws SQLException{
		String qstr = "INSERT INTO Car_Services ?, ?, ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, make);
		st.setString(2, service_type);
		st.setString(3, milage);
		st.setString(4, model);
		st.executeUpdate();
	}
	public static ResultSet getCarService(Connection conn, String service_type, String milage) throws SQLException{
		String qstr = "SELECT * FROM Car_Services WHERE service_type = ? AND milage = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, service_type);
		st.setString(1, milage);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateCarService(Connection conn, String make, String service_type, String milage, String model) throws SQLException{
		String qstr = "UPDATE Car_Services SET";
		int[] track = {0,0,0,0};
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[0] = 1;
		}
		if (!(service_type == null) && !(service_type.length() == 0)){
			qstr += " service_type = ?,";
			track[1] = 1;
		}
		if (!(milage == null) && !(milage.length() == 0)){
			qstr += " milage = ?,";
			track[2] = 1;
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = ?,";
			track[3] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE service_type = ? AND milage = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, service_type);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, milage);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, model);
			count++;
		}
		st.setString(count, service_type);
		count++;
		st.setString(count, milage);
		st.executeUpdate();
	}
}
