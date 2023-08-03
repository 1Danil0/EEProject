package com.danilermolenko.javaee.project;

import java.io.*;
import java.util.Map;

import com.danilermolenko.javaee.project.myclasses.Cart;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        //String user = (String) session.getAttribute("current_user");
        //if(user == null){
            //response for new user. It may be even registration form
            //session.setAttribute("current_user", ID);
        //} else {
            //response for authorized user
       // }

        Cart cart = (Cart) session.getAttribute("cart");
        Integer count = (Integer) session.getAttribute("count");

        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if(count == null){
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", ++count);
        }
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart", cart);
            cart.addItems(name, quantity);
        } else {
            cart.addItems(name, quantity);
            session.setAttribute("cart", cart);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Your count = " + count);
        for(Map.Entry<String, Integer> item: cart.getCartMap().entrySet()){
            out.println(item.getKey() + ": " + item.getValue());
        }
        out.println("</body></html>");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("neview.jsp");
//        dispatcher.forward(request, response);

//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + "Hello my dear, " + name + " " + surname + "</h1>");
//        out.println("</body></html>");



////        response.sendRedirect("http://localhost:8080/javaEEProject/hello-servlet-jsp");
//        RequestDispatcher dispatcher = request
//                .getRequestDispatcher("/hello-servlet-jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void destroy() {

    }
}