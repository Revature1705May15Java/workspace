<html>
<head>
    <title>Intro to Freemarker</title>
</head>
<body>
<form name="user" action="/Free" method="POST">
    fname: <input type="text" name="fName"><br>
    lname: <input type="text" name="lName"><br>
    <input type="submit" value="Save">
</form>

<table class=""datatable>
    <tr>
        <th>Fname</th>
        <th>Lname</th>
    </tr>

    <#list users as user>
        <tr>
            <td>${user.fName}</td>
            <td>${user.lName}</td>
        </tr>
    </#list>
</table>
</body>
</html>