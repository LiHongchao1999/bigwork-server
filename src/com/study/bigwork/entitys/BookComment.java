package com.study.bigwork.entitys;

public class BookComment {
	private int commentId;
	private int bookId;//评论的图书的Id
	private String userName;//评论人名称
	private String comment;//评论内容
	private String commentTime;//评论时的时间
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
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
	public BookComment(int commentId, int bookId, String userName, String comment, String commentTime) {
		super();
		this.commentId = commentId;
		this.bookId = bookId;
		this.userName = userName;
		this.comment = comment;
		this.commentTime = commentTime;
	}
	public BookComment() {
		super();
	}
	@Override
	public String toString() {
		return "BookComment [commentId=" + commentId + ", bookId=" + bookId + ", userName=" + userName + ", comment="
				+ comment + ", commentTime=" + commentTime + "]";
	}
	
}
