<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Login</title>
</head>
<body>

<h1>Welcome to THE BANK</h1>
<h3>Please Log In</h3>
<form name="loginform" action="login" method="post">
Username:<input type="text" name="username"/>
<br>
Password:<input type="password" name="password"/>
<input type="submit" value="login"/>
</form>

	<#if login! == "fail">
	<h3 style="color:red">Your login information is incorrect </h3>
	</#if>


</body>
</html>