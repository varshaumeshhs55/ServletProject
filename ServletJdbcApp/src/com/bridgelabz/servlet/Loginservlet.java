package com.bridgelabz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dbutil.MySQLConnUtilsRegistration;
import com.bridgelabz.model.UserInfo;

public class Loginservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserInfo userinfo=new UserInfo();
//		resp.setContentType("text/html");  
//		 PrintWriter out = resp.getWriter();  
//		userinfo.setName(req.getParameter("name"));
//		userinfo.setMobNO(req.getParameter("number"));
		userinfo.setUserName(req.getParameter("username"));
		userinfo.setPassword(req.getParameter("password"));
//		if(userinfo.getPassword().equals("abc"))
//		{
//			RequestDispatcher rd=req.getRequestDispatcher("/logout.html");
//			rd.forward(req, resp);
//		}else
//		{
////			 out.print("Sorry UserName or Password Error!");  
//			RequestDispatcher rd=req.getRequestDispatcher("/registrationpage.html");
//			rd.include(req, resp);
//		}
	
//		System.out.println(userinfo.getName());;
//		System.out.println(userinfo.getMobNO());
//		System.out.println(userinfo.getUserName());
//		System.out.println(userinfo.getPassword());
try {
	boolean b=MySQLConnUtilsRegistration.loginservlet(userinfo);
	if(b) {
		RequestDispatcher rd=req.getRequestDispatcher("/logout.html");
		rd.forward(req, resp);
	}
	else {
		RequestDispatcher rd=req.getRequestDispatcher("/loginpage.html");
		rd.include(req, resp);
	}
	
} catch (ClassNotFoundException | SQLException e) {
	
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}
	
	}

