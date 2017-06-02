<html>
<head>
    <title>User Info</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid" style="width:30%; margin-top: 10em;">
    <h3>${user.getLastName()}, ${user.getFirstName()}</h3>

    <table class="table table-hover">
        <tr>
            <th>Account #</th>
            <th>Type</th>
            <th>Balance</th>
        </tr>
        <#list accounts as account>
            <#if !(account.getClosed()??) >
                <tr>
                    <td>${account.getId()}</td>
                    <td>${account.getType().getName()}</td>
                    <td>$${account.getBalance()}</td>
                </tr>
            </#if>
        </#list>
    </table>

    <form name="logoutForm" action="/Logout" method="POST">
        <input class="form-control btn-primary" type="submit" name="logoutButton" value="Log out">
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />
</body>
</html>
