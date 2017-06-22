// Validates input and trims leading and trailing whitespace from
// input.
$('#update-btn').click(function() {
	var fname = $('#new-first-name').val();
	fname = fname.trim();
	var lname = $('#new-last-name').val();
	lname = lname.trim();
	var email = $('#new-email').val();
	email = email.trim();
	var pwd = $('#new-pwd').val();
	pwd = pwd.trim();
	var pwdConfirm = $('#confirm-new-pwd').val();
	pwdConfirm = pwdConfirm.trim();
	
	if(fname.length == 0 && lname.length == 0 && email.length == 0 && pwd.length == 0 && pwdConfirm.length == 0) {
		return false;
	} 
	else if(pwd != pwdConfirm) {
		return false;
	}
	else {
		$('#new-first-name').val(fname);
		$('#new-last-name').val(lname);
		$('#new-email').val(email);
		$('#new-pwd').val(pwd);
		
		return true;
	}
});

// Clears all fields in modal.
$('#cancel-update-btn').click(function () {
	$('#update-employee-form').trigger('reset');
	
	return true;
});