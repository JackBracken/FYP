package main.java.me.jackbracken.fyp.fileutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import main.java.me.jackbracken.fyp.models.User;

public class UpsertUsers {
	// TODO Refactor this class
	
	private Connection con = null;
	private PreparedStatement ps = null;
	
	private static final String DB_URL = "jdbc:postgresql://localhost/fyp";
	private static final String DB_USER = "karma";
	private static final String DB_PASSWORD = "karma";
	
	// TODO seems to work, need to test
	private String upsertQuery = "UPDATE users SET name = ?, reputation = ? WHERE id = ? AND site = ?;" +
								 "INSERT INTO users (id, name, reputation, site)" +
									"SELECT ?, ?, ?, ?" +
									"WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = ? AND site = ?);";
	
	UpsertUsers(Vector<User> users) throws SQLException {
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			for(User user: users){
				ps = con.prepareStatement(upsertQuery);

				ps.setString(1, user.getName());
				ps.setInt(2, user.getReputation());
				ps.setInt(3, user.getUserId());
				ps.setString(4, user.getSite());
				ps.setInt(5, user.getUserId());
				ps.setString(6, user.getName());
				ps.setInt(7, user.getReputation());
				ps.setString(8, user.getSite());
				ps.setInt(9, user.getUserId());
				
				// execute query
				ps.executeUpdate();
			}
			
		} catch (SQLException se){
	 		System.out.println(se.getMessage());
		
	 	} finally {
			try {
				
				if (ps != null) {
					ps.close();
				}
				
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
		}
	}
	
}
