// Clears all fields in modal.
$('#cancel-action-btn').click(function () {
	$('#request-action-form')[0].reset();
	return true;
});

$('.approve-request').click(function() {
	$('#hidden-action-field').val('approve');
	var $elem = $(this).parents('tr:first').children()[0];
	setIdField($($elem).text());
	
	return true;
});

$('.deny-request').click(function() {
	$('#hidden-action-field').val('deny');
	var $elem = $(this).parents('tr:first').children()[0];
	setIdField($($elem).text());
	
	return true;
});

function setIdField(id) {
	$('#hidden-id-field').val(id);
	return true;
}

$('.view-employees-requests').click(function() {
	var $elem = $(this).parents('tr:first').children()[0];
	$('<form method="POST" action="viewEmployeesRequests">' +
			'<input type="hidden" name="reqId" value="' + $($elem).text() +'">' +
			'</form>').appendTo('body').submit();
})