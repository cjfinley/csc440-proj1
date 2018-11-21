package project1.CSC440.Fall2018.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Receptionist {
	public static ResultSet receptionistGetSalary(Statement st, String eid){
		String qstr = "SELECT salary FROM Receptionists WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting salary");
		}
		return rs;
	}
	public static void receptionistSetSalary(Statement st, String eid, String salary){
		String qstr = "UPDATE Receptionists SET salary = " + salary + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting salary");
		}
	}
}
