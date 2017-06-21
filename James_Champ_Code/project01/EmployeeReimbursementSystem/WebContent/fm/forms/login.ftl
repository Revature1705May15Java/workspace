<div class="row">
	<div class="col-lg-3"></div>

	<div class="col-lg-6">
		<div>
			<div class="jumbotron">
				<#if error! == "true">
					<div class="alert alert-danger" role="alert">Invalid email address or password</div>
				</#if>

				<form method="POST" action="login">
					<div class="input_group">
						<table>
							<tr>
								<td>User Name:</td>
								<td><input class="form-control" type="email" name="email" required></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td> <input class="form-control" type="password" name="password" required></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td class="text-right"><input class="btn btn-default" type="submit" value="Login"></td>
							</tr>
						</table>
					</div>
				</form>
				
			</div>
		</div>
	</div>

	<div class="col-lg-3"></div>

</div>