<#include "./header.ftl">

<div id="managerMain" class="row container-fluid">
    <div id="requestArchiveTableContainer" class="white-container request-table-container col-xs-10 col-xs-offset-1">
        <h3><strong>Closed</strong> Requests</h3>
        <table id="requestArchiveTable" class="table table-hover tablesorter">
            <thead>
            <tr>
                <th class="">#</th>
                <th class="hidden-xs hidden-sm">Status</th>
                <th class="hidden-xs hidden-sm">Opened</th>
                <th class="hidden-xs hidden-sm">Closed</th>
                <th class="">Requester</th>
                <th class="hidden-xs hidden-sm">Handler</th>
                <th class="">Amount</th>
                <th style="display:none;">Purpose</th>
                <th style="display:none;">Note</th>
            </tr>
            </thead>

            <tbody>
            <#list requestArchive as r>
            <tr id="request${r.getId()}" data-toggle="modal" data-target="#viewRequestModal">
                <td class="id">${r.getId()}</td>
                <td class="state hidden-xs hidden-sm">${r.getState().name()}</td>
                <td class="dateRequested hidden-xs hidden-sm">${r.getDateRequested()}</td>
                <td class="dateResolved hidden-xs hidden-sm">${r.getDateResolved()}</td>
                <td class="requester">${r.getRequesterEmail()}</td>
                <td class="handler hidden-xs hidden-sm">${r.getHandlerEmail()}</td>
                <td class="amount">${r.getAmount()?string.currency}</td>
                <td class="purpose" style="display:none;">${r.getPurpose()}</td>
                <td class="note" style="display:none;"><#if r.getNote()??>${r.getNote()}</#if></td>
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
                            <td>Resolved</td>
                            <td class="dateResolved"></td>
                        </tr>
                        <tr>
                            <td>Employee Requesting</td>
                            <td class="requester"></td>
                        </tr>
                        <tr>
                            <td>Closing Manager</td>
                            <td class="handler"></td>
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
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>



<script src="js/requestArchive.js"></script>
<#include "./footer.ftl">
