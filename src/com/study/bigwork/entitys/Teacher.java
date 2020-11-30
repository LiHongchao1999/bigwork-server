package com.study.bigwork.entitys;

public class Teacher {
	private int teacherId;
	private String image;
	private String pNumber;//教师手机号
	private String password;//教师密码
	private String fSchool;//来自于哪个学校
	private int rank;//认证等级
	private String qqNumber;//qq账号
	private String weNumber;//微信账号
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getpNumber() {
		return pNumber;
	}
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfSchool() {
		return fSchool;
	}
	public void setfSchool(String fSchool) {
		this.fSchool = fSchool;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String getWeNumber() {
		return weNumber;
	}
	public void setWeNumber(String weNumber) {
		this.weNumber = weNumber;
	}
	public Teacher(int teacherId, String image, String pNumber, String password, String fSchool, int rank,
			String qqNumber, String weNumber) {
		super();
		this.teacherId = teacherId;
		this.image = image;
		this.pNumber = pNumber;
		this.password = password;
		this.fSchool = fSchool;
		this.rank = rank;
		this.qqNumber = qqNumber;
		this.weNumber = weNumber;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", image=" + image + ", pNumber=" + pNumber + ", password="
				+ password + ", fSchool=" + fSchool + ", rank=" + rank + ", qqNumber=" + qqNumber + ", weNumber="
				+ weNumber + "]";
	}
	
}