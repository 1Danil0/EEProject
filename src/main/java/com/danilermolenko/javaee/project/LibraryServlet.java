package com.danilermolenko.javaee.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "libraryServlet", value = "/libraryServlet")
public class LibraryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/my_db?useSSL=false&amp&serverTimezone=UTC",
                            "bestuser", "bestuser");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from books");
            while (resultSet.next()){
                writer.println(resultSet.getString("name"));
            }
            statement.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());;
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
