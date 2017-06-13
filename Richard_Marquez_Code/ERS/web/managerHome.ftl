<#include "./header.ftl">

<div class="container-fluid">
    <div id="managerMain" class="row">
        <div id="managerPendingRequestsTableContainer" class="white-container request-table-container col-xs-10 col-xs-offset-1 col-md-5 col-md-offset-1">
            <h3><strong>Open</strong> Requests</h3>
            <table id="pendingRequestsTable" class="table table-hover tablesorter">
                <thead>
                <tr>
                    <th class="col-md-1">#</th>
                    <th class="col-md-3 hidden-xs hidden-sm">Opened</th>
                    <th class="col-md-5 hidden-xs hidden-sm">Purpose</th>
                    <th class="col-md-1">Requester</th>
                    <th class="col-md-2">Amount</th>
                </tr>
                </thead>

                <tbody>
                <#list pendingRequests as r>
                <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
                    <td class="id">${r.getId()}</td>
                    <td class="dateRequested hidden-xs hidden-sm">${r.getDateRequested()}</td>
                    <td class="text purpose hidden-xs hidden-sm"><span>${r.getPurpose()}</span></td>
                    <td class="requester">${r.getRequesterEmail()}</td>
                    <td class="amount">${r.getAmount()?string.currency}</td>
                    <td class="state" style="display:none;">${r.getState().name()}</td>
                </tr>
                </#list>
                </tbody>
            </table>
            <h4 id="noRequestsLabel" class="unavailable alert alert-warning" style="display:none;">No requests available</h4>
        </div>




        <div id="managerEmployeesTableContainer" class="white-container request-table-container col-xs-10 col-xs-offset-1 col-md-4 col-md-offset-1">
            <h3><strong>Employees</strong></h3>
            <table id="employeesTable" class="table table-hover tablesorter">
                <thead>
                <tr>
                    <th class="col-xs-4">First</th>
                    <th class="col-xs-4">Last</th>
                    <th class="col-xs-4">Email</th>
                </tr>
                </thead>

                <tbody>
                <#list allEmployees as e>
                    <tr id="employee${e.getId()}" data-toggle="modal" data-target="#viewEmployeeModal">
                        <td class="firstName">${e.getFirstName()}</td>
                        <td class="lastName">${e.getLastName()}</td>
                        <td class="email">${e.getEmail()}</td>
                        <td class="id" style="display:none;">${e.getId()}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>

    </div>
</div>



<div class="modal fade" id="viewRequestModal" tabindex="-1" role="dialog" aria-labelledby="viewRequestModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title id" id="viewRequestModalLabel">View Request</h4>
                <h3 class="state">Status</h3>
            </div>
            <form method="POST">
                <div class="modal-body">
                    <table class="table">
                        <tr>
                            <td>Requested</td>
                            <td class="dateRequested"></td>
                        </tr>
                        <tr>
                            <td>Employee Requesting</td>
                            <td class="requester"></td>
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
                            <td>Note</td>
                            <td><textarea class="form-control" name="note" placeholder="Add an administrative note here"></textarea></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <input type="hidden" class="requestId" name="requestId" value="">
                    <input formaction="/ApproveRequest" type="submit" class="btn btn-success" value="Approve">
                    <input formaction="/DenyRequest" type="submit" class="btn btn-danger" value="Deny">
                </div>
            </form>
        </div>
    </div>
</div>




<div class="modal fade" id="newUserModal" tabindex="-1" role="dialog" aria-labelledby="newUserModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title id" id="newUserModalLabel">New User</h4>
            </div>
            <form name="newUserForm" action="/NewUser" method="POST">
                <div class="modal-body">
                    <table class="table">
                        <tr>
                            <td>First Name</td>
                            <td>
                                <input class="form-control" required="required" type="text" name="firstName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td>
                                <input class="form-control" required="required" type="text" name="lastName"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>
                                <input class="form-control" required="required" type="email" name="email"/>
                            </td>
                        </tr>
                        <tr>
                            <td>Is Manager</td>
                            <td>
                                <input type="checkbox" data-toggle="toggle" data-on="Yes" data-off="No" name="isManager" value="true"/>
                            </td>
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





<script src="js/managerHome.js"></script>
<#include "./footer.ftl">

