<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        
        <!-- JQuery CDN -->
        <script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
        
        <!-- Data Tables -->
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.css"/>

        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.15/datatables.min.js"></script>
        
        <!-- Row Group Extension for Data Tables -->
        <script type="text/javascript" src="https://cdn.datatables.net/rowgroup/1.0.0/js/dataTables.rowGroup.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.datatables.net/rowgroup/1.0.0/css/rowGroup.bootstrap.min.css">

        <!-- Bootstrap Extension for DataTables -->
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
        
        <!-- Bootstrap -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>  
        
        <title>ERS Portal</title>
        <link rel="stylesheet" href="employees.css">
    </head>
    
    <body>    
        <!-- Top Nav Bar-->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></span>  ERS</a>   
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="manager.ftl">Requests</a></li>
                        <li class="active"><a href="#">Employees<span class="sr-only">(current)</span></a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>  ${employee.firstName}<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li name="update-prof"><a href="profile.ftl"><button id="hidden-button" type="submit" action="profile" method="post">View/Update Profile</button></a></li>
                                <li role="separator" class="divider"></li>
                                <li name="logout"><a href="logout.ftl"><button id="hidden-button" type="submit" action="logout" method="post">Logout</button></a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        
<!--  includes nav sidebar, table body, and footer  -->
        <div class="container-fluid">
            <div class="row">
                <!-- Nav Sidebar -->
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a id="employee-list" href="javascript:void(0)"><button id="hidden-button" type="submit" action="emptables" method="post" name="all-emps">View All Employees</button><span class="sr-only">(current)</span></a></li>
<!--                        <li><a id="manager-list" href="javascript:void(0)"><button id="hidden-button" type="submit" action="emptables" method="post" name="all-mngrs">View All Managers</button></a></li>-->
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">ERS Employee Database</h1>     
                    <!-- Employee Table -->
                    <h2 class="sub-header" id="table-header">Employees</h2>
                    <div class="table-responsive">
                        <table class="table table-striped" id="emp-table">
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div id="manager-modal" class="modal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Promote/Demote Employee</h4>
                    </div>
                    <div class="modal-body">
                        <p id="name"></p>
                        <p id="email"></p>
                        <button name="approve" action="resolve" method="post" type="submit">Promote</button>
                        <button name="deny" type="submit">Demote</button>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data- dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>       
        
<!-- footer-->
<!--
        <div id="footer">
            <footer>Vivamus molestie pretium nunc tempus enim &copy; 2017 
                <br><a href="http://www.lipsum.com/">Dummy text provided by: http://www.lipsum.com</a> 
            </footer>
        </div>
-->
        
<!-- script -->
        <script type="text/javascript">
        $(".dropdown-toggle").dropdown(); 
        $('#req-table tbody').on('click', function()
{
    alert("click acknowledged"); 
//        if($(this).hasClass('selected'))
//        {
//                $(this.removeClass('selected')); 
//        }
//        else
//        {
//            table.$('tr.selected').removeClass('selected'); 
//            $(this).addClass('selected'); 
//            
//            var id = parseInt($('.selected :first-child').text()); 
//            
//            var status = $('.selected :last-child').text(); 
//            
//            if(status == "Pending")
//            {
//                $('#resolve-modal').modal('show');
//                $('#reqid').val(content); 
//            }
//        }
});
        </script>
        <script src="employees.js"></script>
        
    </body>
</html>