package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.bigwork.entitys.WrongQuestion;
import com.study.bigwork.util.DBUtil;

public class WrongQuestionService {

	private List<WrongQuestion> wrongQuestions;
	private DBUtil dbUtil;

	public WrongQuestionService() {
		// 初始化错题集合
		wrongQuestions = new ArrayList<WrongQuestion>();
		dbUtil = new DBUtil();
	}

	/**
	 * 新增错题
	 * 
	 * @param order 待添加的错题对象
	 * @return 添加错题是否成功，成功返回true，否则返回false
	 */
	public boolean addWrongQuestion(WrongQuestion wrongQuestion) {
		// 获取错题信息

		int wrong_id = wrongQuestion.getWrong_id();// 错题id
		int user_id = wrongQuestion.getUser_id();// 用户id
		String update_time = wrongQuestion.getUpdate_time();// 错题提交时间
		String question_Type = wrongQuestion.getQuestion_Type();//错题类型
		List<String> homework_image = wrongQuestion.getHomework_image();// 作业图片
		String allPhoto1 = "";
		Gson gson1 = new Gson();
		allPhoto1 = gson1.toJson(homework_image);
		List<String> result_image = wrongQuestion.getResult_image();// 结果图片
		String allPhoto2 = "";
		Gson gson2 = new Gson();
		allPhoto2 = gson2.toJson(result_image);
		
		List<String> result_image_teachers = wrongQuestion.getResult_image_teacher();
		Gson gson3 = new Gson();
		String result_image_teacher ="";
		result_image_teacher = gson3.toJson(result_image_teachers);
		
		
		
		String result_text_teacher = wrongQuestion.getResult_text_teacher();//获取老师注释
		String result_text_student = wrongQuestion.getResult_text_student();//获取学生注释
		

		// 拼接插入订单的sql语句
		String sql = "insert into `wrongquestion`(wrong_id, user_id ,update_time ,question_Type ,homework_image,"
				+ "result_image,result_text_teacher,result_text_student,result_image_teacher) " + "values("+ wrong_id + ", " + user_id + ",'" + update_time + "',"
						+ "'" + question_Type + "', '" + allPhoto1 + "','" + allPhoto2 + "','" + result_text_teacher + "','" + result_text_student + "','"+result_image_teacher+"')";

		System.out.println(sql);
		// 将错题的信息插入错题表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}
	
	
	/**
	 * 获取WrongQuestion信息
	 * @param sql 查询订单的sql语句
	 * @return WrongQuestion集合
	 */
	public List<WrongQuestion> getWrongQuestions(String sql){
		try {
			System.out.println("获取到的sql语句："+sql);
			//查询Homework
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Homework表字段id的值
				int id = rs.getInt("id");
				//获取Homework表字段wrong_id的值
				int wrong_id = rs.getInt("wrong_id");
				//获取Homework表字段user_id的值
				int user_id = rs.getInt("user_id");
				//获取Homework表字段question_Type的值
				String question_Type = rs.getString("question_Type");
				//获取Homework表字段update_time的值
				String update_time = rs.getString("update_time");
				//获取Homework表字段homework_image的值
				Gson gson = new Gson();
				List<String> homework_image = new ArrayList<>();
				homework_image = gson.fromJson(rs.getString("homework_image"), new TypeToken<ArrayList<String>>() {}.getType());
				//获取Homework表字段result_image的值
				Gson gsons = new Gson();
				List<String> result_image = new ArrayList<>();
				result_image = gsons.fromJson(rs.getString("result_image"), new TypeToken<ArrayList<String>>() {}.getType());
				
				//获取Homework表字段result_text的值
				String result_text_teacher = rs.getString("result_text_teacher");
				
				//获取Homework表字段result_text_student的值
				String result_text_student = rs.getString("result_text_student");
				
				List<String> result_image_teacher = new ArrayList<>();
				result_image_teacher = gsons.fromJson(rs.getString("result_image_teacher"), new TypeToken<ArrayList<String>>() {}.getType());
			
				
				
				//根据获取到的Homework信息构造Homework对象
				WrongQuestion wrongQuestion = new WrongQuestion(id, wrong_id, user_id, question_Type, update_time, homework_image, result_image, result_text_teacher, result_text_student, result_image_teacher);
				wrongQuestions.add(wrongQuestion);
				
				
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return wrongQuestions;
	}
	
	
	
	
	

}
