<!DOCTYPE html>
<html>
<head>
	<title>Employee List</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>

<body>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Employee #</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Manager</th>
		</tr>
		</thead>
		<tbody>
		<#list employees as e>
		<tr>
			<td>${e.employeeId}</td>
			<td>${e.firstName}</td>
			<td>${e.lastName}</td>
			<td>${e.email}</td>
			<#if e.isManager>
				<td>Yes</td>
			<#else>
				<td>No</td>
			</#if>
		</tr>
		</#list>
		</tbody>
	</table>
</body>
</html>