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

<body ng-controller="arPageData" id="pageBody">

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
		<li class="nav-item active  "><a class="dashboard_link nav-link" href="/arDashboard">
				<i class="material-icons">dashboard</i>
				<p>Dashboard</p>
		</a></li>
		<li class="nav-item "><a class="nav-link" href="/arDashboard/myAccount">
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
					        <li class="tab col s3"><a class="active" href="#one">SETTINGS</a></li>
					        <!-- <li class="tab col s3"><a href="#two">More Officers</a></li> -->
					      </ul>
					    </div>
					    <div id="one" class="col s12">
								<form >	
								
									<div class="row">
										<div class="input-field col s12 m12 l4">
											<input id="firstName" name="firstName" type="text"
												class="validate" ng-model="firstName" placeholder="{{firstName}}" value="{{firstName}}"> <label
												for="firstName">First Name</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="lastName" name="lastName" type="text"
												class="validate" ng-model="lastName" placeholder="{{lastName}}" value="{{lastName}}"> <label
												for="lastName">Last Name</label>
										</div>
									<!-- </div>
									<%-- <div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="username" name="username" type="text"
												class="username" ng-model="username" placeholder="${username}"> <label
												for="username">Username</label>
										</div> --%>
									<!-- </div>
									<div class="row"> -->
										<!-- <div class="input-field col s12 m12 l4">
											<input id="password" name="password" type="text"
												class="password" ng-model="password"> <label
												for="password">Password</label>
										</div> -->
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="nic" name="nic" type="text"
												class="validate" ng-model="nic" placeholder="{{nic}}" value="{{nic}}"> <label
												for="nic">NIC No:</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="address" name="address" type="text"
												class="validate" ng-model="address" placeholder="{{address}}" value="{{address}}"> <label
												for="address">Address</label>
										</div>
									<!-- </div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="email" name="email" type="email"
												class="validate" ng-model="email" placeholder="{{email}}" value="{{email}}"> <label
												for="email">Email</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="mobileNumber" name="mobileNumber" type="text"
												class="validate" ng-model="mobileNumber" placeholder="{{mobile}}" value="{{mobile}}"> <label
												for="mobileNumber">Mobile No:</label>
										</div>
									<!-- </div> -->				
									<div class="modal-footer">
										<button class="btn waves-effect waves-light modal-close"
											type="submit" name="action" id="updateAction"
											ng-click="updateAr(firstName,lastName,nic,address,email,mobileNumber)">
											Update <i class="material-icons right">playlist_add_check</i>
										</button> <b>{{updatedMsg}}</b>
									</div>
									</div>
								</form>
						</div>
					    <!-- <div id="two" class="col s12">Upload Excel sheet here!</div> -->
					  </div>
		</div>
</body>
</html>

