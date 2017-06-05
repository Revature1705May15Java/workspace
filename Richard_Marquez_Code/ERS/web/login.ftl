<!DOCTYPE html>
<html>
<head>
    <title>Login &middot; RevatureERS</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Poppins">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>

<header>
    <h1><a href="/"><span class="glyphicon glyphicon-transfer" aria-hidden="true"></span> &middot; Revature<strong>ERS</strong></a></h1>
</header>

<div id="login-container" class="white-container container-fluid">
<#if login?? >
    <div class="alert alert-danger">
        <span>Login <strong>failed</strong></span>
    </div>
</#if>

    <form name="loginForm" action="/Login" method="POST">
        <input class="form-control" type="email" name="username" placeholder="youremail@domain.com" required="required"><br>
        <input class="form-control" type="password" name="password" placeholder="Password" required="required"><br>
        <input class="form-control btn-primary" type="submit" value="Login">
    </form>
</div>

<footer>
    <p>&copy; Blah, Blah Legalese, 2017</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/tablesorter/jquery.tablesorter.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
