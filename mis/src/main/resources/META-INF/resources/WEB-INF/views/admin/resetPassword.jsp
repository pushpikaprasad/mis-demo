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
<script type="text/javascript" src="js/lodash.min.js"></script>

<script type="text/javascript" src="js/toastr.min.js"></script>
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
			<!-- <li class="nav-item "><a class="nav-link"
				href="./notifications.html"> <i class="material-icons">notifications</i>
					<p>Notifications</p>
			</a></li> -->
		</ul>
	</div>


	<div id="main_page" class="main_page">
	<h5>Reset Password</h5>
		<div class="divider"></div>
		<form id="form">
			<div class="row">
				<div class="input-field col s12 m12 l4">
					<input id="email" name="email" type="email" class="validate" required
						> <label for="email">
						Email</label>
				</div>
				<div class="input-field col s12 m12 l4">
					<input id="newPassword" name="newPassword" type="password" class="validate" required
						> <label for="newPassword">
						New Password</label>
				</div>
				<div class="input-field col s12 m12 l4">
				<input type="submit" class="waves-effect waves-light btn light-blue darken-1"
										value="submit">
				</div>
			</div>
		</form>
	</div>
</body>

<script>

$( '#form' )
.submit( function( e ) {
  $.ajax( {
    url: '/adminDashboard/resetPassword',
	type : 'POST',
	data : new FormData(this),
	processData : false,
	contentType : false
}).done(function(data){
	showToastr('success', 'Successfully reset the password!', "<br><br><b> Dismiss </b>");
	$("#form")[0].reset();})
 .fail(function(errMsg) {showToastr('error', 'Something went wrong!', "<br><br>Please try again! - check email address <br><br><b> Dismiss </b>");});
e.preventDefault();

});

$body = $("body");

$(document).on({
ajaxStart : function() {
	$body.addClass("loading");
},
ajaxStop : function() {
	$body.removeClass("loading");
}
});

function showToastr(type, title, messsage) {
    let body;
    toastr.options = {
        "closeButton": false,
        "debug": false,
        "newestOnTop": false,
        "progressBar": false,
        "positionClass": 'toast-bottom-center',
        "preventDuplicates": true,
        "showDuration": "300",
        "hideDuration": "1000",
        "timeOut": 5000,
        "onclick": null,
        "onCloseClick": null,
        "extendedTimeOut": 1000,
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "tapToDismiss": true
    };
    switch(type){
        case "info": body = "<span> <i class='fa fa-spinner fa-pulse'></i></span>";
            break;
        default: body = '';
    }
    const content = messsage + body;
    toastr[type](content, title)
}
</script>

</html>
