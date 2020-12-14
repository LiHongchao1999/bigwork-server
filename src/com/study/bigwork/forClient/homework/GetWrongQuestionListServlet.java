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
import com.study.bigwork.entitys.WrongQuestion;
import com.study.bigwork.services.WrongQuestionService;

/**
 * Servlet implementation class GetWrongQuestionListServlet
 */
@WebServlet("/GetWrongQuestionListServlet")
public class GetWrongQuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<WrongQuestion> wrongQuestions;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWrongQuestionListServlet() {
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
        String questionType = "";
        String questionTypes = "";
        String user_id = "";
        String tags = "";
        String sql = "";
        questionType = request.getParameter("questionType");
        user_id = request.getParameter("user_id");
        if ("math".equals(questionType)) {
        	questionType = "数学";
		}else {
			questionType = "英语";
		}
        
        //调用WrongQuestionService类中getWrongQuestions方法访问数据库，并返回查询结果
        WrongQuestionService wrongQuestionService = new WrongQuestionService();
        if (questionType == null || user_id == null) {
        	sql = "select * from `wrongquestion` where question_Type = '"+questionType+"' order by id DESC";
		}
        else {
        	sql = "select * from `wrongquestion` where question_Type = '"+questionType+"' order by id DESC ";
		}
        wrongQuestions = wrongQuestionService.getWrongQuestions(sql);
        System.out.println("666"+Arrays.asList(wrongQuestions));
        Gson gson = new Gson();
        responseMessage = gson.toJson(wrongQuestions);
        
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
