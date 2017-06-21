<!-- View all employees form -->
<div id="view-employees">
	<h2>Employees</h2>
	<table class="table table-striped">
		<thead>
		<tr>
			<th>Employee #</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Manager</th>
		</tr>
		</thead>
		<tbody>
			<#list employees as e>
			<tr>
				<td>${e.employeeId}</td>
				<td>${e.firstName}</td>
				<td>${e.lastName}</td>
				<td>${e.email}</td>
				<#if e.isManager>
					<td>Yes</td>
				<#else>
					<td>No</td>
				</#if>
			</tr>
			</#list>
		</tbody>
	</table>
</div>