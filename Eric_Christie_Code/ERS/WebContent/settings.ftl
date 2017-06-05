<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Account Settings - Expense Reimbursement System</title>

	<link rel="shortcut icon" href="./img/favicons/ers.ico">
	<link rel="icon" sizes="16x16 32x32 64x64" href="./img/favicons/ers.ico">
	<link rel="icon" type="image/png" sizes="196x196" href="./img/favicons/ers-192.png">
	<link rel="icon" type="image/png" sizes="160x160" href="./img/favicons/ers-160.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./img/favicons/ers-96.png">
	<link rel="icon" type="image/png" sizes="64x64" href="./img/favicons/ers-64.png">
	<link rel="icon" type="image/png" sizes="32x32" href="./img/favicons/ers-32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="./img/favicons/ers-16.png">
	<link rel="apple-touch-icon" href="./img/favicons/ers-57.png">
	<link rel="apple-touch-icon" sizes="114x114" href="./img/favicons/ers-114.png">
	<link rel="apple-touch-icon" sizes="72x72" href="./img/favicons/ers-72.png">
	<link rel="apple-touch-icon" sizes="144x144" href="./img/favicons/ers-144.png">
	<link rel="apple-touch-icon" sizes="60x60" href="./img/favicons/ers-60.png">
	<link rel="apple-touch-icon" sizes="120x120" href="./img/favicons/ers-120.png">
	<link rel="apple-touch-icon" sizes="76x76" href="./img/favicons/ers-76.png">
	<link rel="apple-touch-icon" sizes="152x152" href="./img/favicons/ers-152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="./img/favicons/ers-180.png">
	<meta name="msapplication-TileColor" content="#FFFFFF">
	<meta name="msapplication-TileImage" content="./img/favicons/ers-144.png">
	<meta name="msapplication-config" content="./img/favicons/browserconfig.xml">

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"
    integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
    crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
    crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/icon-styles.css">

  <link rel="stylesheet" href="./css/ers.css">
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">
          <img alt="Brand" src="./img/favicons/ers-32.png"> Expense Reimbursement System
        </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="settings">Link</a></li>
          <li>
            <form class="navbar-form" role="logout" name="logoutForm" method="POST" action="logout">
              <!-- <input type="submit" value="Logout" name="LogoutButton" class="btn btn-default navbar-btn"/> -->
              <button type="button" class="btn btn-default navbar-btn"><i class="material-icons">exit_to_app</i> Logout</button>
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- include an exit X button near the top rigth corner of the page.
  possibly have it replace the logout button to prevent users from logging out from the settings page-->

  <form name="settingsForm" method="POST" action="settings">

    <div class="form-group">
      <label for="employeeEmail">Email Address</label>
      <#-- <div class="input-group"> -->
      <input type="email" class="form-control" id="employeeEmail" placeholder="Email" maxlength="100"
      value="${user.getEmail()}" required>
      <#-- </div> -->
    </div>

    <div class="form-group">
      <label for="employeePassword">Password</label>
      <#-- <div class="input-group"> -->
      <input type="password" class="form-control" id="employeePassword" placeholder="Password" value="SHOW DOTS OR ASTERISKS"
        maxlength="" required>
      <#-- </div> -->
    </div>

    <div class="form-group">
      <!-- make it so that the confirm password input only appears when the password field is changed -->
      <!-- set this input as required only when the password field has been changed -->
      <label for="confirmPassword">Confirm Password</label>
      <#-- <div class="input-group"> -->
      <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"
      maxlength="" pattern="SET PATTERN DYNAMICALLY WHEN PASSWORD IS MODIFIED">
      <#-- </div> -->
    </div>

    <div class="form-group">
      <label for="employeeFirstname">First name</label>
      <#-- <div class="input-group"> -->
      <input type="email" class="form-control" id="employeeFirstname" placeholder="First name" maxlength="100"
      value="${user.getFirstname()}" required>
      <#-- </div> -->
    </div>

    <div class="form-group">
      <label for="employeeLastname">Email Address</label>
      <#-- <div class="input-group"> -->
      <input type="email" class="form-control" id="employeeLastame" placeholder="Last name" maxlength="100"
      value="${user.getLastname()}" required>
      <#-- </div> -->
    </div>

    <!-- unset the disabled attribute on the submit button when changes are made to the user's profile -->
    <button type="submit" class="btn btn-lg btn-success" disabled="disabled">Save Changes</button>
    <button type="reset" class="btn btn-lg btn-default" disabled="disabled">Cancel</button>
  </form>
  
</body>
</html>