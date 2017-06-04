<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login/Register - FakeBank Banking</title>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	 crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	 crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	 crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	 crossorigin="anonymous"></script>
   <script src="../js/demo.js" crossorigin="anonymous"></script>
</head>
<body>
  <h1>Welcome to FakeBank Banking</h1>
  <hr>
  
  

  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <#if loginAttempted??>
          <#if loginAttempted>
            <div class="alert alert-danger alert-dismissible" role="alert">
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
              <strong></strong> Incorrect email address or password. Please try again.
            </div>
          </#if>
        </#if>
      
        <form name="loginForm" method="POST" action="login">
          <table>
            <tr class="form-group"><td>Email:</td><td><input type="email" name="em" class="form-control" required/></td></tr>
            <tr class="form-group"><td>Password:</td><td><input type="password" name="pw" class="form-control" required/></td></tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="submit" value="Login" name="LoginButton" class="btn btn-default"/></td>
            </tr>
          </table>
        </form>
      </div>
      <div class="col-md-6">
        <#if registerAttempted??>
          <#if registerAttempted>
            <div class="alert alert-danger alert-dismissible" role="alert">
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
              <strong></strong> Incorrect email address or password. Please try again.
            </div>
          </#if>
        </#if>
      
        <form name="registerForm" method="POST" action="register">
          <table>
            <tr class="form-group"><td>Email:</td><td><input type="text" name="em" class="form-control"/></td></tr>
            <tr class="form-group"><td>Password:</td><td><input type="password" name="pw" class="form-control"/></td></tr>
            <tr class="form-group"><td>First name:</td><td><input type="text" name="fn" class="form-control"/></td></tr>
            <tr class="form-group"><td>Last name:</td><td><input type="text" name="ln" class="form-control"/></td></tr>
            <tr>
              <td>&nbsp;</td>
              <td><input type="submit" value="Register" name="RegisterButton" class="btn btn-default"/></td>
            </tr>
          </table>
        </form>
      </div>
    </div>
  </div>
  
</body>
</html>