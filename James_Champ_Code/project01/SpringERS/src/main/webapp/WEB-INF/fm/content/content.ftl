<div class="main-content">
	<div class="row">
		<div class="col-md-1"></div>
			<div class="col-md-10">
				<#switch state>
					<#case "pending">
						<#include "/fm/tables/view_all_pending_requests.ftl">
						<script>setClass("#viewPending")</script>
						<#break>
					<#case "resolved">
						<#include "/fm/tables/view_all_resolved_requests.ftl">
						<script>setClass("#viewResolved")</script>
						<#break>
					<#case "viewEmployees">
						<#include "/fm/tables/view_all_employees.ftl">
						<script>setClass("#viewEmployees")</script>						
						<#break>
					<#case "addEmployee">
						<#include "/fm/forms/add_employee_form.ftl">
						<script>setClass("#register")</script>						
						<#break>
					<#case "createRequest">
						<#include "/fm/forms/create_request_form.ftl">
						<script>setClass("#submitRequest")</script>						
						<#break>
					<#case "viewEmployeesRequests">
						<#include "/fm/tables/view_employees_requests_table.ftl">
						<#break>
				</#switch>
			</div>
		<div class="col-md-1"></div>
	</div>
</div>