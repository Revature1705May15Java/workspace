<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>PAGE TITLE HERE - Expense Reimbursement System</title>

  <!--favicons-->
	<link rel="shortcut icon" href="./img/favicons/ers.ico">
	<link rel="icon" sizes="16x16 32x32 64x64" href="./img/favicons/ers.ico">
	<link rel="icon" type="image/png" sizes="196x196" href="./img/favicons/ers-192.png">
	<link rel="icon" type="image/png" sizes="160x160" href="./img/favicons/ers-160.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./img/favicons/ers-96.png">
	<link rel="icon" type="image/png" sizes="64x64" href="./img/favicons/ers-64.png">
	<link rel="icon" type="image/png" sizes="32x32" href="./img/favicons/ers-32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="./img/favicons/ers-16.png">
	<link rel="apple-touch-icon" href="./img/favicons/ers-57.png">
	<link rel="apple-touch-icon" sizes="114x114" href="./img/favicons/ers-114.png">
	<link rel="apple-touch-icon" sizes="72x72" href="./img/favicons/ers-72.png">
	<link rel="apple-touch-icon" sizes="144x144" href="./img/favicons/ers-144.png">
	<link rel="apple-touch-icon" sizes="60x60" href="./img/favicons/ers-60.png">
	<link rel="apple-touch-icon" sizes="120x120" href="./img/favicons/ers-120.png">
	<link rel="apple-touch-icon" sizes="76x76" href="./img/favicons/ers-76.png">
	<link rel="apple-touch-icon" sizes="152x152" href="./img/favicons/ers-152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="./img/favicons/ers-180.png">
	<meta name="msapplication-TileColor" content="#FFFFFF">
	<meta name="msapplication-TileImage" content="./img/favicons/ers-144.png">
	<meta name="msapplication-config" content="./img/favicons/browserconfig.xml">

  <!--jQuery-->
  <script src="https://code.jquery.com/jquery-3.2.1.js"
    integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
    crossorigin="anonymous"></script>

  <!-- Tether -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
    integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
    crossorigin="anonymous"></script>

  <!--Bootstrap 4-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
    integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
    crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
    integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
    crossorigin="anonymous"></script>
  
  <!--Bootstrap 3-->
	<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
    integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
    crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
    crossorigin="anonymous"></script>-->

  <!--Bootstrap Toggle Switch-->
  <!--ONLY INCLUDE THIS ON THE PAGE WHERE ACCOUNT SETTINGS ARE DISPLAYED-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css"
    integrity="sha256-rDWX6XrmRttWyVBePhmrpHnnZ1EPmM6WQRQl6h0h7J8="
    crossorigin="anonymous"/>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"
    integrity="sha256-eZNgBgutLI47rKzpfUji/dD9t6LRs2gI3YqXKdoDOmo="
    crossorigin="anonymous"></script>

  <!--List.js-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.5.0/list.min.js"></script>
  <!--<script src="./libs/list.min.js"></script>-->
  
  <!--Material Design Icons-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./css/icon-styles.css">

  <!--THIS SHOULD BE MOVED TO THE END OF THE DOCUMENT BODY--> <script src="./js/ers.js"></script>
  <link rel="stylesheet" href="./css/ers.css">
</head>
<body>
  <!-- NAVBAR -->
  <nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navContent"
            aria-controls="navContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#main">
      <img src="./img/favicons/ers-32.png" width="30" height="30" class="d-inline-block align-top" alt="">
      Expense Reimbursement System
    </a>

    <div class="collapse navbar-collapse" id="navContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#settingsModal">
            <i class="material-icons vert-align">settings</i> Account Settings
          </button>
        </li>
        <li class="nav-item">
          <a href="logout" class="btn btn-default" role="button">
            <i class="material-icons">exit_to_app</i>
          </a>
          <!--<form class="navbar-form" role="logout" name="logoutForm" method="POST" action="logout">
            <button type="submit" class="btn btn-default navbar-btn">
              <i class="material-icons">exit_to_app</i> Logout
            </button>
          </form>-->
        </li>
      </ul>
    </div>
  </nav>

  <!--DECIDE WHERE ON THE PAGE YOU WANT TO PUT THESE BUTTONS-->
  <!--DISPLAY "ADD EMPLOYEES" BUTTON IF CURRENT USER IS A MANAGER OR "CREATE REQUEST" BUTTON IF CURRENT USER IS AN EMPLOYEE-->
  <#if user.isManager()>
    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#registerModal">
      <i class="material-icons">group_add</i> Register Employees
    </button>
  <#else>
    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#requestModal">
      <i class="material-icons vert-align"></i> Create Request
    </button>
  </#if>

  <!-- MODALS -->
  <!-- Settings Modal -->
  <div class="modal fade" id="settingsModal" tabindex="-1" role="dialog" aria-labelledby="settingsModalLabel"
       aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog" role="form">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="settingsModalLabel">Account Settings</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <i class="material-icons vert-align">close</i>
          </button>
        </div>
        <div class="modal-body">
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
          <button type="button" class="btn btn-primary">Save changes</button>
        </div>
      </div>
    </div>
  </div>

  <#if user??>
    <#if user.isManager()>
      <!-- Registration Modal -->
      <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
           aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog" role="form">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="registerModalLabel">Register Users</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <i class="material-icons">close</i>
              </button>
            </div>
            <div class="modal-body">
              
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
              <button type="button" class="btn btn-primary">Register</button>
            </div>
          </div>
        </div>
      </div>
    <#else>
      <!-- Request Modal -->
      <div class="modal fade" id="requestModal" tabindex="-1" role="dialog" aria-labelledby="requestModalLabel"
           aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog" role="form">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="requestModalLabel">Make Request</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <i class="material-icons">close</i>
              </button>
            </div>
            <div class="modal-body">
              
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
              <button type="button" class="btn btn-primary">Submit</button>
            </div>
          </div>
        </div>
      </div>
    </#if>
  </#if>

  <#if user??>
    Welcome ${user.firstname} ${user.lastname}
  </#if>
</body>
</html>