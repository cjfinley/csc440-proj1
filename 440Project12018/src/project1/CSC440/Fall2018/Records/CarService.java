package project1.CSC440.Fall2018.Records;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarService {
	public static void createCarService(Statement st, String make, String service_type, String milage, String model){
		String fields[] = new String[5];
		fields[0] = make;
		fields[1] = service_type;
		fields[2] = milage;
		fields[3] = model;
		try{
			st.executeUpdate("INSERT INTO Car_Services", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating car service");
		}
	}
	static ResultSet getCarService(Statement st, String service_type){
		String qstr = "SELECT * FROM Car_Services WHERE service_type = " + service_type;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting car service");
		}
		return rs;
	}
	public static void updateCarService(Statement st, String make, String service_type, String milage, String model){
		String qstr = "UPDATE Car_Services SET";
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(service_type == null) && !(service_type.length() == 0)){
			qstr += " service_type = " + service_type + ",";
		}
		if (!(milage == null) && !(milage.length() == 0)){
			qstr += " milage = " + milage + ",";
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = " + model + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE service_type = " + service_type;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating car service");
		}
	}
}
