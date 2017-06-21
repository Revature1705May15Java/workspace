<html>
	<head>
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
		
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
		<div class="container">
		    <div class="row">
		        <div class="col-sm-6 col-md-4 col-md-offset-4">
		            <h1 class="text-center login-title">ERS Sign In</h1>
		            <div class="account-wall">
		                <img class="profile-img" src="img/profile-pic.png" alt="">
		                
		                <!-- Freemarker  -->
		                <#if login! == "not found">
							<div class="alert alert-danger" role="alert"> Incorrect Email </div>
						<#elseif login! == "wpass">
							<div class="alert alert-danger" role="alert"> Incorrect Password </div>
						</#if>
						
		                <form class="form-signin" name="loginform" action="login" method="POST">
		                <input type="email" class="form-control" name="email" placeholder="Email" required autofocus>
		                <input type="password" class="form-control password" name="password" placeholder="Password" required>
		                <input type="checkbox" id="showhide"> Show password <br><br>
		                <button class="btn btn-lg btn-primary btn-block" type="submit">
		                    Sign in</button>
				    </div>
				</div>
			</div>
		</div>
		
	<script type="text/javascript" src="js/login.js"></script>
	</body>
</html>