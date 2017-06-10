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
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">
          <img alt="Brand" src="./img/favicons/ers-32.png"> Expense Reimbursement System
        </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <!--DISPLAY "ADD EMPLOYEES" BUTTON IF CURRENT USER IS A MANAGER OR "CREATE REQUEST" BUTTON IF CURRENT USER IS AN EMPLOYEE-->
          <#if user??>
            <#if user.isManager()>
              <li>
                <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#registrationModal">
                  <i class="material-icons">group_add</i> Register Employees
                </button>
              </li>
            <#else>
              <li>
                <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#createRequestModal">
                  <i class="material-icons"></i> Create Request
                </button>
              </li>
            </#if>
          </#if>
          <li>
            <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#settingsModal">
              <i class="material-icons">settings</i> Account Settings
            </button>
          </li>
          <li>
            <form class="navbar-form" role="logout" name="logoutForm" method="POST" action="logout">
              <!-- <input type="submit" value="Logout" name="LogoutButton" class="btn btn-default navbar-btn"/> -->
              <button type="button" class="btn btn-default navbar-btn">
                <i class="material-icons">exit_to_app</i> Logout
              </button>
            </form>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- MODALS -->
  <#if user.isManager()>
    <div id="registrationModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
         aria-labelledby="registration-title" data-backdrop="static">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h3 class="modal-title" id="registration-title">Register New Employees</h3>
            <button type="button" class="close" aria-label="Close">
              <!--<span aria-hidden="true">&times;</span>-->
              <i class="material-icons">close</i>
            </button>
          </div>
          <div class="modal-body">

          </div>
          <div class="modal-footer">
            
          </div>
        </div>
      </div>
    </div>
  <#else>
    <div id="createRequestModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
         aria-labelledby="request-title" data-backdrop="static">
      <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h3 class="modal-title" id="request-title">Create a Request</h3>
            <button type="button" class="close" aria-label="Close">
              <!--<span aria-hidden="true">&times;</span>-->
              <i class="material-icons">close</i>
            </button>
          </div>
          <div class="modal-body">

          </div>
          <div class="modal-footer">
            
          </div>
        </div>
      </div>
    </div>
  </#if>

  <div id="settingsModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
       aria-labelledby="settings-title" data-backdrop="static">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h3 class="modal-title" id="settings-title">Account Settings</h3>
            <button type="button" class="close" aria-label="Close">
              <!--<span aria-hidden="true">&times;</span>-->
              <i class="material-icons">close</i>
            </button>
        </div>
        <div class="modal-body">

        </div>
        <div class="modal-footer">
          
        </div>
      </div>
    </div>
  </div>

  <!-- MAIN CONTENT -->
  <main>
    <!--sortable, filterable tables go here-->
    <table id="unresolved" class="table table-hover"></table>
    <table id="resolved" class="table table-hover"></table>


    <!--
    <#if user.isManager()>
      <h2>Welcome to the Manager Homepage, ${user.getFirstname()} ${user.getLastname()}</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Status</th>
            <th >Amount</th>
            <th id="requester">Requested by</th>
            <th id="request-date">On</th>
            <th id="request-purpose">For</th>
            <th id="resolver">Resolved by</th>
            <th id="resolved-date">On</th>
            <th id="resolve-note">Because</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>

        </tbody>
      </table>
    <#else>
      <h2>Welcome to the Employee Homepage, ${user.getFirstname()} ${user.getLastname()}</h2>
      <table>
        <thead>
          <tr>
            <th id="request-id">ID</th>
            <th id="request-state">Status</th>
            <th id="request-amount">Amount</th>
            <th id="requester">Requested by</th>
            <th id="request-purpose">For</th>
            <th id="resolver">Resolved by</th>
            <th id="resolved-date">On</th>
            <th id="resolve-note">Because</th>
          </tr>
        </thead>
        <tbody>

        </tbody>
      </table>
    </#if>
    -->

  </main>
  
</body>
</html>