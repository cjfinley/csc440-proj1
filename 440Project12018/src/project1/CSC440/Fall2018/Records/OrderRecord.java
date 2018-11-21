package project1.CSC440.Fall2018.Records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRecord {
	public static void createOrderRecord(Statement st, String sid, String orderDate, String expectedDate, String deliveredDate, String origin, String make, String part_name, String qty, String status){
		String fields[] = new String[9];
		fields[0] = sid;
		fields[1] = orderDate;
		fields[2] = expectedDate;
		fields[3] = deliveredDate;
		fields[4] = origin;
		fields[5] = make;
		fields[6] = part_name;
		fields[7] = qty;
		fields[8] = status;
		try{
			st.executeUpdate("INSERT INTO Ordered", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating order record");
		}
	}
	public static ResultSet getOrderRecord(Statement st, String oid){
		String qstr = "SELECT * FROM Ordered WHERE oid = " + oid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting order record");
		}
		return rs;
	}
	public static void updateOrderRecord(Statement st, String sid, String orderDate, String expectedDate, String deliveredDate, String origin, String make, String part_name, String qty, String status){
		String qstr = "UPDATE Ordered SET";
		if (!(sid == null) && !(sid.length() == 0)){
			qstr += " sid = " + sid + ",";
		}
		if (!(orderDate == null) && !(orderDate.length() == 0)){
			qstr += " orderDate = " + orderDate + ",";
		}
		if (!(expectedDate == null) && !(expectedDate.length() == 0)){
			qstr += " expectedDate = " + expectedDate + ",";
		}
		if (!(deliveredDate == null) && !(deliveredDate.length() == 0)){
			qstr += " deliveredDate = " + deliveredDate + ",";
		}
		if (!(origin == null) && !(origin.length() == 0)){
			qstr += " origin = " + origin + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(part_name == null) && !(part_name.length() == 0)){
			qstr += " part_name = " + part_name + ",";
		}
		if (!(qty == null) && !(qty.length() == 0)){
			qstr += " qty = " + qty + ",";
		}
		if (!(status == null) && !(status.length() == 0)){
			qstr += " status = " + status + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE sid = " + sid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating order record");
		}
	}
}
