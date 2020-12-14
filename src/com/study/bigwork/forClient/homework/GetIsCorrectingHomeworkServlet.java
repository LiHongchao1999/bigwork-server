package com.study.bigwork.forClient.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.study.bigwork.entitys.Homework;
import com.study.bigwork.services.HomeworkService;

/**
 * Servlet implementation class GetIsCorrectingHomeworkServlet
 */
@WebServlet("/GetIsCorrectingHomeworkServlet")
public class GetIsCorrectingHomeworkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Homework> homeworks;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetIsCorrectingHomeworkServlet() {
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
		String responseMessage = null;

		// 输出流
		PrintWriter out = response.getWriter();
		int teacherId;
		String tag = "";
		String sql = "";
		teacherId = Integer.parseInt(request.getParameter("teacherId"));
		tag = request.getParameter("tag");

		// 调用HomeworkService类中getHomeworks方法访问数据库，并返回查询结果
		HomeworkService homeworkService = new HomeworkService();

		if ("waitCorrect".equals(tag)) {
			tag = "待批改";
		} else if ("isCorrecting".equals(tag)) {
			tag = "批改中";
		} else if ("hasCorrected".equals(tag)) {
			tag = "批改完成";
		}

		sql = "select * from `homework` where teacher_id = '" + teacherId + "' and tag ='" + tag + "'";
		System.out.println("sql语句为：" + sql);

		homeworks = homeworkService.getHomeworks(sql);
		System.out.println("666" + Arrays.asList(homeworks));
		Gson gson = new Gson();
		responseMessage = gson.toJson(homeworks);

		System.out.println("对象转为json " + responseMessage);
		// 输出流将信息返回
		out.print(responseMessage);

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
