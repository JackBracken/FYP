package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import main.java.me.jackbracken.FYP.Models.Post;
import main.java.me.jackbracken.FYP.Models.User;

public class ParserLauncher {
	// dataRoot should be the directory with the unzipped stack 
	// exchange files, each site in its own sub-directory
	
	public Vector<User> userList = new Vector<User>();
	public Vector<Post> postList = new Vector<Post>();
	
	public ParserLauncher(File dataRoot) {
		String fileName, site;
		File[] listOfSites = dataRoot.listFiles();
		
		for(File siteDirectory : listOfSites) {
			if(!siteDirectory.isFile()) {
				File[] siteDataFiles = siteDirectory.listFiles();
				site =  siteDirectory.getName();

				System.out.println("Directory:\t" + site);
				for (File dataFile: siteDataFiles) {
					fileName = dataFile.getName();
					
					if (fileName.contains("Users")) {
						System.out.println("Parsing file:\t" + fileName);
						userList = new ParseUserFile(dataFile, site).getUserList();
					} else if (fileName.contains("Posts")) {
						System.out.println("Parsing file:\t" + fileName);
						postList = new ParsePostFile(dataFile, site).getPostList();
					} else {
						System.out.println("Ignoring file:\t" + fileName);
					}
				}
				
				
			} else {
				System.out.println("Erroneous file " + siteDirectory.getName() + "found.");
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
