package project1.CSC440.Fall2018.Objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Vehicle {
	public static void createVehicle(Statement st, String plate, String make, String model, String year, String purchaseDate){
		String fields[] = new String[5];
		fields[0] = plate;
		fields[1] = make;
		fields[2] = model;
		fields[3] = year;
		fields[4] = purchaseDate;
		try{
			st.executeUpdate("INSERT INTO Vehicles", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating vehicle");
		}
	}
	public static ResultSet getVehicle(Statement st, String plate){
		String qstr = "SELECT * FROM Vehicles WHERE plate = " + plate;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting vehicle");
		}
		return rs;
	}
	public static void updateVehicle(Statement st, String plate, String make, String model, String year, String purchaseDate){
		String qstr = "UPDATE Vehicles SET";
		if (!(plate == null) && !(plate.length() == 0)){
			qstr += " plate = " + plate + ",";
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = " + make + ",";
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = " + model + ",";
		}
		if (!(year == null) && !(year.length() == 0)){
			qstr += " year = " + year + ",";
		}
		if (!(purchaseDate == null) && !(purchaseDate.length() == 0)){
			qstr += " purchaseDate = " + purchaseDate + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE plate = " + plate;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating vehicle");
		}
	}
}
