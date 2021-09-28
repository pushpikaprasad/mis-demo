<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="PageDetails">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MIS</title>
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/admin.css" rel="stylesheet">
<link href="css/materialize.css" rel="stylesheet">
<link href="css/materialize.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/lodash.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $('.modal').modal();
	    $('#AddStudent').on('click', function() {
		});
		$("#AddStudent").modal({
			dismissible : false
		});
	  });
	$(document).ready(function(){
	    $('.sidenav').sidenav({
	    	draggable:true
	    });
	    $('.modal').modal();
	    $('.dropdown-trigger').dropdown();
	    $('#AddStudent').on('click', function() {
		});
		$("#AddStudent").modal({
			dismissible : false
		});
	  });
	$(document).ready(function(){
	    $('.tabs').tabs();	    
	  });
	
	</script>
</head>
<body ng-controller="PageData">

	<div id="top">
		<ul id="dropdown1" class="dropdown-content">
			<li><a href="/logout">Logout</a></li>
		</ul>
		<nav class="navbar">
			<div class="nav-wrapper">
				<a href="#" data-target="slide-out" class="sidenav-trigger"><i
					class="material-icons">menu</i></a>
				<ul class="right">
					<!--  <li><a href="sass.html">Sass</a></li>
		      <li><a href="badges.html">Components</a></li> -->
					<!-- Dropdown Trigger -->
					<li><a class="dropdown-trigger" href="#!"
						data-target="dropdown1">${first_name} ${last_name}<i
							class="material-icons right">arrow_drop_down</i></a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div id="left-side">
		<ul id="slide-out" class="sidenav sidenav-fixed z-depth-4">
			<li>

				<p class="MIS-logo">MIS</p>
			</li>
			<li><div class="divider"></div></li>
			<li class="nav-item active  "><a class="nav-link" href="#0">
					<i class="material-icons">dashboard</i>
					<p>Dashboard</p>
			</a></li>
			<li class="nav-item "><a class="nav-link"
				href="/adminDashboard/myAccount"> <i class="material-icons">person</i>
					<p>My Account</p>
			</a></li>
			<!-- <li class="nav-item "><a class="nav-link"
				href="./notifications.html"> <i class="material-icons">notifications</i>
					<p>Notifications</p>
			</a></li> -->
		</ul>
	</div>


	<div id="main_page" class="main_page">
		<h5>Manage Accounts</h5>
		<div class="divider"></div>
		<div class="row">
			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/adminDashboard/students"
						class="btn_load_student black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> STUDENTS<i
								class="material-icons right" style="font-size: 55px;">people_alt</i></span>
						</div>
					</a>
				</div>
			</div>

			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/adminDashboard/officers" class="black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> OFFICERS<i
								class="material-icons right" style="font-size: 55px;">supervised_user_circle</i></span>
						</div>
					</a>
				</div>
			</div>

			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/adminDashboard/ar" class="black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> AR<i
								class="material-icons right" style="font-size: 55px;">account_circle</i></span>
						</div>
					</a>
				</div>
			</div>
			
			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/adminDashboard/employees" class="black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> EMPLOYEE<i
								class="material-icons right" style="font-size: 55px;">badge</i></span>
						</div>
					</a>
				</div>
			</div>
		</div>
		
		<h5>Common Features</h5>
		<div class="divider"></div>
		<div class="row">
			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/adminDashboard/resetPassword"
						class="btn_load_student black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> Reset Password<i
								class="material-icons right" style="font-size: 55px;">password</i></span>
						</div>
					</a>
				</div>
			</div>
		
		
	</div>
</body>
</html>


<!-- <div style="text-align:center">
	<h1>Welcome to Spring Boot Admin DashBoard</h1>

	<h2>You are in Spring Boot Admin DashBoard Page</h2>
	<br><a href="/logout">logout</a>
	</div> -->