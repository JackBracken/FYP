package main.java.me.jackbracken.FYP;

import java.io.File;
import java.util.Vector;

import main.java.me.jackbracken.FYP.FileUtilities.ParsePostFile;
import main.java.me.jackbracken.FYP.FileUtilities.ParseUserFile;
import main.java.me.jackbracken.FYP.FileUtilities.ParseVoteFile;
import main.java.me.jackbracken.FYP.Models.Post;
import main.java.me.jackbracken.FYP.Models.User;
import main.java.me.jackbracken.FYP.Models.Vote;

import com.googlecode.flyway.core.Flyway;

public class FYP {
	public static void main(String[] args) {
		// Create flyway instance
		Flyway flyway = new Flyway();
		// Point to database
		flyway.setDataSource("jdbc:postgresql:fyp", "karma", "karma");
		flyway.migrate();

		final String HOME = System.getenv("HOME");
		
		File userFile = new File(HOME + "/stack/photo/Users.xml");

		ParseUserFile puf = new ParseUserFile(userFile);
		Vector<User> users = new Vector<User>(puf.getUsers());
		for(User u: users) {
			System.out.println(u.toString());
		}
		
		File postFile = new File(HOME + "/stack/photo/Posts.xml");
		
		ParsePostFile ppf = new ParsePostFile(postFile);
		Vector<Post> posts = new Vector<Post>(ppf.getPosts());
		for(Post p: posts) {
			if(p.getAnswerCount() == 0){
				System.out.println(p.toString());
			}
		}
		
		File voteFile = new File(HOME + "/stack/photo/Votes.xml");
		
		ParseVoteFile pvf = new ParseVoteFile(voteFile);
		Vector<Vote> votes = new Vector<Vote>(pvf.getVotes());
		for(Vote v: votes) {
			System.out.println(v.toString());
		}
		
		System.exit(0);
	}
}
