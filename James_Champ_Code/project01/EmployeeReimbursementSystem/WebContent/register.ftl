<!DOCTYPE html>
<html>
<head>
	<title>New Employee Registration</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h3>New Employee Registration</h3>
	<table>
		<form method="POST" action="register">
		<tr>
			<td>First Name:</td>
			<td><input type="text" name="fname" required></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><input type="text" name="lname"required></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" required></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td>Manager:</td>
			<td>
				<input type="radio" name="manager" value="no" checked>No&nbsp;
				<input type="radio" name="manager" value="yes">Yes
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><button>Register</button>
		</tr>
		</form>
	</table>
</body>
</html>