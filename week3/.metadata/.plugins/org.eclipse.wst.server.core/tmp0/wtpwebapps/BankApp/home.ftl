<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Login</title>
</head>
<body>
<h3>Welcome ${firstname} ${lastname}<h3>

<table>
<#list Account as account>
<tr>
<td>Account Number: ${account}</td>
</tr>
</#list>
</table>



</body>
</html>