package project1.CSC440.Fall2018.Records;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repair {
	public static void createRepair(Connection conn, String description, String diagnostic, String fee, String make, String model) throws SQLException{
		String qstr = "INSERT INTO Repairs (description, diagnostic, fee, make, model) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, description);
		st.setString(2, diagnostic);
		st.setString(3, fee);
		st.setString(4, make);
		st.setString(5, model);
		st.executeUpdate();
	}
	public static ResultSet getBasicService(Connection conn, String description) throws SQLException{
		String qstr = "SELECT * FROM Repairs WHERE description = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, description);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updateBasicService(Connection conn, String description, String diagnostic, String fee, String make, String model) throws SQLException{
		String qstr = "UPDATE Repairs SET";
		int[] track = {0,0,0,0,0};
		if (!(description == null) && !(description.length() == 0)){
			qstr += " description = ?,";
			track[0] = 1;
		}
		if (!(diagnostic == null) && !(diagnostic.length() == 0)){
			qstr += " diagnostic = ?,";
			track[1] = 1;
		}
		if (!(fee == null) && !(fee.length() == 0)){
			qstr += " fee = ?,";
			track[2] = 1;
		}
		if (!(make == null) && !(make.length() == 0)){
			qstr += " make = ?,";
			track[3] = 1;
		}
		if (!(model == null) && !(model.length() == 0)){
			qstr += " model = ?,";
			track[4] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE description = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		int count = 1;
		if(track[0] == 1){
			st.setString(count, description);
			count++;
		}
		if(track[1] == 1){
			st.setString(count, diagnostic);
			count++;
		}
		if(track[2] == 1){
			st.setString(count, fee);
			count++;
		}
		if(track[3] == 1){
			st.setString(count, make);
			count++;
		}
		if(track[4] == 1){
			st.setString(count, model);
			count++;
		}
		st.setString(count, description);
		st.executeUpdate();
	}
}
