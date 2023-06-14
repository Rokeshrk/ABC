package com.rokesh.forgotpassword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForgotPasswordStaff")
public class ForgotPasswordStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		System.out.println("Call Successfully... "+ email);
		RequestDispatcher rd;
		request.setAttribute("email",email);
		rd = request.getRequestDispatcher("confirmpwdstaff.jsp");
		rd.forward(request,response);
	}

}