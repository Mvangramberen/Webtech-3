<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- id should be identical to the name of the Java object
	 Java classes should always be located in a package ! -->
<jsp:useBean id="student" class="objects.Student" scope="session"/>
<jsp:setProperty property="*" name="student"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student results</title>
</head>
<body>

<p>Firstname = <%= student.getFirstName() %></p>
<p>Lastname = <%= student.getLastName() %></p>
<p>Grade ( from object ) = <%= student.getGrade() %></p>
<p>Grade ( from request) = <%= request.getParameter("grade")%>
</body>
</html>