<html>
<head>
    <title>Employee Home</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<h2>employee home!</h2>

<input autofocus id="amount" type="number" step="0.01" name="amount">
<input id="purpose" type="text" name="purpose" placeholder="purpose">

<button id="submitBtn">Add Request</button>

<script>
    function addRequest(amount, purpose, callback) {
        $.post('/addRequest',
            { amount: amount, purpose: purpose },
            function (data) {
                callback(data);
            }
        );
    }


    $('#submitBtn').click(function() {
        addRequest($('#amount').val(), $('#purpose').val(), function (res) {
            console.log(res);
        });
    });

</script>

</body>
</html>
