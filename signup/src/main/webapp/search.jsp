<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.Statement, java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException, java.util.ArrayList, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Declare necessary variables
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    String searchTerm = request.getParameter("searchTerm");

    try {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Establish a connection to the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Rokesh@17");

        // Create a statement object to execute SQL queries
        st = conn.createStatement();

        // Execute the SQL query and retrieve the results
        String qry = "SELECT * FROM student";
        if (searchTerm != null && !searchTerm.isEmpty()) {
            qry += " WHERE NAME LIKE '%" + searchTerm + "%'";
        }
        rs = st.executeQuery(qry);

        // Store search results in a List of String arrays
        List<String[]> searchResults = new ArrayList<>();
        while (rs.next()) {
            String[] row = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
            };
            searchResults.add(row);
        }

        // Generate HTML markup for search results
        StringBuilder html = new StringBuilder();
        html.append("<table>");
        html.append("<tr><th>ROLL NO</th><th>NAME</th><th>E-Mail</th><th>PASSWORD</th></tr>");

        for (String[] row : searchResults) {
            html.append("<tr>");
            for (String cell : row) {
                html.append("<td>").append(cell).append("</td>");
            }
            html.append("</tr>");
        }

        html.append("</table>");
        out.println(html.toString());
    } catch (ClassNotFoundException ex) {
        out.println("Error: MySQL JDBC driver not found.");
    } catch (SQLException ex) {
        out.println("Error: " + ex.getMessage());
    } finally {
        // Close all database resources
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                // Handle exception
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                // Handle exception
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                // Handle exception
            }
        }
    }
%>
