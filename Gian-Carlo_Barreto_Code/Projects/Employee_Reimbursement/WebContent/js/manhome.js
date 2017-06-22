$(document).ready(function() {
	$('#reqTable').DataTable();
	$('#pendReqTable').DataTable();
	$('#employees').DataTable();
	
	initReqTableEvents();
	initPendingTableEvents();
	
	$('#reqView .paginate_button').click(function() {
		initReqTableEvents();
	});
	
	$('#pending .paginate_button').click(function() {
		initPendingTableEvents();
	});
	
	$('#reqTable_filter input').keypress(function() {
		initReqTableEvents();
	});
	
	$('#pendReqTable_filter input').keypress(function() {
		initPendingTableEvents();
	});
});

function initReqTableEvents() {
	$('#reqTable tbody tr').click(function() {
		var id = $('.reqid', this).html();
		var empName = $('.empname', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerName = $('.manname', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#reqModal .reqid').html('');
		$('#reqModal .empname').html('');
		$('#reqModal .state').html('');
		$('#reqModal .amount').html('');
		$('#reqModal .opendate').html('');
		$('#reqModal .closedate').html('');
		$('#reqModal .purpose').html('');
		$('#reqModal .manname').html('');
		$('#reqModal .mannote').html('');
		
		$('#reqModal .reqid').html("Request Id: " + id);
		$('#reqModal .empname').html("Employee Name: " + empName);
		$('#reqModal .state').html("State: " + state);
		$('#reqModal .amount').html("Amount: " + amount);
		$('#reqModal .opendate').html("Date Opened: " + openDate);
		$('#reqModal .closedate').html("Date Closed: " + closeDate);
		$('#reqModal .purpose').html("Purpose: " + purpose);
		$('#reqModal .manname').html("Manager Name: " + managerName);
		$('#reqModal .mannote').html("Manager Note: " + managerNote);
		$('#reqModal').modal('show');
	});
}

function initPendingTableEvents() {
	$('#pending table tbody tr').click(function() {
		var id = $('.reqid', this).html();
		var empName = $('.empname', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerName = $('.manname', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#hiddenRequestId').val(id);
		
		$('#pendingModal .reqid').html('');
		$('#pendingModal .empname').html('');
		$('#pendingModal .state').html('');
		$('#pendingModal .amount').html('');
		$('#pendingModal .opendate').html('');
		$('#pendingModal .closedate').html('');
		$('#pendingModal .purpose').html('');
		$('#pendingModal .manname').html('');
		$('#pendingModal .mannote').html('');
		
		$('#pendingModal .reqid').html("Request Id: " + id);
		$('#pendingModal .empname').html("Employee Name: " + empName);
		$('#pendingModal .state').html("State: " + state);
		$('#pendingModal .amount').html("Amount: " + amount);
		$('#pendingModal .opendate').html("Date Opened: " + openDate);
		$('#pendingModal .closedate').html("Date Closed: " + closeDate);
		$('#pendingModal .purpose').html("Purpose: " + purpose);
		$('#pendingModal .manname').html("Manager Name: " + managerName);
		$('#pendingModal .mannote').html("Manager Note: " + managerNote);
		$('#pendingModal').modal('show');
	});
}