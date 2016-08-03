<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<h3>Users:</h3>
	<form action="${pageContext.request.contextPath}/view" method="post">
		<table>
			<c:forEach items="${requestScope.usersList}" var="user">
				<tr>
					<td>Id: <c:out value="${user.id}"></c:out></td>
					<td>Username: <c:out value="${user.username}"></c:out></td>
					<td>Email: <c:out value="${user.email}"></c:out></td>
					<td><a href="update?id=${user.id}">Update</a></td>
					<td><a href="delete?id=${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

	<br>Back:
	<button type="button" onclick="window.location='/jsp-user';">Home</button>
</body>
</html>