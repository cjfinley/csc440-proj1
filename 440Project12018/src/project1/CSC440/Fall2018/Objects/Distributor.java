package project1.CSC440.Fall2018.Objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Distributor {
	public static void createDistributor(Connection conn, String did, String name) throws SQLException{
		String qstr = "INSERT INTO Distributors ?, ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, did);
		st.setString(2, name);
		st.executeUpdate();
	}
	public static ResultSet getDistributor(Connection conn, String did) throws SQLException{
		String qstr = "SELECT * FROM Distributors WHERE DID = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		st.setString(1, did);
		ResultSet rs = null;
		rs = st.executeQuery();
		return rs;
	}
	public static void updatePart(Connection conn, String did, String name) throws SQLException{
		String qstr = "UPDATE Distributors SET";
		int[] track = {0,0};
		if (!(did == null) && !(did.length() == 0)){
			qstr += " did = ?,";
			track[0] = 1;
		}
		if (!(name == null) && !(name.length() == 0)){
			qstr += " name = ?,";
			track[1] = 1;
		}
		qstr = qstr.substring(0, qstr.length() - 1);
		qstr += " WHERE did = ?";
		PreparedStatement st = conn.prepareStatement(qstr);
		if(track[0] == 1){
			st.setString(1, did);
		}
		if(track[1] == 1){
			st.setString(2, name);
		}
	}
}
