<!-- Update employee information modal -->
<div class="modal fade" id="updateEmployeeModal" role="dialog">
	<div class="modal-dialog modal-lg">

    	<!-- Modal content-->
        <div class="modal-content">
        	<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 class="modal-title">Employee Information</h4>
        	</div>
        	<div class="modal-body">
          		<div class="row">
            		<div class="col-md-4">
              			<p id="emp-name"><strong>Name:</strong> ${user.firstName} ${user.lastName}</p>
              			<p id="emp-email"><strong>Email:</strong> ${user.email}</p>
            		</div>
            		<div class="col-md-8">
              			<p>Update your information here:</p>
              			<form class="form-horizontal">
                			<div class="form-group">
                  				<label class="control-label col-md-5" for="new-first-name">First Name:</label>
                  				<input type="text" id="new-first-name"></input>
                			</div>
                			<div class="form-group">
                  				<label class="control-label col-md-5" for="new-last-name">Last Name:</label>
                  				<input type="text" id="new-last-name"></input>
                			</div>
                			<div class="form-group">
                  				<label class="control-label col-md-5" for="new-email-form">Email:</label>
                  				<input type="email" id="new-email-form"></input>
                			</div>
                			<div class="form-group">
                  				<label class="control-label col-md-5" for="new-pwd">Password:</label>
                  				<input type="password" id="new-pwd"></input>
                			</div>
                			<div class="form-group">
                  				<label class="control-label col-md-5" for="confirm-new-pwd">Confirm Password:</label>
                  				<input type="password" id="confirm-new-pwd"></input>
                			</div>
                			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                			<button type="button" class="btn btn-default" data-dismiss="modal">Update</button>
              			</form>
            		</div>
        		</div>
        	</div>
      	</div>
	</div>
</div>