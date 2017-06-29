<!DOCTYPE html>
<html>
<style>
.body{
	background-image:
	
		url(http://www.uksoftech.com/wp-content/uploads/2016/02/website-design-background.png)

}

</style>
<head>

<script src="https://code.jquery.com/jquery-3.2.1.js"  
		integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="  
		crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">


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
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="js/eHome.js"></script>
<meta charset="ISO-8859-1">
<title>Employee Home</title>



</head>
<body>

	<div class="pull-right" style ="length: 150 px" >
      <form action="logout" method="post" name="Logout_Form"
				class="form-signin">

				<button class="btn btn-lg btn-danger btn-block" name="Submit"
					value="Logout" type="Submit">Logout</button>
			</form>

</div>




	<h1 style="color: cyan">Welcome ${emp.firstname} ${emp.lastname}</h1>

	<ul class="nav nav-tabs"  >
		<li class="active"><a data-toggle="tab" href="#home">Account Info</a></li>
		<li><a data-toggle="tab" href="#menu1">Submit Request</a></li>
		<li><a data-toggle="tab" href="#menu2">Pending Requests</a></li>
		<li><a data-toggle="tab" href="#menu3">Resolved Requests</a></li>
		<li><a data-toggle="tab" href="#menu4">Update Information</a></li>
	</ul>

	<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
			<h3>Account Home</h3>
			<p>
				<h2>First name: ${emp.firstname}</h2>  
				<h2>Last name: ${emp.lastname}</h2>
				<h2>Username: ${emp.username}</h2>
				<h2>Employee ID: ${emp.eid}</h2>
			</p>
		</div>
		<div id="menu1" class="tab-pane fade"  style="width: 300px; height: 100px; margin-left: 10%" >
		<h3>Submit Request</h3>
		<div class="row vertical-offset-100">
		<div class="panel panel-default"">
			  	<div class="panel-heading">
			    	<h3 class="panel-title">User Request Reiumbursement</h3>
			 	</div>
			  	<div class="panel-body">
			    	<form action="req" method="post">
                    <fieldset>
                        <div class="form-group">
    		    		    <input class="form-control" placeholder="Amount" name="amount" type="number" step=".01">
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Reasoning" name="note" type="text">
			    		</div>			    		
			    		<input class="btn btn-lg btn-success btn-block" type="submit" value="Submit Request">
			    	</fieldset>
			      	</form>
			    </div>
			</div>
			</div>
		</div>
		<div id="menu2" class="tab-pane fade">
			<h3>${emp.firstname}  ${emp.lastname}'s Requests</h3>
			<table id="example1" >
				<thead>
					<tr>
						<th>Request ID</th>
						<th>Reasoning</th>
						<th>Status</th>
						<th>Amount</th>
						<th>View</th>
					</tr>
				</thead>
				<tbody>
					<#list OpenReqs as req>
					<tr>
						<td>${req.requestid}</td>
						<#assign x = req.requestid>
						
						<#if req.purpose??>
						<td>${req.purpose}</td>
						<#else>
						<td>NA</td>
						</#if>
						
						<#if req.stateid == 0>
						<td>Pending</td>
						<#elseif req.stateid ==1>
						<td>Approved</td>
						<#elseif req.stateid==2>
						<td>Denied</td>
						</#if>
						
						<td>${req.amount}</td>
						
						<td><button href="#reqModal" id="openBtn" data-toggle="modal" class="btn btn-default">View</button>
						
						<div class="modal fade" id="reqModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">�</button>
											<h3 class="modal-title">${x}</h3>
										</div>
										<div class="modal-body">
											<h5 class="text-center">Request [${x}]</h5>
											<table class="table table-striped" id="tblGrid">
												<thead id="tblHead">
													<tr>
														<th>Request ID</th>
														<th>Amount</th>
														<th class="text-right">Status</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>[ID]</td>
														<td>[MONEY]</td>
														<td class="text-right">Pending</td>
													</tr>
													<tr>
														<td>[ID]</td>
														<td>[MONEY]</td>
														<td class="text-right">Closed</td>
													</tr>
													<tr>
														<td>[ID]</td>
														<td>[MONEY]</td>
														<td class="text-right">Open</td>
													</tr>
												</tbody>
											</table>
											<div class="form-group">
												<input type="button"
													class="btn btn-warning btn-sm pull-right" value="Reset">
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default "
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary">Save
												Changes</button>
										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div> <!-- /.modal --></td>
						
					</#list>
					</tr>
				</tbody>
			</table>

			













		</div>
		<div id="menu3" class="tab-pane fade">
			<h3>Approved Requests</h3>
			<table id="example2">
				<thead>
					<tr>
						<th>Request ID</th>
						<th>Reasoning</th>
						<th>Status</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<#list ClosedReqs as req>
					<tr>
						<td>${req.requestid}</td>
						
						<#if req.note??>
						<td>${req.purpose}</td>
						<#else>
						<td>NA</td>
						</#if>
						
						<#if req.stateid == 0>
						<td>Pending</td>
						<#elseif req.stateid ==1>
						<td>Approved</td>
						<#elseif req.stateid==2>
						<td>Denied</td>
						</#if>
						
						<td>${req.amount}</td>
						
					</#list>
					</tr>
				</tbody>
			</table>
		</div>
		
		
		
		<div id="menu4" class="tab-pane fade">
			<div class="container">
				<div class="container">
					<h2>Update your Information</h2>



					<form class="form-horizontal" method="post" name="update_form"
						action="ehome">
						<!--INSERT SERVLET FUNCTIONALITY -->
						<div class="form-group">
							<label class="control-label col-sm-2" for="newUN">Username</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="newun"
									placeholder="Enter Username" name="newun">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="newpw">Password:</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="newpw"
									placeholder="Enter password" name="newpw">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="newfn">First
								Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="newfn"
									placeholder="Last Name" name="newfn">
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-2" for="newln">Last
								Name:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="newln"
									placeholder="First Name" name="newln">
							</div>
						</div>



						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" value="home" class="btn btn-default">Submit</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>

	<div class="container">
		<div class="wrapper">
			
		</div>
	</div>

  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.12.4.js"></script>
  <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
 <script>
 $(document).ready(function()
	      {
	        var navItems = $('.admin-menu li > a');
	        var navListItems = $('.admin-menu li');
	        var allWells = $('.admin-content');
	        var allWellsExceptFirst = $('.admin-content:not(:first)');
	        allWellsExceptFirst.hide();
	        navItems.click(function(e)
	        {
	            e.preventDefault();
	            navListItems.removeClass('active');
	            $(this).closest('li').addClass('active');
	            allWells.hide();
	            var target = $(this).attr('data-target-id');
	            $('#' + target).show();
	        });
	        });
 
  $(function(){
	    $("#example1").dataTable();
	  })
	  
$(function(){
	    $("#example2").dataTable();
	  })
  </script>
</body>
</html>