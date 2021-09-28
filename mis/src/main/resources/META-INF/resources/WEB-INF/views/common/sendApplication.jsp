<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MIS</title>
<link href="css/materialize.css" rel="stylesheet">
<link href="css/materialize.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="css/toastr.min.css">

<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script type="text/javascript" src="js/toastr.min.js"></script>
<script type="text/javascript" src="js/lodash.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.tabs').tabs();
		$('select').formSelect();
	});
</script>
<style type="text/css">
/*LOADING*/
/* Start by setting display:none to make this hidden.
   Then we position it in relation to the viewport window
   with position:fixed. Width, height, top and left speak
   for themselves. Background we set to 80% white with
   our animation centered, and no-repeating */
.modal-looading {
    display:    none;
    position:   fixed;
    z-index:    1000;
    top:        0;
    left:       0;
    height:     100%;
    width:      100%;
    background: rgba( 255, 255, 255, .8 ) 
                url(/img/ajax-loader.gif) 
                50% 50% 
                no-repeat;
}

/* When the body has the loading class, we turn
   the scrollbar off with overflow:hidden */
body.loading .modal-looading {
    overflow: hidden;   
}

/* Anytime the body has the loading class, our
   modal element will be visible */
body.loading .modal-looading {
    display: block;
}

.input-field label {
	color: #212121 !important;
}
</style>
</head>
<body>
	<div id="main_page" class="">
		<div style="margin: 10% 0% 0% 5%;">
			<h5>Application Form</h5>
			<div class="divider"></div>
		</div>

		<br> <br>
		<div class="row">
			
					<div class="col s12 m10 offset-m1 l10 offset-l1">
						<ul class="tabs">
							<li class="tab col s3"><a class="active"
								href="#application1">TRANSCRIPT/ACADEMIC RANK</a></li>
						</ul>
					</div>
				
					<div id="application1" class=" card z-depth-5 col s12 m10 offset-m1 l10 offset-l1">
						<div class="card-content">
						<form id="form" enctype="multipart/form-data">
							<div class="row center">
								<h5>
									FACULTY OF ENGINEERING - UNIVERSITY OF PERADENIYA<br>
									APPLICATION FOR TRANSCRIPT/ACADEMIC RANK CERTIFICATE
								</h5>
								<br><br>
							</div>
							
							
							<div class="row">
							<h5>Personal Details</h5>
							<div class="divider"></div>
							<div class="col s12 m12 l12 #e3f2fd blue lighten-5">					
								<div class="input-field col s12 m6 l6">
									<input id="email" name="email" type="email" required
										class="validate"> <label for="email">Email:</label>
								</div>
								<div class="input-field col s12 m6 l6">
									<input id="mobile" name="mobile" type="text" required
										class="validate"> <label for="mobile">Mobile:</label>
								</div>
								<div class="col s6 m1 offset-m1 l1 offset-l1">
									<div class="prefixing">
										<label> <input name="titlesPrefixing" type="radio"
											value="Mr." required /> <span>Mr.</span>
										</label>
									</div>
									<div class="prefixing">
										<label> <input name="titlesPrefixing" type="radio"
											value="Ms." /> <span>Ms.</span>
										</label>
									</div>
								</div>
								<div class="input-field col s12 m10 l10">
									<input id="surnameWithInitials" name="surnameWithInitials"
										type="text" required class="validate"> <label
										for="surnameWithInitials">Surname with initials:</label>
								</div>
								<div class="input-field col s12 m12 l12">
									<input id="NamesDenotedByInitials"
										name="NamesDenotedByInitials" type="text" required
										class="validate"> <label for="NamesDenotedByInitials">Names
										denoted by initials:</label>
								</div>
								<div class="input-field col s12 m12 l12">
									<input id="postalAddress" name="postalAddress" type="text"
										required class="validate"> <label for="postalAddress">Postal
										address:</label>
								</div>
							</div>
							</div>	
							<div class="row">
							<h5>Educational Details</h5>
							<div class="divider"></div>
							<div class="col s12 m12 l12 #f9fbe7 lime lighten-5">
								<div class="input-field col s6 m6 l6">
									<input id="registrationNo" name="registrationNo" type="text"
										required class="validate"> <label for="registrationNo">Registration
										No:</label>
								</div>
								<div class="input-field col s6 m6 l6">
									<input id="field" name="field" type="text" required
										class="validate"> <label for="field">Field:</label>
								</div>

								<div class="divider"></div>
								<div class="input-field col s12 m12 l12">
									<h6>Particulars of examinations passed:</h6>
								</div>
								<div class="input-field col s12 m4 l4">
									<div class="card">
										<div class="card-content">
											<h6>Course Unit System</h6>

											<input id="cus_generalProgramme" name="cus_generalProgramme"
												type="text" class="validate"> <label
												for="cus_generalProgramme">a). General Programme:</label> <input
												id="cus_specializationProgramme"
												name="cus_specializationProgramme" type="text"
												class="validate"> <label
												for="cus_specializationProgramme">b). Specialization
												Programme:</label>

										</div>
									</div>
								</div>

								<div class="input-field col s12 m4 l4">
									<div class="card cardHover">
										<div class="card-content">
											<h6>Old Regulation Examinations</h6>
											<input id="ore_firstExaminEng" name="ore_firstExaminEng"
												type="text" class="validate"> <label
												for="ore_firstExaminEng">a) First Examination In
												Engineering:</label> <input id="ore_finalPart1Exam"
												name="ore_finalPart1Exam" type="text" class="validate">
											<label for="ore_finalPart1Exam">b) Final Part I
												Examination:</label> <input id="ore_finalPart2Exam"
												name="ore_finalPart2Exam" type="text" class="validate">
											<label for="ore_finalPart2Exam">c) Final Part II
												Examination:</label> <input id="ore_finalPart3Exam"
												name="ore_finalPart3Exam" type="text" class="validate">
											<label for="ore_finalPart3Exam">d) Final Part III
												Examination:</label>
										</div>
									</div>
								</div>

								<div class="input-field col s12 m4 l4">
									<div class="card cardHover">
										<div class="card-content">
											<h6>Postgraduate Examinations</h6>
											<input id="pge_nameOfdegreeOrDipl"
												name="pge_nameOfdegreeOrDipl" type="text" class="validate">
											<label for="pge_nameOfdegreeOrDipl">a) Name of the
												Degree/Diploma:</label> <input id="pge_yearCompleted"
												name="pge_yearCompleted" type="text" class="validate">
											<label for="pge_yearCompleted">b) Year Completed:</label>
										</div>
									</div>
								</div>
							</div>
							</div>
							<div class="row">
							<h5>Payment Details & Clearance</h5>
							<div class="divider"></div>
							<div class="input-field col s12 m12 l12">
									<div class="card #e3f2fd blue lighten-5">
										<div class="card-content black-text">
											<span class="card-title">Notes Fees:</span>
											<p>
												The receipt of payment of the fee prescribed below to the
												Shroff or credit to the Acco. No. <b>0001274688 (BOC)</b> /
												Acco. No. <b>067100121338023 (People's Bank)</b> at any
												branch in favour of the <b><i>'Bursar, University of
														Peradeniya'</i></b> should be submitted with the applications to
												the <b><i>Senior Assistant Registrar, Faculty of
														Engineering, University of Peradeniya</i></b>.
											</p>
											<br> <br>
											<p>
												1. A Transcript or an Academic Rank Certificate to be issued
												within 4 working days* <br> <b>- Rs. 250/= (for a
													local address) </b> <br> <b>- Rs. 750/= (for a foreign
													address)</b> <br> <br> A Transcript or an Academic
												Rank Certificate to be issued within 2 working days <br>
												<b>- Rs. 750/= (for a local address) </b> <br> <b>-
													Rs. 1500/= (for a foreign address)</b> <br> <br>
												Additional copy of a transcript or an Academic Rank
												Certificate posted together in the same envelope for foriegn
												university <br> <b>- Rs. 150/=</b>
											</p>
											<br> <br>
											<p>2. All applications should be accompanied with a
												clearance note in respect of Vacation / Hall Fees arrears
												from the Senior Assistant Registrar / Student Services and
												Bursar / Accounts Branch and Library clearance note . This
												is applicable only at the first time of the requests of the
												above documents.</p>
											<br> <br>
											<p>3. Documents will be posted under registered cover to
												the given address/es by the university</p>
											<br> <br>
											<p>
												Dean's Office,<br> Faculty of Engineering.
											</p>

										</div>
									</div>
								</div>
							<div class="col s12 m12 l12 #f9fbe7 lime lighten-5">
								<div class="divider"></div>
								<div class="input-field col s12 m6 l6">
									<div class="card cardHover">
										<div class="card-content">
											<h6 class="center">Request Made for:</h6>
											
											<p>
												<h6><b>Number of copies</b></h6><br>
												Number of Transcripts:
												<input id="numberOfTranscripts" type="number"
													min="1" required class="validate"><br><br><br>
												Number of Academic Rank Certificates:
												<input id="numberOfAcademicRankCertificates" type="number"
													min="1" required class="validate"> 
												<br><br><p>
												Certificate to be issued within: <br>
													<label> <input id="two_days" name="days" value="2days" type="radio" /> <span> 2 working days</span></label>
													<label> <input id="four_days" name="days" value="4days" type="radio" /> <span> 4 working days</span></label>
												</p>
												<br><br><p>
												for <br>
													<label> <input id="local_address" name="localOrForieng"  value="local" type="radio" /> <span> Local Address</span></label>
													<label> <input id="foreign_address" name="localOrForieng" value="foreign" type="radio" /> <span> Foreign Address</span></label>
												</p>
												<div id="checkBoxView" style="display:none;">
												<p>
													<label>
													<br>
												        <input id="checkBox" type="checkbox" name="additionalCopy" />
												        <span>Additional copy of a transcript or an Academic Rank Certificate posted together in the same envelope for foriegn university</span>
												     </label>
												</p>
												</div>
												
												<input id="requestMadefor" name="requestMadefor"  type="hidden" />
												<input id="numberOfCopies" name="numberOfCopies" type="hidden" />
												<input id="payment" name="payment" type="hidden" />
												
												<br>
												Payment: <h5><div id="viewPayment"></div></h5>
												<script>
												
												 $(document).ready(function() {
													 
													 	var paymentValue = 0;
														var paymentValue1 = 0;
														var paymentValue2 = 0;
														var addValue = 0;
														
														var noOfTrans = 0;
														var noOfAcads = 0;
														
														var numberOfCopies = 0;
														var days = "";
														var text = "";
														var numberOfcopiestext = "";
														var withinDaystext = "";
														var addressText = "";
														var additionalText = "";
														
														$('#numberOfTranscripts,#numberOfAcademicRankCertificates').focusout( function() {
															noOfTrans = $('#numberOfTranscripts').val();
															noOfAcads = $('#numberOfAcademicRankCertificates').val();
															numberOfCopies = Number(noOfTrans) + Number(noOfAcads);
															numberOfcopiestext = noOfTrans+"-Transcritpt/s and "+noOfAcads
															+"- Academic Rank Certificate/s ";
														});
														
														$("input[name='days']").click(function() {
															$('#local_address').prop('checked', false);
															$('#foreign_address').prop('checked', false);
															$('#viewPayment').text("");
														      if($('input[name="days"]:checked').val() == '2days'){
														    	  days = "2days";
														    	  withinDaystext = "and need within 2 Days";
														      }
														      if($('input[name="days"]:checked').val() == '4days'){
														    	  days = "4days";
														    	  withinDaystext = "and need within 4 Days";
														      }
														 });
														
														$("input[name='localOrForieng']").click(function() {

														      if($('input[name="localOrForieng"]:checked').val() == 'local'){
														    	  addressText =" for local address";
														    	  $("#checkBoxView").hide();
														    	  
														    	  $('#collectionMethodView').slideDown(500);
														    	  $("#collectionMethod").val("");
														    	  $("#addressToSendCertificateView").hide();
														    	  $("#addressToSendCertificate").attr('name', 'addressToSendCertificate');
														    	  $("#addressToSendCertificate2").val("");
														    	  $("#addressToSendCertificate2").attr('name', "");
														    	  
														    	  if(days == "2days"){
																	paymentValue1 = noOfTrans*750.00;
																	paymentValue2 = noOfAcads*750.00;
																	paymentValue = paymentValue1 + paymentValue2;
														    	  }
														    	  if(days == "4days"){
														    		paymentValue1 = noOfTrans*250.00;
																	paymentValue2 = noOfAcads*250.00;
																	paymentValue = paymentValue1 + paymentValue2;
														    	  }
														      }
														      if($('input[name="localOrForieng"]:checked').val() == 'foreign'){
														    	  addressText =" for foreign address";
														    	  $("#checkBoxView").slideDown(500);
														    	  
														    	  $('#collectionMethodView').hide();
														    	  $("#addressToSendCertificateView").slideDown(500);
														    	  $("#addressToSendCertificate").val("");
														    	  $("#addressToSendCertificate").attr('name', "");
														    	  $("#addressToSendCertificate2").attr('name', 'addressToSendCertificate');
														    	  $("#collectionMethod").val("From register post");
														    	  
																  if(days == "2days"){
																	paymentValue1 = noOfTrans*1500.00;
																	paymentValue2 = noOfAcads*1500.00;
																	paymentValue = paymentValue1 + paymentValue2;
														    	  }
														    	  if(days == "4days"){
														    		paymentValue1 = noOfTrans*750.00;
																	paymentValue2 = noOfAcads*750.00;
																	paymentValue = paymentValue1 + paymentValue2;
														    	  }
														      }
														      
																$("#checkBox").on('change', function() {
																	  if ($(this).is(':checked')) {
																			addValue = 150;
																			additionalText = " and Additional copy of a transcript or an Academic Rank Certificate posted together in the same envelope for foriegn university"
																			console.log($("#checkBox").val());
																			$('#viewPayment').text("Rs. "+(Number(paymentValue)+Number(addValue)));
																		    text = numberOfcopiestext + withinDaystext + addressText + additionalText;
																			console.log(text);
																		    $('#requestMadefor').val(text);
																			$('#numberOfCopies').val(numberOfCopies);
																			$('#payment').val(paymentValue+addValue);
																	  }else{
																		  $('#viewPayment').text("Rs. "+paymentValue);
																	      text = numberOfcopiestext + withinDaystext + addressText;
																		  console.log(text);
																	      $('#requestMadefor').val(text);
																			$('#numberOfCopies').val(numberOfCopies);
																		$('#payment').val(paymentValue);
																	  }
																});
																 $('#viewPayment').text("Rs. "+paymentValue);
															      text = numberOfcopiestext + withinDaystext + addressText;
																  console.log(text);
															      $('#requestMadefor').val(text);
																	$('#numberOfCopies').val(numberOfCopies);
																$('#payment').val(paymentValue);
														 });
													});
												</script>
											

											<br>	
										</div>
									</div>
								</div>
								<div class="col s12 m6 l6">
								<span><b>*Please upload image files below.</b></span>
									<div class="file-field input-field">
										<div class="btn">
											<span>Deposit Slip</span> <input type="file"  accept="image/*"
												name="paymentReceipt" required>
										</div>
										<div class="file-path-wrapper">
											<input class="file-path validate" type="text">
										</div>
									</div>
									<div class="file-field input-field">
										<div class="btn">
											<span>Paying in Voucher (*Optional) </span> <input
												type="file"  accept="image/*" name="paymentReceipt2">
										</div>
										<div class="file-path-wrapper">
											<input class="file-path validate" type="text">
										</div>
									</div>
									<div class="file-field input-field">
										<div class="btn">
											<span>Clearance Certificate</span> <input type="file"  accept="image/*"
												name="clearenceForm">
										</div>
										<div class="file-path-wrapper">
											<input class="file-path validate" type="text">
										</div>
									</div>
								</div>
							</div>
							</div>
							<div class="row" id="collectionMethodView" style="display:none;">
							<h5>Collection Method</h5>
							<div class="divider"></div>
							<div class="col s12 m12 l12 #e8f5e9 green lighten-5">
								<div class="input-field col s12 m12 l12">
									<select id="collectionMethod" name="collectionMethod" ng-model="collectionMethod" required>
								      <option value="" disabled selected>Choose Collection Method</option>
								      <option  value="From Email">From Email</option>
								      <option value="From register post">From register post</option>
								      <option  value="Collect from AR office">Collect from AR office</option>
								    </select>
								    <label>Collection Method:</label>
								</div>
								<script>
								$('#collectionMethod').change(function(){
											//console.log("Email:"+$("#email").val());
									        if (this.value == "From Email")
										      {
										        $("#emailTo").slideDown(500);
										        $("#emailAddress").text($('#email').val());
										      	$("#addressToSendCertificate").prop('required',false);
										       	$("#localOrForieng").prop('required',false);
										        $('#postTo').hide();
										      }
									        if ( this.value == 'From register post')
										      {
										        $("#postTo").slideDown(500);
										        $("html").animate({scrollTop: $("#postTo").offset().top}, 1200);
										      	$("#addressToSendCertificate").prop('required',true);
										        $("#localOrForieng").prop('required',true);
										        $('#emailTo').hide();
										      }
									        if ( this.value == 'Collect from AR office')
										      {
										        $("#postTo").hide();
										        $("#addressToSendCertificate").prop('required',false);
										       	$("#localOrForieng").prop('required',false);
										        $('#emailTo').hide();
										      }
									 });
								</script>
								<div id="emailTo" style="display:none;"><div class="input-field col s12 m12 l12">Email To:<div id="emailAddress"></div></div></div>
								<div id="postTo" style="display:none;">
								<div id="addressTo" class="input-field col s12 m12 l12">
									<input id="addressToSendCertificate"
										 type="text"
										class="validate"> <label
										for="addressToSendCertificate">The full address to
										which the transcript/academic rank certificate should be sent:</label>
								</div>
								</div>
							</div>
							</div>
							<div class="row" id="addressToSendCertificateView" style="display:none;">
							<h5>Foreign address to send</h5>
							<div class="divider"></div>
							<div class="col s12 m12 l12 #e8f5e9 green lighten-5">
								<div class="input-field col s12 m12 l12">
								<input id="addressToSendCertificate2"
										 type="text"
										class="validate"> <label
										for="addressToSendCertificate">The full address to
										which the transcript/academic rank certificate should be sent:</label>
								</div>
							</div>
							</div>
							
								<div class="input-field col s12 m12 l12 right-align">
									
										<input type="reset"
											class="waves-effect waves-light btn #e8eaf6 indigo lighten-5"
											value="Reset">
										<input type="submit"
											class="waves-effect waves-light btn light-blue darken-5"
											value="submit">

								</div>
						</form>
						</div>
			</div>
		</div>
	</div>

	<div class="modal-looading"></div>

</body>
<script>
	$('#form').submit(function(e) {
		$.ajax({
			url : '/sendApplication',
			type : 'POST',
			data : new FormData(this),
			processData : false,
			contentType : false
		}).done(function(data){
			showToastr('success', 'Successfully sent!', "<br><br><b> Dismiss </b>");
			$("#form")[0].reset();
			$('#viewPayment').text("");
			//location.reload();
			})
	     .fail(function(errMsg) {showToastr('error', 'Something went wrong!', "Please try again! <br><br><b> Dismiss </b>");});
		e.preventDefault();
		
	});

	$body = $("body");

	$(document).on({
		ajaxStart : function() {
			$body.addClass("loading");
		},
		ajaxStop : function() {
			$body.removeClass("loading");
			//showToastr('success', 'Successfully sent!', "Dismiss");
		}
	});

	function showToastr(type, title, messsage) {
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
