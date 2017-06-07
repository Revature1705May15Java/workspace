<!DOCTYPE html>
<html>
<head>
	<title>Manager Home</title>
</head>
<body>
	<form name="viewAll" action="viewEmployees" method="POST" id="form1"></form>
	<form name="registerNew" action="register" method="GET" id="form2"></form>
	
	<button type="submit" formmethod="POST" formaction="">Logout</button>
	<button type="submit" formmethod="POST" formaction="">View Pending Requests</button>
	<button type="submit" formmethod="POST" formaction="">View Resolved Requests</button>
	<button type="submit" formmethod="POST" formaction="">View All Requests</button>
	<button type="submit" form="form1">View All Employees</button>
	<button type="submit" form="form2">Register Employee</button>
</body>
</html>