package com.study.bigwork.services;

import java.sql.SQLException;

import com.study.bigwork.entitys.User;
import com.study.bigwork.util.DBUtil;

public class UserService {

	private DBUtil dbUtil;

	public UserService() {
		
		dbUtil = new DBUtil();
	}

	/**
	 * 添加用户
	 * 
	 * @param user 待添加的用户对象
	 * @return 添加用户是否成功，成功返回true，否则返回false
	 */
	public boolean addUser(User user) {
		// 获取用户信息

		String phoneNumber = user.getPhoneNumber();
		String password = user.getPassword();

		// 拼接插入用户的sql语句
		String sql = "insert into user(phoneNumber, password) values('" + phoneNumber + "', '" + password + "')";
		// 将图书的信息插入图书表中
		int n = -1;// 存储插入的记录数
		try {
			n = dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return n > 0 ? true : false;
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
		String sql = "insert into user(nickname,phoneNumber,password,image,grade,sex) values('" + nickname + "', '" + phoneNumber + "','" + password + "',"
				+ "'" + image + "','" + grade + "','" + sex + "',)";

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
	 * 判断用户是否存在
	 * 
	 * @param user 待判断的用户
	 * @return 存在则返回true，否则返回false
	 */
	public boolean isExistUser(User user) {
		// 获取待判断的用户信息
		String phoneNumber = user.getPhoneNumber();
		String password = user.getPassword();

		// 根据用户信息拼接sql语句
		String sql = "select * from user where phoneNumber = '" + phoneNumber + "' and password = '" + password + "'";
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
