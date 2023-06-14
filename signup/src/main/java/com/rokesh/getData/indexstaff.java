package com.rokesh.getData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexstaff
 */
@WebServlet("/indexstaff")
public class indexstaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Rokesh@17");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from staff");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<LINK REL=\"StyleSheet\" HREF=\"DashboardStyle.css\" TYPE=\"text/css\"> ");
			out.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">\r\n"
					+ "        <div class=\"search-bar\">\r\n"
					+ "            <input type=\"text\" class=\"searchbar\" placeholder=\"Search here ...\" name=\"search\" onkeyup=\"Check()\">\r\n"
					+ "        </div>\r\n"
					+ "    </div>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Username</th>");
			out.println("<th>staffid</th>");
			out.println("<th>email</th>");
			out.println("<th>password</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td class=\"uname\">"+rs.getString("uname")+"</td>");
				out.println("<td class=\"staffid\">"+rs.getString("staffid")+"</td>");
				out.println("<td class=\"email\">"+rs.getString("email")+"</td>");
				out.println("<td class=\"pswd\">"+rs.getString("Pswd")+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("<script src=\"indexstaff.js\"></script>");
			out.println("</html>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}