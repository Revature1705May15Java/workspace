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
		<h1> List of Your Reimbursements</h1>
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
	      <li role="presentation"><a href="reimbView">View All</a></li>
	      <li role="presentation"><a href="submitRequest.ftl">Submit</a><li>
	    </ul>
	  </li>
	  <li role="presentation"><a href="logout">Logout</a></li>
	</ul>
	
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Request Id</th>
					<th>State</th>
					<th>Amount</th>
					<th>Open Date</th>
					<th>Close Date</th>
					<th>Purpose</th>
					<th>Manager Id</th>
					<th>Note</th>
				</tr>
			</thead>
			<#list requests as request>
			<tr>
				<td>${request.requestId}</td>
				<td>${request.type}</td>
				<td>${request.amount}</td>
				<td>${request.openDate}</td>
				<#if (request.closeDate)??>
					<td>${request.closeDate}</td>
				<#else>
					<td></td>
				</#if>
				<#if (request.purpose)??>
					<td>${request.purpose}</td>
				<#else>
					<td></td>
				</#if>
				<#if request.managerId! == 0>
					<td></td>
				<#else>
					<td>${request.managerId}</td>
				</#if>
				<#if (request.managerNote)??>
					<td>${request.managerNote}</td>
				<#else>
					<td></td>
				</#if>
			</tr>
			</#list>
		</table>
	</div>
</body>
</html>