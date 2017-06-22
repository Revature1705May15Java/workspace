$(document).ready(function() {
	$('#reqTable').DataTable();
	
	initTableEvents();
	
	$('.paginate_button').click(function() {
		initTableEvents();
	});
	
	$('#reqTable_filter input').keypress(function() {
		initTableEvents();
	});
});

function initTableEvents() {
	$('#reqTable tbody tr').click(function() {	
		var id = $('.reqid', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerName = $('.manname', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#reqModal .reqid').html('');
		$('#reqModal .state').html('');
		$('#reqModal .amount').html('');
		$('#reqModal .opendate').html('');
		$('#reqModal .closedate').html('');
		$('#reqModal .purpose').html('');
		$('#reqModal .manname').html('');
		$('#reqModal .mannote').html('');
		
		$('#reqModal .reqid').html("Request Id: " + id);
		$('#reqModal .state').html("State: " + state);
		$('#reqModal .amount').html("Amount: " + amount);
		$('#reqModal .opendate').html("Date Opened: " + openDate);
		if (closeDate != "")
			$('#reqModal .closedate').html("Date Closed: " + closeDate);
		$('#reqModal .purpose').html("Purpose: " + purpose);
		if (managerName != "")
			$('#reqModal .manname').html("Manager Name: " + managerName);
		if (managerNote != "")
			$('#reqModal .mannote').html("Manager Note: " + managerNote);
		$('#reqModal').modal('show');
	});
}

