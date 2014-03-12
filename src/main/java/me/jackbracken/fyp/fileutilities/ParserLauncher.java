package main.java.me.jackbracken.fyp.fileutilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import main.java.me.jackbracken.fyp.graph.GraphBuilder;
import main.java.me.jackbracken.fyp.models.Answer;
import main.java.me.jackbracken.fyp.models.Question;
import main.java.me.jackbracken.fyp.models.User;
import main.java.me.jackbracken.fyp.reputation.WeightedSum;

public class ParserLauncher {
	// dataRoot should be the directory with the unzipped stack 
	// exchange files, each site in its own sub-directory
	
	public HashMap<Integer, User> userList = new HashMap<Integer, User>();
	public HashMap<Integer, Question> questionList = new HashMap<Integer, Question>();
	public HashMap<Integer, Answer> answerList = new HashMap<Integer, Answer>();
	int x = 0;
	long startTime, endTime;

	public ParserLauncher(File dataRoot) {
		String fileName, site;
		
		// Get all file objects in dataRoot. Can be File or Directory
		File[] listOfSites = dataRoot.listFiles();
		
		for(File siteDirectory : listOfSites) {
			// Put files from directories in an array
			if(!siteDirectory.isFile() && x < 1) {
				File[] siteDataFiles = siteDirectory.listFiles();
				site = siteDirectory.getName();
				
				byte filesParsed = 0;

				System.out.println("Directory:\t" + site);
				
				if(site.contains("test")) {
					System.out.println("Ignoring test dir");
					continue;
				}
				
				for (File dataFile: siteDataFiles) {
					fileName = dataFile.getName();
					
					if (fileName.equals("Users.xml")) {
						System.out.println("Parsing file:\t" + fileName);
						startTime = System.currentTimeMillis();
						userList = new ParseUsers(dataFile, site).getUserList();
						endTime = System.currentTimeMillis();
						 System.out.println("Parse users execution time: " + ((endTime - startTime) / 1000) + " seconds");
						filesParsed++;
					} else if (fileName.equals("Posts.xml")) {
						 System.out.println("Parsing file:\t" + fileName);
						
						// Get Q and A lists
						startTime = System.currentTimeMillis();
						ParsePosts pp = new ParsePosts(dataFile, site);
						endTime = System.currentTimeMillis();
						System.out.println("Parse posts execution time: " + ((endTime - startTime) / 1000) + " seconds");
						
						questionList = pp.getQuestionList();
						answerList = pp.getAnswerList();
						
						filesParsed++;
					} else {
						System.out.println("Ignoring file:\t" + fileName);
					}

				}
				
				if (filesParsed < 2) {
					System.out.println("Only " + filesParsed + " files were parsed in directory: " + site);
					System.exit(1);
				}
				
				//new GraphBuilder(userList, answerList, questionList);
				
			} else {
				// System.out.println("Unnecessary file " + siteDirectory.getName() + " found.");
			}
		}
	}
}
