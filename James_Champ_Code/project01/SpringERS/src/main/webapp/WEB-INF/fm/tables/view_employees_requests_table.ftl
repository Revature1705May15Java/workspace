<!-- View resolved requests -->
<div id="view-employees-requests">
	<h2>Requests</h2>
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
					<td>
						<#if r.closeDate??>
							${r.closeDate}
						<#else>
							N/A
						</#if>
					</td>
					<td>${r.state.name}</td>
					<td>
						<#if r.manager??>
							${r.manager.lastName}, ${r.manager.firstName}
						<#else>
							N/A
						</#if>
					</td>
					<td>
						<#if r.note??>
							${r.note}
						</#if>
					</td>					
				</tr>
			</#list>
    	</tbody>
	</table>
</div>