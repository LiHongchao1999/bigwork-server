package com.study.bigwork.forClient.circle;

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
import com.study.bigwork.entitys.Circle;
import com.study.bigwork.services.CircleService;

/**
 * Servlet implementation class GetCircleListServlet
 */
@WebServlet("/GetCircleListServlet")
public class GetCircleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Circle> circles;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCircleListServlet() {
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
        String homeworkType = "";
        String homeworkTypes = "";
        String tag = "";
        String tags = "";
        String sql = "select * from `circle` order by id DESC";
        
        
        //调用HomeworkService类中getHomeworks方法访问数据库，并返回查询结果
        CircleService circleService = new CircleService();
        circles = circleService.getCircles(sql);
        System.out.println("666"+Arrays.asList(circles));
        Gson gson = new Gson();
        responseMessage = gson.toJson(circles);
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
