<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Login</title>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="/SpringMVCclass/resources/css/k_strap.css" rel="stylesheet" />
</head>
<body>
<h1>Welcome, Please Login!</h1>

<c:if test="${errorMessage != null }">
	<div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form:form action="login" method="POST" commandName="user">
	
	Username<form:input path="username"/><form:errors path="username"  cssClass="alert alert-danger" element="div"></form:errors> <br>
	Password<form:input path="password"/><form:errors path="password" cssClass="alert alert-danger"></form:errors> <br>
	<input type="submit" value="Login" />
</form:form>

</body>
</html>