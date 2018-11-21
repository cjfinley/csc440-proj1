package project1.CSC440.Fall2018.Objects;

import java.sql.*;

public class ServiceCenter {
	public static void createServiceCenter(Connection conn, String sid, String name, String address, String phone) throws SQLException{
		String qstr = "INSERT INTO Service_Center (sid, name, address, phone) VALUES (?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, sid);
		st.setString(2, name);
		st.setString(3, address);
		st.setString(4, phone);
		st.executeUpdate();
	}
	public static ResultSet getServiceCenter(Connection conn, String sid) throws SQLException{
		String qstr = "SELECT * FROM Service_Center WHERE sid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, sid);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateServiceCenter(Connection conn, String sid, String name, String address, String phone) throws SQLException{
		String qstr = "UPDATE Service_Center SET";
		int[] track = {0,0,0,0};
		if (!(sid == null) && !(sid.length() == 0)){
			qstr += " sid = ?,";
			track[0] = 1;
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = ?,";
			track[1] = 1;
		}
		if (!(address == null) && !(address.length() == 0)){
			qstr += " address = ?,";
			track[2] = 1;
		}
		if (!(phone == null) && !(phone.length() == 0)){
			qstr += " phone = ?,";
			track[3] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE sid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, sid);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, name);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, address);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, phone);
			count++;
		}
		st.setString(count, sid);
		st.executeUpdate();
	}
}
