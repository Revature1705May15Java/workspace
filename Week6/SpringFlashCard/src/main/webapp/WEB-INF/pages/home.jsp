<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Spring Taglib and JSTL taglib -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  Change Doc type to html to use html5 -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='https://fonts.googleapis.com/css?family=Alegreya+Sans+SC:400,300,100' rel='stylesheet' type='text/css'>
<!-- Bootstrap CSS only not js CDN -->
<link rel="stylesheet" href="/SpringFlashCard/resources/css/bootstrap.min.css"/>
<!-- Remember this resource folder can't be seen if it is in your WEB-INF! -->
<link rel="stylesheet" href="/SpringFlashCard/resources/css/steve_strap.css" />
<title>FlashCard Homepage</title>
</head>
<body>
<h1>Welcome home</h1>
<div class="container">
<h1>Unique Question/answer over 4 characters. Can't be blank.</h1>
<!-- Spring and JSTL taglibs used -->
<!-- FlashCard is mapped in the model and validated using the annotations -->
<form:form action="add" method="POST" commandName="flashcard">
			<form:errors path="question" cssClass="alert alert-danger" element="div"/>
			<form:label path="" cssClass="">Add a new Flash Card</form:label>
		    <form:input class="form-control" path="question" placeholder="question" />
		    <br/>
		    <form:input class="form-control" path="answer" placeholder="answer"/>
		    <form:errors path="answer" cssClass="alert alert-danger" element="div"/>
		    <br/>
		    <input type="submit" class="btn btn-default" value="add"/>
</form:form>
</div>
</body>
</html>