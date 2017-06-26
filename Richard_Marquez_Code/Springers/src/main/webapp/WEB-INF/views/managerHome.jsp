<html>
<head>
    <title>Manager Home</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h2>manager home!</h2>

    <input autofocus id="email" type="text" name="email" placeholder="email">
    <input id="password" type="password" name="password" placeholder="password">
    <input id="firstName" type="text" name="firstName" placeholder="First Name">
    <input id="lastName" type="text" name="lastName" placeholder="Last Name">
    <input id="isManager" type="number" name="isManger" placeholder="0">

    <button id="submitBtn">Add Employee</button>

<script>
    function addEmployee(email, password, firstName, lastName, isManager, callback) {
        console.log('in add empl');
        $.post('/addEmployee',
            {email: email, password: password, firstName: firstName, lastName: lastName, isManager: isManager},
            function (data) {
                console.log('in return');
                callback(data);
            }
        );
    }


    $('#submitBtn').click(function() {
        addEmployee($('#email').val(), $('#password').val(), $('#firstName').val(), $('#lastName').val(), $('#isManager').val(), function (res) {
            console.log(res);
        });
    });

</script>

</body>
</html>
