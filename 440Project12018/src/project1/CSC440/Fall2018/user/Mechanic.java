package project1.CSC440.Fall2018.user;

import java.sql.*;

public class Mechanic {
	public static ResultSet mechanicGetHoursWorked(Statement st, String eid){
		String qstr = "SELECT hours FROM Mechanic WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting hours worked");
		}
		return rs;
	}
	public static void mechanicSetHoursWorked(Statement st, String eid, String hours){
		String qstr = "UPDATE Mechanic SET hours = " + hours + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting hours worked");
		}
	}
	static ResultSet mechanicGetRate(Statement st, String eid){
		String qstr = "SELECT rate FROM Mechanic WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting hourly rate");
		}
		return rs;
	}
	static void employeeSetComp(Statement st, String eid, String rate){
		String qstr = "UPDATE Mechanic SET rate = " + rate + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting hourly rate");
		}
	}
}
