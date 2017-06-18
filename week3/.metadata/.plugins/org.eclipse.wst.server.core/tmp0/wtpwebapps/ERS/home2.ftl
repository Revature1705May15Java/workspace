<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>
<!--jquerydatatables-->
<div class="jumbotron">
	<form class="" action="show" method="post">
		Logged in as <#if employee??>
			${employee.firstname} ${employee.lastname}
		</#if><br />
		Options:
		<input type="submit" name="show" value="request">
		<input type="submit" name="show" value="info">
		<input type="submit" name="show" value="newreq">
	</form>
	<form method = "post" action = "logout">
	 <input type="submit" class="btn btn-primary" value="Logout">
	 </form>
</div>




<#if showing==""||showing=="reqs">
<div class = "jumbotron">
	 <div class="col-md-8">
		 <form method = "post" action = "filter">
	 	 <p>Filter Your Requests</p>
	 	 Pending:
	 	 <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending">
	 	 Approved:
	 	 <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved">
	 	 Denied:
	 	 <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied"><br /><br />
	 	 <input type="submit" class="btn btn-primary" name="Filter" value="Filter">
    <p>
			Employee Requests:
		</p>

    <ul>
			<#list modrequests as request>
			Amount: ${request.amt?string.currency} Date made:  ${request.reqdate} <br />Status: ${request.name}<br />
			Purpose: ${request.purpose}<br />Note: ${request.note!"none"}
			<br /> Resolved by:${request.resname!"none"}
			<br /><br />
			</#list>
    </ul>
  </div>
	</#if>

<#if showing==""||showing=="info">
 <div class="jumbotron">
 <form method = "post" action = "info">
 	<#if employee??>
 	Edit First Name:
  <input type="text" name="newfn" class="form-control" value=${employee.firstname} placeholder="New First Name"><br />
   Edit Last Name:
 <input type="text" name="newln" class="form-control" value=${employee.lastname} placeholder="New Last Name"><br />
 	Edit Email:
  <input type="text" name="newemail" class="form-control" value=${employee.email} placeholder="New Email"><br />
   Edit Password:
  <input type="password" name="newpw" class="form-control" value=${employee.password} placeholder="New Password"><br />
  <input type="Submit" class="btn btn-primary" value="Change Account Information">
  </#if>
  </form>
	</#if>

<#if showing==""||showing=="newreq">
	<div class="col-sm-4">
		 <form method="post" action="makerequest">
			 <p>Create New Request</p>
			 <br/>Amount:
			 <input type="number" step=".01" min="0" max="10000" name="Amount" required="required">
			 <br/>Reason:
			 <input type="text" name="Purpose" required="required" maxlength="50" size="50">
			 <br/><input type="submit" class="btn btn-primary" value="Submit Request" >
		 </form>
		 </div>
</div>
</#if>

</body>
</html>
