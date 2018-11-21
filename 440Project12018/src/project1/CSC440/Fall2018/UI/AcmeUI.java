package project1.CSC440.Fall2018.UI;

import java.sql.*;
import java.util.Scanner;

import project1.CSC440.Fall2018.Objects.Distributor;
import project1.CSC440.Fall2018.user.Customer;


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
			
//			ResultSet rs = Distributor.getDistributor(conn, "D0002");
//			while(rs.next()){
//				System.out.printf("Distributor ID: %s\tDistributor Name: %s\n", rs.getString(1), rs.getString(2));
//			}
			boolean programActive = true;
			while( programActive ){
				System.out.println("Select choice by entering number.\n");
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
					loginMenu(stmt);
				case 2:
					signUpMenu(stmt);
				case 3:
					programActive = false;
				default:
					System.out.println("Please choose one of the menu options displayed.");
				}
				
			}
			
			//step5 close the connection object  
			conn.close();  
			in.close();
			}catch(Exception e){ 
				System.out.println("Error connecting to remote database: ");
				System.out.println(e);
			}  
	}
	public static void loginMenu(Statement st){
		
	}
	public static void signUpMenu(Statement st){
		System.out.println("Enter Information Below:");
		System.out.println("Email: ");
		String email = in.nextLine();
		//System.out.println("Password: ");
		//String password = info.nextLine();
		System.out.println("Name: ");
		String name = in.nextLine();
		System.out.println("Address: ");
		String address = in.nextLine();
		System.out.println("Phone Number: ");
		String phone = in.nextLine();
		
		System.out.println("Select choice by entering number.\n");
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
			if (maxcid == null){
				cidnum = 1;
			} else{
				cidnum =Integer.parseInt(maxcid);
				cidnum++;
				cid = Integer.toString(cidnum);
			}
			Customer.createCustomerAccount(st, cid, name, address, email, phone);
		case 2:
			return;
		default:
			System.out.println("Please choose one of the menu options displayed.");
		}
	}
}
