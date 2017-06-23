<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="crossorigin="anonymous"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		
		
		
		
		
		
		<link rel="stylesheet" href="http://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/select/1.2.2/css/select.dataTables.min.css">
		<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.3.1/css/buttons.dataTables.min.css">
		
		<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
		<script src="http://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
		
		<script src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
		<script src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script>
		<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
		<script src="https://cdn.datatables.net/select/1.2.2/js/dataTables.select.min.js"></script>
		

		
		<script type="text/javascript">
			var requestId;
			$(document).ready(function() {
			var table = $('#reimbursementTable').DataTable( {
				columnDefs: [ {
            	orderable: false,
            	className: 'select-checkbox',
            	targets:   0
        	}],
        	select: {
            	style:    'os',
            	selector: 'td:first-child'
        	},
        	order: [[ 1, 'asc' ]]
    		} );
    		$('#reimbursementTable tbody').on('click', 'tr', function () {
    		reimbursement = table.row(this).data();
    		requestId = reimbursement[6];
    		console.log(requestId);
    		console.log(reimbursement);
    		
			});
			
		$("#updateReimbursement").on("click", function () {
     	$("#updateReimbursementModal #requestId").val(requestId);	
		});
		});
		
		$(document).ready(function(){
    		$('#archiveTable').DataTable();
		});
		
		$(document).ready(function(){
    		$('#employeesTable').DataTable();
		});
		</script>
		

		
		
		
		<style type="text/css">
			
			body {
				background: #eee !important;	
			}
			
			.container {	
				margin-top: 80px;
			  	margin-bottom: 80px;
			}
			
			.form-newRequest {
			  	max-width: 380px;
			  	padding: 15px 35px 45px;
			  	margin: 0 auto;
			  	background-color: #fff;
			}
			
			.form-updateEmployee {
			  	max-width: 380px;
			  	padding: 15px 35px 45px;
			  	margin: 0 auto;
			  	background-color: #fff;
			}
			
			.form-signout {
				max-width: 380px;
			  	padding: 15px 35px 45px;
			  	margin: 0 auto;
			}
			
			.form-control {
			  	position: relative;
			  	font-size: 16px;
			  	height: auto;
			  	padding: 10px;
				@include box-sizing(border-box);
			}
			
			input[type="text"] {
			  	margin-bottom: -1px;
			  	border-bottom-left-radius: 0;
			  	border-bottom-right-radius: 0;
			}

		</style>
		
		
	</head
	
	<body>	
	
	
		<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">ERS</a>
		    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	      		<li><button class ="btn btn-default navbar-btn" data-toggle="modal" id="updateReimbursement" data-target="#updateReimbursementModal">Approve / Deny</button></li>
	      		<li><button class ="btn btn-default navbar-btn" data-toggle="modal" data-target="#viewEmployeesModal">View Employees</button></li>
	        	<li><button class ="btn btn-default navbar-btn" data-toggle="modal" data-target="#addEmployeeModal">Add Employee</button></li>
	        	
	      	<li class="dropdown">
  				<button class="btn btn-default dropdown-toggle navbar-btn" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    			Welcome, <#if employee??>${employee.getFirstName()}</#if> <span class="caret"></span>
    			</button>
    			<ul class="dropdown-menu">
	            <li><a href="#" data-toggle="modal" data-target="#updateEmployeeModal">Update Information</a></li>
	            <li> 
					<a class="btn btn-xs" href="logout">Logout</a>
				</li>
	          </ul>
  			</li>     
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	
	      	
	
	
	<div class="container">
	<h3>Pending Reimbursements</h3>
	<table id="reimbursementTable" class="table table-bordered table-hover" cellspacing="0" width="100%">
			 <thead>
			    <tr>
			    	<th></th>
			    	<th>Requester ID</th>
			    	<th>Date Requested</th>
			        <th>Amount</th>
					<th>Purpose</th>
					<th>State</th>
					<th>Request ID</th>
			    </tr>
			</thead>
			<tbody>
				<#list penReimbursements as penR>
			    <tr>
			    	<td></td>
			    	<td>${penR.getRequesterId()}</td>
			    	<td>${penR.getDateRequested()}</td>
			        <td>${penR.getAmount()}</td>
					<td>${penR.getPurpose()}</td>
					<td>${penR.getStateId()}</td>
					<td>${penR.getRequestId()}</td>
			
			    </tr>
			    </#list>
			</tbody>
		</table>
	</div>
	
	
	<div class="container">
	<h3>Archived Reimbursements</h3>
	<table id="archiveTable" class="table table-bordered table-hover" cellspacing="0" width="100%">
			 <thead>
			    <tr>
					<th>Request ID</th>
			    	<th>Requester ID</th>
			    	<th>Resolver ID</th>
			    	<th>Date Requested</th>
			    	<th>Date Resolved</th>
			        <th>Amount</th>
					<th>Purpose</th>
					<th>State</th>
					<th>Note</th>

			    </tr>
			</thead>
			<tbody>
				<#list arcReimbursements as arcR>
			    <tr>
					<td>${arcR.getRequestId()}</td>
			    	<td>${arcR.getRequesterId()}</td>
			    	<td>${arcR.getResolverId()}</td>
			    	<td>${arcR.getDateRequested()}</td>
			    	<td>${arcR.getDateResolved()}</td>
			        <td>${arcR.getAmount()}</td>
					<td>${arcR.getPurpose()}</td>
					<td>${arcR.getStateName()}</td>
					<td>${arcR.getNotes()}</td>
			
			    </tr>
			    </#list>
			</tbody>
		</table>
	</div>
	
	

	
	
	
	<div class="container">
		  <!-- Modal -->
		  <div class="modal fade" id="viewEmployeesModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Employees</h4>
		        </div>
			        <div class="modal-body">
			          
			          <table id="employeesTable" class="table table-bordered table-hover" cellspacing="0" width="100%">
						 <thead>
						    <tr>
								<th>Employee ID</th>
						    	<th>First Name</th>
						    	<th>Last Name</th>
			
						    </tr>
						</thead>
						<tbody>
							<#list employees as emp>
						    <tr>
								<td>${emp.getId()}</td>
						    	<td>${emp.getFirstName()}</td>
						    	<td>${emp.getLastName()}</td>
						    </tr>
						    </#list>
						</tbody>
					</table>
			         
	
		      </div>    
		    </div>
		  </div> 
		</div>
	

	
		
		
		<div class="container">
		  <!-- Modal -->
		  <div class="modal fade" id="addEmployeeModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Add Employee</h4>
		        </div>
		        <form class="form-newEmployee" method="POST" action="addEmployee">
			        <div class="modal-body">
			          <p>Enter employee information</p>
			          <input type="text" class="form-control" name="username" placeholder="Username" required="required"/>
			          <input type="text" class="form-control" name="password" placeholder="Password" required="required"/>
			          <input type="text" class="form-control" name="firstName" placeholder="First Name" required="required"/>
			          <input type="text" class="form-control" name="lastName" placeholder="Last Name" required="required"/>
			          <label class="radio-inline"><input type="radio" value="manager" name="isManager">Manager</label>
					  <label class="radio-inline"><input type="radio" value="employee" checked="checked" name="isManager">Employee</label>
			        </div>
			         <div class="modal-footer">
			          <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit Employee"/>
			        </div>
		        </form>
		      </div>    
		    </div>
		  </div> 
		</div>
		
		
		
		
		
		
		
		
		
		
		
		<div class="container">
		  <!-- Modal -->
		  <div class="modal fade" id="updateEmployeeModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Update Employee Information</h4>
		        </div>
		        <form class="form-updateEmployee" method="POST" action="updateEmployee">
			        <div class="modal-body">
			          <p>Enter Updated Information</p>
			          <input type="text" class="form-control" name="username" placeholder="Username" required="required"/>
			          <input type="text" class="form-control" name="password" placeholder="Password" required="required"/>
			          <input type="text" class="form-control" name="firstName" placeholder="First Name" required="required"/>
			          <input type="text" class="form-control" name="lastName" placeholder="Last Name" required="required"/>
			        </div>
			        <div class="modal-footer">
			          <input type="submit" class="btn btn-lg btn-primary btn-block" value="Update Information"/>
			        </div>
		        </form>
		      </div>    
		    </div>
		  </div> 
		</div>
		
		
		<div class="container">
		  <!-- Modal -->
		  <div class="modal fade" id="updateReimbursementModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Aprove or Deny Reimbursement</h4>
		        </div>
		        <form class="form-updateReimbursement" method="POST" action="updateReimbursement">
			        <div class="modal-body">
			          <p>Enter Update</p>
			          <input type="hidden" class="form-control" id="requestId" name ="requestID" value="">
			          <input type="text" class="form-control" name="notes" placeholder="Note" required="required"/>
			          <label class="radio-inline"><input type="radio" value="2" name="stateId">Approve</label>
					  <label class="radio-inline"><input type="radio" value="3" checked="checked" name="stateId">Deny</label>
			        </div>
			        <div class="modal-footer">
			          <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit"/>
			        </div>
		        </form>
		      </div>    
		    </div>
		  </div> 
		</div>
		
		
	</body>
</html>