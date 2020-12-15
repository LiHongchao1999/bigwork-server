package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.bigwork.entitys.Book;
import com.study.bigwork.entitys.Homework;
import com.study.bigwork.util.DBUtil;

public class HomeworkService {
	private List<Homework> homeworks;
	private DBUtil dbUtil;

	public HomeworkService() {
		// 初始化作业集合
		homeworks = new ArrayList<Homework>();
		dbUtil = new DBUtil();
	}

	/**
	 * 新增作业订单
	 * 
	 * @param order 待添加的作业订单对象
	 * @return 添加订单是否成功，成功返回true，否则返回false
	 */
	public boolean addHomework(Homework homework) {
		// 获取作业订单信息
		int user_id = homework.getUser_id();
		String submitTime = homework.getSubmitTime();// 作业提交时间
		String deadline = homework.getDeadline();// 作业截止时间
		String homeworkType = homework.getHomeworkType();// 作业类型
		List<String> homework_image = homework.getHomework_image();// 作业图片
		String allPhoto = "";
		Gson gson = new Gson();
		allPhoto = gson.toJson(homework_image);
		double money = homework.getMoney();
		String chatId = homework.getChatId();

		// 拼接插入订单的sql语句
		String sql = "insert into `homework`(user_id,submitTime, deadline ,homeworkType ,homework_image ,money,chatId) "
				+ "values('" + user_id + "','" + submitTime + "', '" + deadline + "','" + homeworkType + "'," + "'"
				+ allPhoto + "', '" + money + "','" + chatId + "')";

		System.out.println(sql);
		// 将订单的信息插入作业表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}

	/**
	 * 获取Homework信息
	 * 
	 * @param sql 查询订单的sql语句
	 * @return Homework集合
	 */
	public List<Homework> getHomeworks(String sql) {
		try {
			System.out.println("获取到的sql语句：" + sql);
			// 查询Homework
			ResultSet rs = dbUtil.queryDate(sql);
			while (rs.next()) {
				// 获取Homework表字段id的值
				int id = rs.getInt("id");
				// 获取Homework表字段user_id的值
				int user_id = rs.getInt("user_id");
				// 获取Homework表字段submitTime的值
				String submitTime = rs.getString("submitTime");
				// 获取Homework表字段deadline的值
				String deadline = rs.getString("deadline");
				// 获取Homework表字段homeworkType的值
				String homeworkType = rs.getString("homeworkType");
				// 获取Homework表字段tag的值
				String tag = rs.getString("tag");

				// 获取Homework表字段homework_image的值
				Gson gson = new Gson();
				List<String> homework_image = new ArrayList<>();
				homework_image = gson.fromJson(rs.getString("homework_image"), new TypeToken<ArrayList<String>>() {
				}.getType());

				// 获取Homework表字段teacher_id的值
				int teacher_id = rs.getInt("teacher_id");

				// 获取Homework表字段result_image的值
				Gson gsons = new Gson();
				List<String> result_image = new ArrayList<>();
				result_image = gsons.fromJson(rs.getString("result_image"), new TypeToken<ArrayList<String>>() {
				}.getType());

				// 获取Homework表字段result_image的值
				List<String> result_image_teacher = new ArrayList<>();
				result_image_teacher = gsons.fromJson(rs.getString("result_image_teacher"),
						new TypeToken<ArrayList<String>>() {
						}.getType());

				// 获取Homework表字段result_text的值
				String result_text = rs.getString("result_text");
				// 获取Homework表字段money的值
				double money = rs.getDouble("money");

				String scored = rs.getString("scored");

				// 获取Homework表字段grade的值
				int grade = rs.getInt("grade");
				String chatId = rs.getString("chatId");

				// 根据获取到的Homework信息构造Homework对象
				Homework homework = new Homework(id, user_id, submitTime, deadline, homeworkType, tag, homework_image,
						teacher_id, result_image, result_image_teacher, result_text, money, grade, scored, chatId);
				homeworks.add(homework);

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return homeworks;
	}

	/**
	 * 修改作业信息
	 * 
	 * @param order 待修改的作业对象
	 * @return 修改作业是否成功，成功返回true，否则返回false
	 */
	public boolean updateHomeworkInfo(Homework homework) {
		// 获取订单信息
		int id = homework.getId();
		int grade = homework.getGrade();
		String scored = homework.getScored();

		// 拼接更新蛋糕的sql语句

		String sql = "update homework set grade ='" + grade + "'," + "scored ='" + scored + "' where id ='" + id + "'";

		System.out.println("添加的sql" + sql);
		// 将订单的信息插入订单表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.updateData(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}

	public boolean updateHomeworkInfo(int tag, Homework homework) {
		if (tag == 1) {
			// 获取作业信息
			int id = homework.getId();
			List<String> result_images = homework.getResult_image();// 结果图片
			String result_image = "";
			Gson gson = new Gson();
			result_image = gson.toJson(result_images);

			// 拼接更新图片的sql语句

			String sql = "update homework set result_image ='" + result_image + "' where id ='" + id + "'";

			System.out.println("更新图片的sql" + sql);
			// 将订单的信息插入订单表中
			int n = -1;// 存储插入的记录数
			try {
				n = dbUtil.updateData(sql);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return n > 0 ? true : false;

		} else if (tag == 2) {
			// 获取作业信息
			int id = homework.getId();

			List<String> result_images = homework.getResult_image();// 结果图片
			String result_image = "";
			Gson gson = new Gson();
			result_image = gson.toJson(result_images);

			List<String> result_image_teachers = homework.getResult_image_teacher();// 老师结果图片
			String result_image_teacher = "";
			Gson gson1 = new Gson();
			result_image_teacher = gson1.toJson(result_image_teachers);

			// 老师评语
			String result_text = homework.getResult_text();

			// 拼接更新作业信息的sql语句
			String sql = "update homework set result_image ='" + result_image + "', result_image_teacher = '"
					+ result_image_teacher + "',result_text = '" + result_text + "',tag='批改完成'  where id ='" + id + "'";

			System.out.println("更新作业信息的sql语句" + sql);
			// 将订单的信息插入订单表中
			int n = -1;// 存储插入的记录数
			try {
				n = dbUtil.updateData(sql);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return n > 0 ? true : false;

		}
		return false;
	}

	public boolean updateHomeworkTag(int id, int teacher_id) {
		// 获取订单信息
		String tag = "批改中";
		// 拼接更新蛋糕的sql语句
		String sql = "update homework set teacher_id ='" + teacher_id + "'," + "tag ='" + tag + "' where id ='" + id
				+ "'";

		System.out.println("添加的sql" + sql);
		// 将订单的信息插入订单表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.updateData(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}

}
