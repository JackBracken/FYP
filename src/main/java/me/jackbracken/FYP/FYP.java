package main.java.me.jackbracken.FYP;

import java.io.File;
import java.util.Vector;

import main.java.me.jackbracken.FYP.FileUtilities.ParsePostsFile;
import main.java.me.jackbracken.FYP.FileUtilities.ParseUserFile;
import main.java.me.jackbracken.FYP.Models.Post;
import main.java.me.jackbracken.FYP.Models.User;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		File userFile = new File("/home/jack/stack/photo/Users.xml");

		ParseUserFile puf = new ParseUserFile(userFile);
		Vector<User> users = new Vector<User>(puf.getUsers());
		for(User u: users) {
			System.out.println(u.toString());
		}
		
		File postFile = new File("/home/jack/stack/photo/Posts.xml");
		
		ParsePostsFile ppf = new ParsePostsFile(postFile);
		Vector<Post> posts = new Vector<Post>(ppf.getPosts());
		for(Post p: posts) {
			if(p.getAnswerCount() == 0){
				System.out.println(p.toString());
			}
		}
		
		
		System.exit(0);
	}
}
