package project1.CSC440.Fall2018.Objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Distributor {
	public static void createDistributor(Statement st, String did, String name){
		String fields[] = new String[2];
		fields[0] = did;
		fields[1] = name;
		try{
			st.executeUpdate("INSERT INTO Distributors", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating distributor");
		}
	}
	static ResultSet getDistributor(Statement st, String did){
		String qstr = "SELECT * FROM Distributors WHERE did = " + did;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting distributor");
		}
		return rs;
	}
	public static void updatePart(Statement st, String did, String name){
		String qstr = "UPDATE Distributors SET";
		if (!(did == null) && !(did.length() == 0)){
			qstr += " did = " + did + ",";
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = " + name + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE did = " + did;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating distributor");
		}
	}
}
