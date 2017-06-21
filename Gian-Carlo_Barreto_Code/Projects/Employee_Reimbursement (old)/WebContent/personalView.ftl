<html>
<head>
	<!-- JQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.js" 
			integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  			crossorigin="anonymous">
	</script>
		
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

	<!-- Employee Home Page css file -->
	<link rel="stylesheet" type="text/css" href="css/empHome.css">
</head>
<body>
	<div class="page-header">
		<h1> Personal Information</h1>
	</div>
	
	<ul class="nav nav-pills">
	  <li role="presentation"><a href="empHome">Home</a></li>
	  
	  <!-- Personal Information Dropdown -->
	  <li role="presentation" class="dropdown">
	    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	      Personal <span class="caret"></span>
	    </a>
	    <ul class="dropdown-menu">
	      <li role="presentation"><a href="personalView.ftl">Info</a></li>
	      <li role="presentation"><a href="updateInfo.ftl">Update</a><li>
	    </ul>
	  </li>
	  
	  <!-- Request dropdown -->
	  <li role="presentation" class="dropdown">
	    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
	      Request <span class="caret"></span>
	    </a>
	    <ul class="dropdown-menu">
	    	<#if employee.isManager()>
	    	  <li role="presentation"><a href="#">View All</a></li>
		      <li role="presentation"><a href="#">View Pending</a><li>
		      <li role="presentation"><a href="#">View Resolved</a><li>
	    	<#else>
		      <li role="presentation"><a href="reimbView">View All</a></li>
		      <li role="presentation"><a href="submitRequest.ftl">Submit</a><li>
		    </#if>
	    </ul>
	  </li>
	  
	  <#if employee.isManager()>
	  	  <!-- Employee dropdown -->
		  <li role="presentation" class="dropdown">
		    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		      Employees <span class="caret"></span>
		    </a>
		    <ul class="dropdown-menu">
		      <li role="presentation"><a href="empsView">View All</a></li>
		    </ul>
		  </li>
	  </#if>
	  <li role="presentation"><a href="logout">Logout</a></li>
	</ul>
	
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Is A Manager</th>
				</tr>
			</thead>
			<tr>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>${employee.email}</td>
				<#if employee.isManager()>
					<td>YES</td>
				<#else>
					<td>NO</td>
				</#if>
			</tr>
		</table>
	</div>
</body>
</html>