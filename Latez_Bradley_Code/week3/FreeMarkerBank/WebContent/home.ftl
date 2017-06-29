<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Basic Table</h2>
         
  <table class="table">
    <thead>
      <tr>
        <th>${firstname} ${lastname}</th>
        <th> Accounts </th>

      </tr>
    </thead>
    <tbody>
    <#list accounts as account>
    <tr>
    <td> ${account.id}</td> <td>${account.balance}</td> 
   </#list>
    </tr>
    
    </tbody>
  </table>
</div>

</body>
</html>