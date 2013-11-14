package main.java.me.jackbracken.FYP.Models;

public enum PostType {
	Question(1),
	Answer(2),
	Wiki(3),
	TagWikiExcerpt(4),
	TagWiki(5),
	ModeratorNomination(6),
	WikiPlaceholder(7),
	PrivilegeWiki(8);
	
	PostType(int code) {
		this.code = code;
	}
	
	private int code;
	
	public int getCode() {
		return this.code;
	}
}
