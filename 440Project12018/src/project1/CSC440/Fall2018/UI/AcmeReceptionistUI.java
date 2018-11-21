package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.CSC440.Fall2018.user.Receptionist;

public class AcmeReceptionistUI {

public static Scanner in = new Scanner(System.in);
	
	public static void receptionistMainMenu(Connection conn, String user){
		while( true ){
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.\n");
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
				//Call Customer Profile Menu
				break;
			case 3:
				//Call Register Car menu
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
			System.out.println("\nWelcome!\nSelect your choice by entering the corresponding number.\n");
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
						while(r.next()){
							r.next();
							System.out.printf("Employee ID: %s\n", r.getString("eid"));
							System.out.printf("Name: %s\n", r.getString("name"));
							System.out.printf("Address: %s\n", r.getString("address"));
							System.out.printf("Email: %s\n", r.getString("email"));
							//System.out.printf("Phone Number: %s\n", r.getString("phone"));
							System.out.printf("Compensation: %s\n", r.getString("role"));
							System.out.printf("Compensation: %s\n", r.getString("salary"));
							System.out.println("Compensation Frquency: Monthly");
						}
						ResultSet r2 = Receptionist.getReceptionistEmployer(conn, user);
						while(r2.next()){
							System.out.printf("Service Center: %s\n", r2.getString("sid"));
							System.out.printf("Start Date: %s\n", r2.getString("start_date"));
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					
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
				break;
			case 2:
				
				break;
			case 3:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}

}
