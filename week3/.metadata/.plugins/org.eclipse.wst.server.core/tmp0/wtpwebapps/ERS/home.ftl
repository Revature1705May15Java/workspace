<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script>
function redirectTo(url){
	window.location.replace(url);
}
</script>
</head>
<body>

<div class="jumbotron">
<form method = "post" action = "logout">
	<p>Primary page reached, <#if employee??>
		${employee.firstname} ${employee.lastname}
	</#if></p>
 <input type="submit" class="btn btn-primary" value="Logout">
 </form>




</div>

</body>
</html>
