package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.User;
import com.example.service.CheckUserService;


public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku = new CheckUserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("upwd");
		
		RequestDispatcher rd = null;
		String forward = null;
		if(uname == null || password == null){
			request.setAttribute("msg", "用户名或者密码为空");
			rd =request.getRequestDispatcher("/15/error.jsp");
			rd.forward(request, response);
		}else{
			
			User user = new User();
			user.setName(uname);
			user.setPassword(password);
			boolean bool = cku.check(user);
			if(bool){
				forward = "/15/success.jsp";
			}else{
				request.setAttribute("msg", "用户名或者密码输入错误，请重新输入");
				forward = "/15/error.jsp";
				System.out.println("用户没找到111"+uname+password);
			}
			rd =request.getRequestDispatcher(forward);
			rd.forward(request, response);
		}
	}

}
