package com.study.bigwork.entitys;

import java.util.List;

public class Circle {
	private int id;
	private int userId;//用户id
	private String chatId;//聊天id
    private String userImg; //用户头像
    private String userName;  //用户名
    private String time;  //发表的时间
    private String content;  //发表的内容
    private List<String> sendImg;  //发表的图片
    private int likeSize;  //点赞数
    private int forwardSize;  //转发数
    private int commentSize;  //评论数
    
    
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getChat_id() {
		return chatId;
	}
	public void setChat_id(String chat_id) {
		this.chatId = chat_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getSendImg() {
		return sendImg;
	}
	public void setSendImg(List<String> sendImg) {
		this.sendImg = sendImg;
	}
	public int getLikeSize() {
		return likeSize;
	}
	public void setLikeSize(int likeSize) {
		this.likeSize = likeSize;
	}
	public int getForwardSize() {
		return forwardSize;
	}
	public void setForwardSize(int forwardSize) {
		this.forwardSize = forwardSize;
	}
	public int getCommentSize() {
		return commentSize;
	}
	public void setCommentSize(int commentSize) {
		this.commentSize = commentSize;
	}


	
	
	public Circle(int id, int userId, String chatId, String userImg, String userName, String time, String content,
			List<String> sendImg, int likeSize, int forwardSize, int commentSize) {
		super();
		this.id = id;
		this.userId = userId;
		this.chatId = chatId;
		this.userImg = userImg;
		this.userName = userName;
		this.time = time;
		this.content = content;
		this.sendImg = sendImg;
		this.likeSize = likeSize;
		this.forwardSize = forwardSize;
		this.commentSize = commentSize;
	}
	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Circle [id=" + id + ", userId=" + userId + ", chatId=" + chatId + ", userImg=" + userImg + ", userName="
				+ userName + ", time=" + time + ", content=" + content + ", sendImg=" + sendImg + ", likeSize="
				+ likeSize + ", forwardSize=" + forwardSize + ", commentSize=" + commentSize + "]";
	}
    
    

}
