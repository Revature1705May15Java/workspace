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
					<td><button id="request-action-btn" class="btn btn-default" type="button">Action</button></td>
				</#if>
			</tr>
		</#list>
		</tbody>
	</table>
</div>