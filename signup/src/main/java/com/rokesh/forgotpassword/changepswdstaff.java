package com.rokesh.forgotpassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/changepswdstaff")
public class changepswdstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pswd = request.getParameter("pwd");
		String email=request.getParameter("email");
		
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false","root","Rokesh@17"); 
			PreparedStatement pst = con.prepareStatement("update staff set pswd=? where email=?");
			pst.setString(1, pswd);
			pst.setString(2, email);
			
			int i = pst.executeUpdate();
			System.out.println(i+" "+pswd+" "+email);
			if(i==1) {
				dispatcher = request.getRequestDispatcher("Stafflogin.jsp");
			}
			else {
				request.setAttribute("status", "Invalid mail ID");
				dispatcher = request.getRequestDispatcher("forgotStaff.jsp");
			}
			dispatcher.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}