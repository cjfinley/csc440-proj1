package project1.CSC440.Fall2018.UI;

import java.sql.*;

import project1.CSC440.Fall2018.Objects.Distributor;

public class AcmeUI {
	public static void main(String[] args) {
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con = DriverManager.getConnection(  
			"jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:ORCL01","zjohnso","200093381");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			ResultSet r = Distributor.getDistributor(stmt, "D0001");
			while(r.next()){
				System.out.printf("Distributor ID: %s\tDistributor Name: ", r.getString("did"), r.getString("name"));
			}
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ 
				System.out.println("Error connecting to remote database: ");
				System.out.println(e);
			}  
	}
}
