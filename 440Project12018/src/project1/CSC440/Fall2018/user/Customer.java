package project1.CSC440.Fall2018.user;

import java.sql.*;

public class Customer {

	private static String queryCustomer = "SELECT * FROM CUSTOMER";
	private static String queryOwns = "SELECT * FROM OWNS";
	
	public static void createCustomerAccount(Statement st, String cid, String name, String address, String email, String phone) {
		if ( st == null || cid == null || name == null || address == null || email == null || phone == null ) {
			throw new IllegalArgumentException("Null data");
		}
		try {
			//st.executeUpdate("INSERT INTO Customers " + 
            //"VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
			String val[] = new String[5];
			val[0] = cid;
			val[1] = name;
			val[2] = address;
			val[3] = email;
			val[4] = phone;
			st.executeUpdate("INSERT INTO Customers", val);
		} catch (Exception e) {
			System.err.println("Error creating customer: ");
			System.err.println(e.getMessage());
		}
	}
	
	public static void registerCar(Statement st, String vid, String make, String model, String purchaseDate,
			String mostRecentServiceMiliage, String mostRecentServiceType, String mostRecentServiceDate) {
		if ( st == null || vid == null || make == null || model == null || purchaseDate == null ||
				mostRecentServiceMiliage == null || mostRecentServiceType == null || mostRecentServiceDate == null ) {
			throw new IllegalArgumentException("Null data");
		}
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
	
	public static String viewProfile(Statement st, String cid) {
		String retVal = "";
		try {
			ResultSet customer = st.executeQuery(queryCustomer);
			boolean notFound = true;
			//iterates through the database system to find the 
			while ( customer.next() && notFound ) {
				// Check to make sure it's there 
				if ( customer.getString("CID") != null && customer.getString("CID").equals(cid) ) {
					retVal += "Customer ID: " + customer.getString("CID") + "\n";
					retVal += "Name: "+ customer.getString("NAME") + "\n";
					retVal += "Address: " + customer.getString("ADDRESS") + "\n";
					retVal += "Email: " + customer.getString("EMAIL") + "\n";
					retVal += "Phone: " + customer.getString("PHONE") + "\n";
					notFound = false;
				}
			}
			//if the customer wasn't found, throw an exception
			if ( notFound ) {
				throw new IllegalArgumentException("Customer not found");
			}
			
			ResultSet owns = st.executeQuery(queryOwns);
			notFound = true;
			
			retVal += "Car:\n";
			while ( owns.next() ) {
				// Check to make sure it's there
				if ( owns.getString("CID") != null && owns.getString("CID").equals(cid)) {
					// Adds a tab before so the vehicle entries are entered in
					retVal += "     Make: " + owns.getString("MAKE") + "\n";
					retVal += "     Model: " + owns.getString("MODEL") + "\n";
					notFound = false;
				}
			}
			
			if ( notFound ) {
				retVal += "     No vehicles registered\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error viewing profile");
		}
		return retVal;
	}
	
	public static void updateProfile(Statement st, String cid, String name, String address, String email, String phone) {
		// if there is a name input, then change the name
		if ( name != null ) {
			String query = "UPDATE CUSTOMER SET NAME=" + name + "WHERE CID=" + cid;
			try {
				st.executeUpdate(query);
			} catch (SQLException e) {
				throw new IllegalArgumentException("Error updating customer name");
			}
		}
		// if there is an address input, then change the address
		if ( address != null ) {
			String query = "UPDATE CUSTOMER SET ADDRESS=" + address + "WHERE CID=" + cid;
			try {
				st.executeUpdate(query);
			} catch (SQLException e) {
				throw new IllegalArgumentException("Error updating customer address");
			}
		}
		// if there is an email input, then change the email
		if ( email != null ) {
			String query = "UPDATE CUSTOMER SET EMAIL=" + email + "WHERE CID=" + cid;
			try {
				st.executeUpdate(query);
			} catch (SQLException e) {
				throw new IllegalArgumentException("Error updating customer email");
			}
		}
		// if there is a phone input, then change the phone
		if ( phone != null ) {
			String query = "UPDATE CUSTOMER SET PHONE=" + phone + "WHERE CID=" + cid;
			try {
				st.executeUpdate(query);
			} catch (SQLException e) {
				throw new IllegalArgumentException("Error updating customer phone");
			}
		}
	}
	public static String getMaxCustomerId(Statement st){
		String query = "Select MAX(cid) As mcid From Customer";
		ResultSet rs = null;
		String maxcid = null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			maxcid = rs.getString("mcid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxcid;
	}
	
	public static String viewServiceHistory() {
		return null;
	}
	
	public static void scheduleService() {
		
	}
	
	public static void rescheduleService() {
		
	}
	
	public static String viewInvoice() {
		return null;
	}
}
