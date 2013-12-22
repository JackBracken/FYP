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
		String fileName;
		File[] listOfSites = dataRoot.listFiles();
		
		for(File siteDirectory : listOfSites) {
			if(!siteDirectory.isFile()) {
				File[] siteDataFiles = siteDirectory.listFiles();
				
				System.out.println("Directory:\t" + siteDirectory.getName());
				for (File dataFile: siteDataFiles) {
					fileName = dataFile.getName();
					
					if (fileName.contains("Users")) {
						System.out.println("Parsing file:\t" + fileName);
//						ParseUserFile puf = new ParseUserFile(dataFile);
						userList = new ParseUserFile(dataFile).getUserList();
					} else if (fileName.contains("Posts")) {
						System.out.println("Parsing file:\t" + fileName);
//						ParsePostFile ppf = new ParsePostFile(dataFile);
						postList = new ParsePostFile(dataFile).getPostList();
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
