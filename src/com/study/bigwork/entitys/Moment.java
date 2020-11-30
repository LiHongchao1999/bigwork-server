package com.study.bigwork.entitys;

public class Moment {
	private int id;
	private String updateTime;//发布日期
	private String expirationTime;//截止日期
	private String userName;//发布该朋友圈用户的名称
	private String content;//朋友圈文字内容
	private String images;//朋友圈的文字
	private int dianzan;//朋友圈点赞数
	private int transmit;//朋友圈转发数
	private int comment;//评论数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getDianzan() {
		return dianzan;
	}
	public void setDianzan(int dianzan) {
		this.dianzan = dianzan;
	}
	public int getTransmit() {
		return transmit;
	}
	public void setTransmit(int transmit) {
		this.transmit = transmit;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public Moment(int id, String updateTime, String expirationTime, String userName, String content, String images,
			int dianzan, int transmit, int comment) {
		super();
		this.id = id;
		this.updateTime = updateTime;
		this.expirationTime = expirationTime;
		this.userName = userName;
		this.content = content;
		this.images = images;
		this.dianzan = dianzan;
		this.transmit = transmit;
		this.comment = comment;
	}
	public Moment() {
		super();
	}
	@Override
	public String toString() {
		return "Moments [id=" + id + ", updateTime=" + updateTime + ", expirationTime=" + expirationTime + ", userName="
				+ userName + ", content=" + content + ", images=" + images + ", dianzan=" + dianzan + ", transmit="
				+ transmit + ", comment=" + comment + "]";
	}
	
	
}
