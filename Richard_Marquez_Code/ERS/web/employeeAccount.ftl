<#include "./header.ftl">


<div id="employeeAccountContainer" class="white-container container-fluid">
    <#--<h3>${user.getEmail()}</h3>-->
    <form id="employeeAccountForm" name="employeeAccountForm" action="/EmployeeAccount" method="POST">
        <table class="table">
            <tr>
                <td>First Name</td>
                <td><input class="form-control" required="required" type="text" name="firstName" value="${user.getFirstName()}"></td>
            </tr>

            <tr>
                <td>Last Name</td>
                <td><input class="form-control" required="required" type="text" name="lastName" value="${user.getLastName()}"></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input class="form-control" required="required" type="email" name="email" value="${user.getEmail()}"></td>
            </tr>

            <tr>
                <td>Password *</td>
                <td><input class="form-control password" required="required" pattern=".{6,}" title="Password must be at least 6 characters" name="password" type="password" ></td>
            </tr>
            <tr>
                <td>Confirm Password *</td>
                <td><input class="form-control confirmPassword" required="required" name="confirmPassword" type="password" ></td>
            </tr>
        </table>

        <input type="submit" name="submit" value="Submit" class="form-control btn btn-primary" style="width:30%;margin-left:35%;margin-top:3em;">
    </form>
</div>


<script src="js/employeeAccount.js"></script>
<#include "./footer.ftl">
