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

<!-- jQuery Data Tables -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>

<!-- Employee Home Page css file -->
<link rel="stylesheet" type="text/css" href="css/empHome.css">

<script type="text/javascript" src="js/empHome.js"></script>
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
						<li><a href="#info">Information</a></li>
						<li><a href="#reqView">Request</a></li>
						<li><a href="#personal">Personal</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<div id="info" class="container-fluid">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to"0" class="active"></li>
				<li data-target="#myCarousel"data-slide-to"1"></li>
				<li data-target="#myCarousel"data-slide-to"2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<!-- Submit Reimbursement -->
				<div class="item active">
					<img style="opacity:0.5;" src="img/money.jpg" alt="Submit Reimbursement" id="money">
					<div class="carousel-caption">
						<div class="full-width text-center">
							<h1 class="text1">Submit A Reimbursement</h1>
							<h3 class="text1">In order to submit a reimbursement, you
								will need to provide the amount of the reimbursement as well as
								the reason for the reimbursement</h3>
						</div>
					</div>
				</div>

				<!-- View Reimbursements -->
				<div class="item">
					<a href="#reqView"> 
					<img style="opacity:0.5;" src="img/view.jpg" alt="View Reimbursements" id="money">
						<div class="carousel-caption">
							<div class="full-width text-center">
								<h1 class="text1">View Your Reimbursements</h1>
								<h3 class="text1">You can view all of your pending,
									approved, and denied reimbursements</h3>
							</div>
						</div>
					</a>
				</div>

				<!-- View Personal Info -->
				<div class="item">
					<a href="#personal"> 
					<img style="opacity:0.5;" src="img/personal.png" alt="View Personal Info" id="money">
						<div class="carousel-caption">
							<div class="full-width text-center">
								<h1 class="text1">View Your Personal Information</h1>
								<h3 class="text1">You can view your personal information as
									well as update if you so choose</h3>
							</div>
						</div>
					</a>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<div id="reqView" class="container-fluid">
		<h1>Reimbursements</h1>
		<div class="container">
			<!-- <table id="reqTable" class="table table-bordered"> -->
			<table id="reqTable" class="table table-bordered">
				<thead>
					<tr>
						<th>Request Id</th>
						<th>State</th>
						<th>Amount</th>
						<th>Open Date</th>
						<th>Close Date</th>
						<th style="display:none;"></th>
						<th style="display:none;"></th>
						<th style="display:none;"></th>
					</tr>
				</thead>
				<tbody>
					<#list requests as request>
						<tr>
							<td class="reqid">${request.requestId}</td>
							<td class="state">${request.type}</td>
							<td class="amount">${request.amount?string.currency}</td>
							<td class="opendate">${request.openDate}</td>
							<#if (request.closeDate)??>
							<td class="closedate">${request.closeDate}</td>
							<#else>
								<td class="closedate"></td>
							</#if>
							<td style="display:none;" class="purpose">${request.purpose}</td>
							<td style="display:none;" class="manname">${request.managerName}</td>
							<#if (request.managerNote)??>
								<td style="display:none;" class="mannote">${request.managerNote}</td>
							<#else>
								<td style="display:none;" class="mannote"></td>
							</#if>
						</tr>
					</#list>
				</tbody>
			</table>
			
			<!-- Request View Modal -->
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
							<p class="state"></p>
							<p class="amount"></p>
							<p class="opendate"></p>
							<p class="closedate"></p>
							<p class="purpose"></p>
							<p class="manname"></p>
							<p class="mannote"></p>
						</div>
					</div>
				</div>
			</div>

			<!-- Trigger the submit a request modal with a button -->
			<button type="button" id="subReq"
				class="btn btn-lg btn-primary btn-block" data-toggle="modal"
				data-target="#submitModal">Submit a request</button>

			<!-- Modal -->
			<div id="submitModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!--  Modal content -->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Submit Reimbursement Request</h4>
						</div>
						<div class="modal-body">
							<!-- Submit Request Form -->
							<form name="requestform" action="request" method="POST">
								<div class="input-group">
									Amount: <input type="number" class="form-control" name="amount"
										placeholder="Enter Amount" step="0.01" required="required"> <br>
									Purpose: <input type="text" class="form-control" name="purpose"
										placeholder="purpose" required="required">
								</div>
								<div id="btn">
									<input type="submit" value="Submit">
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
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
						
						
						<form name="updateform" action="update" method="POST">
							<div class="input-group">
								First Name: <input type="text" class="form-control"
									name="firstname" value=${employee.firstName}
									required="required"> <br> 
								Last Name: <input type="text" class="form-control" name="lastname"
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
	
</body>
</html>