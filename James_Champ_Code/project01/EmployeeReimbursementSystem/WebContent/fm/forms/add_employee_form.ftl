<!-- Add new employee form -->
<div id="add-employee">
	<h2>Add Employee</h2>
	<form class="form-horizontal" action="register" method="POST">
    	<div class="form-group">
        	<label class="control-label col-md-2" for="first-name">First Name:</label>
            <input type="text" id="first-name" name="fname"/>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="last-name">Last Name:</label>
            <input type="text" id="last-name" name="lname"/>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="email">Email:</label>
            <input type="email" id="email" name="email"/>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="password">Password:</label>
            <input type="password" id="password" name="password"/>
        </div>
        <div class="form-group">
            <label class="control-label col-md-2" for="manager">Manager:</label>

            <div class="radio-inline">
  	        	<input type="radio" name="manager" value="no" checked><label>No</label>
            </div>
            	<div class="radio-inline">
                	<input type="radio" name="manager" value="yes"><label>Yes</label>
              	</div>
            </div>
        <button type="submit" class="btn btn-success">Add Employee</button>
	</form>
</div>