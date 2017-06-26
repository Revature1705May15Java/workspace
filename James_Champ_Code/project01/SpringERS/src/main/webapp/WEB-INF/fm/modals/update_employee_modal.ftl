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
 						<#include "/fm/forms/update_employee_form.ftl">
            		</div>
        		</div>
        	</div>
      	</div>
	</div>
</div>