<!DOCTYPE html PUBLIC>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<title>COVFEFE</title>
</head>
<body>

	<div class="container">
		<div class="container">

			<div class="row" style="margin-top: 20px">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					
					<form name="user" action="login" method="post">
						<fieldset>
							<h2>Please Sign In</h2>
							<hr class="colorgraph">
							<#if login =="fail">
								<h3 style="color:red">Failed Username/Password is incorrect</h3>
							</#if>
							<div class="form-group">
								<input placeholder="Username" type="text" name="userName"
									class="form-control input-lg">
							</div>
							<div class="form-group">
								<input type="password" name="pwd" class="form-control input-lg"
									placeholder="Password">
							</div>
							<span class="button-checkbox">
								<button type="button" class="btn" data-color="info">Remember
									Me</button> <input type="checkbox" name="remember_me" id="remember_me"
								checked="checked" class="hidden"> <a href=""
								class="btn btn-link pull-right">Forgot Password?</a>
							</span>
							<hr class="colorgraph">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input type="submit" class="btn btn-lg btn-success btn-block"
										value="Sign In">
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<a href="" type="reset" class="btn btn-lg btn-danger btn-block">Clear</a>
								</div>
							</div>
						</fieldset>
					</form>
					
					
				</div>
			</div>

		</div>
	</div>


</body>
</html>