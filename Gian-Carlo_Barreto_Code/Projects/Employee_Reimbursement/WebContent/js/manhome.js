$(document).ready(function() {
	//$('#reqTable').on('click', 'tr', function() {
	$('#reqTable tr').click(function() {
		var id = $('.reqid', this).html();
		var empId = $('.empId', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerId = $('.manid', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#reqModal .reqid').html('');
		$('#reqModal .empid').html('');
		$('#reqModal .state').html('');
		$('#reqModal .amount').html('');
		$('#reqModal .opendate').html('');
		$('#reqModal .closedate').html('');
		$('#reqModal .purpose').html('');
		$('#reqModal .manid').html('');
		$('#reqModal .mannote').html('');
		
		$('#reqModal .reqid').html("Request Id: " + id);
		$('#reqModal .empid').html("Employee Id: " + empId);
		$('#reqModal .state').html("State: " + state);
		$('#reqModal .amount').html("Amount: " + amount);
		$('#reqModal .opendate').html("Date Opened: " + openDate);
		$('#reqModal .closedate').html("Date Closed: " + closeDate);
		$('#reqModal .purpose').html("Purpose: " + purpose);
		$('#reqModal .manid').html("Manager Id: " + managerId);
		$('#reqModal .mannote').html("Manager Note: " + managerNote);
		$('#reqModal').modal('show');
	});
	
	//$('#pendReqTable').on('click', 'tr', function() {
	$('#pending table tbody tr').click(function() {
		//console.log("Fuck this project");
		//console.log($(this).html());
		var id = $('.reqid', this).html();
		var empId = $('.empId', this).html();
		var state = $('.state', this).html();
		var amount = $('.amount', this).html();
		var openDate = $('.opendate', this).html();
		var closeDate = $('.closedate', this).html();
		var purpose = $('.purpose', this).html();
		var managerId = $('.manid', this).html();
		var managerNote = $('.mannote', this).html();
		
		$('#hiddenRequestId').val(id);
		
		$('#pendingModal .reqid').html('');
		$('#pendingModal .empid').html('');
		$('#pendingModal .state').html('');
		$('#pendingModal .amount').html('');
		$('#pendingModal .opendate').html('');
		$('#pendingModal .closedate').html('');
		$('#pendingModal .purpose').html('');
		$('#pendingModal .manid').html('');
		$('#pendingModal .mannote').html('');
		
		$('#pendingModal .reqid').html("Request Id: " + id);
		$('#pendingModal .empid').html("Employee Id: " + empId);
		$('#pendingModal .state').html("State: " + state);
		$('#pendingModal .amount').html("Amount: " + amount);
		$('#pendingModal .opendate').html("Date Opened: " + openDate);
		$('#pendingModal .closedate').html("Date Closed: " + closeDate);
		$('#pendingModal .purpose').html("Purpose: " + purpose);
		$('#pendingModal .manid').html("Manager Id: " + managerId);
		$('#pendingModal .mannote').html("Manager Note: " + managerNote);
		$('#pendingModal').modal('show');
	});
});