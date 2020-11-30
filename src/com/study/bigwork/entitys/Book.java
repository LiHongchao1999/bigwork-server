package com.study.bigwork.entitys;

public class Book {
	private int id;
    private String bookName;//书本名称
    private String bookAuthor;//书本作者
    private String bookPress;//书本出版社
    private double price;//书本价格
    private int stock;//书本库存
    private String image;//书本图片
    private String commission;//推广佣金
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCommission() {
		return commission;
	}
	public void setCommission(String commission) {
		this.commission = commission;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPress=" + bookPress
				+ ", price=" + price + ", stock=" + stock + ", image=" + image + ", commission=" + commission + "]";
	}
	
	
	
    
    
    
	
	
	
}