<%@page import="org.restlet.resource.ClientResource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="edu.ap.rest.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resultaat</title>
</head>

<% 
	String searchTerm = request.getParameter("searchTerm");
	System.out.println("Test: " + searchTerm);
	
	
	
	ClientResource resource = new ClientResource("http://localhost:8080/ExamenVraag2/quotes/" + searchTerm);
	String result = resource.get().getText();
%>
<body>
<%= result %>
</body>
</html>