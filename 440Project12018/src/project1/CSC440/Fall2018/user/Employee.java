package project1.CSC440.Fall2018.user;

import java.sql.*;

public interface Employee {
	static void createEmployee(Statement st, String eid, String name, String address, String email, String phoneNum, String startDate, String compensation){
		String fields[] = new String[6];
		fields[0] = eid;
		fields[1] = name;
		fields[2] = address;
		fields[3] = email;
		fields[4] = phoneNum;
		fields[5] = startDate;
		fields[6] = compensation;
		try{
			st.executeUpdate("INSERT INTO Employee", fields);
		} catch( Exception e ){
			System.err.println("Error creating employee: ");
			System.err.println(e.getMessage());
		}	
	}
	static ResultSet getEmployee(Statement st, String eid){
		String qstr = "SELECT * FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static ResultSet getName(Statement st, String eid){
		String qstr = "SELECT name FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee name: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setName(Statement st, String eid, String name){
		String qstr = "UPDATE t SET t.name = " + name + " FROM Employee t WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (Exception e){
			System.err.println("Error setting employee name: ");
			System.err.println(e.getMessage());
		}
	}
	static ResultSet getAddress(Statement st, String eid){
		String qstr = "SELECT address FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee address: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setAddress(Statement st, String eid){
		
	}
	static ResultSet getEmail(Statement st, String eid){
		String qstr = "SELECT email FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee email: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setEmail(Statement st, String eid){
		
	}
	static ResultSet getPhoneNum(Statement st, String eid){
		String qstr = "SELECT phone FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee phone number: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setPhoneNum(Statement st, String eid){
		
	}
	static ResultSet startDate(Statement st, String eid){
		String qstr = "SELECT startDate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee start date: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setStartDate(Statement st, String eid){
		
	}
	static ResultSet getComp(Statement st, String eid){
		String qstr = "SELECT rate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch(Exception e){
			System.err.println("Error retrieving employee compensation rate: ");
			System.err.println(e.getMessage());
		}
		return rs;
	}
	static void setComp(Statement st, String eid){
		
	}
}
