package com.study.bigwork.forClient.teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.bigwork.entitys.Teacher;
import com.study.bigwork.services.TeacherService;
import com.study.bigwork.util.GetInfo;

import io.rong.models.response.TokenResult;

/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		//设置返回数据格式和编码
        response.setContentType("application/json;charset=utf-8");
        
        //定义StringBuffer变量
      	StringBuffer stringBuffer = new StringBuffer();
        //line保存读取请求信息的当前一行，responseMessage为响应信息，返回信息
        String line = null, responseMessage = null;
        
        //输出流
        PrintWriter out = response.getWriter();
        
        //读取信息时会发生IO异常
        try{
            //BufferedReader为缓冲读取流
            BufferedReader bufferedReader = request.getReader();
            while((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            System.out.println(stringBuffer);
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        //将json数据转为String
        Gson gson = new Gson();
        Teacher teacher =gson.fromJson(stringBuffer.toString(), Teacher.class);
        Teacher teacher2 = new Teacher();
        String sql;
        String phoneNumber = request.getParameter("phoneNumber");
        boolean b = false;
        boolean c = false;
        
        //调用TeacherService类中isExistUser方法访问数据库，并返回查询结果
        TeacherService teacherService = new TeacherService();
        //使用手机号码+密码登录
        if (phoneNumber == null) {
        	sql = "select * from teacher where pNumber = '" + teacher.getpNumber() + "' and password = '" + teacher.getPassword() + "'";
        	teacher2 = teacherService.getTeacher(sql);
		}else {//使用手机号码+验证码登录
			sql = "select * from teacher where pNumber = '" + phoneNumber + "'";
			b = teacherService.isExistTeacher(sql);
			if (b) {
				//已注册
				teacher2 = teacherService.getTeacher(sql);
			}else {
				//未注册
				Teacher teacher3 = new Teacher();
				GetInfo getInfo = new GetInfo();
				TokenResult tokenResult = getInfo.getToken("teacher");
				String chat_id = tokenResult.getUserId();
				String chat_token = tokenResult.getToken();
				sql = "insert into teacher(nickname,pNumber,chat_id,chat_token) values('" + phoneNumber + "','" + phoneNumber + "','" + chat_id + "','" + chat_token + "')";
				System.out.println("注册用户的时候，获取到的sql语句："+sql);
				c = teacherService.addTeacher(sql);
				if (c) {
					sql = "select * from teacher where pNumber = '" + phoneNumber + "'";
					teacher2 = teacherService.getTeacher(sql);
				}else {
					teacher2 = teacher3;
				}
			}
		}
        
        responseMessage = gson.toJson(teacher2);
        
        System.out.println("对象转为json " + responseMessage);
        //输出流将信息返回
        out.print(responseMessage);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
