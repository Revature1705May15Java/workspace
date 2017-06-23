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
	      <li><a><span class="glyphicon glyphicon-user"></span><input type="submit" class="shows" name="show" value="View Employees"></a></li>
	      <li><a><span class="glyphicon glyphicon-plus"></span><input type="submit" class="shows" name="show" value="Add Employee"></a></li>
	      <li><a><span class="glyphicon glyphicon-cog"></span><input type="submit" class="shows" name="show" value="Change Account Information"></a></li>
				<li><a><span class="glyphicon glyphicon-log-out"></span><input type="submit" class="shows" name="show" value="Logout"></a></li>
	    </ul>
			</form>
	  </div>
	</nav>
<!--
		Logged in as <#if employee??>
			${employee.firstname} ${employee.lastname}
		</#if><br />
		Options:
		<input type="submit" name="show" value="request">
		<input type="submit" name="show" value="employee">
		<input type="submit" name="show" value="newemp">
		<input type="submit" name="show" value="info">

	<form method = "post" action = "logout">
	 <input type="submit" class="btn btn-primary" value="Logout">
	 </form>
 -->


 <div class="col-md-6 col-md-offset-3">
   <p style="text-align:center;font-size:1.2em">
		 Logged in as <#if employee??>
		 	${employee.firstname} ${employee.lastname}
 	</#if>
 </p>
 </div>




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

<#if showing==""||showing=="reqs">
<form method = "post" action="process">
	<div class="col-xs-12" style="height:60px;"></div>
	<div class="col-lg-10 col-lg-offset-1">
	<p class="text-right">
	 Filter Employee Requests:<br />
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
 				<th>Add note</th>
 				<th>Approve</th>
 				<th>Deny</th>
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
	 <#if request.stateid==1>
	 <td><input type = "text" name=${request.requestid}n /></td>
	 <td><input type ="radio" name=${request.requestid} value="Approve" /></td>
	 <td><input type ="radio" name=${request.requestid} value="Deny" /></td>
	 <#else>
	 <td> </td>
	 <td> </td>
	 <td> </td>
	 </#if>
 </tr>
 </ul>
 	 </#list>
 </tbody>
</div>
</table>
		<input type="submit" class="btn btn-primary pull-right" name="Update Requests" value="Update Requests">
</form>
</#if>

<!--
<#if showing==""||showing=="emps">
<form method = "post" action="filter">
 <div class="col-lg-10 col-lg-offset-1">
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
-->










<#if showing==""||showing=="emps">
<form method = "post" action="filter">
	<div class="col-xs-12" style="height:60px;"></div>
	<div class="col-lg-10 col-lg-offset-1">
	<p class="text-right">
	 Filter Employee Requests:<br />
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
         <th>First Name</th>
         <th>Last Name</th>
         <th>Email</th>
         <th>Id</th>
 				 <th>Manager</th>
				 <th>View Requests</th>
       </tr>
     </thead>
 		<tbody>
 	 <#list employees as employee>
	 <tr>
 	 <td>${employee.firstname}</td>
   <td>${employee.lastname}</td>
	 <td>${employee.email}</td>
 	 <td>${employee.id}</td>
	 <td><#if employee.ismanager==1>Yes</#if>
	  <#if employee.ismanager==0>No</#if></td>
	 <td><#if employee.ismanager==0><input type ="checkbox" name=${employee.id}c /></#if></td>

 </tr>
 </ul>
 	 </#list>
 </tbody>

</div>
</table>
		<input type="submit" class="btn btn-primary pull-right" name="Filter" value="Filter Employee Requests">
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



<!--
	<#if showing==""||showing=="newemp">
	<div class="col-sm-2 col-sm-offset-1">
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
 </div>
 </#if>
 -->


 <#if showing==""||showing=="newemp">
 <div class="col-sm-2 col-sm-offset-5">
 	<form method = "post" action = "newemployee">
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
 </div>
</body>
</html>
