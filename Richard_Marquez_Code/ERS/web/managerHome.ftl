<#include "./header.ftl">

<div id="managerMain" class="row container-fluid">
    <div id="managerPendingRequestsTableContainer" class="white-container request-table-container col-xs-6 col-xs-offset-1">
        <h3><strong>Open</strong> Requests</h3>
        <table id="pendingRequestsTable" class="table table-hover tablesorter">
            <thead>
            <tr>
                <th class="col-xs-1">#</th>
                <th class="col-xs-2">Opened</th>
                <th class="col-xs-6">Purpose</th>
                <th class="col-xs-2">Amount</th>
                <th class="col-xs-1">Requester</th>
            </tr>
            </thead>

            <tbody>
            <#list pendingRequests as r>
            <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
                <td class="col-xs-1 id">${r.getId()}</td>
                <td class="col-xs-2 dateRequested">${r.getDateRequested()}</td>
                <td class="text col-xs-6 purpose"><span>${r.getPurpose()}</span></td>
                <td class="col-xs-2 amount">${r.getAmount()?string.currency}</td>
                <td class="col-xs-1 requester">${r.getRequesterEmail()}</td>
                <td class="col-xs-1 state" style="display:none;">${r.getState().name()}</td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>




    <div id="managerEmployeesTableContainer" class="white-container request-table-container col-xs-3 col-xs-offset-1">
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
                    <td class="col-xs-4 firstName">${e.getFirstName()}</td>
                    <td class="col-xs-4 lastName">${e.getLastName()}</td>
                    <td class="col-xs-4 email">${e.getEmail()}</td>
                    <td class="id" style="display:none;">${e.getId()}</td>
                </tr>
            </#list>
            </tbody>
        </table>
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
                                <input type="checkbox" name="isManager" value="true"/>
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

