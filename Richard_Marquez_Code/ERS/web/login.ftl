<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div class="container-fluid jumbotron">
    <h2>Welcome to Revature &middot; ERS</h2>
</div>

<div class="container-fluid" style="width:30%;">
<#if login?? >
    <div class="alert alert-warning">
        <span>Login <em>failed</em></span>
    </div>
</#if>

    <form name="loginForm" action="/Login" method="POST">
        <input class="form-control" type="email" name="username" placeholder="youremail@domain.com" required="required"><br>
        <input class="form-control" type="password" name="password" placeholder="password" required="required"><br>
        <input class="form-control btn-primary" type="submit" value="Login">
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
