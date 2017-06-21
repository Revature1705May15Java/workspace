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
		<#else>
			<#include "/fm/forms/login.ftl">
		</#if>
		
		
		<#include "/fm/header_footer/footer.ftl">
	</div>
	
		
	<!-- scripts -->
	<script type="text/javascript" src="js/action.js"></script>
</body>
</html>