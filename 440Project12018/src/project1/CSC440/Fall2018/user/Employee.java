package project1.CSC440.Fall2018.user;

import java.sql.*;

public interface Employee {
	static void createEmployee(Statement st, String role, String eid, String name, String address, String email, String phoneNum, String startDate, String sid){
		String fields[] = new String[8];
		fields[0] = role;
		fields[1] = eid;
		fields[2] = name;
		fields[3] = address;
		fields[4] = email;
		fields[5] = phoneNum;
		fields[6] = startDate;
		fields[7] = sid;
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
	static void updateEmployee(Statement st, String eid, String role, String name, String address, String email, String phoneNum, String startDate, String compensation, String sid){
		String qstr = "UPDATE Employee SET";
		if (!(role == null) && !(role.length() == 0)){
			qstr += " role = " + role + ",";
		}
		if (!(eid == null) && !(eid.length() == 0)){
			qstr += " eid = " + eid + ",";
		}
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
		if (!(sid == null) && !(sid.length() == 0)){
			qstr += " sid = " + sid + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating employee");
		}
	}
	static ResultSet employeeGetName(Statement st, String eid){
		String qstr = "SELECT name FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting name");
		}
		return rs;
	}
	static void employeeSetName(Statement st, String eid, String name){
		String qstr = "UPDATE Employee SET name = " + name + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting name");
		}
	}
	static ResultSet employeeGetAddress(Statement st, String eid){
		String qstr = "SELECT address FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting email");
		}
		return rs;
	}
	static void employeeSetAddress(Statement st, String eid, String address){
		String qstr = "UPDATE Employee SET address = " + address + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting address");
		}
	}
	static ResultSet employeeGetEmail(Statement st, String eid){
		String qstr = "SELECT email FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting email");
		}
		return rs;
	}
	static void employeeSetEmail(Statement st, String eid, String email){
		String qstr = "UPDATE Employee SET email = " + email + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting email");
		}
	}
	static ResultSet employeeGetPhoneNum(Statement st, String eid){
		String qstr = "SELECT phone FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting phone number");
		}
		return rs;
	}
	static void employeeSetPhoneNum(Statement st, String eid, String phone){
		String qstr = "UPDATE Employee SET phone = " + phone + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting phone number");
		}
	}
	static ResultSet employeeGetStartDate(Statement st, String eid){
		String qstr = "SELECT startDate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting start date");
		}
		return rs;
	}
	static void employeeSetStartDate(Statement st, String eid, String startDate){
		String qstr = "UPDATE Employee SET startDate = " + startDate + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting start date");
		}
	}
	static ResultSet employeeGetSId(Statement st, String eid){
		String qstr = "SELECT rate FROM Employee WHERE eid = " + eid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting employee sid");
		}
		return rs;
	}
	static void employeeSetSId(Statement st, String eid, String sid){
		String qstr = "UPDATE Employee SET sid = " + sid + " WHERE eid = " + eid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error setting sid");
		}
	}
}
