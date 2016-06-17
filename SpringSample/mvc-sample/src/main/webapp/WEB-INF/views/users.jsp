<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USERS</title>
</head>
<body>
<h1>Users List</h1>
<c:forEach items="${userList}" var="user" >
<li id="user_<c:out value="user.id"/>">
<div class="userMessage">
<c:out value="${user.name}" />
</div>
<div>
<span class="userTime"><c:out value="${user.birthdate}" /></span>
<span class="userProperties">
(<c:out value="${user.height}" />,
<c:out value="${user.weight}" />)</span>
</div>
</li>
</c:forEach>
</body>
</html>