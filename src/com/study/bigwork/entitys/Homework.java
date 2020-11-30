package com.study.bigwork.entitys;

public class Homework {
	private int id;
	private String submitTime;//上传日期
	private String expirationTime;//截止日期
	private String userName;//上传作业的用户的名字
	private String subject;//作业科目
	private String homeworkImg;//作业图片
	private int state;//判断作业是否被接单
	private int teacherId;//接单教师的id
	private int price;//批改改作业所需钱数
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getHomeworkImg() {
		return homeworkImg;
	}
	public void setHomeworkImg(String homeworkImg) {
		this.homeworkImg = homeworkImg;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Homework() {
		super();
	}
	/**
	 *刚开始上传作业时，不要老师，教师id与状态是后期改的
	 * @param id
	 * @param userName
	 * @param updateTime
	 * @param expirationTime
	 * @param subject
	 * @param image
	 */
	public Homework(int id,String userName, String submitTime, String expirationTime, String subject, String image,int price) {
		super();
		this.id = id;
		this.userName=userName;
		this.submitTime = submitTime;
		this.expirationTime = expirationTime;
		this.subject = subject;
		this.homeworkImg = image;
		this.price=price;
	}
	public Homework(int id, String submitTime, String expirationTime, String userName, String subject,
			String homeworkImg, int state, int teacherId, int price) {
		super();
		this.id = id;
		this.submitTime = submitTime;
		this.expirationTime = expirationTime;
		this.userName = userName;
		this.subject = subject;
		this.homeworkImg = homeworkImg;
		this.state = state;
		this.teacherId = teacherId;
		this.price = price;
	}
	
	
	
	
	
}
