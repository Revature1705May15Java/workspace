<html>
<head>
<title>Welcome to THE BANK</title>
</head>

<body>
<form name="user" action="hello" method="post">
Firstname: <input type="text" name="fn" /> <br>
Lastname: <input type="text" name="ln" /> <br>
<input type="submit" value="Save" />
</form>

<table class="datatable">
<tr>
<th>Username</th>
<th>Password</th>
</tr>

<#list bankUsers as user>
<tr>
<td>${bankUser.fn}</td><td>${bankUser.ln}</td>
</tr>
</#list>
</table>

</body>
</html>