package project1.CSC440.Fall2018.Records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRecord {
	public static void createOrderRecord(Connection conn, String sid, String orderDate, String expectedDate, String deliveredDate, String origin, String make, String part_name, String qty, String status) throws SQLException{
		String qstr = "INSERT INTO Ordered ?, ?, ?, ?, ?, ?, ?, ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, sid);
		st.setString(2, orderDate);
		st.setString(3, expectedDate);
		st.setString(4, deliveredDate);
		st.setString(5, origin);
		st.setString(6, make);
		st.setString(7, part_name);
		st.setString(8, qty);
		st.setString(9, status);
		st.executeUpdate();
	}
	public static ResultSet getOrderRecord(Connection conn, String sid, String part_name, String make) throws SQLException{
		String qstr = "SELECT * FROM Ordered WHERE sid = ? AND part_name = ? AND make = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, sid);
		st.setString(2, part_name);
		st.setString(3, make);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateOrderRecord(Connection conn, String sid, String orderDate, String expectedDate, String deliveredDate, String origin, String make, String part_name, String quantity, String status) throws SQLException{
		String qstr = "UPDATE Ordered SET";
		int[] track = {0,0,0,0,0,0,0,0,0};
		if (!(sid == null) && !(sid.length() == 0)){
			qstr += " sid = ?,";
			track[0] = 1;
		}
		if (!(orderDate == null) && !(orderDate.length() == 0)){
			qstr += " order_Date = ?,";
			track[1] = 1;
		}
		if (!(expectedDate == null) && !(expectedDate.length() == 0)){
			qstr += " exp_Delivery = ?,";
			track[2] = 1;
		}
		if (!(deliveredDate == null) && !(deliveredDate.length() == 0)){
			qstr += " act_Delivery = ?,";
			track[3] = 1;
		}
		if (!(origin == null) && !(origin.length() == 0)){
			qstr += " origin = ?,";
			track[4] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[5] = 1;
		}
		if (!(part_name == null) && !(part_name.length() == 0)){
			qstr += " part_name = ?,";
			track[6] = 1;
		}
		if (!(quantity == null) && !(quantity.length() == 0)){
			qstr += " quantity = ?,";
			track[7] = 1;
		}
		if (!(status == null) && !(status.length() == 0)){
			qstr += " status = ?,";
			track[8] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE sid = ? AND part_name = ? AND make = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, sid);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, orderDate);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, expectedDate);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, deliveredDate);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, origin);
			count++;
		}
		if(track[5] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[6] == 1){
			st.setString(count, part_name);
			count++;
		}
		if(track[7] == 1){
			st.setString(count, quantity);
			count++;
		}
		if(track[8] == 1){
			st.setString(count, status);
			count++;
		}
		st.setString(count, sid);
		count++;
		st.setString(count, part_name);
		count++;
		st.setString(count, make);
		st.executeUpdate();
	}
}
