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

<link rel="stylesheet" href="css/toastr.min.css">

<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/toastr.min.js"></script>
<script type="text/javascript" src="js/lodash.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.modal').modal();
		$('#AddEmployee').on('click', function() {
		});
		$("#AddEmployee").modal({
			dismissible : false
		});

		$('#DeleteEmployee').on('click', function() {
		});
		$("#DeleteEmployee").modal({
			dismissible : false
		});
		$('select').formSelect();

	});
	$(document).ready(function() {
		$('.sidenav').sidenav({
			draggable : true,
		});
		$('.modal').modal();
		$('.dropdown-trigger').dropdown();
	});
	$(document).ready(function() {
		$('.tabs').tabs();

	});
</script>
<style>
.main_page {
	margin: 0% 2% 0% 2%;
}

.sidenav-trigger {
	display: block !important;
}

/* .card {
	width: 100%;
	padding: 0% 0% 15% 0%;
} */

.input-field label {
	color: #212121 !important;
	font-size: 20px !important;
}

.input-field input[type=text]:focus {
	border-bottom: 1px solid #212121 !important;
	box-shadow: 0 1px 0 0 #212121 !important;
}

disabled {
    pointer-events: none;
}
</style>
<body ng-controller="arPageData">

	<div id="top">
		<ul id="dropdown1" class="dropdown-content">
			<li><a href="/logout">Logout</a></li>
		</ul>
		<nav class="navbar">
			<div class="nav-wrapper">
				<a href="#" data-target="slide-out" class="sidenav-trigger"><i
					class="material-icons">menu</i></a>
				<ul class="right">
					<li><a class="dropdown-trigger" href="#!"
						data-target="dropdown1">{{firstName}} {{lastName}}<i
							class="material-icons right">arrow_drop_down</i></a></li>
				</ul>

			</div>

		</nav>

	</div>

	<div id="left-side">
		<ul id="slide-out" class="sidenav z-depth-4">
			<li>

				<p class="MIS-logo">MIS</p>
			</li>
			<li><div class="divider"></div></li>
			<li class="nav-item active "><a class="dashboard_link nav-link"
				href="/arDashboard"> <i class="material-icons">dashboard</i>
					<p>Dashboard</p>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/arDashboard/myAccount"> <i class="material-icons">person</i>
					<p>My Account</p>
			</a></li>
		</ul>
	</div>


	<div id="main_page" class="main_page">
		<h4>Employee List</h4>
		<div class="divider"></div>

		<div class="row">
			<div class="col s12 m12 l12">
				<div class="card z-depth-4">
					<div class="card-content">
					<span class="card-title"><b>Search Employees</b></span>
							
						<form>
						<div class = "row">
							
								<div class="input-field col s12 m12 l4">
									<input id="employeeNumber" name="employeeNumber" type="text" value=""
										class="validate" ng-model="emNumber"> <label
										for="employeeNumber"> Employee No.</label>
								</div>
								<div class="input-field col s12 m12 l8">
									<input id="surnameWithInitials" name="surnameWithInitials" value=""
										type="text" class="validate"
										ng-model="empSurname"> <label
										for="surnameWithInitials"> Surname</label>
								</div>
								<div class="input-field col s12 m12 l6">
									<select id="designation" name="designation"
										ng-model="empDesig">
										<option value="" disabled selected>Choose Designation</option>
										<option value="" selected>--Any--</option>
										<optgroup label="Specific">
											<option value="Lecturer">Lecturer</option>
											<option value="Technical Officer">Technical Officer</option>
											<option value="Lab Attendant">Lab Attendant</option>
											<option value="Electrician">Electrician</option>
											<option value="Engineer">Engineer</option>
											<option value="Workshop">Workshop</option>
											<option value="Works Aide">Works Aide</option>
											<option value="Carpenter">Carpenter</option>
											<option value="Machinist">Machinist</option>
											<option value="Mason">Mason</option>
										</optgroup>
										<optgroup label="Specific">
												<option value="Account Assistant">Account Assistant</option>
												<option value="Assistant Registrar">Assistant Registrar</option>
												<option value="Audio Visual Technical Officer - Grade II">Audio Visual Technical Officer - Grade II</option>
												<option value="Auto Electrician - Grade II">Auto Electrician - Grade II</option>
												<option value="Blacksmith - Grade I">Blacksmith - Grade I</option>
												<option value="Book Binder - Grade I">Book Binder - Grade I</option>
												<option value="Carpenter - Grade II">Carpenter - Grade II</option>
												<option value="Carpenter - Special Grade">Carpenter - Special Grade</option>
												<option value="Computer Operator">Computer Operator</option>
												<option value="course Secretary">course Secretary</option>
												<option value="Electrician - Special Grade">Electrician - Special Grade </option>
												<option value="Engineer [Administration]">Engineer [Administration]</option>
												<option value="Engineer Projects">Engineer Projects</option>
												<option value="Engineering Teaching Assistant Gr.I">Engineering Teaching Assistant Gr.I</option>
												<option value="Foundryman - Grade II">Foundryman - Grade II</option>
												<option value="Instrument Mechanic - Grade III">Instrument Mechanic - Grade III</option>
												<option value="Lab Attendant - Grade III">Lab Attendant - Grade III</option>
												<option value="Lab Attendant - Higher Grade">Lab Attendant - Higher Grade</option>
												<option value="Lab Attendant - Special Grade">Lab Attendant - Special Grade</option>
												<option value="Lab Attendant - Supra Grade">Lab Attendant - Supra Grade</option>
												<option value="Lecturer">Lecturer</option>
												<option value="Lecturer(Probationary)">Lecturer(Probationary)</option>
												<option value="Machinist - Grade II">Machinist - Grade II</option>
												<option value="Machinist - Special Grade">Machinist - Special Grade</option>
												<option value="Management Assistant">Management Assistant</option>
												<option value="Management Assistant - Grade I">Management Assistant - Grade I </option>
												<option value="Management Assistant - Grade II">Management Assistant - Grade II</option>
												<option value="Management Assistant - Grade III">Management Assistant - Grade III</option>
												<option value="Management Assistant (Store Keeping) - Grade III">Management Assistant (Store Keeping) - Grade III</option>
												<option value="Mason - Grade II">Mason - Grade II</option>
												<option value="Mason - Special Grade">Mason - Special Grade</option>
												<option value="Mechanic - Grade II">Mechanic - Grade II</option>
												<option value="Office Aid">Office Aid</option>
												<option value="Office Machine Operator - Grade I">Office Machine Operator - Grade I</option>
												<option value="Painter - Grade II">Painter - Grade II</option>
												<option value="Professor">Professor</option>
												<option value="Professor-Chair">Professor-Chair</option>
												<option value="Secretarial Assistant">Secretarial Assistant</option>
												<option value="Secretary">Secretary</option>
												<option value="Senior Assistant Bursar">Senior Assistant Bursar</option>
												<option value="Senior Computer Operator">Senior Computer Operator </option>
												<option value="Senior Engineering Teaching Assistant">Senior Engineering Teaching Assistant</option>
												<option value="Senior Lecturer Gr.I">Senior Lecturer Gr.I</option>
												<option value="Senior Lecturer Gr.II">Senior Lecturer Gr.II</option>
												<option value="Senior Professor">Senior Professor</option>
												<option value="Senior Staff Assistant / Telephone Operator cum Receptionist">Senior Staff Assistant / Telephone Operator cum Receptionist</option>
												<option value="Senior Staff Management Assistant">Senior Staff Management Assistant</option>
												<option value="Senior Staff Technical Officer">Senior Staff Technical Officer</option>
												<option value="Staff Management Assistant">Staff Management Assistant</option>
												<option value="Staff Technical Officer - Grade I">Staff Technical Officer - Grade I</option>
												<option value="Staff Technical Officer - Grade II">Staff Technical Officer - Grade II</option>
												<option value="Storeman - Grade II">Storeman - Grade II</option>
												<option value="Technical Officer - Grade I">Technical Officer - Grade I</option>
												<option value='Technical Officer - Grade II seg "A"'>Technical Officer - Grade II seg"A"</option>
												<option value='Technical Officer - Grade II seg "A" (ICT)*'>Technical Officer - Grade II seg"A" (ICT)*</option>
												<option value='Technical Officer - Grade II Seg "B"'>Technical Officer - Grade II Seg"B"</option>
												<option value="Tinker - Grade II">Tinker - Grade II</option>
												<option value="Trainee Technical Officer">Trainee Technical Officer</option>
												<option value="Trainee Technical Officer (ICT)*">Trainee Technical Officer (ICT)*</option>
												<option value="Welder - Grade II">Welder - Grade II</option>
												<option value="Works Aide">Works Aide</option>
												<option value="Works Aide - Grade I">Works Aide - Grade I</option>
												<option value="Works Aide - Grade II">Works Aide - Grade II</option>
												<option value="Works Aide - Grade III">Works Aide - Grade III</option>
												<option value="Works Aide - Special Grade">Works Aide - Special Grade</option>
												<option value="workshop Engineer - Grade III">workshop Engineer - Grade III</option>
												<option value="Workshop Superintendent - Grade II">Workshop Superintendent - Grade II</option>
										</optgroup>
									</select> <label>Designation</label>
								</div>
								
								<div class="input-field col s12 m12 l6">
								    <select id="presentDivision" name="presentDivision" ng-model="presentDivi">
										<option value="" disabled selected>Choose present division</option>
											<option value="" selected>--Any--</option>
											<option value="Office of the Dean">Office of the Dean</option>
											<option value="Chemical & Process Engineering">Department of Chemical and Process Engineering</option>
											<option value="Civil Engineering">Department of Civil Engineering</option>
											<option value="Computer Engineering">Department of Computer Engineering</option>
											<option value="Electrical & Electronic Engineering">Department of Electrical and Electronic Engineering</option>
											<option value="Engineering Management">Department of Engineering Management</option>
											<option value="Engineering Mathematics">Department of Engineering Mathematics</option>
											<option value="Manufacturing & Industrial Engineering">Department of Manufacturing and Industrial Engineering</option>
											<option value="Mechanical Engineering">Department of Mechanical Engineering</option>
											<option value="PG Prog. In Civil Engineering">PG Prog. In Civil Engineering</option>
											<option value="PG Prog. In Engi. Management">PG Prog. In Engi. Management</option>
											<option value="CERPS">Centre for Engineering Research and Postgraduate Studies</option>
											<option value="Computing Centre">Computing Centre</option>
											<option value="English Language Teaching Unit (ELTU)">English Language Teaching Unit (ELTU)</option>
											<option value="Industrial Training & Career Guidance Unit">Industrial Training and Career Guidance Unit</option>
											<option value="Engineering Education Unit">Engineering Education Unit</option>
											<option value="Engineering Design Centre">Engineering Design Centre</option>
											<option value="Engineering and Technology Centre">Engineering and Technology Centre</option>
											<option value="Engineering Workshop">Engineering Workshop</option>
											<option value="Electronic Workshop">Electronic Workshop</option>
											<option value="Engineering Technology Incubation Centre">Engineering Technology Incubation Centre</option>
											<option value="Network and Communication Service">Network and Communication Service</option>
											<option value="Vehicle Maintenance Unit">Vehicle Maintenance Unit</option>
								    </select>
								    <label>Present Division</label>
								</div>
								
								<div class="input-field col s12 m12 l6">
								    <select id="type" name="type" ng-model="type">
								    	<option value="" disabled selected>Choose Type</option>
								    	<option value="" selected>--Any--</option>
										<option value="Academic">Academic</option>
										<option value="Non Academic">Non-Academic</option>
										<option value="Academic Supportive">Academic Supportive</option>
								    </select>
								    <label>Staff Type</label>
								</div>
								
								
								<!-- <div class="input-field col s12 m12 l6">
								    <select id="jobNature" name="jobNature" ng-model="jobNature">
								    	<option value="" disabled selected>Choose nature of the job</option>
								    	<option value="" selected>--Any--</option>
										<option value="other">None</option>
										<option value="Office">Office</option>
										<option value="Field">Field</option>
								    </select>
								    <label>Nature of the job</label>
								</div> -->
								<!-- <div class="input-field col s12 m12 l6">
									<input id="subject" name="subject" type="text" class="validate" value=""
										ng-model="empSubject"> <label for="subject">
										Subject</label>
								</div> -->

								<div class="input-field col s12 m12 l12 right-align">
								<button class="btn waves-effect waves-light" type="submit"
									name="action" id="empSearch"
									ng-click="empSearch(emNumber,empSurname,empDesig,presentDivi,type)">
									search <i class="material-icons right">search</i>
									
									<!-- ng-click="empSearch(emNumber,empSurname,empDesig,presentDivi,jobNature,empSubject)" -->
								</button>
								<a href="{{employeesSheetURL}}" class="btn {{disabled}} waves-effect waves-light" 
									name="action" id="empSearchDownload"
									ng-click="empSearchDownload(emNumber,empSurname,empDesig,presentDivi,type)">
									download<i class="material-icons right">download</i>
									<!-- ng-click="empSearchDownload(emNumber,empSurname,empDesig,presentDivi,jobNature,empSubject)" -->
								</a>
								</div>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<button class="waves-effect waves-light btn-large #1a237e indigo darken-4 {{disabled}}" id="summary_btn">
		<i class="material-icons left">summarize</i>Summary
		</button>
		<script>
			$('#summary_btn').on('click', function() {
				$('#summary').toggle(1500);
				$("html").animate({scrollTop: $("#summary_btn").offset().top}, 1200);
			});
		</script>
		<div class="divider"></div>
		<br>
		
		<div id="summary" style="display:none;">
			<div class="row">
			<div class="col s12 m12 l12">
				<div class="card z-depth-4">
					<div class="card-content">
					<span class="card-title"><b>Summary</b></span>
							<br>
							<div class="row">
							
								<!-- <div class="col s6 m6 l6">
									
									<table class="responsive-table">
									<tr class="#e0e0e0 grey lighten-2">
										<th>Department</th>
										<th>Count</th>
									</tr>
									<tr ng-repeat="(key,value) in groupedbydivision">
										<td>{{key}}</td>
										<td>{{value}}</td>
									</tr>
									</table>
								</div> -->
								
								<div class="col s6 m6 l6">
									<table class="responsive-table">
									<tr class="#e0e0e0 grey lighten-2">
										<th>Type</th>
										<th>Count</th>
									</tr>
									<tr ng-repeat="(key,value) in groupedbytype">
										<td>{{key}}</td>
										<td>{{value}}</td>
									</tr>
									</table>
								</div>
								
								<div class="col s6 m6 l6">
								<table class="responsive-table">
									<tr class="#e0e0e0 grey lighten-2">
										<th>Designation</th>
										<th>Count</th>
									</tr>
									<tr ng-repeat="(key,value) in groupedbydesignation">
										<td>{{key}}</td>
										<td>{{value}}</td>
									</tr>
									</table>
								</div>
								
								<div class="col s12 m12 l12">
									<div class="right-align">
									<h4>Total: <b>{{Total_count}}</b></h4>
								</div>
							</div>						
					</div>
				</div>
			</div>
			</div>
		</div>
		</div>
		

		<div class="row">
			<div class="col s12 m12 l12">
				<table class="responsive-table">

					<tr class="#bbdefb blue lighten-4">
						<th>Emp. No</th>
						<th>title</th>
						<th>Surname With Initials</th>
						<th>Names Denoted By Initials</th>
						<th>NIC</th>
						<th>Designation</th>
						<th>Present Division1</th>
						<th>Telephone</th>
						<th>Type</th>
						<th>Email</th>
						<th>Mobile Number</th>
						<th>Address</th>
					</tr>
					<tr ng-repeat="i in employees">
						<td>{{i.employeeNumber}}</td>
						<td>{{i.title}}</td>
						<td>{{i.surnameWithInitials}}</td>
						<td>{{i.namesDenotedByInitials}}</td>
						<td>{{i.nic}}</td>
						<td>{{i.designation}}</td>
						<td>{{i.presentDivision1}}</td>
						<td>{{i.telephone}}</td>
						<td>{{i.type}}</td>
						<td>{{i.email}}</td>
						<td>{{i.mobileNumber}}</td>
						<td>{{i.address}}</td>
						<td><div class="divider"></div></td>
					</tr>
					<tr><td colspan="19" class="center-align"><b>{{NotFoundError}}</b></td></tr>
				</table>
			</div>
		</div>
	</div>


</body>

</html>