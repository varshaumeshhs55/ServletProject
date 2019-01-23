package com.bridgelabz.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {

 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RegistrationForm registrationForm=new RegistrationForm();
	registrationForm.setFirstName(req.getParameter("First_Name"));
	registrationForm.setLastName(req.getParameter("Last_Name"));
	registrationForm.setEmailId(req.getParameter("Email_Id"));
	registrationForm.setPassword(req.getParameter("Password"));
	registrationForm.setMobNo(req.getParameter("Mobile_Number"));
	System.out.println("Success");

}
}
