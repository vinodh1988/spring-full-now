<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Spring boot is running</h1>
<h3>Names</h3>
<hr/>
<ul>
<%
 String[] names= (String[])request.getAttribute("names");
 for(String name:names){
%>
<li><%out.println(name); %></li>
<% } %>
<hr/>
<h3>States</h3>

Applicaton state: <%=request.getAttribute("avalue") %>
Session state: <%=request.getAttribute("svalue") %>

</body>
</html>