<html>
<head>
<title>Intro To Freemarker</title>
</head>

<body>
<form name="user" action="hello" method="post">
Firstname: <input type="text" name="firstname" /> <br>
Lastname: <input type="text" name="lastname" /> <br>
<input type="submit" value="Save" />
</form>

<table class="datatable">
<tr>
<th>Firstname</th>
<th>Lastname</th>
</tr>

<#list users as user>
 <tr>
  <td>${user.fname}</td>
    <td>${user.lname}</td>
      </tr>
    </#list>
</table>

</body>
</html>