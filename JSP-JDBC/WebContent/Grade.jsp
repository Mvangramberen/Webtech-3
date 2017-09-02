<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student grades</title>
</head>
<body>

<form method="POST" action="Result.jsp" >

<!-- The "name" field should identical to the attribute of the Java object ! ( Capital sensitive)  -->
Firstname : <input type="text" name="firstName" size=20><br>
Lastname : <input type="text" name="lastName" size=20><br>
Grade : <input type="text" name="grade" size=20><br>

<input type="submit" value="Save">

</form>

<a href="List.jsp">students list</a>

</body>
</html>