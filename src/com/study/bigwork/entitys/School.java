package com.study.bigwork.entitys;

public class School {
	private int id;
	private String schoolName;
	private String image;//学校图片
	private String pNumber;//联系电话
	private String address;//学校地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public School(int id, String schoolName, String image, String pNumber, String address) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.image = image;
		this.pNumber = pNumber;
		this.address = address;
	}
	public School() {
		super();
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", schoolName=" + schoolName + ", image=" + image + ", pNumber=" + pNumber
				+ ", address=" + address + "]";
	}
	
	
}
