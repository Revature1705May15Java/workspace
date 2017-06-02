<html>
<head>
    <title>Bank Login</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid jumbotron">
    <h2>Welcome to Bank &middot; Revature</h2>
</div>

<div class="container-fluid" style="width:30%;">
    <form name="loginForm" action="/Login" method="POST">
        <input class="form-control" type="text" name="username" placeholder="youremail@domain.com"><br>
        <input class="form-control" type="password" name="password" placeholder="password"><br>
        <input class="form-control btn-primary" type="submit" value="Login">
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.min.js" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />
</body>
</html>
