<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

	<div class="jumbotron">
		<form method = "post" action = "logout">
			<p>Logged in as <#if employee??>
			${employee.firstname} ${employee.lastname}
			</#if></p>
  		<input type="submit" class="btn btn-primary" value="Logout"/>
 		</form>
 	</div>





<div class = "jumbotron">
	 <div class="col-sm-4">
    <p>
			Employee Requests:
		</p>

    <ul>
			<#list modrequests as request>
			<p>${request.amt?string.currency}<br /> Date made:  ${request.reqdate} <br />Status: ${request.name}</p>
			Purpose: ${request.purpose}<br />
			<br /><br />
			</#list>
    </ul>
  </div>

	<div class="jumbotron">
	<form method = "post" action = "filter">
	 <p>Filter Employee Requests</p>
	 Pending:
	 <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending"><br />
	 Approved:
	 <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved"><br />
	 Denied:
	 <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied"><br />
	 <input type="submit" class="btn btn-primary" name="Filter" value="Filter">
	 </form>

	<div class="col-sm-4">
		 <form method="post" action="makerequest">
			 <p>Create New Request</p>
			 <br/>Amount:
			 <input type="number" step=".01" name="Amount">
			 <br/>Reason:
			 <input type="text" name="Purpose">
			 <br/><input type="submit" class="btn btn-primary" value="Submit Request">
		 </form>
		 </div>
</div>

</body>
</html>
