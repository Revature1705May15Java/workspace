initTables();

function initTables() {
    // $.tablesorter.defaults.sortList = [[0,0]];

    if ($('#employeesTable tbody tr').length > 0) {
        $('#employeesTable').tablesorter({sortList: [[1, 0]]});
    }
    if ($('#pendingRequestsTable tbody tr').length > 0) {
        $('#pendingRequestsTable').tablesorter({sortList: [[0, 0]]});
    }

    $('.request-table-container table tbody tr').click(function() {
        var state = $('.state', this).html();
        var id = $('.id', this).html();
        var amount = $('.amount', this).html();
        var purpose = $('.purpose', this).html();
        var dateRequested = $('.dateRequested', this).html();
        var requester = $('.requester', this).html();

        $('#viewRequestModal .id').html('');
        $('#viewRequestModal .state').html('');
        $('#viewRequestModal .dateRequested').html('');
        $('#viewRequestModal .requester').html('');
        $('#viewRequestModal .amount').html('');
        $('#viewRequestModal .purpose').html('');

        $('#viewRequestModal .id').html('Request #' + id);
        $('#viewRequestModal .state').html(state);
        $('#viewRequestModal .dateRequested').html(dateRequested);
        $('#viewRequestModal .requester').html('<a href="mailto:' + requester + '">' + requester + "</a>");
        $('#viewRequestModal .amount').html(amount);
        $('#viewRequestModal .purpose').html(purpose);

        $('#viewRequestModal .requestId').val(id);
    });

    // employees table
    $('#employeesTable tbody tr').click(function() {
        var email = $('.email', this).html();

        $('#pendingRequestsTable tbody tr').hide();

        $('#pendingRequestsTable tbody tr').each(function() {
            var reqEmail = $('.requester', this).html();
            if (reqEmail === email) {
                $(this).show();
            }
        });
    });

}

