package main.java.me.jackbracken.FYP.Models;

public enum VoteType {
	AcceptedByOriginator(1),
	UpMod(2),
	DownMod(3),
	Offensive(4),
	Favorite(5),
	Close(6),
	Reopen(7),
	BountyStart(8),
	BountyClose(9),
	Deletion(10),
	Undeletion(11),
	Spam(12),
	ModeratorReview(15),
	ApproveEditSuggestion(16);
	
	VoteType(int code) {
		this.code = code;
	}
	
	private int code;
	
	public int getCode() {
		return this.code;
	}
}
