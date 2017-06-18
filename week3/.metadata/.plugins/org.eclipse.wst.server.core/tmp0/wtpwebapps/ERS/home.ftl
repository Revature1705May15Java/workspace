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
	<form class="" action="show" method="post">
		Logged in as <#if employee??>
			${employee.firstname} ${employee.lastname}
		</#if><br />
		Options:
		<input type="submit" name="show" value="request">
		<input type="submit" name="show" value="employee">
		<input type="submit" name="show" value="newemp">
		<input type="submit" name="show" value="info">
	</form>
	<form method = "post" action = "logout">
	 <input type="submit" class="btn btn-primary" value="Logout">
	 </form>
</div>






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

<#if showing==""||showing=="reqs">
<form method = "post" action="process">
 <div class="col-md-8">
	 <p name ="requests">Filter Employee Requests</p>
	 Pending:
	 <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending">
	 Approved:
	 <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved">
	 Denied:
	 <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied"><br /><br />
	 <input type="submit" class="btn btn-primary" name="Filter" value="Filter Employee Requests">
	 <input type="submit" class="btn btn-primary" name="Filter" value="View All Employee Requests">
  <p>
 	 Requests
  </p>
  <ul>
 	 <#list modrequests as request>
 	 Amount: ${request.amt?string.currency} Date made:  ${request.reqdate}<br />Status: ${request.name}<br />
 	 Purpose: ${request.purpose}<br />Note: ${request.note!"none"}
 	<br />Requested by:${request.reqname!"none"} <br /> Resolved by:${request.resname!"none"}
 	 <br />
	 <#if request.stateid==1>
	 Add Note:<input type = "text" name=${request.requestid}n />
	 Approve:<input type ="radio" name=${request.requestid} value="Approve" />
	 Deny:<input type ="radio" name=${request.requestid} value="Deny" /><br />
	 </#if><br /><br />
 	 </#list>
  </ul>
		<input type="submit" class="btn btn-primary" name="Update Requests" value="Update Requests">

 	</div>
</form>
</#if>

<#if showing==""||showing=="emps">
<form method = "post" action="filter">
 <div class="col-md-8">
	 <p>Filter Employee Requests</p>
   Pending:
   <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending">
   Approved:
   <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved">
   Denied:
   <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied"><br /><br />
   <input type="submit" class="btn btn-primary" name="Filter" value="Filter Employee Requests">
 	<input type="submit" class="btn btn-primary" name="Filter" value="View All Employee Requests">
  <p>
 	 Employees:
  </p>
  <ul>
 	 <#list employees as employee>
 	 Name: ${employee.firstname} ${employee.lastname}<br />
	 Email: ${employee.email}<br />
	 ID: ${employee.id}<br />
 	 Manager:
	 <#if employee.ismanager==1>Yes</#if>
	  <#if employee.ismanager==0>No</#if>
 	 <br />
	 <#if employee.ismanager==0>
	 View requests:<input type ="checkbox" name=${employee.id}c /></#if>
	 <br /><br />
 	 </#list>
  </ul>
 	</div>

</form>
</#if>

<!--
<#if showing==""||showing=="reqs"||showing="emps">
 <div class="jumbotron">
 <form method = "post" action = "filter">
  <p>Filter Employee Requests</p>
  Pending:
  <input type="checkbox" class="btn btn-primary" name="Pending" value="Pending"><br />
  Approved:
  <input type="checkbox" class="btn btn-primary" name="Approved" value="Approved"><br />
  Denied:
  <input type="checkbox" class="btn btn-primary" name="Denied" value="Denied"><br />
  <input type="submit" class="btn btn-primary" name="Filter" value="Filter Employee Requests">
	<input type="submit" class="btn btn-primary" name="Filter" value="View All Employee Requests">
  </form>
</div>
</#if>
-->


	<#if showing==""||showing=="newemp">
<div class="jumbotron">
<form method = "post" action = "newemployee">
	<#if employee??>
	<br />
	New Employee First Name:
 <input type="text" name="newempfn" class="form-control" placeholder="New Employee First Name" required="required"><br />
  New Employee Last Name:
<input type="text" name="newempln" class="form-control"placeholder="New Employee Last Name" required="required"><br />
	New Employee Email:
 <input type="text" name="newempemail" class="form-control" placeholder="New Employee Email" required="required"><br />
 Manager?
 <input type="checkbox" name="newempismanager"/><br /><br />
 <input type="Submit" class="btn btn-primary" value="Create New Employee">
 </#if>
 </form>
 </#if>

</body>
</html>
