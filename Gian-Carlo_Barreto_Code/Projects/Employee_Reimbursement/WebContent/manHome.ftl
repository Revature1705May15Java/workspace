<html>
<head>
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous">
	
</script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<!-- Employee Home Page css file -->
<link rel="stylesheet" type="text/css" href="css/empHome.css">

</head>
<body data-syp="scroll" data-target=".navbar" data-offset="50">

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Employee Reimbursement System</a>
			</div>
			<div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li><a href="#reqView">Resolved Requests</a></li>
						<li><a href="#pending">Pending Requests</a></li>
						<li><a href="#empView">Employees</a></li>
						<li><a href="#personal">Personal</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- View all resolved request -->
	<div id="reqView" class="container-fluid">
		<h1>Resolved Requests</h1>
		<div class="container">
			<table id="reqTable" class="table table-bordered">
				<thead>
					<tr>
						<th>Request Id</th>
						<th>Employee Id</th>
						<th>State</th>
						<th>Amount</th>
						<th>Open Date</th>
						<th>Close Date</th>
					</tr>
				</thead>
				<#list resolved as request>
					<tr>
						<td class="reqid">${request.requestId}</td>
						<td class="empid">${request.employeeId}</td>
						<td class="state">${request.type}</td>
						<td class="amount">${request.amount?string.currency}</td>
						<td class="opendate">${request.openDate}</td>
						<#if (request.closeDate)??>
						<td class="closedate">${request.closeDate}</td>
						<#else>
							<td class="closedate"></td>
						</#if>
						<td style="display:none;" class="purpose">${request.purpose}</td>
						<td style="display:none;" class="manid">${request.managerId}</td>
						<#if (request.managerNote)??>
							<td style="display:none;" class="mannote">${request.managerNote}</td>
						<#else>
							<td style="display:none;" class="mannote"></td>
						</#if>
					</tr>
				</#list>
			</table>
			<!-- Modal -->
			<div id="reqModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
	
					<!--  Modal content -->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Request Information</h4>
						</div>
						<div class="modal-body">
							<p class="reqid"></p>
							<p class="empid"></p>
							<p class="state"></p>
							<p class="amount"></p>
							<p class="opendate"></p>
							<p class="closedate"></p>
							<p class="purpose"></p>
							<p class="manid"></p>
							<p class="mannote"></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	
	<!-- View all pending request -->
	<div id="pending" class="container-fluid">
		<h1>Pending Requests</h1>
		<div class="container">
			<table id="pendReqTable" class="table table-bordered">
				<thead>
					<tr>
						<th>Request Id</th>
						<th>Employee Id</th>
						<th>State</th>
						<th>Amount</th>
						<th>Open Date</th>
					</tr>
				</thead>
				<#list pending as request>
					<tr>
						<td class="reqid">${request.requestId}</td>
						<td class="empid">${request.employeeId}</td>
						<td class="state">${request.type}</td>
						<td class="amount">${request.amount?string.currency}</td>
						<td class="opendate">${request.openDate}</td>
						<td style="display:none;" class="purpose">${request.purpose}</td>
					</tr>
				</#list>
			</table>
			
			<!-- Modal -->
			<div id="pendingModal" class="modal fade" role="dialog">
				<div class="modal-dialog">
	
					<!--  Modal content -->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Request Information</h4>
						</div>
						<div class="modal-body">
							<p class="reqid"></p>
							<p class="empid"></p>
							<p class="state"></p>
							<p class="amount"></p>
							<p class="opendate"></p>
							<p class="purpose"></p>
							<form name="appdenform" action="appden" method="POST">
								<h5>Note:</h5> 
								<textarea rows="4" cols="50" name="note"></textarea><br>
								<input type="radio" name="choice" value="approve"/>Approve
								<input type="radio" name="choice" value="deny"/>Deny
								<input type="hidden" name="reqid" value="" id="hiddenRequestId"/>
								<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
	<!-- Employee View -->
	<div id="empView" class="container-fluid">
		<h1>Employees</h1>
		<div class="container">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Is A Manager</th>
					</tr>
				</thead>
				<#list employees as emp>
				<tr>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<#if emp.isManager()>
						<td>YES</td>
					<#else>
						<td>NO</td>
					</#if>
				</tr>
				</#list>
			</table>
		</div>
	</div>
	
	
	<!-- View/Update personal information -->
	<div id="personal" class="container-fluid">
		<h1>Personal Information</h1>
		<#if updated! == "fail">
			<div class="alert alert-danger" role="alert"> Email not available </div>
		</#if>
		<h3>First Name: ${employee.firstName}</h3>
		<h3>Last Name: ${employee.lastName}</h3>
		<h3>Email: ${employee.email}</h3>

		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-lg btn-primary btn-block"
			data-toggle="modal" data-target="#updateModal">Update</button>

		<!-- Modal -->
		<div id="updateModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!--  Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Update Personal Information</h4>
					</div>
					<div class="modal-body">
						<!-- Update Form -->
						<#if updated! =="fail">
						<div class="alert alert-danger" role="alert">Incorrect Email
						</div>
						</#if>
						<form name="updateform" action="update" method="POST">
							<div class="input-group">
								First Name: <input type="text" class="form-control"
									name="firstname" value=${employee.firstName}
									required="required"> <br> Last Name: <input
									type="text" class="form-control" name="lastname"
									value=${employee.lastName} required="required"> <br>
								Email: <input type="text" class="form-control" name="email"
									value=${employee.email} required="required">
							</div>
							<br>
							<div id="btn">
								<input type="submit" value="Submit">
							</div>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript" src="js/manhome.js"></script>
</body>
</html>