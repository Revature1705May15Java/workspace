<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>
<body>

<div class="jumbotron">
<form method = "post" action = "info">
	<#if employee??>
	Edit First Name:
 <input type="text" name="newfn" class="form-control" value=${employee.firstname} placeholder="New First Name"><br />
  Edit Last Name:
<input type="text" name="newln" class="form-control" value=${employee.lastname} placeholder="New Last Name"><br />
	Edit Email:
 <input type="text" name="newemail" class="form-control" value=${employee.email} placeholder="New Email"><br />
  Edit Password:
 <input type="password" name="newpw" class="form-control" value=${employee.password} placeholder="New Password"><br />
 <input type="Submit" class="btn btn-primary" value="Change Account Information">
 </#if>
 </form>

 <form method = "post" action = "home">
  <input type="submit" class="btn btn-primary" value="Return to Homepage">
  </form>



</div>

</body>
</html>
