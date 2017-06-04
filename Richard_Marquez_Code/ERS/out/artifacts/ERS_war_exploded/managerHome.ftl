<!DOCTYPE html>
<html>
<head>
    <title>Home</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div class="container-fluid" style="width:30%; margin-top: 10em;">
    <h2>Manager</h2>
    <h3>${user.getLastName()}, ${user.getFirstName()}</h3>

    <form name="logoutForm" action="/Logout" method="POST">
        <input class="form-control btn-primary" type="submit" name="logoutButton" value="Log out">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
