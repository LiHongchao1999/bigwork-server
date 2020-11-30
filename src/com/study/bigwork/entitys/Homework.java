package com.study.bigwork.entitys;

public class Homework {
	private int id;
	private String updateTime;//上传日期
	private String expirationTime;//截止日期
	private String subject;//作业科目
	private String image;//作业图片
	private int flag;//判断作业是否被接单
	private int teacherId;//接单教师的id
	private int price;//批改改作业所需钱数
	
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	
	public Homework() {
		super();
	}
	/**
	 *刚开始上传作业时，不要老师，教师id与状态是后期改的
	 * @param id
	 * @param updateTime
	 * @param expirationTime
	 * @param subject
	 * @param image
	 */
	public Homework(int id, String updateTime, String expirationTime, String subject, String image,int price) {
		super();
		this.id = id;
		this.updateTime = updateTime;
		this.expirationTime = expirationTime;
		this.subject = subject;
		this.image = image;
		this.price=price;
	}
	
	
}
