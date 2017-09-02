<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Import everything that has been generated in the webservice package  -->
<%@page import="webservice.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result string</title>
</head>
<body>
<%

// The proxy for the Upper class has been auto generated. 
UpperProxy proxy = new UpperProxy();
String inputString = request.getParameter("inputString");
String outputString = "";

try{
	// The proxy is the Single point of access. The methods of the Upper.java file has been inherited.
	outputString = proxy.toUpper(inputString);
}
catch(Exception e)
{
	System.out.println(e);
}


%>

<h1><%= outputString %></h1>
</body>
</html>