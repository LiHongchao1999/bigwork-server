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
 * Servlet implementation class UserLoginByQQServlet
 */
@WebServlet("/UserLoginByQQServlet")
public class UserLoginByQQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginByQQServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		// 设置返回数据格式和编码
		response.setContentType("application/json;charset=utf-8");

		// 定义StringBuffer变量
		StringBuffer stringBuffer = new StringBuffer();
		// line保存读取请求信息的当前一行，responseMessage为响应信息，返回信息
		String line = null, responseMessage = null;

		// 输出流
		PrintWriter out = response.getWriter();

		// 读取信息时会发生IO异常
		try {
			// BufferedReader为缓冲读取流
			BufferedReader bufferedReader = request.getReader();
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
			}
			System.out.println(stringBuffer);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 将json数据转为String
		Gson gson = new Gson();
		User user = new User();
		String sql = "";
		String nickName = request.getParameter("nickName");
		String sex = request.getParameter("sex");
		boolean b = false;
		boolean c = false;
		// 调用UserService类中isExistUser方法访问数据库，并返回查询结果
		UserService userService = new UserService();
		if (nickName!= null &&(sex!=null)) {

			sql = "select * from user where nickName = '" + nickName + "'";
			b = userService.isExistUser(sql);
			if (b) {
				// 已注册
				System.out.println("已注册");
				user = userService.getUser(sql);
			} else {
				System.out.println("未注册");
				// 未注册
				User user3 = new User();
				GetInfo getInfo = new GetInfo();
				TokenResult tokenResult = getInfo.getToken("user");
				String chat_id = tokenResult.getUserId();
				String chat_token = tokenResult.getToken();
				sql = "insert into user(nickname,sex,chat_id,chat_token) values('" + nickName + "','" + sex + "','"
						+ chat_id + "','" + chat_token + "')";
				System.out.println("注册用户的时候，获取到的sql语句：" + sql);
				c = userService.addUser(sql);
				if (c) {
					sql = "select * from user where nickName = '" + nickName + "'";
					user = userService.getUser(sql);
				} else {
					user = user3;
				}
			}
			responseMessage = gson.toJson(user);

			System.out.println("对象转为json " + responseMessage);
			// 输出流将信息返回
			out.print(responseMessage);

		}else {
			out.print("参数错误");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
