<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Details</title>
	
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<h3>Account # ${account.accountId}</h3>
	<table class="table table-striped">
		<tr>
			<th>Account #</th>
			<th>Account Type</th>
			<th>Balance</th>
			<th>Date Opened</th>
			<th>Action</th>
		</tr>
		
		<form id="accountDetails" name="viewDetailsForm" action="details" method="POST"></form>
		
		<tr>
			<td>${account.accountId}</td>
			<td>${account.type.name}</td>
			<td>${account.balance?string.currency}</td>
			<td>${account.openDate}</td>
			<td>
				<div class="btn-group">
  					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action<span class="caret"></span>
  					</button>
  					<ul class="dropdown-menu">
    					<li><a href="#">Deposit</a></li>
    					<li><a href="#">Withdraw</a></li>
    					<li><a href="#">Transfer</a></li>
       					<li><a href="#">Add Account Holder</a></li>
    					<li><a href="#">Close Account</a></li>
  					</ul>
				</div>	
			</td>
		</tr>
	</table>
</body>
</html>