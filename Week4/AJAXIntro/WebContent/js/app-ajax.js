

/*
 * jQuery AJAX call using ajax() method
 */
$(document).ready(function() {
	$('#userName').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});

/*Syntax of the jQuery ajax() method
 * try to relate it to the above code to 
 * further understand what's happening
 * 
 * $.ajax({
  url: url,
  data: data,
  success: success,
  dataType: dataType
});
 */







// shorthand approach to using ajax() method
//$(document).ready(function() {
//        $('#userName').blur(function(event) {
//                var name = $('#userName').val();
//                $.get('GetUserServlet', {
//                        userName : name
//                }, function(responseText) {
//                        $('#ajaxGetUserServletResponse').text(responseText);
//                });
//        });
//});