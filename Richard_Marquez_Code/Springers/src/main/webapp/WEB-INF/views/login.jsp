<html>
<head>
    <title>Index</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>

<form action="/login" method="post">
    <input autofocus type="text" name="email" placeholder="email">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="login">
</form>

<script>
    function login(email, password, callback) {
        $.ajax({
            url: "/login",
            method: "POST",
            success: function (res, status, xhr) {
                callback(res);
            }
        });
    }

    function getEmployeeById(id, callback) {
        $.ajax({
            url: "/employee/" + id,
            method: "GET",
            success: function (res, status, xhr) {
                callback(res);
            }
        });
    }


</script>

</body>
</html>
