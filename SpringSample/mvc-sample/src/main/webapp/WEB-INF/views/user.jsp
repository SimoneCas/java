<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER</title>
</head>
<body>
<h1>New User</h1>
<c:set value="${user}" var="user" />
<li id="user_<c:out value="user.id"/>">
<div class="userMessage">
<c:out value="${user.name}" /><br/>
<c:out value="${user.surname}" />
</div>

</li>
</body>
</html>