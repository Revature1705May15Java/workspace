<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/myLogo.png" />
    <#--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">-->
    <link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css'>
</head>

<body>
<div class="login">
    <h1>Login</h1>
    <form method="post" action="hello">
        <input autofocus type="text" name="uName" placeholder="Username" required="required" />
        <input type="password" name="pass" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
    </form>
</div>

<#if login! == "fail">
    <div class="" id="throwError">
        <#--<a href="" class="close" data-dismiss="alert" aria-label="close"><strong>X</strong></a>-->
        <#--<strong>Failed to login!</strong>-->
        <button id="myError" style="visibility: hidden" class="show-alert show-alert__error">Error</button>
        <#--<script>$('#myError').trigger('click');</script>-->
        <script>
            setTimeout(function(){

                $("#myError").click();

            },1);
        </script>
    </div>
</#if>

    <#--<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="js/fancyAlert.js"></script>
</body>

</html>
