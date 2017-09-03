<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="BLL.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>students</title>
</head>
<body>

<%
DataAccessProxy proxy = new DataAccessProxy();
String[] aResult = proxy.getAllStudents();

%>


<h1>Students</h1>
<table>
<tr>
	<th>Firstname</th>
	<th>Lastname</th>
	<th>Grade</th>
</tr>

<% for (String row : aResult){
	String[] columns = row.split(";");
%>

<tr>
	<td><%= columns[0] %></td>	
	<td><%= columns[1] %></td>
	<td><%= columns[2] %></td>
</tr>	
	
<%} %>
</table>	
</body>
</html>