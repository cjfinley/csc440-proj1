package project1.CSC440.Fall2018.Objects;

import java.sql.*;

public class ServiceCenter {
	public static void createServiceCenter(Connection conn, String sid, String name, String address, String phone){
		String fields[] = new String[4];
		fields[0] = sid;
		fields[1] = name;
		fields[2] = address;
		fields[3] = phone;
		try{
			st.executeUpdate("INSERT INTO Service_Center", fields);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error creating service center");
		}
	}
	public static ResultSet getServiceCenter(Connection conn, String sid){
		String qstr = "SELECT * FROM Service_Center WHERE sid = " + sid;
		ResultSet rs = null;
		try{
			rs = st.executeQuery(qstr);
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error getting service center");
		}
		return rs;
	}
	public static void updateServiceCenter(Connection conn, String sid, String name, String address, String phone){
		String qstr = "UPDATE Service_Center SET";
		if (!(sid == null) && !(sid.length() == 0)){
			qstr += " sid = " + sid + ",";
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = " + name + ",";
		}
		if (!(address == null) && !(address.length() == 0)){
			qstr += " address = " + address + ",";
		}
		if (!(phone == null) && !(phone.length() == 0)){
			qstr += " phone = " + phone + ",";
		}
		
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE sid = " + sid;
		try{
			st.executeUpdate(qstr);
		} catch (SQLException e){
			throw new IllegalArgumentException("Error updating service center");
		}
	}
}
