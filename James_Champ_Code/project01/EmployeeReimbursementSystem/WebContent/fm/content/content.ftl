<div class="main-content">
	<div class="row">
		<div class="col-md-1"></div>
			<div class="col-md-10">
				<#switch state>
					<#case "pending">
						<#include "/fm/tables/view_all_pending_requests.ftl">
						<#break>
					<#case "resolved">
						<#include "/fm/tables/view_all_resolved_requests.ftl">
						<#break>
					<#case "viewEmployees">
						<#include "/fm/tables/view_all_employees.ftl">
						<#break>
					<#case "addEmployee">
						<#include "/fm/forms/add_employee_form.ftl">
						<#break>
					<#case "createRequest">
						<#include "/fm/forms/create_request_form.ftl">
						<#break>
				</#switch>
			</div>
		<div class="col-md-1"></div>
	</div>
</div>