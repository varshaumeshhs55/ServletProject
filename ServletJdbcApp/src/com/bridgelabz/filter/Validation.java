package com.bridgelabz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation implements Filter {
	final String REGEX_EMAIL_ID = "^[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
	final String REGEX_CONTACT = "^[0-9]{10}$";

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chainObj)
			throws IOException, ServletException {
		RequestDispatcher requestDispatcher = null;
		HttpServletResponse response = (HttpServletResponse) res;
		PrintWriter out = response.getWriter();
		HttpServletRequest request = (HttpServletRequest) req;
		String emailid = request.getParameter("Email_Id");
		String number = request.getParameter("Mobile_Number");
		if (emailid.matches(REGEX_EMAIL_ID) && (number.matches(REGEX_CONTACT))) {
			chainObj.doFilter(request, response);
		} else {
			out.write("<p><center><b>Please enter the valid details...!!!</b></center></p>");
			requestDispatcher = request.getRequestDispatcher("/registrationpage.html");
			requestDispatcher.include(request, response);
		}
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
