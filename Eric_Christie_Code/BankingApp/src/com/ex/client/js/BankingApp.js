$(document).ready(function() {
	// $('#ddl-script').load('../../sqlscripts/DDL.sql', (res, status) => {});
	$.getJSON('./js/DDL.sql', function(data) {
		let sqlScript = data;
		console.log(sqlScript);
		$('#sqlscript').html(data);
	});
});