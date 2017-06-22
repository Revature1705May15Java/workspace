<!-- Update employee information modal -->
<div class="modal fade" id="requestActionModal" role="dialog">
	<div class="modal-dialog modal-lg">

    	<!-- Modal content-->
        <div class="modal-content">
        	<div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h4 class="modal-title">Request Action</h4>
        	</div>
        	<div class="modal-body">
          		<div class="row">
            		<div class="col-md-2"></div>
            		<div class="col-md-8">
 						<#include "/fm/forms/request_action_form.ftl">
            		</div>
        		</div>
        	</div>
      	</div>
	</div>
</div>