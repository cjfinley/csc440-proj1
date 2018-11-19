package project1.CSC440.Fall2018.Records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepairHistory {
	public static void createServiceHistory(Statement st, String plate, String service_type, String make, String model, String repair_date, String start_time, String mechanic_name){
		String fields[] = new String[7];
		fields[0] = plate;
		fields[1] = service_type;
		fields[2] = make;
		fields[3] = model;
		fields[4] = repair_date;
		fields[5] = start_time;
		fields[6] = mechanic_name;
		try{
			st.executeUpdate("INSERT INTO Repair_History", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating repair history");
		}
	}
	static ResultSet getServiceHistory(Statement st, String plate){
		String qstr = "SELECT * FROM Repair_History WHERE plate = " + plate;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting repair history");
		}
		return rs;
	}
	public static void updateBasicService(Statement st, String plate, String service_type, String make, String model, String repair_date, String start_time, String mechanic_name){
		String qstr = "UPDATE Repair_History SET";
		if (!(plate == null) && !(plate.length() == 0)){
			qstr += " plate = " + plate + ",";
		}
		if (!(service_type == null) && !(service_type.length() == 0)){
			qstr += " service_type = " + service_type + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = " + model + ",";
		}
		if (!(repair_date == null) && !(repair_date.length() == 0)){
			qstr += " repair_date = " + repair_date + ",";
		}
		if (!(start_time == null) && !(start_time.length() == 0)){
			qstr += " start_time = " + start_time + ",";
		}
		if (!(mechanic_name == null) && !(mechanic_name.length() == 0)){
			qstr += " mechanic_name = " + mechanic_name + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE plate = " + plate;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating repair history");
		}
	}
}
