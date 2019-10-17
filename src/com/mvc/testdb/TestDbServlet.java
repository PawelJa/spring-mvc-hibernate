package com.mvc.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // setup connection variables
        String user = "root";
        String pass = "pass";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&useTimezone=true&serverTimezone=UTC";
        String driver = "com.mysql.cj.jdbc.Driver";

        // get connection
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to db: " + jdbcUrl);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            out.println("Success !!!");

            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
