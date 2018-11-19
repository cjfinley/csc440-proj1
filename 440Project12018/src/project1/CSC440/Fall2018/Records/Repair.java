package project1.CSC440.Fall2018.Records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repair {
	public static void createRepair(Statement st, String description, String diagnostic, String fee, String make, String model){
		String fields[] = new String[5];
		fields[0] = description;
		fields[1] = diagnostic;
		fields[2] = fee;
		fields[3] = make;
		fields[4] = model;
		try{
			st.executeUpdate("INSERT INTO Repairs", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating repair");
		}
	}
	static ResultSet getBasicService(Statement st, String description){
		String qstr = "SELECT * FROM Repairs WHERE description = " + description;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting repair");
		}
		return rs;
	}
	public static void updateBasicService(Statement st, String description, String diagnostic, String fee, String make, String model){
		String qstr = "UPDATE Repairs SET";
		if (!(description == null) && !(description.length() == 0)){
			qstr += " description = " + description + ",";
		}
		if (!(diagnostic == null) && !(diagnostic.length() == 0)){
			qstr += " diagnostic = " + diagnostic + ",";
		}
		if (!(fee == null) && !(fee.length() == 0)){
			qstr += " fee = " + fee + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = " + model + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE description = " + description;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating repair");
		}
	}
}
