<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App Home</title>
</head>
<body>
<h1>Welcome Back!</h1>

${fn} 
${ln}

<table class="datatable">
<tr>
<th>Account Id</th>
<th>Account Balance</th>
</tr>
<#list accounts as account>
<tr>
<td>${account.id}</td> <td>${account.balance}</td>
</tr>
</#list>
</table>

</body>
</html>