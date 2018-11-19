package project1.CSC440.Fall2018.Records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicService {
	public static void createBasicService(Statement st, String service, String make, String rate, String hours, String model){
		String fields[] = new String[5];
		fields[0] = service;
		fields[1] = make;
		fields[2] = rate;
		fields[3] = hours;
		fields[4] = model;
		try{
			st.executeUpdate("INSERT INTO Basic_Service", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating basic service");
		}
	}
	static ResultSet getBasicService(Statement st, String service){
		String qstr = "SELECT * FROM Basic_Service WHERE service = " + service;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting basic service");
		}
		return rs;
	}
	public static void updateBasicService(Statement st, String service, String make, String rate, String hours, String model){
		String qstr = "UPDATE Basic_Service SET";
		if (!(service == null) && !(service.length() == 0)){
			qstr += " service = " + service + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(rate == null) && !(rate.length() == 0)){
			qstr += " rate = " + rate + ",";
		}
		if (!(hours == null) && !(hours.length() == 0)){
			qstr += " hours = " + hours + ",";
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = " + model + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE service = " + service;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating basic service");
		}
	}
}
