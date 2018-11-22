package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import project1.CSC440.Fall2018.Objects.Vehicle;
import project1.CSC440.Fall2018.Records.ServiceHistory;
import project1.CSC440.Fall2018.user.Customer;
import project1.CSC440.Fall2018.user.Receptionist;


public class AcmeManagerUI {

	public static Scanner in = new Scanner(System.in);
	public static void managerMainMenu( Connection conn, Statement st, String user ) {
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
				getServiceHistory(conn, user);
				break;
			case 5:
				//Call Reschedule Service menu
				break;
			case 6:
				//call invoices menu
				break;
			case 7:
				return;
			default:
				System.out.println("Please choose one of the menu options displayed.");
			}
		}
	}
	
	private static void getServiceHistory(Connection conn, String user) {
		// TODO Auto-generated method stub
		
	}
	
	private static void registerCar(Connection conn, String user) {
		// TODO Auto-generated method stub
		
	}
	
	private static void viewCustomer(Connection conn, String user) {
		// TODO Auto-generated method stub
		
	}
	
	private static void profileMenu(Connection conn, String user) {
		// TODO Auto-generated method stub
		
	}
}
