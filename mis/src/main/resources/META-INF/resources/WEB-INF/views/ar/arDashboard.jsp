<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="PageDetails">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MIS</title>
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/student.css" rel="stylesheet">
<link href="css/materialize.css" rel="stylesheet">
<link href="css/materialize.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/toastr.min.css">



<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/toastr.min.js"></script>
<script type="text/javascript" src="js/lodash.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	    $('.modal').modal();
	    $('.modal').on('click', function() {
		});

		 $('#applicationView').on('click', function() {
			});

	  });
	$(document).ready(function(){
	    $('.sidenav').sidenav({
	    	draggable:true
	    });
	    $('.dropdown-trigger').dropdown();
	  });
	$(document).ready(function(){
	    $('.tabs').tabs();   
	  });
	

	</script>

</head>
<body ng-controller="ArPageData">

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
			<li class="nav-item active  "><a class="nav-link"
				href="/arDashboard"> <i class="material-icons">dashboard</i>
					<p>Dashboard</p>
			</a></li>
			<li class="nav-item "><a class="nav-link"
				href="/arDashboard/myAccount"> <i class="material-icons">person</i>
					<p>My Account</p>
			</a></li>
			<!-- <li class="nav-item "><a class="nav-link"
				href="./notifications.html"> <i class="material-icons">notifications</i>
					<p>Notifications</p>
			</a></li> -->
		</ul>
	</div>


	<div id="main_page" class="main_page">
		<h5>Dashboard</h5>
		<div class="divider"></div>
		<div class="row">
			
			<div id="view_applications" class="col s12 m12 l4">
				<div class="card cardHover">
					<a href="/arDashboard/Applications"
						class="black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4">
								APPLICATIONS<i class="material-icons right"
								style="font-size: 55px;">description</i>
							</span>
						</div>
					</a>
				</div>
			</div>
			
			<div class="col s12 m6 l4">
				<div class="card cardHover">
					<!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
					<a href="/arDashboard/employees" class="black-text">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> EMPLOYEE<i
								class="material-icons right" style="font-size: 55px;">badge</i></span>
						</div>
					</a>
				</div>
			</div>

		</div>


	</div>



	<div class="modal-looading">
		<!-- Place at bottom of page -->
	</div>

</body>

</html>
