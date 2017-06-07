<#include "./header.ftl">

<div id="managerMain" class="row container-fluid">
    <div id="managerPendingRequestsTableContainer" class="white-container request-table-container col-xs-6 col-xs-offset-1">
        <h3><strong>Open</strong> Requests</h3>
        <table id="pendingRequestsTable" class="table table-hover tablesorter">
            <thead>
            <tr>
                <th class="col-xs-1">#</th>
                <th class="col-xs-1">Requester</th>
                <th class="col-xs-6">Purpose</th>
                <th class="col-xs-2">Amount</th>
                <th class="col-xs-2">Opened</th>
            </tr>
            </thead>

            <tbody>
            <#list pendingRequests as r>
            <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
                <td class="col-xs-1 id">${r.getId()}</td>
                <td class="col-xs-1 requester">${r.getRequesterId()}</td>
                <td class="text col-xs-6 purpose"><span>${r.getPurpose()}</span></td>
                <td class="col-xs-2 amount">${r.getAmount()?string.currency}</td>
                <td class="col-xs-2 dateRequested">${r.getDateRequested()}</td>
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
            <#--<#list pendingRequests as r>-->
            <#--<tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">-->
                <#--<td class="col-xs-1 state">${r.getState().name()}</td>-->
                <#--<td class="col-xs-1 id">${r.getId()}</td>-->
                <#--<td class="text col-xs-6 purpose"><span>${r.getPurpose()}</span></td>-->
                <#--<td class="col-xs-2 amount">${r.getAmount()?string.currency}</td>-->
                <#--<td class="col-xs-2 dateRequested">${r.getDateRequested()}</td>-->
            <#--</tr>-->
            <#--</#list>-->
            </tbody>
        </table>
    </div>


</div>


<script src="js/managerHome.js"></script>
<#include "./footer.ftl">

