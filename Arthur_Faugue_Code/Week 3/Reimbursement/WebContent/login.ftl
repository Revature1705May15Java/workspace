<!DOCTYPE html PUBLIC>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
<title>Reimbursement</title>
</head>
<body>
<div class="container">
	<div class="container">

<div class="container">
	<div class="row">
		<h2>Real Bank</h2>
        
        
       <div class="col-md-7 ">

<div class="panel panel-default">
  <div class="panel-heading">  <h4 >User Profile</h4></div>
   <div class="panel-body">
       
    <div class="box box-info">
        
            <div class="box-body">
                     <div class="col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://www.artstartart.com/assets/images/generic_user.png" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
<div style="color:#999;" >click here to change profile image</div>   
                     </div>
              
              <br>
    
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h4 style="color:#00b1b1;">${firstname} ${lastname}</h4></span>
              <span><p>Customer</p></span>            
            </div>
            <div class="clearfix"></div>
            <hr style="margin:5px 0 5px 0;">
    
              
<div class="col-sm-5 col-xs-6 tital " >First Name:</div><div class="col-sm-7 col-xs-6 ">${firstname}</div>
     <div class="clearfix"></div>
<div class="bot-border"></div>

<div class="col-sm-5 col-xs-6 tital " >Last Name:</div><div class="col-sm-7"> ${lastname}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>

<#list requests as request>
<hr style="margin:5px 0 5px 0;">
<div class="col-sm-5 col-xs-6 tital " >Request Number:</div><div class="col-sm-7"> ${request.id}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<div class="col-sm-5 col-xs-6 tital " >Pending Amount: $</div><div class="col-sm-7"> ${request.amount}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<#if request.stateId == 1>
<div class="col-sm-5 col-xs-6 tital " >State: </div><div class="col-sm-7"> Pending</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<#elseif request.stateId == 2>
<div class="col-sm-5 col-xs-6 tital " >State: </div><div class="col-sm-7"> Approved</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<#elseif request.stateId == 3>
<div class="col-sm-5 col-xs-6 tital " >State: </div><div class="col-sm-7"> Denied</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
</#if>
</#list>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
            
    </div> 
    </div>
</div>  
    <script>
              $(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       
              </script> 
        
   </div>
</div>

</div>
</div>

</body>
</html>