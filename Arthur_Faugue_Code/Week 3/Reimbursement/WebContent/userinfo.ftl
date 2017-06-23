<!DOCTYPE html PUBLIC>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"
	rel="stylesheet" media="all">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" media="all" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"
	rel="stylesheet" media="all" />
	
	<link href="css/user.css" rel="stylesheet">

<title>Reimbursement</title>
</head>
<body>
	<div class="navbar-wrapper">

		<nav class="navbar navbar-inverse navbar-static-top navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand">Refund Me</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="#request" data-toggle="modal"
							data-target="#request">Make Request</a></li>
						<li><a href="sort">View Request</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a class="navbar-brand pull-right">Welcome
								${firstname}</a></li>
						<li><form action="logout" method="post">
								<button type="submit"
									class="btn btn-danger btn-rounded pull-right"
									style="margin-top: 8px; margin-left: 5px;">Log Out</button>
							</form></li>

					</ul>
				</div>
			</div>
		</nav>

	</div>

	<div id="request" class="modal" role="dialog">
		<div class="container bs-nopadding text-center well">
			<form role="form" action="requested" method="post">
				<br style="clear: both">
				<h3 style="margin-bottom: 25px; text-align: center;">Request
					Form</h3>
				<div class="form-group">
					<input type="number" min="1" step="0.01" class="form-control" name="amount"
						placeholder="Enter Requested Amount" pattern="(0\.((0[1-9]{1})|([1-9]{1}([0-9]{1})?)))|(([1-9]+[0-9]*)(\.([0-9]{1,2}))?)" required>
				</div>
				<div class="form-group">
					<textarea class="form-control" type="text" name="purpose"
						placeholder="Purpose (Optional)" maxlength="500" rows="7"></textarea>
					<span class="help-block"><p id="characterLeft"
							class="help-block ">You have reached the limit of 500
							characters.</p></span>
				</div>

				<button type="submit" class="btn btn-lg btn-success btn-block">Submit
					Form</button>
			</form>
		</div>
	</div>

	<div id="update" class="modal" role="dialog">
		<div class="container bs-nopadding text-center well">
			<form role="form" action="user" method="post" data-toggle="validator" id="formUpdate">
				<br style="clear: both">
				<h3 style="margin-bottom: 25px; text-align: center;">Update
					Employee Info</h3>
				<div class="form-group">
					<input type="text" class="form-control" name="email"
						placeholder="Enter new user name" required>
				</div>
				<label for="inputPassword" class="control-label">Password</label>
				<div class="form-group">
					<input type="password" data-minlength="6" class="form-control"
						name="password" id="password" placeholder="Password" required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control"
						id="passwordC" data-match="#inputPassword"
						data-match-error="Whoops, these don't match" placeholder="Confirm password"
						required>
						<div class="help-block with-errors"></div>
				</div>
				
				<button type="submit" class="btn btn-lg btn-success btn-block">Submit
					Form</button>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="container">

			<div class="container">
				<div class="row">
					<h2>Refund Me</h2>


					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 style="color: #00b1b1;">${firstname} ${lastname}'s
								Employee Info.</h4>
						</div>

						<div class="panel-body">

							<div class="box box-info">

								<div class="box box-info">

									<div class="box-body">
										<div class="col-sm-6">
											<h4 style="color: #00b1b1;">${firstname} ${lastname}</h4>
											</span> <span><p>Employee</p></span>
										</div>
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
			<script type="text/javascript">
			$('#formUpdate').on('submit',function(){
				   if($('#password').val()!=$('#passwordC').val()){
				       alert('Passwords do not match!');
				       return false;
				   }
				   return true;
				});
			</script>
</body>
</html>