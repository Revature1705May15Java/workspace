<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

Employee

<br>

 Welcome! ${name}
 <br>


<#if display! == "yes">
<#list requests as requests>
<tr>
 <td>Amount: 	$</td> <td>${requests.amount}</td> <td>	Reason: </td> <td>${requests.purpose}</td> <td>	Status: </td> <td>${requests.type.name}</td> <br>
</tr>
</#list>
<#else>
No Requests have been made
<b>
</#if>




<div class="container">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog" data-backdrop="static">
    <div class="modal-dialog">
    
    
    
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <form name = "requestForm" action="addRequest" method="post">
			Amount <br>
			<input type = "number" step=".01" name ="amount" required = required/> <br>
			Purpose <br>
			<input type = "text" name = "purp" required = required/> 
			<input type="submit" value="submit"/>
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  
  
  
</div>


</body>
</head>