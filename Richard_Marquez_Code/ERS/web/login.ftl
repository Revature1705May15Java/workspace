<#include "./header.ftl">


<div id="login-container" class="white-container container-fluid">
    <form name="loginForm" action="/Login" method="POST">
        <input class="form-control" autofocus type="email" name="username" placeholder="youremail@domain.com" required="required"><br>
        <input class="form-control" type="password" name="password" placeholder="Password" required="required"><br>
        <input class="form-control btn-primary" type="submit" value="Login">
    </form>
</div>


<#include "./footer.ftl">
