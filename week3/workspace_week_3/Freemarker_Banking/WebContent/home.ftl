<html>

<head>

<script
  src="https://code.jquery.com/jquery-3.2.1.min.js"
  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


	<title>Welcome Page</title>
</head>
<body style="background-color: aquamarine;">

	<div class="jumbotron" style="background-color: skyblue; color: purple;">
	
	<h3 style="text-align: center;">Welcome ${fn} ${ln}!</h3>
	
	</div>
	
	<div class="jumbotron" style="background-color: skyblue;">

		<table class="table table-hover" style="text-align: center;">
			<tr>
			<th style="text-align: center;">ID</th>
			<th style="text-align: center;">Balance</th>
			</tr>
			<#list Account as acc>
				<tr>
					<td>${acc.getId()}  </td> <td>${acc.getBalance()}</td>
				</tr>
			</#list>
			
		</table>
		
	</div>
	
</body>

</html>