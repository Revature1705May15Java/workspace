<html>
	<head>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
		<script src="https://code.jquery.com/jquery-3.2.1.jsintegrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="crossorigin="anonymous"></script>
		
		<style type="text/css">
			@import "bourbon";
			
			body {
				background: #eee !important;	
			}
			
	
			
			.wrapper {	
				margin-top: 80px;
			  	margin-bottom: 80px;
			}
			
			.form-signin {
			  	max-width: 380px;
			  	padding: 15px 35px 45px;
			  	margin: 0 auto;
			  	background-color: #fff;
			  	border: 1px solid rgba(0,0,0,0.1);  
			}
			
			.form-control {
			  	position: relative;
			  	font-size: 16px;
			  	height: auto;
			  	padding: 10px;
				@include box-sizing(border-box);
			}
			
			input[type="text"] {
			  	margin-bottom: -1px;
			  	border-bottom-left-radius: 0;
			  	border-bottom-right-radius: 0;
			}
			input[type="password"] {
			 	margin-bottom: 20px;
			  	border-top-left-radius: 0;
			  	border-top-right-radius: 0;
			}

		</style>
		
	</head
	<body>
		<div class="wrapper">
		<form class="form-signin" method="POST" action="login">
			<h2 class="form-signin-heading">Please login</h2>
			<input type="text" class="form-control" name="username" placeholder="Username" required="required"/>
			<input type="password" class="form-control" name="password" placeholder="Password" required="required"/>
			<input type="submit" class="btn btn-lg btn-primary btn-block" value="Login"/>
		</form>
		</div>
		<#if login! == "fail">
			<div class="alert alert-warning alert-dismissable">
  				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  				Incorrect username or password!
			</div>
		</#if>
	</body>
</html>