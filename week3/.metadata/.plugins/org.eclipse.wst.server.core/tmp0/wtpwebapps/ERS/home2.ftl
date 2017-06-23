<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<style >
	.shows {
		background-color: #242424;
		border: none;
		color: grey;
		padding:10px 5px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 1.5em;
		margin: 4px 2px;
		cursor: pointer;
	}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">

		<form class="" action="show" method="post">
		<ul class="nav navbar-nav">

			<li><a><span class="glyphicon glyphicon-home" id="home" style="font-size:3em;color:#48a2be;padding-right:10px"></span><input type="submit" class="shows" name="show" value="Revature ERS" style="font-size:3em;"></a></li>
			<li><a><span class="glyphicon glyphicon-inbox"></span><input type="submit" class="shows" name="show" value="View Requests"></input></a></li>
			<li><a><span class="glyphicon glyphicon-plus"></span><input type="submit" class="shows" name="show" value="New Reimbursement Request"></a></li>
			<li><a><span class="glyphicon glyphicon-cog"></span><input type="submit" class="shows" name="show" value="Change Account Information"></a></li>
			<li><a><span class="glyphicon glyphicon-log-out"></span><input type="submit" class="shows" name="show" value="Logout"></a></li>
		</ul>
		</form>
	</div>
</nav>













<div class="col-md-6 col-md-offset-3">
	<p style="text-align:center;font-size:1.2em">
		Logged in as <#if employee??>
		 ${employee.firstname} ${employee.lastname}
 </#if>
</p>
</div>




<#if showing==""||showing=="reqs">
	<div class="col-xs-12" style="height:60px;"></div>
	<div class="col-lg-10 col-lg-offset-1">
	<p class="text-right">
	 Filter Your Requests:<br />
	 Pending:
	 <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending">
	 Approved:
	 <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved">
	 Denied:
	 <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied">
	 </p>
	 <input type="submit" class="btn btn-primary pull-right" name="Filter" value="Filter Requests">
	 <input type="submit" class="btn btn-primary pull-right" name="Filter" value="View All Employee Requests" style="margin-right:5px">
  <table class="table table-condensed">
    <thead>
  <ul>
		<thead>
       <tr>
         <th>Amount</th>
         <th>Date made</th>
         <th>Requested by</th>
         <th>Purpose</th>
 				 <th>Status</th>
         <th>Resolved by</th>
         <th>Note</th>
       </tr>
     </thead>
 		<tbody>
 	 <#list modrequests as request>
	 <tr>
 	 <td>${request.amt?string.currency}</td>
   <td>${request.reqdate}</td>
	 <td>${request.reqname!"none"}</td>
 	 <td>${request.purpose}</td>
	 <td>${request.name}</td>
	 <td>${request.resname!"none"}</td>
 	 <td>${request.note!"none"}</td>
 </tr>
 </ul>
 	 </#list>
 </tbody>
</div>
</table>
</#if>
<!--
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
-->

	<#if showing==""||showing=="info">
	<div class="col-sm-2 col-sm-offset-5">
		<form method = "post" action = "info">
	 	<#if employee??>
	 	Edit First Name:
	  <input type="text" name="newfn" class="form-control" value="${employee.firstname}" placeholder="New First Name"><br />
	   Edit Last Name:
	 <input type="text" name="newln" class="form-control" value="${employee.lastname}" placeholder="New Last Name"><br />
	 	Edit Email:
	  <input type="text" name="newemail" class="form-control" value="${employee.email}" placeholder="New Email"><br />
	   Edit Password:
	  <input type="password" name="newpw" class="form-control"  value="" placeholder="New Password"><br />
	  <input type="Submit" class="btn btn-primary" value="Change Account Information">
	  </#if>
	  </form>
	</div>
		</#if>

<!--
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
-->
<#if showing==""||showing=="newreq">
<div class="col-md-4 col-sm-offset-4">
	<form method="post" action="makerequest">
		<p style="text-align:center;">Create New Request
		<br/>Amount:<br />
		<input type="number" step=".01" min="0" max="10000" name="Amount" required="required">
		<br/>Reason:<br />
		<input type="text" name="Purpose" required="required" maxlength="50" size="50">
		<br /><br/><input type="submit" class="btn btn-primary" value="Submit Request" >
		</p>
	</form>
</div>
	</#if>



</body>
</html>
