<%@ page import="java.util.Date" %>
<%@ page import="com.danilermolenko.javaee.project.myclasses.MyClass" %>
<!DOCTYPE html>

<html>

<body>

<h1> Testing jsp </h1>
<% Date date = new Date();
String str = "Current date and time " + date;%>

<%= str %>
<br>
<br>

<%
    StringBuilder stringBuilder = new StringBuilder("");
    for(int i = 0; i < 100; i++){
    stringBuilder.append("\nHello " + i + "\n");

}%>
<%= stringBuilder %>
<br>
<br>

<% MyClass<String> myClass1 = new MyClass<>("Hello Danil!");
MyClass<Integer> myClass2 = new MyClass<>(14); %>

<%= myClass1.getField() %>
<br>
<br>
<%= myClass2.getField() %>
<br>
<br>
<% String name = request.getParameter("name");
String surname = request.getParameter("surname");%>
<%= "Hello " + name + " " + surname%>
</body>

</html>
