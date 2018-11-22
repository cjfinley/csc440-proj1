package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import project1.CSC440.Fall2018.Objects.Vehicle;
import project1.CSC440.Fall2018.user.Customer;
import project1.CSC440.Fall2018.user.Employee;
import project1.CSC440.Fall2018.user.Manager;
import project1.CSC440.Fall2018.user.Mechanic;
import project1.CSC440.Fall2018.user.Receptionist;


public class AcmeManagerUI {

	public static Scanner in = new Scanner(System.in);
	public static void managerMainMenu( Connection conn, Statement st, String user ) {
		while( true ){
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tProfile");
			System.out.println("2.\tView Customer Profile");
			System.out.println("3.\tAdd New Employees");
			System.out.println("4.\tPayroll");
			System.out.println("5.\tInventory");
			System.out.println("6.\tOrders");
			System.out.println("7.\tNotifications");
			System.out.println("8.\tNew Car Model");
			System.out.println("9.\tCar Service Details");
			System.out.println("10.\tService History");
			System.out.println("11.\tInvoices");
			System.out.println("12.\tLog Out");
			//Handles user input for menu options
			String s = in.nextLine();
			int choice = 0;
			try{
				choice = Integer.parseInt(s);
			} catch(NumberFormatException e){
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice){
			case 1:
				//Profile
				AcmeManagerUI.viewProfile(conn,user);
				break;
			case 2:
				//View Customer Profile
				AcmeManagerUI.viewCustomerProfile(conn,user);
				break;
			case 3:
				//Add New Employees
				AcmeManagerUI.addNewEmployee(conn,user);
				break;
			case 4:
				//Payroll
				AcmeManagerUI.payroll(conn,user);
				break;
			case 5:
				//Inventory
				AcmeManagerUI.inventory(conn,user);
				break;
			case 6:
				//Orders
				AcmeManagerUI.orders(conn,user);
				break;
			case 7:
				//Notifications
				AcmeManagerUI.notifications(conn,user);
				break;
			case 8:
				//New Car Model
				AcmeManagerUI.newCarModel(conn,user);
				break;
			case 9:
				//Car Service Details
				AcmeManagerUI.carServiceDetails(conn,user);
				break;
			case 10:
				//Service History
				AcmeManagerUI.serviceHistory(conn,user);
				break;
			case 11:
				//Invoices
				AcmeManagerUI.Invoices(conn,user);
				break;
			case 12:
				//log out
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	private static void Invoices(Connection conn, String user) {
		System.out.println("Error recieving invoice.");
		return;
	}
	private static void serviceHistory(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void carServiceDetails(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void newCarModel(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void notifications(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void orders(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void inventory(Connection conn, String user) {
		System.out.println("Error: Option not available");
	}
	private static void payroll(Connection conn, String user) {
		boolean keepGoing = true;
		while( keepGoing ) {
			System.out.print("Employee ID: ");
			String eid = in.nextLine();
			ResultSet rs = null;
			ResultSet r = null;
			try {
				rs = Employee.getEmployee(conn, eid);
			} catch (SQLException e1) {
				System.out.println("Error finding employee");
				return;
			}
			String role = null;
			try {
				role = rs.getString("role");
			} catch (SQLException e1) {
				System.out.println("Error finding employee role.");
				return;
			}
			if ( role != null && role.equals("manager")) {
				try {
					r = Manager.getManager(conn, eid);
					System.out.printf("Employee ID: %s%n", r.getString("eid"));
					System.out.printf("Name: %s%n", r.getString("name"));
					System.out.printf("Address: %s%n", r.getString("address"));
					System.out.printf("Email: %s%n", r.getString("email"));
					System.out.printf("Phone Number: %s%n", r.getString("phone"));
					System.out.printf("Role: %s%n", r.getString("role"));
					System.out.printf("Compensation: $%s%n", r.getString("salary"));
					System.out.println("Compensation Frquency: Monthly");
				} catch (SQLException e) {
					System.out.println("Error finding manager");
					return;
				}
			} else if ( role != null && role.equals("receptionist")) {
				try {
					r = Receptionist.getReceptionist(conn, eid);
					System.out.printf("Employee ID: %s%n", r.getString("eid"));
					System.out.printf("Name: %s%n", r.getString("name"));
					System.out.printf("Address: %s%n", r.getString("address"));
					System.out.printf("Email: %s%n", r.getString("email"));
					System.out.printf("Phone Number: %s%n", r.getString("phone"));
					System.out.printf("Role: %s%n", r.getString("role"));
					System.out.printf("Compensation: $%s%n", r.getString("salary"));
					System.out.println("Compensation Frquency: Monthly");
				} catch (SQLException e) {
					System.out.println("Error finding receptionist");
					return;
				}
				
			} else {
				try {
					r = Mechanic.getMechanic(conn, eid);
					System.out.printf("Employee ID: %s%n", r.getString("eid"));
					System.out.printf("Name: %s%n", r.getString("name"));
					System.out.printf("Address: %s%n", r.getString("address"));
					System.out.printf("Email: %s%n", r.getString("email"));
					System.out.printf("Phone Number: %s%n", r.getString("phone"));
					System.out.printf("Role: %s%n", r.getString("role"));
					System.out.printf("Compensation: $%s%n", r.getString("rate"));
					System.out.println("Compensation Frquency: Hourly");
				} catch (SQLException e) {
					System.out.println("Error finding mechanic");
					return;
				}
			}
			
			
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tGo Back");
			String s = in.nextLine();
			int choice = 0;
			try {
				choice = Integer.parseInt(s);
			} catch ( NumberFormatException e ) {
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice) {
			case 1:
				//Go back
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	private static void addNewEmployee(Connection conn, String user) {
		boolean keepGoing = true;
		while( keepGoing ) {
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tAdd");
			System.out.println("2.\tGo Back");
			String s = in.nextLine();
			int choice = 0;
			try {
				choice = Integer.parseInt(s);
			} catch ( NumberFormatException e ) {
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice) {
			case 1:
				//add employee
				System.out.print("Role (Mechanic/Receptionist): ");
				String role = in.nextLine();
				System.out.print("Employe ID: ");
				String eid = in.nextLine();
				System.out.print("Name: ");
				String name = in.nextLine();
				System.out.print("Address: ");
				String address = in.nextLine();
				System.out.print("Email: ");
				String email = in.nextLine();
				System.out.print("Phone Number: ");
				String phoneNum = in.nextLine();
				try {
					Employee.createEmployee(conn, role, eid, name, address, email, phoneNum);
				} catch (SQLException e) {
					System.out.println("Error adding employee");
					return;
				}
				if ( role.charAt(0) == 'M' || role.charAt(0) == 'm' ) {
					System.out.print("Hourly Rate: ");
					String rate = in.nextLine();
					try {
						Mechanic.createMechanic(conn, role, eid, name, address, email, phoneNum, rate);
					} catch (SQLException e) {
						System.out.println("Error adding mechanic.");
						return;
					}
				} else {
					System.out.print("Salary: ");
					String salary = in.nextLine();
					try {
						Receptionist.createReceptionist(conn, role, eid, name, address, email, phoneNum, salary);
					} catch (SQLException e) {
						System.out.println("Error adding receptionist.");
						return;
					}
				}
			case 2:
				//Go back
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	private static void viewCustomerProfile(Connection conn, String user) {
		boolean keepGoing = true;
		while( keepGoing ){
			System.out.print("Enter customer email address: ");
			String cEmail = in.nextLine();
			String cid = null;
				try {
					ResultSet r = Customer.getCustomerByEmail(conn, cEmail);
					while(r != null && r.next()){
						cid = r.getString("cid");
						System.out.printf("Customer ID: %s%n", cid);
						System.out.printf("Name: %s%n", r.getString("name"));
						System.out.printf("Address: %s%n", r.getString("address"));
						System.out.printf("Email: %s%n", r.getString("email"));
						System.out.printf("Phone Number: %s%n", r.getString("phone"));
					}
					ResultSet r2 = Vehicle.getPlatesForOwner(conn, cid);
					while(r2 != null && r2.next()){
						String plate = r2.getString("plate");
						System.out.printf("%nOwned since: %s%n", r2.getString("since"));
						ResultSet r3 = Vehicle.getVehicle(conn, plate);
						while(r3 != null && r3.next()){
							System.out.printf("Plate: %s%n", r3.getString("plate"));
							System.out.printf("Make: %s%n", r3.getString("make"));
							System.out.printf("Model: %s%n", r3.getString("model"));
							System.out.printf("Miles: %s%n", r3.getString("miles"));
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
				System.out.println("1.\tGo Back");
				//Handles user input for menu options
				String sa = in.nextLine();
				int choice1 = 0;
				try{
					choice1 = Integer.parseInt(sa);
				} catch(NumberFormatException e){
					System.out.println("Is not a valid option, enter a new one.");
				}
				switch(choice1){
				case 1:
					keepGoing = false;
				default:
					System.out.println("Please choose one of the menu options displayed.");
				}
			}
	}
	private static void viewProfile(Connection conn, String user) {
		while( true ){
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tView Profile");
			System.out.println("2.\tUpdate Profile");
			System.out.println("3.\tGo Back");
			//Handles user input for menu options
			String s = in.nextLine();
			int choice = 0;
			try{
				choice = Integer.parseInt(s);
			} catch(NumberFormatException e){
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice){
			case 1:
				boolean keepGoing = true;
				while( keepGoing ){
					try {
						ResultSet r = Receptionist.getReceptionist(conn, user);
						while(r != null && r.next()){
							System.out.printf("Employee ID: %s%n", r.getString("eid"));
							System.out.printf("Name: %s%n", r.getString("name"));
							System.out.printf("Address: %s%n", r.getString("address"));
							System.out.printf("Email: %s%n", r.getString("email"));
							System.out.printf("Phone Number: %s%n", r.getString("phone"));
							System.out.printf("Role: %s%n", r.getString("role"));
							System.out.printf("Compensation: $%s%n", r.getString("salary"));
							System.out.println("Compensation Frquency: Monthly");
						}
						ResultSet r2 = Receptionist.getReceptionistEmployer(conn, user);
						while(r2 != null && r2.next()){
							System.out.printf("Service Center: %s%n", r2.getString("sid"));
							System.out.printf("Start Date: %s%n", r2.getString("start_date"));
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
					System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
					System.out.println("1.\tGo Back");
					//Handles user input for menu options
					String sa = in.nextLine();
					int choice1 = 0;
					try{
						choice1 = Integer.parseInt(sa);
					} catch(NumberFormatException e){
						System.out.println("Is not a valid option, enter a new one.");
					}
					switch(choice1){
					case 1:
						keepGoing = false;
					default:
						System.out.println("Please choose one of the menu options displayed.");
					}
				}
				break;
			case 2:
				boolean keepGoing2 = true;
				while( keepGoing2 ) {
					System.out.println("\nWelcome Customer!\nSelect what field to update by entering the corresponding number.");
					System.out.println("1.\tName");
					System.out.println("2.\tAddress");
					System.out.println("3.\tPhone Number");
					System.out.println("4.\tEmail");
					System.out.println("5.\tGo Back");
					//Handles user input for menu options
					String s1 = in.nextLine();
					int choice1 = 0;
					try{
						choice1 = Integer.parseInt(s1);
					} catch(NumberFormatException e){
						System.out.println("Is not a valid option, enter a new one.");
					}
					switch(choice1) {
					case 1:
						System.out.print("Name: ");
						String name = in.nextLine();
						try {
							Receptionist.updateReceptionist(conn, null, user,  name, null, null, null, null);
						} catch (SQLException e) {
							System.out.println("Error updating name: AcmeCustomerUI.updateProfile.java");
						}
						break;
					case 2:
						System.out.print("Address: ");
						String address = in.nextLine();
						try {
							Receptionist.updateReceptionist(conn, null, user,  null, address, null, null, null);
						} catch (SQLException e) {
							System.out.println("Error updating address: AcmeCustomerUI.updateProfile.java");
						}
						break;
					case 3:
						System.out.print("Phone Number: ");
						String phone = in.nextLine();
						try {
							Receptionist.updateReceptionist(conn, null, user,  null, null, null, phone, null);
						} catch ( SQLException e ) {
							System.out.println("Error updating phone: AcmeCustomerUI.updateProfile.java");
						}
						break;
					case 4:
						System.out.print("Email: ");
						String email = in.nextLine();
						try {
							Receptionist.updateReceptionist(conn, null, user,  null, null, email, null, null);
						} catch ( SQLException e ) {
							System.out.println("Error updating phone: AcmeCustomerUI.updateProfile.java");
						}
						break;
					case 5:
						keepGoing2 = false;
					default:
						System.out.println("Invalid input: please select one of the valid options.");
					}
				}
				break;
			case 3:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
}
