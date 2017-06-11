<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login - Expense Reimbursement System</title>

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

	<!--jQuery-->
  <script src="https://code.jquery.com/jquery-3.2.1.js"
    integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
    crossorigin="anonymous"></script>

  <!-- Tether -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
    integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
    crossorigin="anonymous"></script>

  <!--Bootstrap 4-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
    integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
    crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
    integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
    crossorigin="anonymous"></script>
  
  <!--Material Design Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/icon-styles.css">

  <#-- <script src="./js/ers.js"></script> -->
  <link rel="stylesheet" href="./css/ers.css">
</head>
<body class="login">
  <div class="container">
    <#if loginAttempted??>
      <#if loginAttempted>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
          <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <i class="material-icons">close</i>
          </button>
          <i class="material-icons vert-align-middle">error</i> Incorrect email address or password. Please try again.
        </div>
      </#if>
    </#if>

    <form name="loginForm" class="form-login" method="POST" action="login">
      <h2 class="form-login-heading">Login</h2>
      <label for="loginEmail" class="sr-only">Email address</label>
      <input type="email" name="em" id="loginEmail" class="form-control" placeholder="Email address" required autofocus>
      <label for="loginPassword" class="sr-only">Password</label>
      <input type="password" name="pw" id="loginPassword" class="form-control" placeholder="Password" required>
      <br><!--remove this if you include the checkbox in the form-->
      <!--
      <div class="form-check checkbox">
        <label class="form-check-label">
          <input type="checkbox" class="form-check-input" name="useFallbackClient" value="true">
          I don't want to use the fancy client
        </label>
      </div>
      -->
      <button type="submit" class="btn btn-lg btn-primary btn-block">
        <span class="align-middle">Login&nbsp;&nbsp;</span><i class="material-icons align-middle">verified_user</i>
      </button>
    </form>
  </div>
</body>
</html>