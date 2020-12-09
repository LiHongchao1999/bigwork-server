package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.bigwork.entitys.Circle;
import com.study.bigwork.entitys.Homework;
import com.study.bigwork.util.DBUtil;

public class CircleService {
	private List<Circle> circles;
	private DBUtil dbUtil;
	
	
	public CircleService() {
		//初始化帖子集合
		circles = new ArrayList<Circle>();
		dbUtil = new DBUtil();
	}
	
	/**
	 * 新增帖子
	 * @param order 待添加的帖子对象
	 * @return 添加帖子是否成功，成功返回true，否则返回false
	 */
	public boolean addCircle(Circle circle) {
		//获取帖子信息
		 String userImg =circle.getUserImg();//用户头像
		 String userName = circle.getUserName();//用户名
		 String time = circle.getTime();//发表的时间
		 String content = circle.getContent();//发表的内容
		 List<String> send_image = circle.getSendImg();//作业图片
		 String sendImg = "";
		 Gson gson = new Gson();
		 sendImg = gson.toJson(send_image);
		 
		//拼接插入订单的sql语句
		String sql = "insert into `circle`(userName, time ,content ,sendImg) "
				+ "values('" + userName + "', '" + time + "','" + content + "','" + sendImg + "')";
		
		System.out.println(sql);
		//将订单的信息插入作业表中
		int n = -1;//存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}
	
	
	/**
	 * 获取Circle信息
	 * @param sql 查询订单的sql语句
	 * @return Circle集合
	 */
	public List<Circle> getCircles(String sql){
		try {
			System.out.println("获取到的sql语句："+sql);
			//查询Homework
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Circle表字段id的值
				int id = rs.getInt("id");
				//获取Circle表字段userImg的值
				String userImg = rs.getString("userImg");
				//获取Circle表字段userName的值
				String userName = rs.getString("userName");
				//获取Circle表字段time的值
				String time = rs.getString("time");
				//获取Circle表字段content的值
				String content = rs.getString("content");
				
				//获取Circle表字段sendImg的值
				Gson gson = new Gson();
				List<String> sendImg = new ArrayList<>();
				sendImg = gson.fromJson(rs.getString("sendImg"), new TypeToken<ArrayList<String>>() {}.getType());
				
				//获取Homework表字段likeSize的值
				int likeSize = rs.getInt("likeSize");
				//获取Homework表字段forwardSize的值
				int forwardSize = rs.getInt("forwardSize");
				//获取Homework表字段commentSize的值
				int commentSize = rs.getInt("commentSize");
				
				
				//根据获取到的Homework信息构造Homework对象
				Circle circle = new Circle(id, userImg, userName, time, content, sendImg, likeSize, forwardSize, commentSize);
				circles.add(circle);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return circles;
	}
	
	
	

}
