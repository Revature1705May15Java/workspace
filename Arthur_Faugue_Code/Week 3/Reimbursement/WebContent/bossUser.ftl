
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin.css" rel="stylesheet">

<link href="css/user.css" rel="stylesheet">

<style>
body {
	padding: 20px 20px;
}

.results tr[visible='false'], .no-result {
	display: none;
}

.results tr[visible='true'] {
	display: table-row;
}

.counter {
	padding: 8px;
	color: #ccc;
}
</style>

<script>
	ffunction doConfirm(msg, yesFn, noFn)
	{
	    var confirmBox = $("#confirmBox");
	    confirmBox.find(".message").text(msg);
	    confirmBox.find(".yes,.no").unbind().click(function()
	    {
	        confirmBox.hide();
	    });
	    confirmBox.find(".yes").click(yesFn);
	    confirmBox.find(".no").click(noFn);
	    confirmBox.show();
	}
	</script>
</head>

<body id="page-top">

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarExample"
			aria-controls="navbarExample" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="#">Refund Me</a>
		<div class="collapse navbar-collapse" id="navbarExample">
			<ul class="sidebar-nav navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="sort"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
				</li>
                <li class="nav-item">
                    <a class="nav-link" href="employee"><i class="fa fa-users"></i> Employees</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="user"><i class="fa fa-user fa-fw"></i> Personal Info.</a>
                </li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li><a class="navbar-brand pull-right" style="color: white">Welcome
						${firstname}</a></li>
				<li><form action="logout" method="post">
						<button type="submit"
							class="btn btn-danger btn-rounded pull-right"
							style="margin-top: -2px; margin-left: 5px;">Log Out</button>
					</form></li>
			</ul>
		</div>
	</nav>
	
	<!-- BEGIN # MODAL LOGIN -->
		<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    	<div class="modal-dialog">
			<div class="modal-content">
             
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                
                    <form role="form" action="user" method="post" data-toggle="validator">
				<br style="clear: both">
						<h3 style="margin-bottom: 25px; text-align: center;">Update
							Employee Info</h3>
						<div class="form-group">
					<input type="text" class="form-control" name="email"
						placeholder="Enter new email address" required>
				</div>
				<label for="inputPassword" class="control-label">Password</label>
				<div class="form-group">
					<input type="password" data-minlength="6" class="form-control"
						name="password" id="password" placeholder="Password" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" id="passwordC"
						data-match="#inputPassword"
						data-match-error="Whoops, these don't match"
						placeholder="Confirm password" required>
					<div class="help-block with-errors"></div>
				</div>

				<button type="submit" class="btn btn-lg btn-success btn-block">Submit
					Form</button>
			</form>
                    
                </div>
                <!-- End # DIV Form -->
                
			</div>
		</div>
	</div>
    <!-- END # MODAL LOGIN -->
	<div class="content-wrapper py-3">

		<div class="container-fluid">

			<!-- Breadcrumbs -->
			<ol class="breadcrumb">
				<li class="breadcrumb-item">Dashboard</li>
				<li class="breadcrumb-item active">Personal Info</li>
			</ol>

			<div class="container">
				<div class="row">


					<div>
						<div class="panel-heading">
							<h4 style="color: #00b1b1;">${firstname} ${lastname}'s
								Employee Info.</h4>
						</div>

						<div class="panel-body">

							<div class="box box-info">

								<div class="box box-info">

									<div class="box-body">
										<button class="btn btn-success" data-toggle="modal"
											data-target="#update">Update Employee Info.</button>
										<div class="clearfix"></div>
										<hr style="margin: 5px 0 5px 0;">


										<div class="col-sm-5 col-xs-6 tital ">First Name: ${firstname}</div>
										<div class="col-sm-7 col-xs-6 "></div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-5 col-xs-6 tital ">Last Name: ${lastname}</div>
										<div class="col-sm-7"></div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>

										<div class="col-sm-5 col-xs-6 tital ">User Name: ${email}</div>
										<div class="col-sm-7"></div>
										<div class="clearfix"></div>
										<div class="bot-border"></div>
									</div>

								</div>
							</div>
						</div>

					</div>
				</div>

			</div>


		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /.content-wrapper -->

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-chevron-up"></i>
	</a>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/tether/tether.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/sb-admin.min.js"></script>
	
	<script type="text/javascript">
	$('form').on('submit',function(){
		   if($('#password').val()!=$('#passwordC').val()){
		       alert('Password not matches');
		       return false;
		   }
		   return true;
		});
	
	</script>
</body>

</html>
