package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.study.bigwork.entitys.Teacher;
import com.study.bigwork.entitys.User;
import com.study.bigwork.util.DBUtil;

public class TeacherService {

	private DBUtil dbUtil;

	public TeacherService() {
		
		dbUtil = new DBUtil();
	}

	/**
	 * 添加教师
	 * 
	 * @param user 待添加的教师对象
	 * @return 添加教师是否成功，成功返回true，否则返回false
	 */
	public boolean addTeacher(String sql) {
		// 拼接插入教师的sql语句
		// 将教师的信息插入教师表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}
	
	
	
	/**
	 * 获取Teacher信息
	 * @param sql 查询Teacher的sql语句
	 * @return User集合
	 */
	public Teacher getTeacher(String sql){
		Teacher teacher = new Teacher();
		try {
			//查询Teacher
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Teacher表字段teacherId的值
				int teacherId = rs.getInt("teacherId");
				//获取Teacher表字段nickname的值
				String nickname = rs.getString("nickname");
				//获取Teacher表字段image的值
				String image = rs.getString("image");
				//获取Teacher表字段pNumber的值
				String pNumber = rs.getString("pNumber");
				//获取Teacher表字段password的值
				String password = rs.getString("password");
				//获取Teacher表字段fSchool的值
				String fSchool = rs.getString("fSchool");
				//获取Teacher表字段rank的值
				int rank = rs.getInt("rank");
				//获取Teacher表字段qqNumber的值
				String qqNumber = rs.getString("qqNumber");
				//获取Teacher表字段weNumber的值
				String weNumber = rs.getString("weNumber");
				//获取Teacher表字段chat_id的值
				String chat_id = rs.getString("chat_id");
				//获取Teacher表字段chat_token的值
				String chat_token = rs.getString("chat_token");
				
				
				//根据获取到的Teacher信息构造Teacher对象
				Teacher teacher2 = new Teacher(teacherId, nickname, image, pNumber, password, fSchool, rank, qqNumber, weNumber, chat_id, chat_token);
				teacher = teacher2;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	
	/**
	 * 获取User信息
	 * @param sql 查询User的sql语句
	 * @return User集合
	 */
	public Teacher getChatTeacher(String sql){
		Teacher teacher = new Teacher();
		try {
			//查询Teacher
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取Teacher表字段nickname的值
				String nickname = rs.getString("nickname");
				//获取Teacher表字段image的值
				String image = rs.getString("image");
				//获取Teacher表字段chat_id的值
				String chat_id = rs.getString("chat_id");
				Teacher teacher2 = new Teacher();
				teacher2.setNickname(nickname);
				teacher2.setImage(image);
				teacher2.setChat_id(chat_id);
				teacher = teacher2;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	
	

	/**
	 * 修改用户信息
	 * 
	 * @param
	 * @return 修改用户资料是否成功，成功返回true，否则返回false
	 */
	public boolean updateUserInfo(User user) {
		// 获取用户信息
		int id = user.getId();
		String nickname = user.getNickname();// 用户昵称
		String phoneNumber = user.getPhoneNumber();// 手机号码
		String password = user.getPassword();// 密码
		String image = user.getImage();// 头像
		String qqNumber = user.getQqNumber();// QQ号码
		String weChatNumber = user.getWeChatNumber();// 微信号码
		String grade = user.getGrade();// 年级
		String sex = user.getSex();// 性别

		// 拼接插入用户的sql语句		
		String sql = "update user set nickname ='" + nickname + "', phoneNumber ='" + phoneNumber + "',"
				+ "password ='" + password + "',image ='" + image + "',sex ='" + sex + "' "
						+ "where id = '" + id + "' ";
	
		System.out.println("sql:"+sql);

		// 将用户的信息插入用户表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
	}

	/**
	 * 判断Teacher是否存在
	 * 
	 * @param user 待判断的Teacher
	 * @return 存在则返回true，否则返回false
	 */
	public boolean isExistTeacher(String sql) {
		System.out.println(sql);
		boolean b = false;
		try {
			b = dbUtil.isExist(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
}
