package main.java.me.jackbracken.fyp.fileutilities;

import java.io.File;
import java.sql.SQLException;
import java.util.Vector;

import main.java.me.jackbracken.fyp.models.Post;
import main.java.me.jackbracken.fyp.models.User;

public class ParserLauncher {
	// dataRoot should be the directory with the unzipped stack 
	// exchange files, each site in its own sub-directory
	
	public Vector<User> userList = new Vector<User>();
	public Vector<Post> postList = new Vector<Post>();

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

				System.out.println("Directory:\t" + site);
				
				for (File dataFile: siteDataFiles) {
					fileName = dataFile.getName();
					
					if (fileName.equals("Users.xml")) {
						System.out.println("Parsing file:\t" + fileName);
						userList = new ParseUsers(dataFile, site).getUserList();
						filesParsed++;
					} else if (fileName.equals("Posts.xml")) {
						System.out.println("Parsing file:\t" + fileName);
						postList = new ParsePosts(dataFile, site).getPostList();
						filesParsed++;
					} else {
						System.out.println("Ignoring file:\t" + fileName);
					}
				}
				
				if (filesParsed < 2) {
					System.out.println("Only " + filesParsed + " files were parsed in directory: " + site);
					System.exit(1);
				}
				
				try {
					new UpsertUsers(userList);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			} else {
				System.out.println("Unnecessary file " + siteDirectory.getName() + "found.");
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
