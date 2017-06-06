<!DOCTYPE html>
<html>
<head>
	<title>Employee List</title>
</head>

<body>
	<table class="datatable">
		<tr>
			<th>Employee #</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Manager</th>
		</tr>
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
	</table>
</body>
</html>