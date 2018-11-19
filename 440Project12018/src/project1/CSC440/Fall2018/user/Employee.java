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
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating employee");
		}
	}
	static ResultSet getEmployee(Statement st, String eid){
		String qstr = "SELECT * FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting employee");
		}
		return rs;
	}
	static void updateEmployee(Statement st, String eid, String name, String address, String email, String phoneNum, String startDate, String compensation){
		String qstr = "UPDATE Employee SET";
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = " + name + ",";
		}
		if (!(address == null) && !(address.length() == 0)){
			qstr += " address = " + address + ",";
		}
		if (!(email == null) && !(email.length() == 0)){
			qstr += " email = " + email + ",";
		}
		if (!(phoneNum == null) && !(phoneNum.length() == 0)){
			qstr += " phone = " + phoneNum + ",";
		}
		if (!(startDate == null) && !(startDate.length() == 0)){
			qstr += " startDate = " + startDate + ",";
		}
		if (!(compensation == null) && !(compensation.length() == 0)){
			qstr += " rate = " + compensation + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating employee");
		}
	}
	static ResultSet getName(Statement st, String eid){
		String qstr = "SELECT name FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting name");
		}
		return rs;
	}
	static void setName(Statement st, String eid, String name){
		String qstr = "UPDATE Employee SET name = " + name + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting name");
		}
	}
	static ResultSet getAddress(Statement st, String eid){
		String qstr = "SELECT address FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting email");
		}
		return rs;
	}
	static void setAddress(Statement st, String eid, String address){
		String qstr = "UPDATE Employee SET address = " + address + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting address");
		}
	}
	static ResultSet getEmail(Statement st, String eid){
		String qstr = "SELECT email FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting email");
		}
		return rs;
	}
	static void setEmail(Statement st, String eid, String email){
		String qstr = "UPDATE Employee SET email = " + email + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting email");
		}
	}
	static ResultSet getPhoneNum(Statement st, String eid){
		String qstr = "SELECT phone FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting phone number");
		}
		return rs;
	}
	static void setPhoneNum(Statement st, String eid, String phone){
		String qstr = "UPDATE Employee SET phone = " + phone + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting phone number");
		}
	}
	static ResultSet startDate(Statement st, String eid){
		String qstr = "SELECT startDate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting start date");
		}
		return rs;
	}
	static void setStartDate(Statement st, String eid, String startDate){
		String qstr = "UPDATE Employee SET startDate = " + startDate + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting start date");
		}
	}
	static ResultSet getComp(Statement st, String eid){
		String qstr = "SELECT rate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting compensation rate");
		}
		return rs;
	}
	static void setComp(Statement st, String eid, String rate){
		String qstr = "UPDATE Employee SET rate = " + rate + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting compensation rate");
		}
	}
}
