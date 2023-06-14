package com.rokesh.studentissued;

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

@WebServlet("/StudentIssued")
public class StudentIssued extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Rokesh@17");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT issuedBook.AccNo , issuedBook.Issue_date ,issuedBook.person_id, bookDetails.Title, bookDetails.Author, bookDetails.Publisher , bookDetails.Edition FROM issuedBook INNER  JOIN bookDetails ON issuedBook.AccNo=bookDetails.AccNo;");
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
					+ "            <input type=\"text\" class=\"searchbar\" placeholder=\"Search here ...\" name=\"search\" onkeyup=\"CheckHistory()\">\r\n"
					+ "        </div>\r\n"
					+ "    </div>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>AccessionNo</th>");
			out.println("<th>Issued Date No</th>");
			out.println("<th>ID</th>");
			out.println("<th>Title</th>");
			out.println("<th>Author</th>");
			out.println("<th>Publisher</th>");
			out.println("<th>Edition</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td class=\"AccNo\">"+rs.getString("AccNo")+"</td>");
				out.println("<td class=\"Date\">"+rs.getString("Issue_date")+"</td>");
				out.println("<td class=\"ID\">"+rs.getString("person_id")+"</td>");
				out.println("<td class=\"Title\">"+rs.getString("Title")+"</td>");
				out.println("<td class=\"Author\">"+rs.getString("Author")+"</td>");
				out.println("<td class=\"Publisher\">"+rs.getString("Publisher")+"</td>");
				out.println("<td class=\"Edition\">"+rs.getString("Edition")+"</td>");

				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("<script src=\"Issue.js\"></script>");
			out.println("</html>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
