<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="PageDetails">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MIS</title>
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/officer.css" rel="stylesheet">
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
	$(document).ready(function() {
		$('.modal').modal();
		 $('#applicationView').on('click', function() {
			});
			$("#applicationView").modal({
				dismissible : false
			});
			 $('#applicationView2').on('click', function() {
				});
	});
	$(document).ready(function() {
		$('.sidenav').sidenav({
			draggable : true
		});
		
		$('.dropdown-trigger').dropdown();
	});
	$(document).ready(function() {
		$('.tabs').tabs();
	});
	
	
	
</script>
</head>
<body ng-controller="officerPageData">

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
				href="/officerDashboard"> <i class="material-icons">dashboard</i>
					<p>Dashboard</p>
			</a></li>
			<li class="nav-item "><a class="nav-link"
				href="/officerDashboard/myAccount"> <i class="material-icons">person</i>
					<p>My Account</p>
			</a></li>
			<!-- <li class="nav-item "><a class="nav-link"
				href="./notifications.html"> <i class="material-icons">notifications</i>
					<p>Notifications</p>
			</a></li> -->
		</ul>
	</div>


	<div id="main_page" class="main_page">
		<h5>Applications</h5>
		<div class="divider"></div>
		<div class="row">
			<div class="col s12 m12 l12">
				<ul class="tabs" style="font: bold;">
					<li class="tab col s2"><a class="active" href="#one">PREPARED APPLICATIONS</a></li>
					<!-- <li class="tab col s2"><a  href="#two">ACCEPTED</a></li>
					<li class="tab col s2"><a  href="#three">COMPLETED</a></li>
					<li class="tab col s2 disabled" ><a  href="#_"></a></li>
					<li class="tab col s2"><a href="#four">REJECTED</a></li>
					<li class="tab col s2"><a  href="#five">ALL</a></li> -->
				</ul>
			</div>
			<br><br><br>
			<div id="one">
				<div class="col s12 m12 l12">
					<table class="responsive-table">

						<tr class="#bbdefb table_head">
							<!-- <th>Application ID</th> -->
							<th>Registration No</th>
							<th>Application Type</th>
							<th>Application Status</th>
							<th>Surname with initials</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
							<th></th>
						</tr>
						<tr ng-repeat="i in preparedApplications">
							<!--  <td>{{i.applicationId}}</td> -->
							<td>{{i.registrationNo}}</td>
							<td>{{i.applicationType}}</td>
							<td>{{i.status}}</td>
							<td>{{i.surnameWithInitials}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="checkApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td><a href="{{downloadURL}}"
								class="waves-effect waves-light btn-small modal-trigger modal-close  light-blue darken-1"><i
									ng-click="downloadPDFApplication(i.applicationId)"
									class="material-icons">download</i></a></td>
						</tr>
					</table>
				</div>
			</div>
			
	<!--  VIEW APPLICATION -->
	<div id="applicationView" class="modal">
		<div class="row">
			<div class="col s8 m8 l8">
				<iframe src="{{pdfURL}}" width="100%" height="500px"></iframe>
			</div>
			<div class="col s4 m4 l4">
				<div class="col s10 m10 l10">
					<br>
					<h6>Application View</h6>
				</div>
				<div class="col s2 m2 l2">
					<br>
					<button
						class="modal-close btn waves-effect waves-light pink darken-1">
						<i class="material-icons">close</i>
					</button>
				</div>

				<div class="container col s12 m12 l12"
					style="display: {{CheckedNotOKFormdisplay}}">

					<div class="divider"></div>
					<br>
					<br>
					<br> <a
						class="waves-effect waves-light btn modal-close  light-blue darken-1"
						ng-click="checkedOKApplication()">OK</a> <br>
					<br>
					<div class="divider"></div>
					<br>
					<br>

					<form>
						<div class="row">
							<div class="input-field col s12 m12 l12">
								<textarea id="reason" name="reason" ng-model="reasonMsg"
									class="materialize-textarea" value="" required></textarea>
								<label for="reason">Reason for NOT OK:</label>

								<button
									class="btn waves-effect waves-light #424242 grey darken-3"
									type="submit" name="action" id="rejectApplication"
									ng-click="checkedNotOKApplication(reasonMsg)">
									Submit<i class="material-icons right ">sd_card_alert</i>
								</button>

							</div>
						</div>
					</form>

				</div>
				<div class="container col s12 m12 l12" style="display: {{checkOKdisplay}}">
					<br>
					<br>
					<br>
					<h6>{{CheckedNotOKMessage}}</h6>
					<br>
					<br>
					<br>
					<button
						class="btn waves-effect waves-light modal-close #424242 green darken-3">
						OK<i class="material-icons right ">done</i>
					</button>
				</div>
			</div>
		</div>
	</div>

	<!--  VIEW APPLICATION WITHOUT ANY OPPTIONS-->
	<div id="applicationView2" class="modal">
		<div class="row">
			<div class="col s12 m12 l12">
				<br>
				<h6>Application View</h6>
				<div class="divider"></div>
				<br>
			</div>

			<div class="col s12 m12 l12">
				<iframe src="{{pdfURL}}" width="100%" height="500px"></iframe>
			</div>
		</div>
	</div>	
		
		
		
	</div>

	
</body>
</html>