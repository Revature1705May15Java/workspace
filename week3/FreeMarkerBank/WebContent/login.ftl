<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>WELCOME TO DA BANK</h1>
<h3>Please don't Log in</h3>

<form name="loginform" action="login" method="Post">
<input type="text" name="username" placeholder="userid">
<br>
 <input type="password" name="password" placeholder="Password">
<input type="submit" value="LOGIN">


</form>

<#if login=="fail">
	<h3 style="color:red">Your login information is wrong</h3>
</#if>
</body>
</html>