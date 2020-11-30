package com.study.bigwork.entitys;



public class Book {
	private int BookId;
	private String name;//书名
	private String publisher;//出版社
	private int remaining;//剩余数量
	private int price;
	private String notification;//购买须知
	private String image;//图片地址
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getRemaining() {
		return remaining;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNotification() {
		return notification;
	}
	public void setNotification(String notification) {
		this.notification = notification;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Book(int bookId, String name, String publisher, int remaining, int price, String notification,
			String image) {
		super();
		BookId = bookId;
		this.name = name;
		this.publisher = publisher;
		this.remaining = remaining;
		this.price = price;
		this.notification = notification;
		this.image = image;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [BookId=" + BookId + ", name=" + name + ", publisher=" + publisher + ", remaining=" + remaining
				+ ", price=" + price + ", notification=" + notification + ", image=" + image + "]";
	}
	
}
