<html>
	<head>
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="crossorigin="anonymous"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		
		
		<style type="text/css">
			
			body {
				background: #eee !important;	
			}
			
			.container {	
				margin-top: 80px;
			  	margin-bottom: 80px;
			}
			
			.form-newUser {
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
		<#if employee??>
    		${employee.getFirstName()} ${employee.getLastName()}
		</#if>
		<h3>MANAGER HOME PAGE</h3>
		
		<div class="container">
		  <!-- Trigger the modal with a button -->
		  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Add Employee</button>
		
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
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
			          <label class="radio-inline"><input type="radio" value="true" name="optradio">Manager</label>
					  <label class="radio-inline"><input type="radio" value="false" checked="checked" name="optradio">Employee</label>
			        </div>
			        <div class="modal-footer">
			          <input type="submit" class="btn btn-lg btn-primary btn-block" value="Add Employee"/>
			        </div>
		        </form>
		      </div>    
		    </div>
		  </div> 
		</div>
		
		<form class="form-signout" method="POST" action="logout">
			<input type="submit" class="btn btn-lg btn-primary btn-block" value="Logout"/>
		</form>
	</body>
</html>