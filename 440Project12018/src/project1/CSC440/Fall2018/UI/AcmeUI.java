package project1.CSC440.Fall2018.UI;

import java.sql.*;
import java.util.Scanner;

import project1.CSC440.Fall2018.Objects.Distributor;
import project1.CSC440.Fall2018.Objects.Vehicle;
import project1.CSC440.Fall2018.user.Customer;
import project1.CSC440.Fall2018.user.Manager;
import project1.CSC440.Fall2018.user.Mechanic;
import project1.CSC440.Fall2018.user.Receptionist;


public class AcmeUI {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection conn = DriverManager.getConnection(  
			"jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:ORCL01","zjohnso","200093381");  
			  
			//step3 create the statement object  
			Statement stmt = conn.createStatement(); 
			
			
			//*****************TEST STATEMENTS ARE COMMENTED OUT BELOW*********************
			//Test class methods to create, update and retrieve items in the database tables
//			Distributor.createDistributor(conn, "D0004", "D4");
//			ResultSet rs = Distributor.getDistributor(conn, "D0004");
//			while(rs.next()){
//				System.out.printf("Distributor ID: %s\tDistributor Name: %s\n", rs.getString(1), rs.getString(2));
//			}
			try{
				//Vehicle.createVehicle(conn, "XYY-5555", "Nissan", "Crashed", "0000");
//				ResultSet rs2 = Vehicle.getVehicle(conn, "XYY-5555");
//				while(rs2.next()){
//					System.out.printf("Vehicle ID: %s\tVehicle Make: %s\tVehicle Model: %s\tVehicle Milage: %s\n", rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4));
//				}
//				Vehicle.updateVehicle(conn, "XYY-5555", "", null, "99999");
//				rs2 = Vehicle.getVehicle(conn, "XYY-5555");
//				while(rs2.next()){
//					System.out.printf("Vehicle ID: %s\tVehicle Make: %s\tVehicle Model: %s\tVehicle Milage: %s\n", rs2.getString(1), rs2.getString(2), rs2.getString(3), rs2.getString(4));
//				}

			boolean programActive = true;
			while( programActive ){
				System.out.println("\nSelect choice by entering number.\n");
				System.out.println("1.\tLogin");
				System.out.println("2.\tSign up");
				System.out.println("3.\tExit");
				
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
					loginMenu(conn, stmt);
					break;
				case 2:
					signUpMenu(conn, stmt);
					break;
				case 3:
					programActive = false;
					break;
				default:
					System.out.println("Please choose one of the menu options displayed.");
				}
				
			}
			//step5 close the connection object  
			conn.close();  
			in.close();
			}catch(Exception e){ 
				System.out.println("Error navigating menu: ");
				System.out.println(e);
			}
		}catch(Exception e){ 
			System.out.println("Error connecting to remote database: ");
			System.out.println(e);
		}
	}
	public static void loginMenu(Connection conn, Statement st){
		boolean loggedin = false;
		while(!loggedin){
			System.out.print("Enter Login Info (Username for employees is ID #, Customers use their email address): \n");
			System.out.print("Username: ");
			String user = in.nextLine();
			System.out.print("Password: ");
			String pw = in.nextLine();
			System.out.println("\nSelect your choice by entering the corresponding number.\n");
			System.out.println("1.\tLog In");
			System.out.println("2.\tGo Back");
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
				ResultSet match = null;
				try {
					try{
					match = Customer.getCustomerByEmail(conn, user);
					} catch (SQLSyntaxErrorException e){
						//Catches error thrown when trying to look up employees by an email
					}
					if(match.next() != false && pw == "password"){
						loggedin = true;
						//Call customer UI
						break;
					}
					try{
						match = Manager.getManager(conn, user);
						} catch (SQLSyntaxErrorException e){
							//Catches error thrown when trying to look up employees by an email
						}
					if(match.next() != false && pw == "password"){
						loggedin = true;
						//Call manager UI
						break;
					}
					try{
						match = Receptionist.getReceptionist(conn, user);
						} catch (SQLSyntaxErrorException e){
							//Catches error thrown when trying to look up employees by an email
						}
					if(match.next() != false && pw == "password"){
						loggedin = true;
						//Call receptionist UI
						break;
					}
					try{
						match = Mechanic.getMechanic(conn, user);
						} catch (SQLSyntaxErrorException e){
							//Catches error thrown when trying to look up employees by an email
						}
					if(match.next() != false && pw == "password"){
						loggedin = true;
						//Call mechanic UI
						break;
					}
				} catch (SQLException e) {
					System.out.print("Incorrect username or password.\n");
				}
				break;
			case 2:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	public static void signUpMenu(Connection conn, Statement st) throws SQLException{
		System.out.println("Enter Information Below:");
		System.out.print("Email: ");
		String email = in.nextLine();
		//System.out.println("Password: ");
		//String password = info.nextLine();
		System.out.print("Name: ");
		String name = in.nextLine();
		System.out.print("Address: ");
		String address = in.nextLine();
		System.out.print("Phone Number: ");
		String phone = in.nextLine();
		
		System.out.println("\nSelect your choice by entering the corresponding number.\n");
		System.out.println("1.\tSign up");
		System.out.println("2.\tGo Back");
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
			String cid = null;
			int cidnum = 0;
			String maxcid = Customer.getMaxCustomerId(st);
			//Checking validity of query since not using prepared statement
			//System.out.println("MAXCID: " + maxcid);
			if (maxcid == null){
				cidnum = 1;
			} else{
				cidnum =Integer.parseInt(maxcid);
				cidnum++;
				cid = Integer.toString(cidnum);
			}
			Customer.createCustomer(conn, cid, name, address, email, phone);
			break;
		case 2:
			return;
		default:
			System.out.println("Please choose one of the menu options displayed.");
		}
	}
}
