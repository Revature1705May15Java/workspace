<!-- View pending requests -->
<div id="view-pending-requests">
	<h2>Pending Requests</h2>
    <table class="table table-striped">
    	<thead>
	        <tr>
	        	<th>ID #</th>
	            <th>Employee Name</th>
	            <th>Amount</th>
	            <th>Purpose</th>
	            <th>Date Opened</th>
	            <#if user.isManager>
	            	<th>Action</th>
	            </#if>
			</tr>
		</thead>
		<tbody>
		<#list pendingRequests as pr>
			<tr>
				<td>${pr.requestId}</td>
				<td>${pr.requester.lastName}, ${pr.requester.firstName}</td>
				<td>${pr.amount?string.currency}</td>
				<td>${pr.purpose}</td>
				<td>${pr.openDate}</td>
				<#if user.isManager>
					<td>
						<div class="btn-group">
  							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    						Action <span class="caret"></span>
  							</button>
  							<ul class="dropdown-menu">
   					 			<li class="approve-request"><a href="#requestActionModal" data-toggle="modal">Approve</a></li>
    							<li class="deny-request"><a href="#requestActionModal" data-toggle="modal">Deny</a></li>
    							<li role="separator" class="divider"></li>
    							<li class="view-employees-requests"><a href="#">View Employee's Requests</a></li>
  							</ul>
						</div>
					</td>
				</#if>
			</tr>
		</#list>
		</tbody>
	</table>
</div>