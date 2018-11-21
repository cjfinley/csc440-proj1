package project1.CSC440.Fall2018.Records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceHistory {
	public static void createServiceHistory(Connection conn, String plate, String service_type, String make, String model, String service_date, String start_time, String mechanic_name) throws SQLException{
		String qstr = "INSERT INTO Service_History ?, ?, ?, ?, ?, ?, ?, ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, plate);
		st.setString(2, service_type);
		st.setString(3, make);
		st.setString(4, model);
		st.setString(5, service_date);
		st.setString(6, start_time);
		st.setString(7, mechanic_name);
		st.executeUpdate();
	}
	public static ResultSet getServiceHistory(Connection conn, String plate, String service_date, String service_type) throws SQLException{
		String qstr = "SELECT * FROM Service_History WHERE plate = ? AND service_date = ? AND service_type = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, plate);
		st.setString(2, service_date);
		st.setString(3, service_type);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateServiceHistory(Connection conn, String plate, String service_type, String make, String model, String service_date, String start_time, String mechanic_name) throws SQLException{
		String qstr = "UPDATE Service_History SET";
		int[] track = {0,0,0,0,0,0,0};
		if (!(plate == null) && !(plate.length() == 0)){
			qstr += " plate = ?,";
			track[0] = 1;
		}
		if (!(service_type == null) && !(service_type.length() == 0)){
			qstr += " service_type = ?,";
			track[1] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[2] = 1;
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = ?,";
			track[3] = 1;
		}
		if (!(service_date == null) && !(service_date.length() == 0)){
			qstr += " service_date = ?,";
			track[4] = 1;
		}
		if (!(start_time == null) && !(start_time.length() == 0)){
			qstr += " start_time = ?,";
			track[5] = 1;
		}
		if (!(mechanic_name == null) && !(mechanic_name.length() == 0)){
			qstr += " mechanic_name = ?,";
			track[6] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE plate = ? AND service_date = ? AND service_type = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, plate);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, service_type);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, model);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, service_date);
			count++;
		}
		if(track[5] == 1){
			st.setString(count, start_time);
			count++;
		}
		if(track[6] == 1){
			st.setString(count, mechanic_name);
			count++;
		}
		st.setString(count, plate);
		count++;
		st.setString(count, service_date);
		count++;
		st.setString(count, service_type);
		st.executeUpdate();
	}
}
