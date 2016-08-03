<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<h3>Add a new user:</h3>
	<form action="${pageContext.request.contextPath}/create" method="post">
		<p>
			Username: <input type="text" name="username" required />
		</p>
		<p>
			Password: <input type="password" name="password" required />
		</p>
		<p>
			Email: <input type="text" name="email" />
		</p>

		<button type="submit" name="addUser">Save</button>
	</form>
	<br>
	<br> Back:
	<button type="button" onclick="window.location='/jsp-user';">Home</button>

</body>
</html>