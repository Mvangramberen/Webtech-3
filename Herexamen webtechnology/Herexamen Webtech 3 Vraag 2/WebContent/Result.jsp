<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.restlet.resource.ClientResource"%>	
<%@page import="producten.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultaat</title>
</head>

<% 
	String searchProduct = request.getParameter("searchProduct");
	
	
	
	ClientResource resource = new ClientResource("http://localhost:8080/Herexamen_Webtech_3_Vraag_2/producten/" + searchProduct);
	String result = resource.get().getText();
%>
<body>
<%= result %>
</body>
</html>