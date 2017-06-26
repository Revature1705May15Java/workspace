<form id="update-employee-form" class="form-horizontal" action="updateEmployee" method="POST">
	<div class="form-group">
        <label class="control-label col-md-5" for="new-first-name">First Name:</label>
    	<input type="text" id="new-first-name" name="fname"></input>
    </div>
    <div class="form-group">
		<label class="control-label col-md-5" for="new-last-name">Last Name:</label>
		<input type="text" id="new-last-name" name="lname"></input>
	</div>
	<div class="form-group">
		<label class="control-label col-md-5" for="new-email-form">Email:</label>
		<input type="email" id="new-email" name="email"></input>
	</div>
	<div class="form-group">
		<label class="control-label col-md-5" for="new-pwd">Password:</label>
		<input type="password" id="new-pwd" name="pwd"></input>
	</div>
	<div class="form-group">
		<label class="control-label col-md-5" for="confirm-new-pwd">Confirm Password:</label>
		<input type="password" id="confirm-new-pwd" name="pwd2"></input>
	</div>
	<button id="cancel-update-btn" type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
	<button id="update-btn" type="submit" class="btn btn-success">Update</button>
	
	<script type="text/javascript" src="js/validateUpdate.js"></script>
</form>