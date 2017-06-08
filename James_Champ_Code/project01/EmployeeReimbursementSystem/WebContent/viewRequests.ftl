<!DOCTYPE html>
<html>
<head>
	<title>Request List</title>
	
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
			<th>Request #</th>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Amount</th>
			<th>Date Opened</th>
			<th>Purpose</th>
			<th>State</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<#list requests as r>
		<tr>
			<td>${r.requestId}</td>
			<td>${r.requester.lastName}</td>
			<td>${r.requester.firstName}</td>
			<td>${r.amount}</td>
			<td>${r.openDate}</td>
			<td>${r.purpose}</td>
			<td>${r.state.name}</td>
		</tr>
		</#list>
		</tbody>
	</table>
</body>
</html>