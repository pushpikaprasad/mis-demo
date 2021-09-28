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
					<li class="tab col s2"><a class="active" href="#one">ACCEPTED</a></li>
					<li class="tab col s2"><a class="active" href="#two">CHECKED NOT OK</a></li>
					<li class="tab col s2"><a class="active" href="#three">CHECKED OK</a></li>
					<li class="tab col s2"><a class="active" href="#four">COMPLETED</a></li>
					<li class="tab col s2"><a class="active" href="#five">ALL</a></li>
				</ul>
			</div>
			<br>
			<br>
			<br>
			<div id="one">
				<div class="col s12 m12 l12">
					<table class="responsive-table">

						<tr class="#bbdefb table_head">
							<!-- <th>Application Status</th> -->
							<th>view</th>
							<th>Registration No</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
						</tr>
						<tr ng-repeat="i in acceptedApplications" ng-if="$index < 1">
							
							<!-- <td>{{i.status}}</td> -->
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td>
							 <form id="formU"  enctype="multipart/form-data" class="blurforms">
							 	
							 	<input type="hidden" name="applicationID" value="{{i.applicationId}}">
								<div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Transcript Document</span>
									<input type="file" accept=".pdf" name="transcriptDocument" ng-model="transcriptDocument">
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							    <div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Academic Rank Document</span>
								 	<input type="file" accept=".pdf" name="AcademicDocument" ng-model="AcademicDocument" >
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							     <input type="submit"  onclick="upload()"
									class="waves-effect waves-light btn light-blue darken-1"
									value="submit pdf document/s" />
								 <input type="reset" class="waves-effect waves-light btn #37474f blue-grey darken-3"/>
								 
							    </form>
							</td>
							<!-- <td><a href=""
								class="waves-effect waves-light btn-small #424242 green darken-3"><i
									ng-click="completedTranAcadApplication(i.applicationId, transcriptDocument, AcademicDocument)"
									class="material-icons">done</i></a></td> -->
						</tr>
						<!-- <tr><td colspan=6><b>*Only first application in the list can be proceed at a time and others' form will be in disable mood.</b></td></tr>
						 -->
						 <tr ng-repeat="i in acceptedApplications" ng-if="$index > 0">
							
							<!-- <td>{{i.status}}</td> -->
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td>
							<b>*Disabled</b>
							 <form id="formU"  enctype="multipart/form-data" class="blurforms">
							 	
							 	<input type="hidden" name="applicationID" value="{{i.applicationId}}">
								<div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Transcript Document</span>
									<input disabled type="file" accept=".pdf" name="transcriptDocument" ng-model="transcriptDocument">
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							    <div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Academic Rank Document</span>
								 	<input disabled type="file" accept=".pdf" name="AcademicDocument" ng-model="AcademicDocument">
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							     <input disabled type="submit"  onclick="upload()"
									class="waves-effect waves-light modal-close btn light-blue darken-1"
									value="submit pdf document/s" />
									
								 
							    </form>
							</td>
							<!-- <td><a href=""
								class="waves-effect waves-light btn-small #424242 green darken-3"><i
									ng-click="completedTranAcadApplication(i.applicationId, transcriptDocument, AcademicDocument)"
									class="material-icons">done</i></a></td> -->
						</tr>
						
					</table>
				</div>
			</div>
			<div id="two">
				<div class="col s12 m12 l12">
					<table class="responsive-table">

						<tr class="#bbdefb table_head">
							<!-- <th>Application Status</th> -->
							<th>view</th>
							<th>Registration No</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
						</tr>
						<tr ng-repeat="i in checkedNotOKApplications" ng-if="$index < 1">
							
							<!-- <td>{{i.status}}</td> -->
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td>
							 <form id="formcheck"  enctype="multipart/form-data">
							 	<input type="hidden" name="applicationID" value="{{i.applicationId}}">
								<div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Transcript Document</span>
									<input type="file" accept=".pdf" name="transcriptDocument" ng-model="transcriptDocument" >
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							    <div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Academic Rank Document</span>
								 	<input type="file" accept=".pdf" name="AcademicDocument" ng-model="AcademicDocument">
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							     <input type="submit"  onclick="upload2()"
									class="waves-effect waves-light modal-close btn light-blue darken-1"
									value="resubmit pdf document/s" />
								  <input type="reset" class="waves-effect waves-light btn #37474f blue-grey darken-3"/>
								 
							    </form>
							    
							</td>
							<!-- <td><a href=""
								class="waves-effect waves-light btn-small #424242 green darken-3"><i
									ng-click="completedTranAcadApplication(i.applicationId, transcriptDocument, AcademicDocument)"
									class="material-icons">done</i></a></td> -->
							
						
						</tr>
						<tr ng-repeat="i in checkedNotOKApplications" ng-if="$index > 0">
							
							<!-- <td>{{i.status}}</td> -->
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td>
							<b>*Disabled</b>
							 <form id="formU"  enctype="multipart/form-data">
							 	<input type="hidden" name="applicationID" value="{{i.applicationId}}">
								<div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Transcript Document</span>
									<input disabled type="file" accept=".pdf" name="transcriptDocument" ng-model="transcriptDocument" >
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							    <div class="file-field input-field">
							      <div class="btn btn-small">
							        <span>Academic Rank Document</span>
								 	<input disabled type="file" accept=".pdf" name="AcademicDocument" ng-model="AcademicDocument">
								  </div>
							      <div class="file-path-wrapper">
							        <input class="file-path validate" type="text">
							      </div>
							    </div>
							     <input disabled type="submit"  onclick="upload()"
									class="waves-effect waves-light modal-close btn light-blue darken-1"
									value="resubmit pdf document/s" />
								 
							    </form>
							    
							</td>
							<!-- <td><a href=""
								class="waves-effect waves-light btn-small #424242 green darken-3"><i
									ng-click="completedTranAcadApplication(i.applicationId, transcriptDocument, AcademicDocument)"
									class="material-icons">done</i></a></td> -->
							
						
						</tr>
						
					</table>
				</div>
			</div>
			<div id="three">
				<div class="col s12 m12 l12">
					<table class="responsive-table">

						<tr class="#bbdefb table_head">
							<!-- <th>Application Status</th> -->
							<th>view</th>
							<th>Registration No</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
						</tr>
						
						<tr ng-repeat="i in checkedOKApplications">
							
							<!-- <td>{{i.status}}</td> -->
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td><a href=""
								class="waves-effect waves-light btn-small #424242 green darken-3"><i
									ng-click="completedTranAcadApplication(i.applicationId)"
									class="material-icons">done</i></a></td>
						</tr>
						
					</table>
				</div>
			</div>
			<div id="four">
				<div class="col s12 m12 l12">
					<table class="responsive-table">

						<tr class="#bbdefb table_head">
							<!-- <th>Application ID</th> -->
							<th>Application Type</th>
							<th>Application Status</th>
							<th>Surname with initials</th>
							<th>Registration No</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
						</tr>
						<tr ng-repeat="i in completedTranAcadApplications">
							<!-- <td>{{i.applicationId}}</td> -->
							<td>{{i.applicationType}}</td>
							<td>{{i.status}}</td>
							<td>{{i.surnameWithInitials}}</td>
							<td>{{i.registrationNo}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td><a
								class="waves-effect waves-light btn modal-trigger modal-close  light-blue darken-1"
								href="#applicationView2"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>
							
						</tr>
					</table>
				</div>
			</div>
			<div id="five">
				<div class="col s12 m12 l12">
					<div class="col s12 m12 l4">
						<form class="#424242 grey darken-3">
							<div class="row" style="padding: 10px">
								<div class="input-field col s12 m12 l12 ">
									<input id="searchByRegNo" name="searchByRegNo" type="text"
										class="searchByRegNo" ng-model="searchByRegNo" placeholder="Enter Student Reg. No.">
									<label for="username">Reg. No.: </label>
									<button class="btn waves-effect waves-light right"
											type="submit" name="action" id="searchAction"
											ng-click="getAllApplicationsByRegNo(searchByRegNo)">
											Search <i class="material-icons right">search</i>
							        </button>
								</div>
							</div>
						</form>
					</div>
					<table class="responsive-table">
						<tr class="#bbdef table_head" style="font-size: 9">
							<!-- <th>Application ID</th> -->
							<th>Registration No</th>
							<th>Application Type</th>
							<th>Application Status</th>
							<th>Surname with initials</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Collection Method</th>
							<th></th>
						</tr>
						<tr ng-repeat="i in allApplications">
							<!-- <td>{{i.applicationId}}</td> -->
							<td>{{i.registrationNo}}</td>
							<td>{{i.applicationType}}</td>
							<td>{{i.status}}</td>
							<td>{{i.surnameWithInitials}}</td>
							<td>{{i.email}}</td>
							<td>{{i.mobileNumber}}</td>
							<td>{{i.collectionMethod}}</td>
							<td><a
								class="waves-effect waves-light btn modal-trigger  light-blue darken-1"
								href="#applicationView2"
								ng-click="viewApplication(i.applicationId)"><i
									class="material-icons">visibility</i></a></td>

						</tr>
					</table>
				</div>
			</div>
		</div>

		<!--  VIEW APPLICATION -->
		<div id="applicationView" class="modal">
			<div class="row">
				<div class="col s12 m9 l9">
					<iframe src="{{pdfURL}}" width="100%" height="500px"></iframe>
				</div>
				<div class="col s12 m3 l3">
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
					<br><br>
					<div class="container col s12 m12 l12"
						>
						<a href="{{downloadURL}}" style="display: inline-flex"
							class="waves-effect waves-light btn"
							ng-click="downloadPDFApplication(applicationId)">
							<i class="material-icons">download</i>Download</a>
						<div class="divider"></div>
						<br> <br>
					</div>
				</div>
			</div>
		</div>

		<!--  VIEW APPLICATION WITHOUT ANY OPPTIONS-->
		<div id="applicationView2" class="modal">
			<div class="row">
				<div class="col s12 m12 l12">
				<div class="col s11 m11 l11">
						<br>
						<h6>Application View</h6>
					</div>
					<div class="col s1 m1 l1">
						<br>
						<button
							class="modal-close btn waves-effect waves-light pink darken-1 right">
							<i class="material-icons">close</i>
						</button>
					</div>
				</div>

				<div class="col s12 m12 l12">
					<iframe src="{{pdfURL}}" width="100%" height="500px"></iframe>
				</div>
			</div>
		</div>



	</div>


</body>
<script>
function upload(){
	    var data = new FormData(document.getElementById("formU")); 
	    var formFields = document.getElementById('formU').elements;
	    //console.log(formFields["transcriptDocument"].files.length);
	    if(formFields["transcriptDocument"].files.length == true || formFields["AcademicDocument"].files.length == true){
	    	
	    	$.ajax({
				url : '/officerDashboard/allApplications/uploadDocuments/',
				type : 'POST',
				data : data,
				processData : false,
				contentType : false,
			}).done(function(data){
				showToastr('success', 'Successfully uploaded!', "<br><br><b> Dismiss </b>", "one");
				//location.reload();
				})
		     .fail(function(errMsg) {showToastr('error', 'Something went wrong!', "Please try again! <br><br><b> Dismiss </b>");});
	    }else{
	    	alert("Files need to upload!");
	    }		
}
function upload2(){
	
	var formcheckdata = new FormData(document.getElementById("formcheck"));
	var formcheckFields = document.getElementById('formcheck').elements;
	//console.log(formcheckFields["transcriptDocument"].files.length);
	if(formcheckFields["transcriptDocument"].files.length == true || formcheckFields["AcademicDocument"].files.length == true){
    	
    	$.ajax({
			url : '/officerDashboard/allApplications/uploadDocuments/',
			type : 'POST',
			data : formcheckdata,
			processData : false,
			contentType : false,
		}).done(function(data){
			showToastr('success', 'Successfully uploaded!', "<br><br><b> Dismiss </b>", "two");
			//location.reload();
			})
	     .fail(function(errMsg) {showToastr('error', 'Something went wrong!', "Please try again! <br><br><b> Dismiss </b>");});
    }else{
    	alert("Files need to upload!");
    }
}
function showToastr(type, title, messsage, hash) {
	let body;
	toastr.options = {
		"closeButton" : false,
		"debug" : false,
		"newestOnTop" : false,
		"progressBar" : false,
		"positionClass" : 'toast-top-center',
		"preventDuplicates" : true,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : 5000,
		"onclick" : null,
		"onCloseClick" : null,
		"extendedTimeOut" : 1000,
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut",
		"tapToDismiss" : true
	};
	toastr.options.onHidden = function(){
		  $(document).scrollTop(0);
		  window.location.hash = hash;
		  window.location.reload();
		};
	switch (type) {
	case "info":
		body = "<span> <i class='fa fa-spinner fa-pulse'></i></span>";
		break;
	default:
		body = '';
	}
	const content = messsage + body;
	toastr[type](content, title)
}

</script>
</html>