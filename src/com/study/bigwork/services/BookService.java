package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.bigwork.entitys.Book;
import com.study.bigwork.util.DBUtil;


public class BookService {
	private List<Book> books;
	private DBUtil dbUtil;
	
	
	public BookService() {
		//初始化Book集合
		books = new ArrayList<Book>();
		dbUtil = new DBUtil();
	}
	
	
	/**
	 * 获取Book信息
	 * @param sql 查询订单的sql语句
	 * @return Book集合
	 */
	public List<Book> getBooks(String sql){
		try {
			//查询Book
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Book表字段id的值
				int id = rs.getInt("id");
				//获取Book表字段bookName的值
				String bookName = rs.getString("bookName");
				//获取Book表字段bookAuthor的值
				String bookAuthor = rs.getString("bookAuthor");
				//获取Book表字段bookPress的值
				String bookPress = rs.getString("bookPress");
				//获取Book表字段totalPrice的值
				double price = rs.getDouble("price");
				//获取Book表字段stock的值
				int stock = rs.getInt("stock");
				//获取Book表字段stock的值
				String image = rs.getString("image");
				//获取Book表字段commission的值
				double commission = rs.getDouble("double");
				
				//根据获取到的图书信息构造图书对象
				Book book = new Book(id, bookName, bookAuthor, bookPress, price, stock, image, commission);
				books.add(book);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	
	/**
	 * 新增图书
	 * @param book 待添加的图书对象
	 * @return 添加图书是否成功，成功返回true，否则返回false
	 */
	public boolean addBook(Book book) {
		//获取图书信息
		 String bookName =book.getBookName();//图书名称
		 String bookAuthor =book.getBookAuthor();//图书作者							
		 String bookPress = book.getBookPress();//图书出版社
		 double price = book.getPrice();//图书价格
		 int stock = book.getStock();//图书库存
		 String image =book.getImage();//图书照片
		 
		//拼接插入book的sql语句
		String sql = "insert into `book`(bookName, bookAuthor ,bookPress ,price ,stock,image) "
				+ "values(" + bookName + ", " + bookAuthor + "," + bookPress + ","
						+ "" + price + ", " + stock + ","+ image+")";
		
		System.out.println(sql);
		//将图书的信息插入图书表中
		int n = -1;//存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}
	
}
