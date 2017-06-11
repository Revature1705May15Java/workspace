<html>
<head>
<title>Employee Page</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style>

div#newuser{
    height: 250px;
    width: 350px;
    overflow-y: scroll;
    color: black;
}

</style>

<title>Welcome Page</title>
</head>
<body style="background-color: aquamarine;">

	<div class="jumbotron" style="background-color: skyblue; color: purple; text-align: center;">

		<form method="POST" action="logout">
			<input class="btn-primary" type="submit" name="logout" value="Log Out" />
		</form>

		
		<div id="newuser" class="jumbotron">
			<#if createrequest! == "success">
			<h3 style="color:green">Request submitted.</h3>
			</#if>
			<#if createrequest! == "fail">
			<h3 style="color:red">Invalid entry. Please try again.</h3>
			</#if>
			<h4>Create a New Reimbursement Request</h3>
			<form method="POST" action="createRequest">
			<input class="form-control" type="number" name="amount" min="1" required="required">
			<input class="form-control" type="text" name="purpose" placeholder="Purpose of spending" required="required" />
			<input class="btn-primary" type="submit" value="Create Employee"/>
			</form>
		</div>
		
	</div>

</body>
</html>