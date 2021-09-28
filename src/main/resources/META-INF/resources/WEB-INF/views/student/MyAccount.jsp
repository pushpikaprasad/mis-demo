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
	<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/lodash.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	    $('.sidenav').sidenav({
	    	draggable:true
	    });
	    $('.modal').modal();
	    $('.dropdown-trigger').dropdown();
	  });
	$(document).ready(function(){
	    $('.tabs').tabs();
	    /* $('.tabs').tabs({
	        //swipeable : true,
	        responsiveThreshold : 1920
	     }); */
	    
	  });
	
	</script>

<body ng-controller="StudentPageData" id="pageBody">

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
					data-target="dropdown1">${first_name} ${last_name}<i class="material-icons right">arrow_drop_down</i></a></li>
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
		<li class="nav-item active  "><a class="dashboard_link nav-link" href="/studentDashboard">
				<i class="material-icons">dashboard</i>
				<p>Dashboard</p>
		</a></li>
		<li class="nav-item "><a class="nav-link" href="/studentDashboard/myAccount">
				<i class="material-icons">person</i>
				<p>My Account</p>
		</a></li>
		<!-- <li class="nav-item "><a class="nav-link"
			href="./notifications.html"> <i class="material-icons">notifications</i>
				<p>Notifications</p>
		</a></li> -->
	</ul>
	</div>
	
	
	<div id="main_page" class="main_page">
	
	  
	<h5> MY ACCOUNT</h5>
	<div class="divider"></div>
	
	<div class="row">
					    <div class="col s12">
					      <ul class="tabs">
					        <li class="tab col s3"><a class="active" href="#one">Account Details</a></li>
					        <!-- <li class="tab col s3"><a href="#two">More Officers</a></li> -->
					      </ul>
					    </div>
					    <div id="one" class="col s12">
								
									<div class="row">
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>First Name</h6></label>
													<h6>${first_name}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Last Name</h6></label>
													<h6>${last_name}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Username</h6></label>
													<h6>${username}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Registration No</h6></label>
													<h6>${registraionNo}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Address</h6></label>
													<h6>${address}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Email</h6></label>
													<h6>${email}</h6>
												</div>
											</div>
										</div>
										<div class="input-field col s12 m6 l4">
											<div class="card">
												<div class="card-content">
													<label><h6>Mobile No</h6></label>
													<h6>${mobile}</h6>
												</div>
											</div>
										</div>
									</div>
						</div>
					    <!-- <div id="two" class="col s12">Upload Excel sheet here!</div> -->
					  </div>
					  
		</div>
</body>
</html>


<!-- <div style="text-align:center">
	<h1>Welcome to Spring Boot Admin DashBoard</h1>

	<h2>You are in Spring Boot Admin DashBoard Page</h2>
	<br><a href="/logout">logout</a>
	</div> -->