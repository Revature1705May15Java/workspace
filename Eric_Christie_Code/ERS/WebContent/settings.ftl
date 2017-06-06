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
    integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
    integrity="sha256-rDWX6XrmRttWyVBePhmrpHnnZ1EPmM6WQRQl6h0h7J8=" crossorigin="anonymous"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"
    integrity="sha256-eZNgBgutLI47rKzpfUji/dD9t6LRs2gI3YqXKdoDOmo=" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/icon-styles.css">

  <script src="./js/ers.js"></script>
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
        <a class="navbar-brand" href="home">
          <img alt="Brand" src="./img/favicons/ers-32.png"> Expense Reimbursement System
        </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li></li>
          <!--<li><button><i class="material-icons">settings</i> Account Settings</button></li>--> <!-- a button to show the user's profile settings -->
          <li>
            <a class="btn btn-default navbar-btn" href="settings">
              <i class="material-icons">settings</i> Account Settings
            </a>
          </li>
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

  <!-- MODALS -->

  

  <!-- include an exit X button near the top rigth corner of the page.
    possibly have it replace the logout button to prevent users from logging out from the settings page-->

  <form id="settingsForm" name="settingsForm" action="settings">

    <div class="form-group">
      <label for="employeeEmail">Email Address</label>
      <input type="email" name="em" class="form-control" id="employeeEmail" placeholder="Email"
        maxlength="100" value="${user.getEmail()}" autocomplete="email" required>
    </div>

    <div class="form-group">
      <#if user.getLatestLogout()??>
        <label for="employeePassword">Change Password</label>
        <input type="password" name="pw" class="form-control" id="employeePassword" placeholder="Password" value=""
          maxlength="100" minlength="8" onchange="activatePasswordConfirmation()"> <!-- what happens when minlength is specified for a non-required field? -->
        <!-- currently, password is not a required input -->
        <!-- make it so that the confirm password input only appears when the password field is changed -->
        <!-- set this input as required only when the password field has been changed -->
        <br>
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"
          maxlength="100" minlength="8">
      <#else>
        <!-- require new password if this is the user's first time logging in -->
        <label for="employeePassword">Change Password</label>
        <input type="password" name="pw" class="form-control" id="employeePassword" placeholder="Password" value=""
          maxlength="100" minlength="8" onchange="activatePasswordConfirmation()" autofocus required>
        <br>
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password"
          maxlength="100" minlength="8" required>
      </#if>
    </div>

    <div class="form-group">
      <label for="employeeFirstname">First name</label>
      <input type="email" name="fn" class="form-control" id="employeeFirstname" placeholder="First name"
        maxlength="100" value="${user.getFirstname()}" autocomplete="given-name" required>
    </div>

    <div class="form-group">
      <label for="employeeLastname">Last name</label>
      <input type="email" name="ln" class="form-control" id="employeeLastame" placeholder="Last name" 
        maxlength="100" value="${user.getLastname()}" autocomplete="family-name" required>
    </div>

    <div class="form-group">
      <#if user.isManager()>
        <label class="checkbox-inline" for="emailAlerts">
          Email Alerts: <input type="checkbox" name="ea" id="emailAlerts" value="emailAlertsOn" data-toggle="toggle" checked>
        </label>
      <#elseif user.isEmailAlertsOn()>
        <label class="checkbox-inline" for="emailAlerts">
          Email Alerts: <input type="checkbox" name="ea" id="emailAlerts" value="emailAlertsOn" data-toggle="toggle" checked>
        </label>
      <#else>
        <label class="checkbox-inline" for="emailAlerts">
          Email Alerts: <input type="checkbox" name="ea" id="emailAlerts" value="emailAlertsOn" data-toggle="toggle">
        </label>
      </#if>
    </div>

    <!-- unset the disabled attribute on the submit button when changes are made to the user's profile -->
    <button type="submit" id="saveSettings" class="btn btn-lg btn-success">Save Settings</button>
    <button type="reset" id="resetSettings" class="btn btn-lg btn-default" disabled="disabled">Reset</button>
  </form>
  
</body>
</html>