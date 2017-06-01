<html>
<head>
    <title>User Info</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid" style="width:30%; margin-top: 10em;">
    <p>
        ${currUser.getLastName()}, ${currUser.getFirstName()}
    </p>

    <form name="logoutForm" action="/Bank" method="POST">
        <input class="form-control btn-primary" type="submit" name="logoutButton" value="Logout">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />
</body>
</html>
