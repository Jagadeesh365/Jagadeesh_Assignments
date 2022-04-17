<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login Form</h2>
<p><font color="red">${errorMessage}</font></p>
<form method="post" action="checkDetails">
	Enter User Name : <input type="text" name="userName"/>
	Enter Password : <input type="password" name="password"/>
	<input type="submit" value="Submit" />
</form>
</body>
</html>