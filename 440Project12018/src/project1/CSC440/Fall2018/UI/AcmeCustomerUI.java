package project1.CSC440.Fall2018.UI;

import java.sql.Connection;
import java.util.Scanner;

public class AcmeCustomerUI {
	
	public static Scanner in = new Scanner(System.in);
	
	public static void customerMainMenu(Connection conn, String user){
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
				break;
			case 2:
				//Call Car Registration menu
				break;
			case 3:
				//Call service menu
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
	public static void profileMenu(Connection conn, String user){
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
				while( true ){
					
					
					System.out.println("\nWelcome Customer!\nSelect your choice by entering the corresponding number.\n");
					System.out.println("1.\tGo Back");
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
						return;
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
