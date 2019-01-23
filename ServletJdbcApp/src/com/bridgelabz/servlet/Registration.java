package com.bridgelabz.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dbutil.MySQLConnUtilsRegistration;
import com.bridgelabz.model.RegistrationForm;

public class Registration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setFirstName(req.getParameter("First_Name"));
		registrationForm.setLastName(req.getParameter("Last_Name"));
		registrationForm.setEmailId(req.getParameter("Email_Id"));
		registrationForm.setPassword(req.getParameter("PASSWORD"));
		registrationForm.setMobNo(req.getParameter("Mobile_Number"));
		System.out.println("Success");

		try {
			MySQLConnUtilsRegistration.registration(registrationForm);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
