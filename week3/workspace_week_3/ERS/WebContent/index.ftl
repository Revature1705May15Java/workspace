<html>
<head>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


	<title>Welcome Page</title>
</head>
<body style="background-color: aquamarine;">

	<div class="jumbotron" style="background-color: skyblue; color: purple; text-align: center;">
		<form method="POST" action="login">
		
			<input class="form-control" type="text" name="username" placeholder="Username" required="required" />
			<input class="form-control" type="password" name="password" placeholder="Password"  required="required" />
			<input class="btn-primary" type="submit" value="Login"/>
		
		</form>
		<#if login! == "fail">
		<h3 style="color:red">Login username or password incorrect. Please try again.</h3>
		</#if>
	</div>
	<div class="input-group">
		<span class="input-group-addon" id="basic-addon1">@</span>
		<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
	</div>
</body>

</html>