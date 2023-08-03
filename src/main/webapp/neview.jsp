<%@ page import="java.util.Map" %>
<%@ page import="com.danilermolenko.javaee.project.myclasses.Cart" %><%--
  Created by IntelliJ IDEA.
  User: zer0c
  Date: 03.08.2023
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% Cart cart = (Cart) session.getAttribute("cart");
String str = "";
    for(Map.Entry<String, Integer> item: cart.getCartMap().entrySet()){
        str += item.getKey() + ": " + item.getValue() + ", ";
    }
%>
<%= str %>

</body>
</html>
