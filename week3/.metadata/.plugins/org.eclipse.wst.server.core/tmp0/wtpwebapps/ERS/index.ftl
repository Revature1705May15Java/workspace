<html>
<head>

  <script src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
  .vcenter {
      display: inline-block;
      vertical-align: middle;
      float: none;
  }
  </style>
</head>
<body>

<div class="col-xs-12" style="height:140px;"></div>

<div class="col-sm-2 col-sm-offset-5 vcenter">
<form method = "post" action = "login">
  <p style="text-align:center;">
    Revature ERS<br />Enter your login information:<br />
  </p>
 <input type="text" name="username" class="form-control" placeholder="Username" required="required"/>
 <input type="password" name="password" class="form-control" placeholder="Password" required="required"/>
 <input type="submit" class="btn btn-primary" value="Login" />
 </form>
<p>
  <#if attempt?has_content>
		Login failed, please try again.
	</#if>
</p>
</div>


</body>
</html>
