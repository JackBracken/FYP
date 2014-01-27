package main.java.me.jackbracken.fyp.fileutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Vector;

import main.java.me.jackbracken.fyp.models.Post;

public class UpsertPosts {
	// TODO Refactor this class
	
	private Connection con = null;
	private PreparedStatement ps = null;
	
	private static final String DB_URL = "jdbc:postgresql://localhost/fyp";
	private static final String DB_USER = "karma";
	private static final String DB_PASSWORD = "karma";
	
	// TODO seems to work, need to test
	private String upsertQuery = "UPDATE posts SET posttypeid = ?, score = ? WHERE id = ? AND site = ?;" +
								 "INSERT INTO posts (id, posttypeid, creationdate, score, acceptedanswer, ownerid, answers, site)" +
									"SELECT ?, ?, ?, ?, ?, ?, ?, ?" +
									"WHERE NOT EXISTS (SELECT 1 FROM posts WHERE id = ? AND site = ?);";
	
	UpsertPosts(Vector<Post> posts) throws SQLException {
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			for(Post post: posts){
				ps = con.prepareStatement(upsertQuery);

				Date sqlCreationDate = new Date(post.getCreationDate().getTime());
				
				ps.setInt(1, post.getPostTypeID());
				ps.setInt(2, post.getScore());
				ps.setInt(3, post.getID());
				ps.setString(4, post.getSite());
				ps.setInt(5, post.getID());
				ps.setInt(6, post.getPostTypeID());
				ps.setDate(7, sqlCreationDate);
				ps.setInt(8, post.getScore());
				ps.setInt(9, post.getAcceptedAnswer());
				ps.setInt(10, post.getOwnerID());
				ps.setInt(11, post.getAnswerCount());
				ps.setString(12, post.getSite());
				ps.setInt(13, post.getID());
				ps.setString(14, post.getSite());
				
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
