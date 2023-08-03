package com.danilermolenko.javaee.project;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hello my dear, " + name + " " + surname + "</h1>");
        out.println("</body></html>");
        

//        response.sendRedirect("http://localhost:8080/javaEEProject/hello-servlet-jsp");
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/hello-servlet-jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {

    }
}