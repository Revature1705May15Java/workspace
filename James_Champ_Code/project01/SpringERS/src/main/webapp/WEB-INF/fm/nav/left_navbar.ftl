<ul class="nav navbar-nav">
	<li id="viewPending"><a class="nav-item" href="viewPending">View Pending</a></li>
    <li id="viewResolved"><a class="nav-item" href="viewResolved">View Resolved</a></li>
        
    <#if user.isManager>
    	<li id="viewEmployees"><a class="nav-item" id="list-employees-link" href="viewEmployees">View Employees</a></li>
    	<li id="register"><a class="nav-item" id="add-employee-link" href="register">Add Employee</a></li>  
    <#else>
    	<li id="submitRequest"><a class="nav-item" href="submitRequest">Create Request</a></li>
    </#if>
</ul>

<script type="text/javascript" src="js/nav.js"></script>