<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IL CONTROLLER HA FUNZIONATO</title>
</head>
<body>
<h1>Welcome User</h1>
<a href="<c:url value="/users" />">Users</a> |
<a href="<c:url value="/users/Claudio" />">User by Name</a> |
<a href="<c:url value="/users/register" />">Register</a>

</body>
</html>