<!-- View resolved requests -->
<div id="view-resolved-requests">
	<h2>Resolved Requests</h2>
    <table class="table table-striped">
    	<thead>
	    	<tr>
	        	<th>ID #</th>
	            <th>Employee Name</th>
	            <th>Amount</th>
	            <th>Purpose</th>
	            <th>Date Opened</th>
	            <th>Date Closed</th>
	            <th>State</th>
	            <th>Closing Manager</th>
	            <th>Note</th>
	    	</tr>
    	</thead>
    	<tbody>
    		<#list requests as r>
				<tr>
					<td>${r.requestId}</td>
					<td>${r.requester.lastName}, ${r.requester.firstName}</td>
					<td>${r.amount?string.currency}</td>
					<td>${r.purpose}</td>
					<td>${r.openDate}</td>
					<td>${r.closeDate}</td>
					<td>${r.state.name}</td>
					<td>${r.manager.lastName}, ${r.manager.firstName}</td>
					<td>${r.note}</td>					
				</tr>
			</#list>
    	</tbody>
	</table>
</div>