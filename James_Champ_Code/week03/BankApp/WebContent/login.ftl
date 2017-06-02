<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Bank App Login</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Welcome to Placeholder Bank!</h1>
	<h3>Please log in</h3>
	
	
	<form name="loginform" action="login" method="POST">
	<table>
		<tr>
			<td>User Name:</td> 
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td> <input type="password" name="password"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Login" class="btn btn-default"></td>
		</tr>
	</table>
	</form>
	<#if login! == "fail">
		<h3 style="color:red">Your login information is incorrect</h3>
	</#if>
	<p>Or, create a <a href="signup.html">new account</a>.</p>
</body>
</html>