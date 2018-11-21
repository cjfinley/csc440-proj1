package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.CSC440.Fall2018.Objects.Vehicle;
import project1.CSC440.Fall2018.user.Customer;
import project1.CSC440.Fall2018.user.Receptionist;

public class AcmeReceptionistUI {

public static Scanner in = new Scanner(System.in);
	
	public static void receptionistMainMenu(Connection conn, String user){
		while( true ){
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tProfile");
			System.out.println("2.\tView Customer Profile");
			System.out.println("3.\tRegister Car");
			System.out.println("4.\tService History");
			System.out.println("5.\tReschedule Service");
			System.out.println("6.\tInvoices");
			System.out.println("7.\tLog Out");
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
				profileMenu(conn, user);
				break;
			case 2:
				viewCustomer(conn, user);
				break;
			case 3:
				//Call Register Car menu
				registerCar(conn, user);
				break;
			case 4:
				//Call Service History menu
				break;
			case 5:
				//Call Reschedule Service menu
				break;
			case 6:
				//call invoices menu
				break;
			case 7:
				in.close();
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	public static void profileMenu(Connection conn, String user){
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
	public static void viewCustomer(Connection conn, String user){
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
	public static void registerCar(Connection conn, String user){
		boolean keepGoing = true;
		while( keepGoing ){
			System.out.println("Enter Information Below:");
			System.out.print("Customer Email: ");
			String email = in.nextLine();
			System.out.print("License Plate: ");
			String plate = in.nextLine();
			System.out.print("Purchase Date (DD/MMM/YY): ");
			String purchase_date = in.nextLine();
			System.out.print("Make: ");
			String make = in.nextLine();
			System.out.print("Model: ");
			String model = in.nextLine();
			System.out.print("Miles: ");
			String miles = in.nextLine();
				
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.");
			System.out.println("1.\tRegister");
			System.out.println("2.\tCancel");
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
				try {
					String cid = null;
					ResultSet rs = Customer.getCustomerByEmail(conn, email);
					while(rs != null && rs.next()){
						cid = rs.getString("cid");
					}
					Vehicle.createVehicle(conn, plate, make, model, miles);
					Vehicle.registerVehicle(conn, cid, plate, purchase_date);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				keepGoing = false;
				break;
			case 2:
				keepGoing = false;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}	
	}
	public static void getServiceHistory(Connection conn, String user){
		boolean keepGoing = true;
		while( keepGoing ){
			System.out.print("Enter customer email address: ");
			String cEmail = in.nextLine();
			String cid = null;
				try {
					ResultSet r = Customer.getCustomerByEmail(conn, cEmail);
					while(r != null && r.next()){
						cid = r.getString("cid");
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
}
