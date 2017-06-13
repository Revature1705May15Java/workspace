<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!-- JQuery CDN -->
        <script
          src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
        
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>  

        <title>ERS Portal</title>
        <link rel="stylesheet" href="manager.css">
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
                  <a class="navbar-brand" href="#"><span class="glyphicon-class"><span class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></span></span>  ERS</a>   
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Requests<span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Employees</a></li>
                    </ul>
                    <form class="navbar-form navbar-left">
                        <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
<!--                            change User to $Employee.firstName $Employee.lastName -->
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>  User<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">User Profile</a></li>
                                <li><a href="#">Update Profile</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="#">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
       
        <div class="container-fluid">
            <div class="row">
                <!-- Nav Sidebar -->
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="#">Pending Requests <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Approved Requests</a></li>
                        <li><a href="#">Denied Requests</a></li>
                        <li><a href="#">View All Requests</a></li>
                    </ul>
<!--                    <li role="separator" class="divider"></li>-->
                    <ul class="nav nav-sidebar">
                        <li><a href="#">Submit New Request</a></li>
                        <li><a href="#">View Your Requests</a></li>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Dashboard</h1>     
                    <!-- Pending Requests Table -->
            <!--        Badge of Total Pending Requests -->
                    <h2 class="sub-header">Requests Awaiting Approval <span class="badge">42</span></h2>
            <!--        change the 42 to pending requests -->
                    <div class="table-responsive">
                        <table class="table table-striped" id="pendingRequests">
                            <thead>
                                <tr>
                                    <th>Firstname</th>
                                    <th>Lastname</th>
                                    <th>Email</th>
                                    <th>Amount Requested</th>
                                    <th>Purpose</th>
                                    <th>Date Submitted</th>
                                    <th>Approve/Deny Requests</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- On rows -->
                                <!-- success for approved, danger for denied, active for pending -->
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="success">
                                    <td>...</td>
                                </tr>
                <!--                <tr class="warning">...</tr>-->
                                <tr class="danger">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                                <tr class="active">
                                    <td>...</td>
                                </tr>
                <!--                <tr class="info">...</tr>-->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        
<!--
        <div class="dummytext">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit! 
        </div>
-->

        <div id="footer">
            <footer>Vivamus molestie pretium nunc tempus enim &copy; 2017 
                <br><a href="http://www.lipsum.com/">Dummy text provided by: http://www.lipsum.com</a> 
            </footer>
        </div>
        
<!--        script -->
        <script type="text/javascript">
            $('#myModal').on
            (
                'shown.bs.modal', function () 
                {
                    $('#myInput').focus()
                }
            ); 
            $('.dropdown-toggle').dropdown();
            $('#myAffix').affix
            (
                {
                    offset: 
                    {
                        top: 100,
                        bottom: function () 
                        {
                            return (this.bottom = $('.footer').outerHeight(true))
                        }
                    }
                }
            );
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="../../dist/js/bootstrap.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
        
    </body>
</html>