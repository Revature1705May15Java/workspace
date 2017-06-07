<#include "./header.ftl">


<div class="row container-fluid">
    <div id="pendingRequests" class="white-container request-table-container col-xs-10 col-xs-offset-1">
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


    <div id="resolvedRequests" class="white-container request-table-container col-xs-10 col-xs-offset-1">
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
                    <td class="text col-xs-5 purpose"><span>${r.getPurpose()}</span></td>
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
                            <td>
                                <div class="input-group">
                                    <span class="input-group-addon">$</span>
                                    <input class="form-control" required="required" type="number" min="0.00" step="0.01" max="100000" placeholder="0.00" name="requestAmount"/>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Purpose</td>
                            <td><textarea class="form-control" required="required" rows="5" cols="50" name="requestPurpose" placeholder="Why are you requesting reimbursement?"></textarea></td>
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
        </div>
    </div>
</div>


<script src="js/employeeHome.js"></script>
<#include "./footer.ftl">
