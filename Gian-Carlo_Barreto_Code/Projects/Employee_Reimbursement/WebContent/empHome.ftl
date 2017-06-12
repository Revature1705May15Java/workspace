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
		 <h1> Welcome ${firstname} ${lastname} to the Employee Homepage</h1>
		<!--<h1> Welcome John Doe to the Employee Homepage</h1> -->
		<h3> What would you like to do?</h3>
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
	
	<div class="row">
		<div class="col-xs-6 col-md-4">
			<a href="submitRequest.ftl" class="thumbnail">
				<h4>Submit Reimbursement Request</h4>
			</a>
		</div>
		
		<div class="col-xs-6 col-md-4">
			<a href="reimbView" class="thumbnail">
				<h4>View Reimbursements</h4>
			</a>
		</div>
		
		<div class="col-xs-6 col-md-4">
			<a href="personalView.ftl" class="thumbnail">
				<h4>View Personal Information</h4>
			</a>
		</div>
	</div>
	
	<div class="row">
		<div class="col-xs-6 col-md-4">
			<a href="updateInfo.ftl" class="thumbnail">
				<h4>Update Personal Information</h4>
			</a>
		</div>
		
		<div class="col-xs-6 col-md-4">
			<a href="logout" class="thumbnail">
				<h4>Logout</h4>
			</a>
		</div>
	</div>
</body>
</html>