<#include "./header.ftl">


<div class="container-fluid" style="width:30%; margin-top: 10em;">
    <h2>Manager</h2>
    <h3>${user.getLastName()}, ${user.getFirstName()}</h3>

    <form name="logoutForm" action="/Logout" method="POST">
        <input class="form-control btn-primary" type="submit" name="logoutButton" value="Log out">
    </form>
</div>


<#include "./footer.ftl">
