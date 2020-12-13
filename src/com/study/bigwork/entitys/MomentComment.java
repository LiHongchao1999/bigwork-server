package com.study.bigwork.entitys;

public class MomentComment {
	private int commentId;
	private int MomentId;//评论的朋友圈的Id
	private String userName;//评论人名称
	private String comment;//评论内容
	private String commentTime;//评论时的时间
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getMomentId() {
		return MomentId;
	}
	public void setMomentId(int momentId) {
		MomentId = momentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public MomentComment(int commentId, int momentId, String userName, String comment, String commentTime) {
		super();
		this.commentId = commentId;
		MomentId = momentId;
		this.userName = userName;
		this.comment = comment;
		this.commentTime = commentTime;
	}
	public MomentComment() {
		super();
	}
	@Override
	public String toString() {
		return "MomentComment [commentId=" + commentId + ", MomentId=" + MomentId + ", userName=" + userName
				+ ", comment=" + comment + ", commentTime=" + commentTime + "]";
	}
	
}
