package project1.CSC440.Fall2018.user;

import java.sql.*;

public class Customer {

	public static void createCustomerAccount(Statement st, int cid, String name, String address, String email, int phone) {
		
	}
	
	public static void registerCar(Statement st, String vid, String make, String model, String purchaseDate,
			String mostRecentServiceMiliage, String mostRecentServiceType, String mostRecentServiceDate) {
		if ( !make.equals("Honda") || !make.equals("Nissan") || !make.equals("Toyota")) {
			throw new IllegalArgumentException("Invalid vehicle");
		}
		try {
			//st.executeUpdate("INSERT INTO Customers " + 
            //"VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
			String val[] = new String[7];
			val[0] = vid;
			val[1] = make;
			val[2] = model;
			val[3] = purchaseDate;
			val[4] = mostRecentServiceMiliage;
			val[5] = mostRecentServiceType;
			val[6] = mostRecentServiceDate;
			st.executeUpdate("INSERT INTO Customers", val);
		} catch (Exception e) {
			System.err.println("Error inserting car: ");
			System.err.println(e.getMessage());
		}
	}
	
	
	
}
