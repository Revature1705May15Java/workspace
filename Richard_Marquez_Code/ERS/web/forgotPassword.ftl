<#include "./header.ftl">


<div id="login-container" class="white-container container-fluid">
    <form name="forgotPasswordForm" action="/ForgotPassword" method="POST">
        <input class="form-control" autofocus type="email" name="email" placeholder="youremail@domain.com" required="required"><br>
        <input class="form-control btn-primary" type="submit" value="Submit">
    </form>
</div>


<#include "./footer.ftl">
