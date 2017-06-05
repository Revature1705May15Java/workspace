$(document).ready(function () {
    initTables();
});

// Thanks to Arbiter Christie for the idea
function initTables() {
    $.tablesorter.defaults.sortList = [[1,0]];

    if ($('#pendingRequestsTable').length > 0) $('#pendingRequestsTable').tablesorter();
    if ($('#resolvedRequestsTable').length > 0) $('#resolvedRequestsTable').tablesorter();
}

