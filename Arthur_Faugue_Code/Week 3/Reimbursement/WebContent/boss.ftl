
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin.css" rel="stylesheet">
    
    <link href="css/user.css" rel="stylesheet">
    
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
`
	<script type="text/javascript" src="js/tablesorter/jquery.tablesorter.pager.js"></script> 
	
	<style>
	body{
	  padding:20px 20px;
	}
	
	.results tr[visible='false'],
	.no-result{
	  display:none;
	}
	
	.results tr[visible='true']{
	  display:table-row;
	}
	
	.counter{
	  padding:8px; 
	  color:#ccc;
	}
	</style>
	
	<script>
	ffunction doConfirm(msg, yesFn, noFn)
	{
	    var confirmBox = $("#confirmBox");
	    confirmBox.find(".message").text(msg);
	    confirmBox.find(".yes,.no").unbind().click(function()
	    {
	        confirmBox.hide();
	    });
	    confirmBox.find(".yes").click(yesFn);
	    confirmBox.find(".no").click(noFn);
	    confirmBox.show();
	}
	</script>
</head>

<body id="page-top">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <a class="navbar-brand" href="#">Refund Me</a>
        <div class="collapse navbar-collapse" id="navbarExample">
            <ul class="sidebar-nav navbar-nav" >
                <li class="nav-item active">
                    <a class="nav-link" href="sort"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="employee"><i class="fa fa-users"></i> Employees</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="user"><i class="fa fa-user fa-fw"></i> Personal Info.</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto">
                <li><a class="navbar-brand pull-right" style="color:white">Welcome ${firstname}</a></li>
						<li><form action="logout" method="post">
							<button type="submit" class="btn btn-danger btn-rounded pull-right"  style="margin-top: -2px;margin-left: 5px;">Log Out</button>
						</form></li>
            </ul>
        </div>
    </nav>
	<div id="confirmBox">
	    <div class="message"></div>
	    <button class="yes">Yes</button>
	    <button class="no">No</button>
	</div>
    <div class="content-wrapper py-3">

        <div class="container-fluid">

            <!-- Breadcrumbs -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">Dashboard</li>
                <li class="breadcrumb-item active">Manager Dashboard</li>
            </ol>

            <!-- Icon Cards -->
            <div class="row">
                <div class="col-xl-3 col-sm-6 mb-3">
                    <div class="card card-inverse card-primary o-hidden h-100">
                        <div class="card-block">
                            <div class="card-block-icon">
                                <i class="fa fa-fw fa-list"></i>
                            </div>
                            <div class="mr-5">
                                ${allReq} Total Request!
                            </div>
                        </div>
                        <form id="my_form" action="sort" method="post" class="card-footer clearfix small z-1">
                        	<input type="text" name="state" value="4" style="display: none;" />
	                        <a href="javascript:{}" onclick="document.getElementById('my_form').submit();" style="color:white">
	                            <span class="float-left" >Sort By...</span>
	                            <span class="float-right"><i class="fa fa-angle-right"></i></span>
	                        </a>
				        </form>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6 mb-3">
                    <div class="card card-inverse card-success o-hidden h-100">
                        <div class="card-block">
                            <div class="card-block-icon">
                                <i class="fa fa-flag"></i>
                            </div>
                            <div class="mr-5">
                                ${allAppr} Approved Request!
                            </div>
                        </div>
                        <form id="my_form1" action="sort" method="post" class="card-footer clearfix small z-1">
                        	<input type="text" name="state" value="2" style="display: none;" />
	                        <a href="javascript:{}" onclick="document.getElementById('my_form1').submit();" style="color:white">
	                            <span class="float-left" >Sort By...</span>
	                            <span class="float-right"><i class="fa fa-angle-right"></i></span>
	                        </a>
				        </form>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6 mb-3">
                    <div class="card card-inverse card-warning o-hidden h-100">
                        <div class="card-block">
                            <div class="card-block-icon">
                                <i class="fa fa-cog fa-fw"></i>
                            </div>
                            <div class="mr-5">
                                ${allPend} Pending Request!
                            </div>
                        </div>
                        <form id="my_form2" action="sort" method="post" class="card-footer clearfix small z-1">
                        	<input type="text" name="state" value="1" style="display: none;" />
	                        <a href="javascript:{}" onclick="document.getElementById('my_form2').submit();" style="color:white">
	                            <span class="float-left" >Sort By...</span>
	                            <span class="float-right"><i class="fa fa-angle-right"></i></span>
	                        </a>
				        </form>
                    </div>
                </div>
                <div class="col-xl-3 col-sm-6 mb-3">
                    <div class="card card-inverse card-danger o-hidden h-100">
                        <div class="card-block">
                            <div class="card-block-icon">
                                <i class="fa fa-trash-o"></i>
                            </div>
                            <div class="mr-5">
                                ${allDen} Denied Request!
                            </div>
                        </div>
                        <form id="my_form3" action="sort" method="post" class="card-footer clearfix small z-1">
                        	<input type="text" name="state" value="3" style="display: none;" />
	                        <a href="javascript:{}" onclick="document.getElementById('my_form3').submit();" style="color:white">
	                            <span class="float-left" >Sort By...</span>
	                            <span class="float-right"><i class="fa fa-angle-right"></i></span>
	                        </a>
				        </form>
                    </div>
                </div>
            </div>
            
            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table"></i> Employee List
                    <div class="pull-right">
                   		<input type="text" class="search form-control" placeholder="What you looking for?">
                	</div>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table id="pendingRequestsTable" class="table table-bordered tablesorter table-hover results" width="100%" id="dataTable" cellspacing="0">
                            <thead>
                                <tr class="filters">
                                    <th>Request Id</th>
                                    <th>State</th>
                                    <th>Date Requested</th>
                                    <th>Date Resolved</th>
                                    <th>Amount $</th>
                                    <th>Requester</th>
                                    <th>View</th> 
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Request Id</th>
                                    <th>State</th>
                                    <th>Date Requested</th>
                                    <th>Date Resolved</th>
                                    <th>Amount $</th>
                                    <th>Requester</th>
                                    <th>View</th>
                                </tr>
                            </tfoot>
                            <tbody>
                            <#list requests as request>
                                <tr>
                                    <th>${request.id} </th>
                                    <#if request.stateId == 1>
                                    <th>Pending</th>
									<#elseif request.stateId == 2>
									<th>Approved </th>
									<#elseif request.stateId == 3>
									<th>Denied </th>
									</#if>
                                    <th>${request.reqDate} </th>
                                    <#if request.resDate??>
                                    <th>${request.resDate} </th>
                                    <#else>
                                    <th>N/A </th>
                                    </#if>
                                    <th>${request.amount} </th>
                                    <th>${request.reqFn} ${request.reqLn}</th>
                                    <th> <button type="button" class="btn btn-primary btn-rounded pull-left" data-toggle="modal"
			data-target="#${request.id}" style="margin-top: 8px;margin-left: 5px;">View Request</button></th>
                                    
                                </tr>
                                <div id="${request.id}" class="modal fade in">
							        <div class="modal-dialog">
							            <div class="modal-content">
							 
							                <div class="modal-header">
							                    <a class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span></a>
							                    <h4 class="modal-title">View Request # ${request.id}</h4>
							                </div>
							                <div class="modal-body">
							                    <p>Requester: ${request.reqFn} ${request.reqLn}</p>
							                    <p>Requested Amount: ${request.amount}</p>
							                    <#if request.purpose??>
			                                    <p>Purpose: ${request.purpose}</p>
			                                    <#else>
			                                    <p>Purpose: N/A</p>
			                                    </#if>
							                    <#if request.note??>
			                                    <p>Note: ${request.note}</p>
			                                    <#else>
			                                    <p>Note: N/A</p>
			                                    </#if>
			                                    <#if request.resFn??>
			                                    <p>Resolver: ${request.resFn} ${request.resLn}</p>
			                                    <#else>
			                                    <p>Resolver: N/A</p>
			                                    </#if>
			                                    <form action="sort" method="post">
							                </div>
							                <div class="modal-footer">
							                	<#if request.stateId == 2>
							                    <div class="btn-group">
							                        <button class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
							                    </div>
							                    <#elseif request.stateId == 3>
												<div class="btn-group">
							                        <button class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
							                    </div>
												<#else>
												<form action="sort" method="post">
													<textarea class="form-control" type="text" name="note"
														placeholder="Purpose (Optional)" maxlength="500" rows="7"></textarea>
													<input type="text" name="reqID" value="${request.id}" style="display: none;" />
													<button id="accept${request.id}" class="btn btn-success" name="reqState" type="submit" value="2" onclick="showMessage('msg');">Approve</button>
													
													<button id="deny${request.id}" class="btn btn-danger" name="reqState" type="submit" value="3" onclick="showMessage('msg');">Deny</button>
												</form>
												<script>
													$('#deny${request.id}').click(function(e)
													{
													    if(confirm("Are you sure?"))
													    {
													        alert('Request was denied!');
													    }
													    else
													    {
													        e.preventDefault();
													    }
													});
												
													$('#accept${request.id}').click(function(e)
													{
													    if(confirm("Request was accepted!"))
													    {
													        alert('navigate!');
													    }
													    else
													    {
													        e.preventDefault();
													    }
													});	
											    </script>
												</#if>
							                </div>
							 
							            </div><!-- /.modal-content -->
							        </div><!-- /.modal-dalog -->
							    </div><!-- /.modal -->
                             </#list> 
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /.content-wrapper -->

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/sb-admin.min.js"></script>
    
    <!--Table Sorter -->
    <script type="text/javascript" src="js/tablesorter/jquery-latest.js"></script> 
	<script type="text/javascript" src="js/tablesorter/jquery.tablesorter.js"></script> 
 
	<script>
    $(document).ready(function() 
    	    { 
    	        $("#pendingRequestsTable").tablesorter(); 
    	    } 
    	); 

	$(document).ready(function() {
    	  $(".search").keyup(function () {
    	    var searchTerm = $(".search").val();
    	    var listItem = $('.results tbody').children('tr');
    	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
    	    
    	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
    	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
    	    }
    	  });
    	    
    	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
    	    $(this).attr('visible','false');
    	  });

    	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
    	    $(this).attr('visible','true');
    	  });

    	  var jobCount = $('.results tbody tr[visible="true"]').length;
    	    $('.counter').text(jobCount + ' item');

    	  if(jobCount == '0') {$('.no-result').show();}
    	    else {$('.no-result').hide();}
    			  });
    	});
    
	
    </script>
</body>

</html>
