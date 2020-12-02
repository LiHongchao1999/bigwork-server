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
 * Servlet implementation class GetHomeworkListServlet
 */
@WebServlet("/GetHomeworkListServlet")
public class GetHomeworkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Homework> homeworks;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHomeworkListServlet() {
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
        String responseMessage = null;
      
        //输出流
        PrintWriter out = response.getWriter();
        
        
        //调用MenuService类中getUsers方法访问数据库，并返回查询结果
        HomeworkService homeworkService = new HomeworkService();
        
        homeworks = homeworkService.getHomeworks("select * from `homework`");
        System.out.println("666"+Arrays.asList(homeworks));
        Gson gson = new Gson();
        responseMessage = gson.toJson(homeworks);
        
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
