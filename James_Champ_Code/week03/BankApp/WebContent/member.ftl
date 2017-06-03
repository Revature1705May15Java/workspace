<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Accounts</title>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Welcome, ${user.firstName} ${user.lastName}!</h1>
	<h3>Accounts:</h3>
	<table class="table table-striped">
		<tr>
			<th>Account #</th>
			<th>Account Type</th>
			<th>Balance</th>
			<th>Date Opened</th>
			<th>Action</th>
		</tr>
		
		<form id="accountDetails" name="viewDetailsForm" action="details" method="POST"></form>
		<#list user.accounts as a>
		<tr>
			<td>${a.accountId}</td>
			<td>${a.type.name}</td>
			<td>${a.balance?string.currency}</td>
			<td>${a.openDate}</td>
			<td>
				<button form="accountDetails" type="submit" class="btn btn-default" name="account" value="${a.accountId}">View Account</button>
			</td>
		</tr>
		</#list>
	</table>
</body>
</html>