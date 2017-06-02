<html>
<body>
<h1>welcome, ${fn} ${ln}! </h1>

<table class="datatable">
	<tr>
		<th> Account </th> <th> Balance </th>
	</tr>
	<#list accountInfo as account>
	<tr>
		<td>${account.get(1)}</td> <td>${account.get(2)}</td>
	</tr>
	</#list>
	</table>

<body>

</html>