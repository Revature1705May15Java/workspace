<!DOCTYPE html>
<html>
<head>
    <title>Home &middot RevatureERS</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Poppins">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <#--<link rel="stylesheet" type="text/css" href="/js/tablesorter/themes/blue/style.css">-->
</head>
<body>

<header>
    <h1><a href="/"><span class="glyphicon glyphicon-transfer" aria-hidden="true"></span> &middot; Revature<strong>ERS</strong></a></h1>

    <nav>
        <ul>
            <a id="newRequest" href="#"><li>New Request</li></a>
            <a id="accountInfo" href="/Account"><li>Account</li></a>
            <a id="logout" class="btn btn-primary" href="/Logout"><li>Log Out</li></a>
        </ul>
    </nav>
</header>

<#--<div>-->
    <#--<h2>Employee</h2>-->
    <#--<h3>${user.getLastName()}, ${user.getFirstName()}</h3>-->
<#--</div>-->

<div id="pendingRequests" class="white-container request-table-container container-fluid">
    <h3><strong>Open</strong> Requests</h3>
    <table id="pendingRequestsTable" class="table table-hover tablesorter">
        <thead>
        <tr>
            <th class="col-xs-1">Status</th>
            <th class="col-xs-1">#</th>
            <th class="col-xs-6">Purpose</th>
            <th class="col-xs-2">Amount</th>
            <th class="col-xs-2">Opened</th>
        </tr>
        </thead>

        <tbody>
        <#list pendingRequests as r>
            <tr id="request${r.getId()}">
                <td class="col-xs-1 state">${r.getState().name()}</td>
                <td class="col-xs-1 id">${r.getId()}</td>
                <td class="text col-xs-6 pupose"><span>${r.getPurpose()}</span></td>
                <td class="col-xs-2 amount">${r.getAmount()?string.currency}</td>
                <td class="col-xs-2 dateRequested">${r.getDateRequested()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<div id="resolvedRequests" class="white-container request-table-container container-fluid">
    <h3><strong>Resolved</strong> Requests</h3>

    <table id="resolvedRequestsTable" class="table table-hover tablesorter">
        <thead>
            <tr>
                <th class="col-xs-1">Status</th>
                <th class="col-xs-1">#</th>
                <th class="col-xs-5">Purpose</th>
                <th class="col-xs-1">Amount</th>
                <th class="col-xs-2">Opened</th>
                <th class="col-xs-2">Closed</th>
            </tr>
        </thead>

        <tbody>
        <#list resolvedRequests as r>
            <tr id="request${r.getId()}">
                <td class="col-xs-1 state">${r.getState().name()}</td>
                <td class="col-xs-1 id">${r.getId()}</td>
                <td class="text col-xs-5 purpose"><span>${r.getPurpose()} sklj fldj fsjd flsd jfs dkjsdl</span></td>
                <td class="col-xs-1 amount">${r.getAmount()?string.currency}</td>
                <td class="col-xs-2 dateRequested">${r.getDateRequested()}</td>
                <td class="col-xs-2 dateResolved">${r.getDateResolved()}</td>
                <td class="note" style="display:none;">${r.getNote()}</td>
                <td class="handler" style="display:none;">${r.getHandlerEmail()}</td>
            </tr>
        </#list>
        </tbody>
    </table>
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
