<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="shared/header.jsp"%>
<!--  Main js functions -->
	<script src="resources/js/submitImage.js"></script>
</head>
<body onsubmit="findImageBlob('imageForm','img')">
<h3>Hello, ${ loggedUser.username.toLowerCase() }</h3>

<form id="imageForm" class="form-horizontal" method="POST" action="profile.do">
	<div class="form-group">
		<label for="receipt_input" class="control-label">Blob</label>
		<input name="receipt" id="receipt_input" type="file" class="file" accept="image/*" data-show-upload="false" data-allowed-file-extensions='["jpg", "png"]' required>
	</div>
	<input id="blob" name="blob" hidden=hidden />
	<div class="form-group">
		<button type="submit" class="btn btn-lg btn-success btn-block">Submit</button>
	</div>
	<c:if test="${ blob != null }">
		<div class="form-group">
			<label class="control-label">Blob from DB</label>
			<input name="blob_input" id="blob_input" type="file" class="file" data-show-upload="false">
			<input id="imageBlob" value="${blob}" hidden="hidden"/>
			<script src="resources/js/viewImage.js"></script>
		</div>
	</c:if>
</form>
</body>
</html>