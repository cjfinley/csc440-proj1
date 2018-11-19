package project1.CSC440.Fall2018.Objects;

import java.sql.*;

public class Parts {
	public static void createPart(Statement st, String part_name, String make, String price, String warranty){
		String fields[] = new String[4];
		fields[0] = part_name;
		fields[1] = make;
		fields[2] = price;
		fields[3] = warranty;
		try{
			st.executeUpdate("INSERT INTO Parts", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating part");
		}
	}
	static ResultSet getPart(Statement st, String part_name){
		String qstr = "SELECT * FROM Parts WHERE part_name = " + part_name;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting part");
		}
		return rs;
	}
	public static void updatePart(Statement st, String part_name, String make, String price, String warranty){
		String qstr = "UPDATE Parts SET";
		if (!(part_name == null) && !(part_name.length() == 0)){
			qstr += " part_name = " + part_name + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(price == null) && !(price.length() == 0)){
			qstr += " price = " + price + ",";
		}
		if (!(warranty == null) && !(warranty.length() == 0)){
			qstr += " warranty = " + warranty + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE part_name = " + part_name;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating part");
		}
	}
}
