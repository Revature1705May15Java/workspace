<ul class="nav navbar-nav">
	<li class="active"><a href="viewPending">View Pending</a></li>
    <li><a href="viewResolved">View Resolved</a></li>
        
    <#if user.isManager>
    	<li><a id="list-employees-link" href="viewEmployees">View Employees</a></li>
    	<li><a id="add-employee-link" href="register">Add Employee</a></li>  
    <#else>
    	<li><a href="submitRequest">Create Request</a></li>
    </#if>
</ul>