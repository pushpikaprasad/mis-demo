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
	    $('#DeleteOfficer').on('click', function() {
		});
		$("#DeleteOfficer").modal({
			dismissible : false
		});
		$('#EditOfficer').on('click', function() {
		});
		$("#EditOfficer").modal({
			dismissible : false
		});
		
		
		$('select').formSelect();
	  });
	$(document).ready(function(){
	    $('.sidenav').sidenav({
	    	draggable:true
	    });
	    $('.modal').modal();
	    $('.dropdown-trigger').dropdown();
	  });
	$(document).ready(function(){
	    $('.tabs').tabs();
	    
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
			<li class="nav-item active  "><a class="dashboard_link nav-link"
				href="/adminDashboard"> <i class="material-icons">dashboard</i>
					<p>Dashboard</p>
			</a></li>
			<li class="nav-item "><a class="nav-link"
				href="/adminDashboard/myAccount"> <i class="material-icons">person</i>
					<p>My Account</p>
			</a></li>
			
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
					<a href="#AddOfficer" class="black-text modal-trigger" ng-click="openAddOfficerForm()">
						<div class="card-content  waves-effect waves-block waves-light">
							<span class="card-title activator text-darken-4"> ADD
								OFFICERS<i class="material-icons right" style="font-size: 55px;">group_add</i>
							</span>
						</div>
					</a>
				</div>
			</div>
		</div>

		<h5>Officers</h5>
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
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<tr ng-repeat="i in officers">
						<td>{{i.firstName}}</td>
						<td>{{i.lastName}}</td>
						<td>{{i.username}}</td>
						<td>{{i.address}}</td>
						<td>{{i.email}}</td>
						<td>{{i.mobileNumber}}</td>
						<td><a
									class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
									href="#EditOfficer" value="i.cultivationId"
									ng-click="updateOfficerView(i.email)"><i
										class="material-icons">edit</i></a></td>
						<td><a
									class="waves-effect waves-light btn modal-trigger modal-close  red darken-1"
									href="#DeleteOfficer" value="i.email"
									ng-click="deleteOfficerEmail(i.email)"><i
										class="material-icons">delete</i></a></td>
								<td"></td>
						

					</tr>
				</table>
			</div>
		</div>
	</div>

	<!-- Add Officers -->
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
					<h5>ADD OFFICERS</h5>
				</div>
			</div>

			<div class="row">
				<div class="col s12">
					<ul class="tabs">
						<li class="tab col s3"><a class="active" href="#one">Add
								Officer</a></li>
						
					</ul>
				</div>
				<div id="one" class="col s12">
					<form>
						<div class="row">
							<div class="input-field col s12 m12 l4">
								<input id="firstName" name="firstName" type="text"
									class="validate" ng-model="officer_firstName"> <label
									for="firstName">First Name</label>
							</div>
						
							<div class="input-field col s12 m12 l4">
								<input id="lastName" name="lastName" type="text"
									class="validate" ng-model="officer_lastName"> <label
									for="lastName">Last Name</label>
							</div>
						
							<div class="input-field col s12 m12 l4">
								<input id="username" name="username" type="text"
									class="username" ng-model="officer_username"> <label
									for="username">Username</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="password" name="password" type="text"
									class="password" ng-model="officer_password"> <label
									for="password">Password</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="nic" name="nic" type="text" class="validate"
									ng-model="officer_nic"> <label for="nic">NIC No:</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="address" name="address" type="text" class="validate"
									ng-model="officer_address"> <label for="address">Address</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="email" name="email" type="email" class="validate"
									ng-model="officer_email"> <label for="email">Email</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="mobileNumber" name="mobileNumber" type="text"
									class="validate" ng-model="officer_mobileNumber"> <label
									for="mobileNumber">Mobile No:</label>
							</div>
							<div class="divider"></div>
							
							
							<div class="input-field col s12 m12 l12">
							<br><h6>Work Category</h6>
							<p>
							<label>
							<input id="checkBox1" type="checkbox" value="1" ng-model="officer_workCategoryID1"/>
							<span>Check Applications</span>
							</label></p>
							<p>
							<label>
							<input id="checkBox2" type="checkbox" value="2" ng-model="officer_workCategoryID2"/>
							<span>Process Accepted Applications</span>
							</label>
							</p>
							<p>
							<label>
							<input id="checkBox2" type="checkbox" value="2" ng-model="officer_workCategoryID3"/>
							<span>Check Transcript/Academic Documents</span>
							</label>
							</p>
								    
							</div>
							
							<div class="modal-footer">
								<button class="btn waves-effect waves-light modal-close"
									type="submit" name="action" id="addAction"
									ng-click="addOfficer(officer_firstName,officer_lastName,officer_username,officer_password,officer_nic,officer_address,officer_email,officer_mobileNumber, officer_workCategoryID1,officer_workCategoryID2,officer_workCategoryID3)">
									Add <i class="material-icons right">playlist_add</i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Edit Officers -->
	<div id="EditOfficer" class="modal">
		<div class="modal-content">
			<div class="raw">
				<div class="col s12 m12 l12">
					<div class="right-align">
						<button
							class="modal-close btn waves-effect waves-light pink darken-1 ">
							<i class="material-icons">close</i>
						</button>
					</div>
					<h5>EDIT OFFICERS</h5>
				</div>
			</div>

			<div class="row">
				<div class="col s12">
					<ul class="tabs">
						<li class="tab col s3"><a class="active" href="#one">Edit
								Officer</a></li>
					</ul>
				</div>
				<div id="one" class="col s12">
					<form>
						<div class="row">
							<div class="input-field col s12 m12 l4">
								<input id="id" name="id" type="hidden" value="{{officerID}}"
									class="validate" ng-model="officer_ID">
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="firstName" name="firstName" type="text" placeholder="{{uo_firstName}}"  value="{{uo_firstName}}"
									class="validate" ng-model="uof_firstName"> <label
									for="firstName">First Name</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="lastName" name="lastName" type="text" placeholder="{{uo_lastName}}"  value="{{uo_lastName}}"
									class="validate" ng-model="uof_lastName"> <label
									for="lastName">Last Name</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="nic" name="nic" type="text" class="validate" 
									ng-model="uof_nic" placeholder="{{uo_nic}}"  value="{{uo_nic}}">  <label for="nic">NIC No:</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="address" name="address" type="text" class="validate" placeholder="{{uo_address}}"  value="{{uo_address}}"
									ng-model="uof_address"> <label for="address">Address</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="email" name="email" type="email" class="validate" placeholder="{{uo_email}}"  value="{{uo_email}}"
									ng-model="uof_email"> <label for="email">Email</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="mobileNumber" name="mobileNumber" type="text" placeholder="{{uo_mobileNumber}}"  value="{{uo_mobileNumber}}"
									class="validate" ng-model="uof_mobileNumber"> <label
									for="mobileNumber">Mobile No:</label>
							</div>
							
							<div class="input-field col s12 m12 l4">
								<input id="workCategoryID" name="workCategoryID" type="text" placeholder="{{uo_workCategoryId}}" value="{{uo_workCategoryId}}"
									class="validate" ng-model="uof_workCategoryId"> <label
									for="workCategoryID">Work Category:</label>
							</div>
							
							<div class="modal-footer">
								<button class="btn waves-effect waves-light modal-close"
									type="submit" name="action" id="addAction"
									ng-click="updateOfficer(officerID, uof_firstName,uof_lastName,uof_nic,uof_address,uof_email,uof_mobileNumber, uof_workCategoryId)">
									Update <i class="material-icons right">edit</i>
								</button>
							</div>
						</div>
					</form>
				</div>
				<!-- <div id="two" class="col s12">Upload Excel sheet here!</div> -->
			</div>
		</div>
	</div>
	<!-- DELETE OFFICER -->
	<div id="DeleteOfficer" class="modal">
		<div class="modal-content">
			<div class="raw">
						<div class="col s12  m12 l12">
							<div class="right-align">
								<button
									class="modal-close btn waves-effect waves-light pink darken-1 ">
									<i class="material-icons">close</i>
								</button>
							</div>
						</div>
						<div class="col s11 m11 l11">
							<h5>Do you need to delete this Officer's Account? </h5><br>
								Email : {{deleteOfficerbyEmail}}<br>
						</div>
					</div>
					<div class="raw">
					<form>
						<div class="right-align ">
							<button
								class="btn waves-effect waves-light modal-close blue-text blue lighten-5">
								No</button>
							<button
								class="btn waves-effect waves-light modal-close red darken-1"
								type="submit" name="action"
								ng-click="deleteOfficer(deleteOfficerbyEmail)">Delete</button>
						</div>
					</form>
					</div>
		</div>
	</div>
	
</body>
</html>


