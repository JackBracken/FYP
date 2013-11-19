package main.java.me.jackbracken.FYP.FileUtilities;

import java.io.File;

public class ParserLauncher {
	// dataRoot should be the directory with the unzipped stack 
	// exchange files, each site in its own sub-directory
	
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
						new ParseUserFile(dataFile);
					} else if (fileName.contains("Posts")) {
						System.out.println("Parsing file:\t" + fileName);
						new ParsePostFile(dataFile);
					} else if (fileName.contains("Votes")) {
						System.out.println("Parsing file:\t" + fileName);
						new ParseVoteFile(dataFile);
					} else {
						System.out.println("Ignoring file:\t" + fileName);
					}
				}
				
				
			} else {
				System.out.println("Erroneous file " + siteDirectory.getName() + "found.");
			}
		}
	}
}
