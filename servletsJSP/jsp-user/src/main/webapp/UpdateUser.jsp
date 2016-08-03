<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User</title>
</head>
<body>

	<h3>Update user:</h3>
	<c:set var="userVar" scope="session" value="${requestScope.user}" />

	<form action="${pageContext.request.contextPath}/update" method="post">
		<p>
			Username: <input type="text" name="userName" value="${userVar.username}">
		</p>
		<p>
			Password: <input type="text" name="userPass" value="${userVar.password}">
		</p>
		<p>
			Email: <input type="text" name="userEmail" value="${userVar.email}">
		</p>
		<input type="hidden" name="userId" value="${userVar.id}">
		<input type="submit" value="Update user">
	</form>
	
	<br>
	<br> Back to home:
	<button type="button" onclick="window.location='/jsp-user';">Home</button>

</body>
</html>