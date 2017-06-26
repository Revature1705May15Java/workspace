<!DOCTYPE html>
<html>
<head>
	<title>Employee Reimbursement System</title>
	<#include "/fm/head/bootstrap.ftl">
</head>
<body>
	<div class="container">
		<#include "/fm/header_footer/header.ftl">
		
		<#if user??>
			<#include "/fm/nav/navbar.ftl">
			<!-- include content -->
			<#include "/fm/content/content.ftl">
			<!-- include modal -->
			<#include "/fm/modals/update_employee_modal.ftl">
			<#include "/fm/modals/request_action_modal.ftl">
			
			<script type="text/javascript" src="js/requestAction.js"></script>
		<#else>
			<#include "/fm/forms/login.ftl">
		</#if>
		
		
		<#include "/fm/header_footer/footer.ftl">
	</div>
	
		
</body>
</html>