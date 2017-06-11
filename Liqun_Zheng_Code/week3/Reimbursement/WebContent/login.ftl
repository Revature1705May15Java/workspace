<!DOCTYPE html>
<html>

<head>
<style>
p.ex1 {
	margin-top: 8cm;
}


body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("https://www.paychex.com/a/i/articles/expense-reimbursement-101.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>

<meta charset="UTF-8">
<title>Bank App Login</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<body>
<div class="bg">
	
	<form name="loginform" action="login" method="POST">
	
		<div class="container">
			<div class="row">
				<div class="col-md-offset-4 col-md-5">
					<div class="form-login">
					<p class="ex1">
						<#if login=="fail">

						<h3 style="color:red"> Your login information is incorrect <h3>
						</#if>
					
						<h3 style="color: blue">Welcome to Reimbursement System</h3>
						<input type="text" id="userName"
							class="form-control input-sm chat-input" placeholder="username"
							name="username" /> </br> <input type="password" id="userPassword"
							class="form-control input-sm chat-input" placeholder="password"
							name="password" /> </br>
						<button class="btn btn-lg btn-primary" type="submit">Login</button>
					</p>
					</div>
					
				</div>
			</div>
		</div>
	
	</form>
	
</div>	



</body>
</html>