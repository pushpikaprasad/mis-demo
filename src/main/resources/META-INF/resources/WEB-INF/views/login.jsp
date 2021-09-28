<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MIS</title>
<link href="css/login.css" rel="stylesheet">
<link href="css/materialize.css" rel="stylesheet">
<link href="css/materialize.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	<div class="row">
	<div class="section"></div>
		<div class="col s12 m6">
			<div class="section"></div>
			<div class="section"></div>
			<div class="container col s12">
			<h3>Welcome Again !</h3>
			</div>

		</div>
		<div class="col s12 m6"> 
			<div class="section"></div>
			<div class="section"></div>
			<div class="card">
			
			<div class="login container center-align col s12 z-depth-4">
				<div class="row transparent"
					style="margin: 10px 0px 10px 0px; padding: 32px 32px 32px 32px; border: 1px solid #EEE;">
					<%-- <p>${error}</p> --%>
					<div class="row">
						 <div class="">
						    <span class="white-text text-darken-2"><h6><b>${loginError}</b></h6></span>
						 </div>
					</div>
					
					<form method="POST" action="/login_success" class="col s12">
						
						<div class='row'>
							<div class='input-field col s12'>
								<input class='validate' type='text' name="username"
									id='username' required /> <label style="color: #fff;" for='username'>Username</label>
							</div>
						</div>

						<div class='row'>
							<div class='input-field col s12'>
								<input class='validate' type='password' name='password'
									id='password' required /> <label style="color: #fff;" for='password'>Password</label>
							</div>
						</div>

						<br />
						<div style="align: center">
							<div class='row'>
								<button type='submit' name='btn_login'
									class='col s12 btn btn-large waves-effect indigo'>Login</button>
							</div>
						</div>

						<!-- <p class="login__signup">
							Don't have an account? &nbsp;<a href="/register">Register</a>
						</p> -->

					</form>
				</div>
			</div>
			</div>
		</div>

	</div>
	</div>


	<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>