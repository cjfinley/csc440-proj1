package project1.CSC440.Fall2018.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manager {
	public static void createManager(Connection conn, String role, String eid, String name, String address, String email, String phoneNum, String salary) throws SQLException{
		String qstr = "INSERT INTO Managers (role, eid, name, address, email, phone, salary) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, role);
		st.setString(2, eid);
		st.setString(3, name);
		st.setString(4, address);
		st.setString(5, email);
		st.setString(6, phoneNum);
		st.setString(7, salary);
		st.executeUpdate();
	}
	public static ResultSet getManager(Connection conn, String eid) throws SQLException{
		String qstr = "SELECT * FROM Managers WHERE eid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, eid);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateManager(Connection conn, String role, String eid, String name, String address, String email, String phoneNum, String salary) throws SQLException{
		String qstr = "UPDATE Managers SET";
		int[] track = {0,0,0,0,0,0,0};
		if (!(role == null) && !(role.length() == 0)){
			qstr += " role = ?,";
			track[0] = 1;
		}
		if (!(eid == null) && !(eid.length() == 0)){
			qstr += " eid = ?,";
			track[1] = 1;
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = ?,";
			track[2] = 1;
		}
		if (!(address == null) && !(address.length() == 0)){
			qstr += " address = ?,";
			track[3] = 1;
		}
		if (!(email == null) && !(email.length() == 0)){
			qstr += " email = ?,";
			track[4] = 1;
		}
		if (!(phoneNum == null) && !(phoneNum.length() == 0)){
			qstr += " phone = ?,";
			track[5] = 1;
		}
		if (!(salary == null) && !(salary.length() == 0)){
			qstr += " salary = ?,";
			track[5] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE eid = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, role);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, eid);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, name);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, address);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, email);
			count++;
		}
		if(track[5] == 1){
			st.setString(count, phoneNum);
			count++;
		}
		if(track[6] == 1){
			st.setString(count, salary);
			count++;
		}
		st.setString(count, eid);
		st.executeUpdate();
	}
}
