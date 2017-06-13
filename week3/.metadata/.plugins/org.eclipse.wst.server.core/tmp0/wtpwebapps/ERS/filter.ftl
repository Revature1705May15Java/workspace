<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

	<div class="col-sm-4">
	 <p>
		 Requests
	 </p>

	 <ul>
		 <#list modrequests as request>
		 <p>${request.amt?string.currency}<br /> Date made:  ${request.reqdate} <br />Status: ${request.name}</p>
		 Purpose: ${request.purpose}<br />
		 <br /><br />
		 </#list>
	 </ul>
	</div>


<div class="jumbotron">
<form method = "post" action = "logout">
	<p>Primary page reached, <#if employee??>
		${employee.firstname} ${employee.lastname}
	</#if></p>
 <input type="submit" class="btn btn-primary" value="Logout">
 </form>

 <div class="jumbotron">
 <form method = "post" action = "home">
	<input type="submit" class="btn btn-primary" name="Returnhome" value="Return to homepage">
  </form>





</div>

</body>
</html>
