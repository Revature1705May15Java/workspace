$(document).ready(function () {
    initTables();
    initPasswordValidation();
});

// Thanks to Arbiter Christie for the idea
function initTables() {
    $.tablesorter.defaults.sortList = [[1,1]];

    if ($('#pendingRequestsTable').length > 0) $('#pendingRequestsTable').tablesorter();
    if ($('#resolvedRequestsTable').length > 0) $('#resolvedRequestsTable').tablesorter();

    $('.request-table-container table tbody tr').click(function() {
        var state = $('.state', this).html();
        var id = $('.id', this).html();
        var amount = $('.amount', this).html();
        var purpose = $('.purpose', this).html();
        var dateRequested = $('.dateRequested', this).html();
        var dateResolved = $('.dateResolved', this).html();
        var note = $('.note', this).html();

        var handler = $('.handler', this).html();
        if (handler == null) handler = '';

        $('#viewRequestModal .id').html('');
        $('#viewRequestModal .state').html('');
        $('#viewRequestModal .dateResolved').html('');
        $('#viewRequestModal .dateRequested').html('');
        $('#viewRequestModal .amount').html('');
        $('#viewRequestModal .purpose').html('');
        $('#viewRequestModal .note').html('');
        $('#viewRequestModal .handler').html('');

        $('#viewRequestModal .id').html('Request #' + id);
        $('#viewRequestModal .state').html(state);
        $('#viewRequestModal .dateResolved').html(dateResolved);
        $('#viewRequestModal .dateRequested').html(dateRequested);
        $('#viewRequestModal .amount').html(amount);
        $('#viewRequestModal .purpose').html(purpose);
        $('#viewRequestModal .note').html(note);
        $('#viewRequestModal .handler').html('<a href="mailto:' + handler + '">' + handler + "</a>");
    });
}

function initPasswordValidation() {
    // Only attempt validate passwords on employee account page
    if ($('#employeeAccountContainer').length == 0) return;

    var password = document.getElementById('employeeAccountContainer').getElementsByClassName('password')[0];
    var confirm = document.getElementById('employeeAccountContainer').getElementsByClassName('confirmPassword')[0];

    function validatePassword(){
        if(password.value != confirm.value) {
            confirm.setCustomValidity('Passwords don\'t match');
        } else {
            confirm.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm.onkeyup = validatePassword;
}

