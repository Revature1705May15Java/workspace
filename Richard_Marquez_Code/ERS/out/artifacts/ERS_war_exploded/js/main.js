$(document).ready(function () {
    initTables();
});

// Thanks to Arbiter Christie for the idea
function initTables() {
    $.tablesorter.defaults.sortList = [[1,0]];

    $("#pendingRequestsTable").tablesorter();
    $("#resolvedRequestsTable").tablesorter();
}

