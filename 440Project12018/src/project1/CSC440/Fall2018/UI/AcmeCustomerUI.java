package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.CSC440.Fall2018.Objects.Vehicle;
import project1.CSC440.Fall2018.Records.RepairHistory;
import project1.CSC440.Fall2018.Records.ServiceHistory;
import project1.CSC440.Fall2018.user.Customer;

public class AcmeCustomerUI {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void customerMainMenu(Connection conn, Statement st, String user){
		while( true ){
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
			System.out.println("1.\tProfile");
			System.out.println("2.\tRegister Vehicle");
			System.out.println("3.\tService");
			System.out.println("4.\tInvoices");
			System.out.println("5.\tLog Out");
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
				//Call profile menu
				AcmeCustomerUI.profileMenu(conn, st, user);
				break;
			case 2:
				//Call Car Registration menu
				AcmeCustomerUI.registerCarMenu(conn, user);
				break;
			case 3:
				//Call service menu
				AcmeCustomerUI.carServiceMenu(conn, user);
				break;
			case 4:
				//Call invoice menu
				break;
			case 5:
				in.close();
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	public static void profileMenu(Connection conn, Statement st, String user){
		while( true ){
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
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
				AcmeCustomerUI.viewProfile(conn);
				break;
			case 2:
				AcmeCustomerUI.updateProfile(conn);
				break;
			case 3:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	
	public static void viewProfile(Connection conn) {
		boolean keepGoing = true;
		while( keepGoing ){
			ResultSet rs = null;
			//loops until a valid email is input
			while ( true ) {
				System.out.print("Please enter your email or exit: ");
				String email = in.nextLine();
				if ( email != null && email.equals("exit")) {
					return;
				}
				try {
					rs = Customer.getCustomerByEmail(conn, email);
					break;
				} catch (SQLException e1) {
					System.out.println("Error finding profile.");
				}	
			}
			String retStr = null;
			try {
				retStr += rs.getString("cid") + ": " + rs.getString("name")  + "\n";
				retStr += "     " + rs.getString("address") + "\n";
				retStr += "     " + rs.getString("email") + ", " + rs.getString("phone");
			} catch (SQLException e1) {
				System.out.println("Error fetching customer profile: AcmeCustomerUI.viewProfile.java");
				return;
			}
			System.out.println(retStr);
			
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
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
	
	public static void updateProfile(Connection conn) {
		while( true ) {
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
			System.out.println("1.\tName");
			System.out.println("2.\tAddress");
			System.out.println("3.\tPhone Number");
			System.out.println("4.\tEmail");
			System.out.println("5.\tGo Back");
			//Handles user input for menu options
			String s = in.nextLine();
			int choice = 0;
			try{
				choice = Integer.parseInt(s);
			} catch(NumberFormatException e){
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice) {
			case 1:
				System.out.print("Name: ");
				String name = in.nextLine();
				try {
					Customer.updateCustomer(conn, null, null, name, null, null);
				} catch (SQLException e) {
					System.out.println("Error updating name: AcmeCustomerUI.updateProfile.java");
				}
			case 2:
				System.out.print("Address: ");
				String address = in.nextLine();
				try {
					Customer.updateCustomer(conn, null, address, null, null, null);
				} catch (SQLException e) {
					System.out.println("Error updating address: AcmeCustomerUI.updateProfile.java");
				}
			case 3:
				System.out.print("Phone Number: ");
				String phone = in.nextLine();
				try {
					Customer.updateCustomer(conn, null, null, null, null, phone);
				} catch ( SQLException e ) {
					System.out.println("Error updating phone: AcmeCustomerUI.updateProfile.java");
				}
			case 4:
				System.out.print("Email: ");
				String email = in.nextLine();
				try {
					Customer.updateCustomer(conn, null, null, null, email, null);
				} catch ( SQLException e ) {
					System.out.println("Error updating phone: AcmeCustomerUI.updateProfile.java");
				}
			case 5:
				return;
			default:
				System.out.println("Invalid inpu: please select one of the valid optoins.");
			}
		}
	}
	
	// This will add a new vehicle to the Vehicle table. 
	public static void registerCarMenu( Connection conn, String user ) {
		while( true ) {
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
			System.out.println("1.\tRegister");
			System.out.println("2.\tCancel");
			//Handles user input for menu options
			String s = in.nextLine();
			int choice = 0;
			try{
				choice = Integer.parseInt(s);
			} catch(NumberFormatException e){
				System.out.println("Is not a valid option, enter a new one.");
			}
			switch(choice) {
			case 1:
				// Register the car
				System.out.print("\nLiscence Plate: ");
				String plate = in.nextLine();
				System.out.print("\nMake: ");
				String make = in.nextLine();
				System.out.print("\nModel: ");
				String model = in.nextLine();
				System.out.print("\nCurrent Miliage: ");
				String miles = in.nextLine();
				try {
					Vehicle.createVehicle(conn, plate, make, model, miles);
				} catch (SQLException e) {
					System.out.println("Error registering vehicle, please try again.");
				}
			case 2:
				// Cancel
				return;
			}
		}
	}
	
	public static void carServiceMenu( Connection conn, String user ) {
		while( true ){
			System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
			System.out.println("1.\tView Service History");
			System.out.println("2.\tSchedule Service");
			System.out.println("3.\tReschedule Service");
			System.out.println("4.\tGo Back");
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
				while( true ){
					System.out.println("Please enter your vehicle information:");
					System.out.print("Plate: ");
					String plate = in.nextLine();
					System.out.print("\nService Date:\n\tDay: ");
					int serviceDay = in.nextInt();
					//discards the rest of the line
					in.nextLine();
					System.out.print("\n\tMonth (1-12): ");
					int serviceMonth = in.nextInt();
					in.nextLine();
					System.out.print("\n\tYear (****): ");
					int serviceYear = in.nextInt();
					in.nextLine();
					String months[] = {"Jan", "Feb","Mar","Apr","May", "Jun","Jul","Aug","Sep","Nov","Dec"};
					String serviceMonthString = months[serviceMonth - 1];
					String service_date = "" + serviceDay + "-" + serviceMonthString + "-" + serviceYear;
					System.out.print("\nService Type (A/B/C): ");
					String service_type = in.nextLine();
					ResultSet rs = null;
					try {
						rs = ServiceHistory.getServiceHistory(conn, plate, service_date, service_type);
					} catch (SQLException e1) {
						System.err.println(e1.getMessage());
						System.out.println("Error 202: AcmeCustomerUI.carServiceMenu.java");
					}
					String retStr = null;
					// 1 is plate, 2 is service type, 3 is make, 4 is model, 5 is service date, 6 is start time, 7 is mechanic name
					// Format:
					// date: time --- make, model
					//      service type, mechanic name
					try {
						while ( rs != null && rs.next() ) {
						  retStr += rs.getString(5)+  ": " + rs.getString(6) + " ---- " + rs.getString(3) + ", " + rs.getString(4) + "\n";
						  retStr += "     " + rs.getString(2) + ", " + rs.getString(7) + "\n";
						}
					} catch (SQLException e1) {
						System.out.println("Error fetching service history: AcmeCustomerUI.carServiceMenu.java");
					}
					System.out.println(retStr + "\n");
					
					System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
					boolean invalid = true;
					int choice1 = 0;
					while (invalid ) {
						System.out.println("1.\tGo Back");
						//Handles user input for menu options
						String st = in.nextLine();
						try{
							choice1 = Integer.parseInt(st);
							invalid = false;
						} catch(NumberFormatException e){
							System.out.println("Is not a valid option, enter a new one.");
						}
					}
					
					switch(choice1){
					case 1:
						break;
					default:
						System.out.println("Please choose one of the menu options displayed.");
					}
				}
			case 2:
				System.out.println("Would you like to (1) Schedule Maintenance (2) Schedule Repair ?");
				String sa = in.nextLine();
				int choice2 = 0;
				try {
					choice2 = Integer.parseInt(sa);
				} catch ( NumberFormatException e1 ) {
					System.out.println("Is not a valid option, enter a new one.");
				}
				switch( choice2 ) {
				case 1:
					while( true ) {
						System.out.println("Please enter your vehicle information:");
						System.out.print("Plate: ");
						String plate = in.nextLine();
						System.out.print("\nTodays Date:\n\tDay: ");
						int serviceDay = in.nextInt();
						//discards the rest of the line
						in.nextLine();
						System.out.print("\n\tMonth (1-12): ");
						int serviceMonth = in.nextInt();
						in.nextLine();
						System.out.print("\n\tYear (****): ");
						int serviceYear = in.nextInt();
						in.nextLine();
						String months[] = {"Jan", "Feb","Mar","Apr","May", "Jun","Jul","Aug","Sep","Nov","Dec"};
						String serviceMonthString = months[serviceMonth - 1];
						String service_date = "" + serviceDay + "-" + serviceMonthString + "-" + serviceYear;
						System.out.print("\nService Type (A/B/C): ");
						String service_type = in.nextLine();
						System.out.print("\nMake: ");
						String make = in.nextLine();
						System.out.print("\nModel: ");
						String model = in.nextLine();
						System.out.print("\nTime (HH:MM): ");
						String start_time = in.nextLine();
						System.out.print("\nMechanics Name: ");
						String mechanic_name = in.nextLine();
						try {
							ServiceHistory.createServiceHistory(conn, plate, service_type, make, model, service_date, start_time, mechanic_name);
						} catch (Exception e ) {
							System.out.println("Error creating service, try again?");
							String response = in.nextLine();
							if ( response.charAt(0) == 'N' || response.charAt(0) == 'n' ) {
								break;
							}
						}
					}
				case 2:
					while( true ) {
						System.out.println("Please enter your vehicle information:");
						System.out.print("Plate: ");
						String plate = in.nextLine();
						System.out.print("\nTodays Date:\n\tDay: ");
						int serviceDay = in.nextInt();
						//discards the rest of the line
						in.nextLine();
						System.out.print("\n\tMonth (1-12): ");
						int serviceMonth = in.nextInt();
						in.nextLine();
						System.out.print("\n\tYear (****): ");
						int serviceYear = in.nextInt();
						in.nextLine();
						String months[] = {"Jan", "Feb","Mar","Apr","May", "Jun","Jul","Aug","Sep","Nov","Dec"};
						String serviceMonthString = months[serviceMonth - 1];
						String repair_date = "" + serviceDay + "-" + serviceMonthString + "-" + serviceYear;
						System.out.print("\nMake: ");
						String make = in.nextLine();
						System.out.print("\nModel: ");
						String model = in.nextLine();
						System.out.print("\nTime (HH:MM): ");
						String start_time = in.nextLine();
						System.out.print("\nMechanics Name: ");
						String mechanic_name = in.nextLine();
						System.out.print("\nDiagnostic (enter >>> when finished): ");
						String diagnostic = "";
						String temp = in.next();
						while  ( !temp.equals(">>>") ) {
							diagnostic += temp;
							diagnostic += " ";
							temp = in.next();
						}
						try {
							RepairHistory.createRepairHistory(conn, plate, diagnostic, make, model, repair_date, start_time, mechanic_name);
						} catch (Exception e ) {
							System.out.println("Error creating service, try again?");
							String response = in.nextLine();
							if ( response.charAt(0) == 'N' || response.charAt(0) == 'n' ) {
								break;
							}
						}
					}
				}
				break;
			case 3:
				while ( true ) {
					//reschedule service using the liscence plate number
					System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
					System.out.println("1.\tReschedule Service");
					System.out.println("2.\tReschedule Maintenance");
					System.out.println("3.\tGo back");
					//Handles user input for menu options
					String sb = in.nextLine();
					int choice1 = 0;
					try{
						choice1 = Integer.parseInt(sb);
					} catch(NumberFormatException e){
						System.out.println("Is not a valid option, enter a new one.");
					}
					System.out.println("Please enter your vehicle information:");
					System.out.print("Plate: ");
					String plate = in.nextLine();
					System.out.print("\nTodays Date:\n\tDay: ");
					int serviceDay = in.nextInt();
					//discards the rest of the line
					in.nextLine();
					System.out.print("\n\tMonth (1-12): ");
					int serviceMonth = in.nextInt();
					in.nextLine();
					System.out.print("\n\tYear (****): ");
					int serviceYear = in.nextInt();
					in.nextLine();
					String months[] = {"Jan", "Feb","Mar","Apr","May", "Jun","Jul","Aug","Sep","Nov","Dec"};
					String serviceMonthString = months[serviceMonth - 1];
					String repair_date = "" + serviceDay + "-" + serviceMonthString + "-" + serviceYear;
					System.out.print("\nMake: ");
					String make = in.nextLine();
					System.out.print("\nModel: ");
					String model = in.nextLine();
					System.out.print("\nTime (HH:MM): ");
					String start_time = in.nextLine();
					System.out.print("\nMechanics Name: ");
					String mechanic_name = in.nextLine();
					
					switch(choice1) {
					case 1:
						//Reschedule Service
						System.out.print("\nService Type (A/B/C): ");
						String service_type = in.nextLine();
						try {
							ServiceHistory.updateServiceHistory(conn, plate, service_type, make, model, repair_date, start_time, mechanic_name);
						} catch (SQLException e) {
							System.out.println("Error updating service history.");
							System.out.print("Would you like to try again? (Y/N): ");
							String response = in.nextLine();
							if ( response.charAt(0) == 'N' || response.charAt(0) == 'n' ) {
								break;
							}
						}
					case 2:
						//Reschedule Maintenance:
						System.out.print("\nDiagnostic (enter >>> when finished): ");
						String diagnostic = "";
						String temp = in.next();
						while  ( !temp.equals(">>>") ) {
							diagnostic += temp;
							diagnostic += " ";
							temp = in.next();
						}
						try {
							RepairHistory.updateRepairHistory(conn, plate, diagnostic, make, model, repair_date, start_time, mechanic_name);
						} catch (SQLException e) {
							System.out.println("Error updating service history.");
							System.out.print("Would you like to try again? (Y/N): ");
							String response = in.nextLine();
							if ( response.charAt(0) == 'N' || response.charAt(0) == 'n' ) {
								break;
							}
						}
					case 3:
						//Go back
						break;
					default:
						System.out.println("Please choose one of the menu options displayed.");
					}
				}
			case 4:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	
	public static void carInvoiceMenu( Connection conn, String user ) {
		
	}
}
