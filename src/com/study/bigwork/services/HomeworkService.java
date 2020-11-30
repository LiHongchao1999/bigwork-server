package com.study.bigwork.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.bigwork.entitys.Homework;
import com.study.bigwork.util.DBUtil;

public class HomeworkService {
	private DBUtil dbUtil;
	private List<Homework> homeworks;
	public HomeworkService() {
		homeworks=new ArrayList<Homework>();
		dbUtil= new DBUtil();
	}
	/**
	 * 获取Homework信息
	 * @param attr //根据属性名获取Homework
	 * @param value
	 * @return Homework的列表
	 */
	public List<Homework> getHomework(String attr,String value) {
		ResultSet rs;
		Homework homework = null;
		
		String sql="select * from homework where "+attr+" = '"+value+"'";
		try {                                                                                                                                                                                                           
			rs = dbUtil.queryDate(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String submitTime=rs.getString("submittime");
				String expirationTime=rs.getString("expirationTime");
				String subject=rs.getString("subject");
				String homeworkImg=rs.getString("homeworkimg");
				int state=rs.getInt("state");
				int teacherId=rs.getInt("teacherId");
				String userName=rs.getString("username");
				int price=rs.getInt("price");
				homework=new Homework(id,submitTime,expirationTime,userName,subject,homeworkImg,state,teacherId,price);
				homeworks.add(homework);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return homeworks;
	}
	public boolean addHomework(Homework homework) {
		int a=0;
		String sql="insert into homework(id,submitTime,expirationTime,userName,subject,homeworkImg,state,teacherId,price)"
				+ " values(' "+homework.getId()+"',"
								+homework.getSubmitTime()+"',"
										+homework.getExpirationTime()+"',"
												+homework.getUserName()+"',"
														+homework.getSubject()+"',"
																+homework.getHomeworkImg()+"',"
																		+homework.getState()+"',"
																				+homework.getTeacherId()+"',"
																						+homework.getPrice()+"')";
		try {
			a=dbUtil.addDataToTable(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==0) {
			System.out.println("插入失败");
			return false;
		}else {
			System.out.println("插入成功");
			return true;
		}
	}
	public boolean deleteHomework(String attr,String value) {
		int a=-1;
		boolean exist=false;
		String select="select * from homework where "+attr+"='"+value+"'";
		String delete="delete from cake  where "+attr+"='"+value+"'";
		try {
			exist=dbUtil.isExist(select);
			if(exist) {
				a=dbUtil.updateData(delete);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean updateHomework(String attr,String value,Homework homework) {
		int a=-1;
		boolean exist=false;
		String select="select * from homework where "+attr+"='"+value+"'";
		String sql="insert into homework(id,submitTime,expirationTime,userName,subject,homeworkImg,state,teacherId,price)"
				+ " values(' "+homework.getId()+"',"
								+homework.getSubmitTime()+"',"
										+homework.getExpirationTime()+"',"
												+homework.getUserName()+"',"
														+homework.getSubject()+"',"
																+homework.getHomeworkImg()+"',"
																		+homework.getState()+"',"
																				+homework.getTeacherId()+"',"
																						+homework.getPrice()+"')";
		String sql="update cake set name='"+name+"',price='"+price+"',size='"+size+"',detail='"+detail+"'where name='"+name+"'";
		try {
			exist=dbUtil.isExist(select);
			if(exist) {
				a=dbUtil.updateData(sql);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a>0) {
			return true;
		}else {
			return false;
		}
	
	}
}
