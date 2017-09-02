<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP Project</title>
</head>
<body>
<h1>Choose a lector</h1>

<form method="POST">
	<input type="checkbox" name="lector" value="Phillipe Possemiers" > Phillipe Possemiers
	<input type="checkbox" name ="lector" value="Olga Coutrin"> Olga Coutrin
	<input type="checkbox" name="lector" value="Nicolas Goris"> Nicolas Goris
	<br>
	<input type="submit" value="Kies">
	
	<%
	String[] lectors = request.getParameterValues("lector");
	if(lectors != null){ %>
		
		<h2>U hebt de volgende lectoren geselecteerd</h2>
		<ul>
			<%
				for(String lector: lectors){
			%>
		<li> 
			<%= lector %>
		</li>
			<%}}%>
			
		</ul>
	
	
	
	
</form>
</body>
</html>