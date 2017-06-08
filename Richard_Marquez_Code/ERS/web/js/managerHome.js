initTables();

function initTables() {
    // $.tablesorter.defaults.sortList = [[0,0]];

    $('#employeesTable').tablesorter( {sortList: [[1,0]]} );
    $('#pendingRequestsTable').tablesorter( {sortList: [[0,0]]} );
}
