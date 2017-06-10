initTables();

function initTables() {
    // $.tablesorter.defaults.sortList = [[0,0]];

    if ($('#pendingRequestsTable tbody tr').length > 0) {
        $('#pendingRequestsTable').tablesorter({sortList: [[1, 1]]});
    }

    $('.request-table-container table tbody tr').click(function() {
        var state = $('.state', this).html();
        var id = $('.id', this).html();
        var amount = $('.amount', this).html();
        var purpose = $('.purpose', this).html();
        var note = $('.note', this).html();
        var dateRequested = $('.dateRequested', this).html();
        var dateResolved = $('.dateResolved', this).html();
        var requester = $('.requester', this).html();
        var handler = $('.handler', this).html();

        $('#viewRequestModal .id').html('');
        $('#viewRequestModal .state').html('');
        $('#viewRequestModal .dateRequested').html('');
        $('#viewRequestModal .dateResolved').html('');
        $('#viewRequestModal .requester').html('');
        $('#viewRequestModal .handler').html('');
        $('#viewRequestModal .amount').html('');
        $('#viewRequestModal .purpose').html('');
        $('#viewRequestModal .note').html('');

        $('#viewRequestModal .id').html('Request #' + id);
        $('#viewRequestModal .state').html(state);
        $('#viewRequestModal .dateRequested').html(dateRequested);
        $('#viewRequestModal .dateResolved').html(dateResolved);
        $('#viewRequestModal .requester').html('<a href="mailto:' + requester + '">' + requester + "</a>");
        $('#viewRequestModal .handler').html('<a href="mailto:' + handler + '">' + handler + "</a>");
        $('#viewRequestModal .amount').html(amount);
        $('#viewRequestModal .purpose').html(purpose);
        $('#viewRequestModal .note').html(note);

        $('#viewRequestModal .requestId').val(id);
    });

    // employees table
    $('#employeesTable tbody tr').click(function() {
        var firstName = $('.firstName', this).html();
        console.log(firstName);
    });

}
