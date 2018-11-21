package project1.CSC440.Fall2018.Records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicService {
	public static void createBasicService(Connection conn, String service, String make, String rate, String hours, String model) throws SQLException{
		String qstr = "INSERT INTO Basic_Service ?, ?, ?, ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, service);
		st.setString(2, make);
		st.setString(3, rate);
		st.setString(4, hours);
		st.setString(5, model);
		st.executeUpdate();
	}
	public static ResultSet getBasicService(Connection conn, String service) throws SQLException{
		String qstr = "SELECT * FROM Basic_Service WHERE service = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, service);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateBasicService(Connection conn, String service, String make, String rate, String hours, String model) throws SQLException{
		String qstr = "UPDATE Basic_Service SET";
		int[] track = {0,0,0,0,0};
		if (!(service == null) && !(service.length() == 0)){
			qstr += " service = ?,";
			track[0] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[1] = 1;
		}
		if (!(rate == null) && !(rate.length() == 0)){
			qstr += " rate = ?,";
			track[2] = 1;
		}
		if (!(hours == null) && !(hours.length() == 0)){
			qstr += " hours = ?,";
			track[3] = 1;
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = ?,";
			track[4] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE service = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, service);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, rate);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, hours);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, model);
			count++;
		}
		st.setString(count, service);
		st.executeUpdate();
	}
}
