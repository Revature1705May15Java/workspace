<html>
<head>
<style>
body{
background-image: url("money-background.jpg");
background-repeat: no-repeat;
background-position: center;
background-size: cover;
background-attachment: fixed;
}
.loginboxes{

margin: -100px 0 0 -150px;

    padding: 10px;
    position: absolute;
    width: 300px;
    height: 200px;
    z-index: 15;
    top: 50%;
    left: 50%;

}
.page-header{
font-family: "Brush Script MT", cursive;
	text-align:center;
}

</style>
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">



<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="page-header">
<h1 style="background-color:Black; color:Red";>
ERS: <small style="color:Red; font-size:32px";>Let us take care of your expenses!</small>
</h1>
</div>
<div class = "loginboxes">
<div class="wrapper">
		<form action="login" method="POST" name="Login_Form" class="form-signin" >       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="email" class="form-control" name="email" placeholder="Email" required="required" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="Password" required="required"/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>		
<#if login! =="fail">
	<h3 style="color:red">Your login information is incorrect </h3>
	
</#if>	
	</div>
</div>
</body>
</html