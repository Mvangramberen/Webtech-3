<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- It's mandatory to import the JdbcConnection class ( made by yourself ) 
	 and the Arraylist for further usage -->
<%@ page import="jdbc.JdbcConnection" %>
<%@ page import ="java.util.ArrayList" %>


<!-- id should be identical to the name of the Java object
	 Java classes should always be located in a package ! -->
<jsp:useBean id="student" class="objects.Student" scope="session"/>
<jsp:setProperty property="*" name="student"/>




<%
/*
Don't forget to move your "mysql-connector-java-6.0.6-bin.jar" file to the WEB-INF -> lib directory !!!
otherwise you will get the "class not found exception" for the "com.mysql.cj.jdbc.Driver" !!!
*/


JdbcConnection connection = null;
ArrayList<String> students = null;

try{
	String firstname = student.getFirstName();
	String lastname = student.getLastName();
	int grade = student.getGrade();
	
	connection = JdbcConnection.getJdbcConnection();
	connection.openConnection("students", "root", "root");
	String insertQuery = "INSERT INTO students(firstname, lastname, grade) VALUES('" + firstname +"','" + lastname + "', '" + grade + "')";
	String selectAllQuery ="SELECT firstname, lastname, grade FROM students";

	connection.executeInsert(insertQuery);
	students = connection.selectAll(selectAllQuery);

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student results</title>
</head>
<body>

<h1>Grades</h1>

<table>
<tr>
	<th>Firstname</th>
	<th>Lastname</th>
	<th>grades</th>
</tr>
<%
		for(String row : students){
			String[] colums = row.split(";");
			out.println("<tr><td>" + colums[0] + "</td><td>" + colums[1] + "</td><td>" + colums[2] + "</td></tr>" );	
		}
	}
	catch(Exception e){
		System.out.println(e);
	}

	finally{
		connection.closeConnection();
	}
%>


</table>
</body>
</html>