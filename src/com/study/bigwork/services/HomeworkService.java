package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.bigwork.entitys.Book;
import com.study.bigwork.entitys.Homework;
import com.study.bigwork.util.DBUtil;


public class HomeworkService {
	private List<Homework> homeworks;
	private DBUtil dbUtil;
	
	
	public HomeworkService() {
		//初始化作业集合
		homeworks = new ArrayList<Homework>();
		dbUtil = new DBUtil();
	}
	
	
	/**
	 * 新增作业订单
	 * @param order 待添加的作业订单对象
	 * @return 添加订单是否成功，成功返回true，否则返回false
	 */
	public boolean addHomework(Homework homework) {
		//获取作业订单信息
		 String submitTime =homework.getSubmitTime();//作业提交时间
		 String deadline = homework.getDeadline();//作业截止时间
		 String homeworkType = homework.getHomeworkType();//作业类型
		 List<String> homework_image = homework.getHomework_image();//作业图片
		 double money = homework.getMoney();
		 
		//拼接插入订单的sql语句
		String sql = "insert into `homework`(submitTime, deadline ,homeworkType ,homework_image ,money) "
				+ "values('" + submitTime + "', " + deadline + ",'" + homeworkType + "'," + homework_image.toString() + ", '" + money + "')";
		
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
	 * 获取Homework信息
	 * @param sql 查询订单的sql语句
	 * @return Homework集合
	 */
	public List<Homework> getHomeworks(String sql){
		try {
			//查询Homework
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Homework表字段id的值
				int id = rs.getInt("id");
				//获取Homework表字段submitTime的值
				String submitTime = rs.getString("submitTime");
				//获取Homework表字段deadline的值
				String deadline = rs.getString("deadline");
				//获取Homework表字段homeworkType的值
				String homeworkType = rs.getString("homeworkType");
				//获取Homework表字段tag的值
				String tag = rs.getString("tag");
				//获取Homework表字段homework_image的值
				List<String> homework_image = new ArrayList<>();
				homework_image.add(rs.getString("homework_image"));
				//获取Homework表字段teacher_id的值
				int teacher_id = rs.getInt("teacher_id");
				//获取Homework表字段result_image的值
				List<String> result_image = new ArrayList<>();
				homework_image.add(rs.getString("result_image"));
				
				//获取Homework表字段result_text的值
				String result_text = rs.getString("result_text");
				//获取Homework表字段money的值
				double money = rs.getDouble("money");
				
				//根据获取到的Homework信息构造Homework对象
				Homework homework = new Homework(id, submitTime, deadline, homeworkType, tag, homework_image, 
						teacher_id, result_image, result_text, money);
				homeworks.add(homework);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}
	
	
	
	
	
	
	
	

}
