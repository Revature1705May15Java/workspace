<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pokemon</title>
<%@ include file="headers.jsp" %>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1>Pokemon</h1>
	<div class="container">

		<div class="jumbotron">
			<h1>Using RESTful Pokemon API</h1>
		</div>

		<div class="well">
			<!-- User will enter a pokemon id -->
			<input type="text" id="pokemonId" placeholder="Enter Pokemon ID">
			<input type="submit" value="Get Pokemon Info" id="pokemonSubmit" class="btn btn-info"/>
		</div>

		<div class="well">
			<div class="text-center">
				<!-- API will return pokemon information
					We will append that information to the page -->
				<img id="pokemonImg" alt="" src="">
				<h3 id="pokemonName"></h3>
			</div> 
		</div>


	</div>
<script type="text/javascript" src="resources/js/jsPokemon.js"></script>
</body>
</html>