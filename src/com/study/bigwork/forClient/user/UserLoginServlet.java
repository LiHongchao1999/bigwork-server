package com.study.bigwork.forClient.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.bigwork.entitys.User;
import com.study.bigwork.services.UserService;
import com.study.bigwork.util.GetInfo;

import io.rong.models.response.TokenResult;


/**
 * 用户登录
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
        User user =gson.fromJson(stringBuffer.toString(), User.class);
        User user2 = new User();
        String sql;
        String phoneNumber = request.getParameter("phoneNumber");
        boolean b = false;
        boolean c = false;
        
        //调用UserService类中isExistUser方法访问数据库，并返回查询结果
        UserService userService = new UserService();
        //使用手机号码+密码登录
        if (phoneNumber == null) {
        	sql = "select * from user where phoneNumber = '" + user.getPhoneNumber() + "' and password = '" + user.getPassword() + "'";
        	user2 = userService.getUser(sql);
		}else {//使用手机号码+验证码登录
			sql = "select * from user where phoneNumber = '" + phoneNumber + "'";
			b = userService.isExistUser(sql);
			if (b) {
				//已注册
				user2 = userService.getUser(sql);
			}else {
				//未注册
				User user3 = new User();
				GetInfo getInfo = new GetInfo();
				TokenResult tokenResult = getInfo.getToken("user");
				String chat_id = tokenResult.getUserId();
				String chat_token = tokenResult.getToken();
				sql = "insert into user(nickname,phoneNumber,chat_id,chat_token) values('" + phoneNumber + "','" + phoneNumber + "','" + chat_id + "','" + chat_token + "')";
				System.out.println("注册用户的时候，获取到的sql语句："+sql);
				c = userService.addUser(sql);
				if (c) {
					sql = "select * from user where phoneNumber = '" + phoneNumber + "'";
					user2 = userService.getUser(sql);
				}else {
					user2 = user3;
				}
			}
		}
        
        responseMessage = gson.toJson(user2);
        
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
