package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.study.bigwork.entitys.Book;
import com.study.bigwork.entitys.User;
import com.study.bigwork.util.DBUtil;

import io.rong.RongCloud;
import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

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
	public boolean addUser(String sql) {
		// 拼接插入用户的sql语句
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
	 * 获取User信息
	 * @param sql 查询User的sql语句
	 * @return User集合
	 */
	public User getUser(String sql){
		User user = new User();
		try {
			//查询User
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取User表字段id的值
				int id = rs.getInt("id");
				//获取User表字段nickname的值
				String nickname = rs.getString("nickname");
				//获取User表字段phoneNumber的值
				String phoneNumber = rs.getString("phoneNumber");
				//获取User表字段password的值
				String password = rs.getString("password");
				//获取User表字段image的值
				String image = rs.getString("image");
				//获取User表字段stock的值
				String qqNumber = rs.getString("qqNumber");
				//获取User表字段weChatNumber的值
				String weChatNumber = rs.getString("weChatNumber");
				//获取User表字段grade的值
				String grade = rs.getString("grade");
				//获取User表字段sex的值
				String sex = rs.getString("sex");
				//获取User表字段chat_id的值
				String chat_id = rs.getString("chat_id");
				//获取User表字段chat_token的值
				String chat_token = rs.getString("chat_token");
				
				
				//根据获取到的User信息构造User对象
				User user2 = new User(id, nickname, phoneNumber, password, image, qqNumber, weChatNumber, grade, sex, chat_id, chat_token);
				user = user2;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	/**
	 * 获取User信息
	 * @param sql 查询User的sql语句
	 * @return User集合
	 */
	public User getChatUser(String sql){
		User user = new User();
		try {
			//查询User
			ResultSet rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				//获取User表字段nickname的值
				String nickname = rs.getString("nickname");
				//获取User表字段image的值
				String image = rs.getString("image");
				//获取User表字段chat_id的值
				String chat_id = rs.getString("chat_id");
				User user2 = new User();
				user2.setNickname(nickname);
				user2.setImage(image);
				user2.setChat_id(chat_id);
				user = user2;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
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
		
		String sql1 = "update circle set userImg ='" + image + "' where userId = '" + id + "' ";
	
		System.out.println("sql:"+sql);

		// 将用户的信息插入用户表中
		int n = -1;// 存储插入的记录数
		int q = -1;
		try {
			n = dbUtil.addDataToTable(sql);
			q = dbUtil.updateData(sql1);
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
	public boolean isExistUser(String sql) {
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
