<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring MVC Example | Login</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">${errorMessage}</div>
</c:if>

<h1>Login</h1>
<form:form action="login" method="POST" commandName="user">
    Username: <form:input path="username" />    <form:errors path="username" cssClass="alert alert-danger" element="div"/><br/>
    Password: <form:password path="password"/> <form:errors path="password" cssClass="alert alert-danger" element="div"/> <br/>
    <input type="submit" value="Login"/>
</form:form>


</body>
</html>
