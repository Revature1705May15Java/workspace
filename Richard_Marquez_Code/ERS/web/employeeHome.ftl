<!DOCTYPE html>
<html>
<head>
    <title>Home &middot RevatureERS</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Poppins">
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>

<header>
    <h1><a href="/"><span class="glyphicon glyphicon-transfer" aria-hidden="true"></span> &nbsp;Revature<strong>ERS</strong></a></h1>

    <nav>
        <ul>
            <a id="newRequest" href="#">
                <li data-toggle="modal" data-target="#newRequestModal"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> &nbsp;New Request</li>
            </a>
            <a id="accountInfo" href="/Account">
                <li><span class="glyphicon glyphicon-user" aria-hidden="true"></span> &nbsp;Account</li>
            </a>
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
            <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
                <td class="col-xs-1 state">${r.getState().name()}</td>
                <td class="col-xs-1 id">${r.getId()}</td>
                <td class="text col-xs-6 purpose"><span>${r.getPurpose()}</span></td>
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
            <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
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


<div class="modal fade" id="newRequestModal" tabindex="-1" role="dialog" aria-labelledby="newRequestModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title id" id="newRequestModalLabel">New Request</h4>
            </div>
            <form name="newRequestForm" action="/NewRequest" method="POST">
                <div class="modal-body">
                    <table class="table">
                        <tr>
                            <td>Request Date</td>
                            <td class="requestDate">${currentDate}</td>
                        </tr>
                        <tr>
                            <td>Amount</td>
                            <td><strong>$</strong> <input required="required" type="number" min="0.00" step="0.01" max="100000" placeholder="0.00" name="requestAmount"/></td>
                        </tr>
                        <tr>
                            <td>Purpose</td>
                            <td><textarea required="required" rows="5" cols="50" name="requestPurpose" placeholder="Why are you requesting reimbursement?"></textarea></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input type="submit" value="Submit" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>


<div class="modal fade" id="viewRequestModal" tabindex="-1" role="dialog" aria-labelledby="viewRequestModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title id" id="viewRequestModalLabel">New Request</h4>
                <h3 class="state">Status</h3>
            </div>
            <div class="modal-body">
                <table class="table">
                    <tr>
                        <td>Requested</td>
                        <td class="dateRequested"></td>
                    </tr>
                    <tr>
                        <td>Resolved</td>
                        <td class="dateResolved"></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td class="amount"></td>
                    </tr>
                    <tr>
                        <td>Purpose</td>
                        <td class="purpose"></td>
                    </tr>
                    <tr>
                        <td>Admin Note</td>
                        <td class="note"></td>
                    </tr>
                    <tr>
                        <td>Handled By</td>
                        <td class="handler"></td>
                    </tr>
                </table>
            </div>
        <#--<div class="modal-footer">-->
        <#--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
        <#--</div>-->
        </div>
    </div>
</div>


<footer>
    <p>&copy; Legalese and Stuffz, 2017</p>
</footer>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/tablesorter/jquery.tablesorter.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
