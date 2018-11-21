package project1.CSC440.Fall2018.Objects;

import java.sql.*;

public class Parts {
	public static void createPart(Connection conn, String part_name, String make, String price, String warranty) throws SQLException{
		String qstr = "INSERT INTO Parts (part_name, make, price, warranty) VALUES ?, ?, ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, part_name);
		st.setString(2, make);
		st.setString(3, price);
		st.setString(4, warranty);
		st.executeUpdate();
	}
	public static ResultSet getPart(Connection conn, String part_name) throws SQLException{
		String qstr = "SELECT * FROM Parts WHERE part_name = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, part_name);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updatePart(Connection conn, String part_name, String make, String price, String warranty) throws SQLException{
		String qstr = "UPDATE Parts SET";
		int[] track = {0,0,0,0};
		if (!(part_name == null) && !(part_name.length() == 0)){
			qstr += " part_name = ?,";
			track[0] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[1] = 1;
		}
		if (!(price == null) && !(price.length() == 0)){
			qstr += " price = ?,";
			track[2] = 1;
		}
		if (!(warranty == null) && !(warranty.length() == 0)){
			qstr += " warranty = ?,";
			track[3] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE part_name = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, part_name);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, price);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, warranty);
			count++;
		}
		st.setString(count, part_name);
		st.executeUpdate();
	}
}
