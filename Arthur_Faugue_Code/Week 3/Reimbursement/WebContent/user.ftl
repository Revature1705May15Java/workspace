<!DOCTYPE html PUBLIC>
<html lang="en">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"
	rel="stylesheet" media="all">

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" media="all" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css"
	rel="stylesheet" media="all" />
	
	<link href="css/user.css" rel="stylesheet">

<title>Reimbursement</title>
</head>
<body>
<div class="navbar-wrapper">

		<nav class="navbar navbar-inverse navbar-static-top navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand">Refund Me</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="#request" data-toggle="modal"
							data-target="#request">Make Request</a></li>
						<li><a href="user">View User</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a class="navbar-brand pull-right">Welcome ${firstname}</a></li>
						<li><form action="logout" method="post">
							<button type="submit" class="btn btn-danger btn-rounded pull-right"  style="margin-top: 8px;margin-left: 5px;">Log Out</button>
						</form></li>
						
					</ul>
				</div>
			</div>
		</nav>

	</div>
	
	<div id="request" class="modal" role="dialog">
		<div class="container bs-nopadding text-center well">
			<form role="form" action="requested" method="post">
				<br style="clear: both">
				<h3 style="margin-bottom: 25px; text-align: center;">Request
					Form</h3>
				<div class="form-group">
					<input type="number" min="1" step="0.01" class="form-control" name="amount"
						placeholder="Enter Requested Amount" pattern="(0\.((0[1-9]{1})|([1-9]{1}([0-9]{1})?)))|(([1-9]+[0-9]*)(\.([0-9]{1,2}))?)" required>
				</div>
				<div class="form-group">
					<textarea class="form-control" type="text" name="purpose"
						placeholder="Purpose (Optional)" maxlength="500" rows="7"></textarea>
					<span class="help-block"><p id="characterLeft"
							class="help-block ">You have reached the limit of 500
							characters.</p></span>
				</div>

				<button type="submit" class="btn btn-lg btn-success btn-block"
											>Submit Form</button>
			</form>
		</div>
	</div>
	
<div class="container">
	<div class="container">

<div class="container">
	<div class="row">
		<h2>Refund Me</h2>
        

<div class="panel panel-default">
  <div class="panel-heading">  <h4 style="color:#00b1b1;">${firstname} ${lastname}'s Request</h4></div>
   <div class="panel-body">
       
    <div class="box box-info">
    <h4>Sort By</h4>
    <form action="sort" method="post">
	    <button class="btn btn-default" name="state" type="submit" value="4">All</button>
	    
	    <button class="btn btn-primary" name="state" type="submit" value="1">Pending</button>
	
		<button class="btn btn-success" name="state" type="submit" value="2">Approved</button>
	
		<button class="btn btn-danger" name="state" type="submit" value="3">Denied</button>
	</form>
   <div class="clearfix"></div>
<div class="bot-border"></div>  

<#list requests as request>
<hr style="margin:5px 0 5px 0;">
<div class="col-sm-5 col-xs-6 tital " >Request Number: </div><div class="col-sm-7"> ${request.id}</div>
  <div class="clearfix"></div>
<div class="bot-border"></div>
<div class="col-sm-5 col-xs-6 tital " >Pending Amount: </div><div class="col-sm-7">$ ${request.amount}</div>
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
<div class="bot-border"></div>
<button type="button" class="btn btn-primary btn-rounded pull-left" data-toggle="modal"
			data-target="#${request.id}" style="margin-top: 8px;margin-left: 5px;">View Request</button>
  <div class="clearfix"></div>
<div class="bot-border"></div>

	<div id="${request.id}" class="modal fade in" style="vertical-align: middle; top:30%; left:5%;">

			<div class="container bs-nopadding text-center well">
				<div class="row" style="color: #fff">
					<div style="background: #990134" class="col-sm-3">Request ID</div>
					<div style="background: #63102c" class="col-sm-3">State</div>
					<div style="background: #990134" class="col-sm-3">Date
						Requested</div>
					<div style="background: #63102c" class="col-sm-3">Date
						Resolved</div>
				</div>
				<div class="row">
					<div class="col-sm-3">${request.id}</div>
					<#if request.stateId == 1>
					<div class="col-sm-3">Pending</div>
					<#elseif request.stateId == 2>
					<div class="col-sm-3">Approved</div>
					<#elseif request.stateId == 3>
					<div class="col-sm-3">Denied</div>
					</#if>
					<div class="col-sm-3">${request.reqDate}</div>
					<#if request.resDate??>
					<div class="col-sm-3">${request.resDate}</div>
					<#else>
					<div class="col-sm-3">N/A</div>
					</#if>
				</div>
				<div class="row" style="color: #fff">
					<div style="background: #990134" class="col-sm-3">Amount
						Requested</div>
					<div style="background: #63102c" class="col-sm-3">Resolver ID</div>
					<div style="background: #990134" class="col-sm-3">Purpose</div>
					<div style="background: #63102c" class="col-sm-3">Note</div>
				</div>
				<div class="row">
					<div class="col-sm-3">$ ${request.amount} $</div>
					<#if request.resId??>
					<div class="col-sm-3">${request.resId}</div>
					<#else>
					<div class="col-sm-3">N/A</div>
					</#if>
					<#if request.purpose??>
					<div class="col-sm-3">${request.purpose}</div>
					<#else>
					<div class="col-sm-3">N/A</div>
					</#if>
					<#if request.note??>
					<div class="col-sm-3">${request.note}</div>
					<#else>
					<div class="col-sm-3">N/A</div>
					</#if>
				</div>
			</div>

	</div>

</#list>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

        </div>
            
    </div> 
    </div>
</div>  
        
   </div>


</div>
</div>

</body>
</html>