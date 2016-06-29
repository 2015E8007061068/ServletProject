package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8836600316523334639L;

//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String userName = arg0.getParameter("uname");
//		String password = arg0.getParameter("upwd");
//		
//		System.out.println("用户名 ==》"+userName);
//		System.out.println("密码 ==》"+password);
//		
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("====进入doGet方法=======");
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("====进入doPost方法=======");
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");
		
		System.out.println("用户名 ==》"+userName);
		System.out.println("密码 ==》"+password);
		
		String forward = null;
		if((userName.equals("xudong"))&&(password.equals("123456"))){
			//请求转发
			forward = "/14/success.jsp";
			//请求转发不能转发给其他应用的地址，重定向可以
//			forward = "https://www.baidu.com/";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
			
			
//			//页面的重定向 不能传递login的参数
//			resp.sendRedirect(req.getContextPath()+"/14/success.jsp");
		}else{
			forward ="/14/error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
			
//			resp.sendRedirect(req.getContextPath()+"/14/error.jsp");
		}
		
	}
	

}
