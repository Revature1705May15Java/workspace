<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Students</title>
</head>
<body>
<h1>List of our new Students!</h1>

<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Major</th>
	</tr>
	
	  <#list listOfStudents as student>
	<tr>
		<td>${ student.id }</td>
		<td>${ student.name }</td>
		<td>${ student.major}</td>
	</tr>
</#list>
</table>
</body>
</html>
