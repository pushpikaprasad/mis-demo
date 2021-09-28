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
	    $('#AddOfficer').on('click', function() {
		});
		$("#AddOfficer").modal({
			dismissible : false
		});
	  });
	$(document).ready(function(){
	    $('.sidenav').sidenav({
	    	draggable:true
	    });
	    $('.modal').modal();
	    $('.dropdown-trigger').dropdown();
	    $('#AddOfficer').on('click', function() {
		});
		$("#AddOfficer").modal({
			dismissible : false
		});
	  });
	$(document).ready(function(){
	    $('.tabs').tabs();
	    /* $('.tabs').tabs({
	        //swipeable : true,
	        responsiveThreshold : 1920
	     }); */
	    
	  });
	$('#left-side').on("click",".dashboard_link",function(e){ 
		  e.preventDefault(); // cancel click
		  var page = $(this).attr('href');   
		  $('body').fadeIn('slow', function(){
			 // $('body').fadeOut(300);
			  $('body').load(page);
			  window.history.pushState("Details", "Title", "/adminDashboard");
		  });
		});
	</script>

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
		<li class="nav-item active  "><a class="dashboard_link nav-link" href="/adminDashboard">
				<i class="material-icons">dashboard</i>
				<p>Dashboard</p>
		</a></li>
		<li class="nav-item "><a class="nav-link" href="/adminDashboard/myAccount">
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
	<!-- <h5> Student Accounts</h5>
	<div class="divider"></div> -->
	<div class="row">
	    <div class="col s12 m12 l4">
	        <div class="card cardHover">
                 <!-- <div class="card-image waves-effect waves-block waves-light">
                   image link 
                 </div> -->
                 <a href="#AddOfficer" class="black-text modal-trigger" ng-click="openAddArForm()">
                 <div class="card-content  waves-effect waves-block waves-light">
                   <span class="card-title activator text-darken-4">
                   ADD AR<i class="material-icons right" style="font-size: 55px;">person_add</i></span>
                 </div>
                 </a>
	    </div>
	    </div>
	  </div>
	  
	<h5> Ars</h5>
	<div class="divider"></div>
	<div class="row">
	    <div class="col s12 m12 l12">
	       <table class="responsive-table">
	       
	       <tr class="#bbdefb blue lighten-4">
	       <th>First Name</th>
	       <th>Last Name</th>
	       <th>Username</th>
	       <th>Address</th>
	       <th>Email</th>
	       <th>Mobile</th>
	       <th>Login Status</th>
	       </tr>
	       <tr ng-repeat="i in ars">
								<td>{{i.firstName}}</td>
								<td>{{i.lastName}}</td>
								<td>{{i.username}}</td>
								<td>{{i.address}}</td>
								<td>{{i.email}}</td>
								<td>{{i.mobileNumber}}</td>
								<td>{{i.loginStatus}}</td>
								<!-- <td><a
									class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
									href="#UpdateCultivation" value="i.cultivationId"
									ng-click="updateClick(i.cultivationId,i.cultivationType,i.harvestAmount,i.location, i.availability,i.farmerId )"><i
										class="material-icons">edit</i></a></td>
								<td><a
									class="waves-effect waves-light btn modal-trigger modal-close  red darken-1"
									href="#DeleteCultivation" value="i.cultivationId"
									ng-click="deleteClick(i.cultivationId)"><i
										class="material-icons">delete</i></a></td>
								<td"></td> -->
								<td><div class="divider"></div></td>

			</tr>
	       </table>
	    </div>
	  </div>
	</div>
	
	<!-- Add Ars -->
	<div id="AddOfficer" class="modal">
				<div class="modal-content">
					<div class="raw">
						<div class="col s12 m12 l12">
							<div class="right-align">
								<button
									class="modal-close btn waves-effect waves-light pink darken-1 ">
									<i class="material-icons">close</i>
								</button>
							</div>
							<h5>ADD AR</h5>
						</div>
					</div>
					
					<div class="row">
					    <div class="col s12">
					      <ul class="tabs">
					        <li class="tab col s3"><a class="active" href="#one">Add Ar</a></li>
					        <!-- <li class="tab col s3"><a href="#two">More Ars</a></li> -->
					      </ul>
					    </div>
					    <div id="one" class="col s12">
								<form>	
									<div class="row">
										<div class="input-field col s12 m12 l4">
											<input id="firstName" name="firstName" type="text"
												class="validate" ng-model="Ar_firstName"> <label
												for="firstName">First Name</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="lastName" name="lastName" type="text"
												class="validate" ng-model="Ar_lastName"> <label
												for="lastName">Last Name</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="username" name="username" type="text"
												class="username" ng-model="Ar_username"> <label
												for="username">Username</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="password" name="password" type="text"
												class="password" ng-model="Ar_password"> <label
												for="password">Password</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="nic" name="nic" type="text"
												class="validate" ng-model="Ar_nic"> <label
												for="nic">NIC No:</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="address" name="address" type="text"
												class="validate" ng-model="Ar_address"> <label
												for="address">Address</label>
										</div>
									<!-- </div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="email" name="email" type="email"
												class="validate" ng-model="Ar_email"> <label
												for="email">Email</label>
										</div>
									<!-- </div>
									<div class="row"> -->
										<div class="input-field col s12 m12 l4">
											<input id="mobileNumber" name="mobileNumber" type="text"
												class="validate" ng-model="Ar_mobileNumber"> <label
												for="mobileNumber">Mobile No:</label>
										</div>
									<!-- </div> -->				
									<div class="modal-footer">
										<button class="btn waves-effect waves-light modal-close"
											type="submit" name="action" id="addAction"
											ng-click="addAr(Ar_firstName,Ar_lastName,Ar_username,Ar_password,Ar_nic,Ar_address,Ar_email,Ar_mobileNumber)">
											Add <i class="material-icons right">playlist_add</i>
										</button>
									</div>
									</div>
								</form>
						</div>
					    <!-- <div id="two" class="col s12">Upload Excel sheet here!</div> -->
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