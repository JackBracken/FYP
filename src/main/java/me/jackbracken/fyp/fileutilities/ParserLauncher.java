package main.java.me.jackbracken.fyp.fileutilities;

import java.io.File;
import java.util.Vector;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.me.jackbracken.fyp.models.Post;
import main.java.me.jackbracken.fyp.models.User;

import org.apache.log4j.Logger;

public class ParserLauncher {
	// dataRoot should be the directory with the unzipped stack 
	// exchange files, each site in its own sub-directory
	
	public Vector<User> userList = new Vector<User>();
	public Vector<Post> postList = new Vector<Post>();
	public static Logger logger = Logger.getLogger(";");
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	private String dbUrl = "jdbc:postgresql://localhost/testdb";
	private String user = "karma";
	private String pass = "karma";
	
	public ParserLauncher(File dataRoot) {
		String fileName, site;
		
		// Get all file objects in dataRoot. Can be File or Directory
		File[] listOfSites = dataRoot.listFiles();
		
		for(File siteDirectory : listOfSites) {
			// Put files from directories in an array
			if(!siteDirectory.isFile()) {
				File[] siteDataFiles = siteDirectory.listFiles();
				site = siteDirectory.getName();
				byte filesParsed = 0;

				logger.info("Directory:\t" + site);
				
				for (File dataFile: siteDataFiles) {
					fileName = dataFile.getName();
					
					if (fileName.equals("Users.xml")) {
						logger.info("Parsing file:\t" + fileName);
						userList = new ParseUsers(dataFile, site).getUserList();
						filesParsed++;
					} else if (fileName.equals("Posts.xml")) {
						logger.info("Parsing file:\t" + fileName);
						postList = new ParsePosts(dataFile, site).getPostList();
						filesParsed++;
					} else {
						logger.info("Ignoring file:\t" + fileName);
					}
				}
				
				if (filesParsed < 2) {
					logger.error("Only " + filesParsed + " files were parsed in directory: " + site);
					System.exit(1);
				}
				
				
			} else {
				logger.info("Unnecessary file " + siteDirectory.getName() + "found.");
			}
		}
		
		try {
			con = DriverManager.getConnection(dbUrl, user, pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT VERSION()");
			
			if (rs.next()) {
				logger.info(rs.getString(1));
			}
			
	 	} catch (SQLException se){
			logger.error(se.getMessage());
		
	 	} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (st != null) {
					st.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				logger.error(se.getMessage());
			}
		}
		
	}
	
	public Vector<User> getUserList() {
		return userList;
	}
	
	public Vector<Post> getPostList() {
		return postList;
	}
}
