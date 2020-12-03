package com.study.bigwork.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.study.bigwork.entitys.Homework;
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
		String result_text_teacher = wrongQuestion.getResult_text_teacher();//获取老师注释
		String result_text_student = wrongQuestion.getResult_text_student();//获取学生注释
		

		// 拼接插入订单的sql语句
		String sql = "insert into `wrongquestion`(wrong_id, user_id ,update_time ,question_Type ,homework_image,"
				+ "result_image,result_text_teacher,result_text_student) " + "values("+ wrong_id + ", " + user_id + ",'" + update_time + "',"
						+ "'" + question_Type + "', '" + allPhoto1 + "','" + allPhoto2 + "','" + result_text_teacher + "','" + result_text_student + "')";

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

}
