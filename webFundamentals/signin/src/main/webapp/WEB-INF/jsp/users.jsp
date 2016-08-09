<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Users</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<h3>All Users</h3>
	<div class="table">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Username</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.userList}" var="user">
					<tr>
						<td><c:out value="${user.getUsername() }"></c:out></td>
						<td><c:out value="${user.getPassword() }"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>