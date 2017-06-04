<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>FakeBank Banking</title>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	 crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	 crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	 crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	 crossorigin="anonymous"></script>
   <script src="./js/demo.js" crossorigin="anonymous"></script>
</head>
<body>

  <h3>Hello ${user.getFirstname()} ${user.getLastname()}</h3>
  
  <div class="panel-group">
  
    <div class="panel panel-primary" id="accounts-panel">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse1" href="#accounts">My Accounts</a>
        </h4>
      </div>
      <div id="accounts" class="panel-collapse collapse">
        <#if !user.accounts.isEmpty()>
          <table class="table table-hover">
            <#list user.accounts as account>
              <tr>
                <td>account.getId()</td>
                <td>account.getType().getName()</td>
                <td>account.getBalance().doubleValue()?string.currency</td>
              </tr>
            </#list>
          </table>
        </#if>
      </div>
    </div>
    
    <div class="panel panel-default" id="open-panel">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse2" href="#open-collapse">Open New Account</a>
        </h4>
      </div>
      <div id="open-collapse" class="panel-collapse collapse">
        
      </div>
    </div>
    
    <div class="panel panel-default" id="transfer-panel">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse3" href="#transfer-collapse">Make Transfer</a>
        </h4>
      </div>
      <div id="transfer-collapse" class="panel-collapse collapse">
        
      </div>
    </div>
    
  </div>
  
</body>
</html>