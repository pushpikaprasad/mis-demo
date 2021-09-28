// Page module
var PageDetails = angular.module('PageDetails', []);

//========= ADMIN ============================================================================================================

//Admin Page controller
	PageDetails.controller('PageData', function($scope, $http) {
		
		//read all data of students
		$http.get('/adminDashboard/studentList').then(function(res) {
				$scope.students= res.data; 

			});
		
		//get student details
		$scope.getStudentDetails = function() {
			
			$http.get('/adminDashboard/studentList').then(function(res) {
				$scope.students= res.data; 

			});
		};
		
		//To clear add student form
		$scope.openAddStudentForm = function(){
				$scope.std_username="";
				$scope.std_password="";
				$scope.std_firstName="";
				$scope.std_lastName="";
				$scope.std_address="";
				$scope.std_email="";
				$scope.std_mobileNumber="";
				$scope.std_registrationNo="";
		};
		
		//Add students details
		$scope.addStudent = function (firstName,lastName,username,password,registrationNo,address,email,mobileNumber) {
			
			var studentData = {
				username:username,
				password:password,
				firstName:firstName,
				lastName:lastName,
				address:address,
				email:email,
				mobileNumber:mobileNumber,
				loginStatus:null,
				role:"STUDENT",
				registrationNo:registrationNo
			};

			//console.log(studentData);
			$http.post('/adminDashboard/studentList/addstudent', JSON.stringify(studentData)).then(function (response) {

				if (response.studentData)

				console.log("Post Data Submitted Successfully!");
				$scope.getStudentDetails();

				}, function (response) {	
					console.log("Service not Exists");
					
				
				});
		};
		
		
		//read all data of ar
		$http.get('/adminDashboard/arList').then(function(res) {
				$scope.ars= res.data; 

			});
		
		//get ar details
		$scope.getArDetails = function() {
			
			$http.get('/adminDashboard/arList').then(function(res) {
				$scope.ars= res.data; 

			});
		}
		
		//To clear ar add form
		$scope.openAddArForm = function(){
				$scope.Ar_username="";
				$scope.Ar_password="";
				$scope.Ar_firstName="";
				$scope.Ar_lastName="";
				$scope.Ar_address="";
				$scope.Ar_email="";
				$scope.Ar_mobileNumber="";
				$scope.Ar_nic="";
		};
		
	
		//Add ar details
		$scope.addAr = function (Ar_firstName,Ar_lastName,Ar_username,Ar_password,Ar_nic,Ar_address,Ar_email,Ar_mobileNumber) {
			
			var arData = {
				username:Ar_username,
				password:Ar_password,
				firstName:Ar_firstName,
				lastName:Ar_lastName,
				address:Ar_address,
				email:Ar_email,
				mobileNumber:Ar_mobileNumber,
				loginStatus:null,
				role:"AR",
				nic:Ar_nic
			};

			//console.log(arData);
			$http.post('/adminDashboard/arList/addar', JSON.stringify(arData)).then(function (response) {

				if (response.arData)

				console.log("Post Data Submitted Successfully!");
				$scope.getArDetails();

				}, function (response) {	
					console.log("Service not Exists");
				});
		};	
		
		//Get admin
		$http.get("/adminDashboard/getAdmin").then(function(res) {
				$scope.admin= res.data; 
				$scope.firstName=$scope.admin['firstName'],
				$scope.lastName=$scope.admin['lastName'],
				$scope.address=$scope.admin['address'],
				$scope.email=$scope.admin['email'],
				$scope.mobileNumber=$scope.admin['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="ADMIN",
				$scope.nic=$scope.admin['nic']
				
			});
	
		//update admin details
		$scope.updateAdmin = function (firstName,lastName,nic,address,email,mobileNumber) {
			
			var adminData = {
				id: $scope.admin['id'],
				username: $scope.admin['username'],
				password: $scope.admin['password'],
				firstName:firstName,
				lastName:lastName,
				address:address,
				email:email,
				mobileNumber:mobileNumber,
				loginStatus:null,
				role:"ADMIN",
				nic:nic
		};

		//console.log(adminData);
		$http.post('/adminDashboard/updateAdmin', JSON.stringify(adminData)).then(function (response) {
		
				$scope.updatedMsg = "Account is updated!";
				$scope.firstName=adminData['firstName'],
				$scope.lastName=adminData['lastName'],
				$scope.address=adminData['address'],
				$scope.email=adminData['email'],
				$scope.mobileNumber=adminData['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="ADMIN",
				$scope.nic=adminData['nic']

				if (response.adminData){
				console.log("Post Data Submitted Successfully!");
				}
				
				}, function (response) {	
					console.log("Service not Exists");
				});
			
		};	
		
		// get student delete email
		$scope.deleteStudentEmail = function(email){
			$scope.deleteStudentbyEmail = email;
		};
		
		//delete student
		$scope.deleteStudent = function(email){
			$http.delete("/adminDashboard/deleteStudent/"+email).then(function(res){
			
				
				if (res){
				console.log("Post Data Submitted Successfully!");
				$scope.getStudentDetails();
				}
				
				}, function (response) {	
					console.log("Service not Exists");
				});
		};
		
		//###########################################################
		//officer in Admin Dashbpard
		//###########################################################
		
		//read all data of officers
		$http.get('/adminDashboard/officerList').then(function(res) {
				$scope.officers= res.data; 

			});
		
		//get officer details
		$scope.getOfficerDetails = function() {
			
			$http.get('/adminDashboard/officerList').then(function(res) {
				$scope.officers= res.data; 

			});
		};
		
		//get officer By email
		$scope.getOfficerByEmail = function(email){
			$http.get('/adminDashboard/officerList/'+email).then(function(res) {
				$scope.officer= res.data; 
			});
		}
		
		//To clear officer add form
		$scope.openAddOfficerForm = function(){
				$scope.officer_username="";
				$scope.officer_password="";
				$scope.officer_firstName="";
				$scope.officer_lastName="";
				$scope.officer_address="";
				$scope.officer_email="";
				$scope.officer_mobileNumber="";
				$scope.officer_nic="";
		};
		
		//Add officer details
		$scope.addOfficer = function (officer_firstName,officer_lastName,officer_username,officer_password,officer_nic,officer_address,officer_email,officer_mobileNumber,officer_workCategoryID1,officer_workCategoryID2, officer_workCategoryID3) {
			
			var officer_workCategoryID = "";
			var checkBoxValue1 ="";
			var checkBoxValue2 ="";
			var checkBoxValue3 ="";
            var workCategoryNumber ="";
									 
			if (officer_workCategoryID1 == undefined || officer_workCategoryID1 == "") {
				checkBoxValue1 = "";
			}else{
				checkBoxValue1 = "1";
			}
			if (officer_workCategoryID2 == undefined || officer_workCategoryID2 == "") {
				checkBoxValue2 = "";
			}else{
				checkBoxValue2 = "2";
			}
			if (officer_workCategoryID3 == undefined || officer_workCategoryID3 == "") {
				checkBoxValue3 = "";
			}else{
				checkBoxValue3 = "3";
			}
			officer_workCategoryID = checkBoxValue1+checkBoxValue2+checkBoxValue3;
			//console.log(officer_workCategoryID);
			
			
			var officerData = {
				username:officer_username,
				password:officer_password,
				firstName:officer_firstName,
				lastName:officer_lastName,
				address:officer_address,
				email:officer_email,
				mobileNumber:officer_mobileNumber,
				loginStatus:null,
				role:"OFFICER",
				nic:officer_nic,
				workCategoryID:officer_workCategoryID
			};

		//console.log(officerData);
		$http.post('/adminDashboard/officerList/addofficer/'+officerData['workCategoryID'], JSON.stringify(officerData)).then(function (response) {

				if (response.officerData)
				//console.log(response.officerData);
				console.log("Post Data Submitted Successfully!");
				$scope.getOfficerDetails();

				}, function (response) {	
					console.log("Service not Exists");
				});
		};	
		
		// get officer delete email
		$scope.deleteOfficerEmail = function(email){
			$scope.deleteOfficerbyEmail = email;
		};
		
		//delete officer
		$scope.deleteOfficer = function(email){
			$http.delete("/adminDashboard/deleteOfficer/"+email).then(function(res){
			
				
				if (res){
				console.log("Post Data Submitted Successfully!");
				$scope.getOfficerDetails();
				}
				
				}, function (response) {	
					console.log("Service not Exists");
				});
		};
		
		// update officer 
		// view model
		$scope.updateOfficerView = function(email){
			$http.get('/adminDashboard/officerList/'+email).then(function(res) {
				$scope.officer= res.data; 
				var officerData = $scope.officer;
				//console.log(officerData);
				$scope.officerID = officerData['id'];
				$scope.uof_firstName = officerData['firstName'];
				$scope.uof_lastName = officerData['lastName'];
				$scope.uof_address = officerData['address'];
				$scope.uof_email = officerData['email'];
				$scope.uof_mobileNumber = officerData['mobileNumber'];
				$scope.uof_nic = officerData['nic'];
				$scope.uof_workCategoryId = officerData['workCategoryId'];
			});
		};
		// update officer
		$scope.updateOfficer = function(officerID, u_firstName,u_lastName,u_nic,u_address,u_email,u_mobileNumber, u_workCategoryId){
		
		  var officerUpdateData = {
				id: officerID,
				password: $scope.officer['password'],
				username: $scope.officer['username'],
				firstName:u_firstName,
				lastName:u_lastName,
				address:u_address,
				email:u_email,
				mobileNumber:u_mobileNumber,
				nic:u_nic,
				workCategoryId:u_workCategoryId,
				loginStatus: null,
				role: "OFFICER"
			};
			//console.log(officerUpdateData);
			$http.post('/adminDashboard/officerList/updateOfficer', JSON.stringify(officerUpdateData)).then(function (response) {
				if (response){
					$scope.getOfficerDetails();
					$scope.uo_firstName = officerUpdateData['firstName'];
					$scope.uo_lastName = officerUpdateData['lastName'];
					$scope.uo_address = officerUpdateData['address'];
					$scope.uo_email = officerUpdateData['email'];
					$scope.uo_mobileNumber = officerUpdateData['mobileNumber'];
					$scope.uo_nic = officerUpdateData['nic'];
					$scope.uo_workCategoryId = officerUpdateData['workCategoryId'];
				}
			});
			
		}
		
		
		
		/******************************************** Employee Details ******************************************/
		//Get all employees
		$http.get('/adminDashboard/employeeDetails').then(function(res) {
				$scope.employees= res.data; 
				$scope.groupedbydivision = _.countBy($scope.employees, function(employee) {
									  return employee.presentDivision1;
									});
					
					$scope.groupedbytype = _.countBy($scope.employees, function(employee) {
									  return employee.type;
									});
					$scope.groupedbydesignation = _.countBy($scope.employees, function(employee) {
									  return employee.designation;
									});
							
					//console.log($scope.groupedbydesignation.id);
					//console.log($scope.groupedbytype);
					$scope.Total_count = $scope.employees.length;
			});
		
		//get employee details
		$scope.getEmployeeDetails = function() {
			
			$http.get('/adminDashboard/employeeDetails').then(function(res) {
				$scope.employees= res.data; 
			});
		};
		
		//add employee
		$scope.addEmployee = function (employeeNumber,title,surnameWithInitials,namesDenotedByInitials,nic,designation,presentDivision1,telephone,type,email,mobileNumber,address) {
			
			count = 0;
			if(address == undefined || address == ""){
				address = "--";
				count++;
			}
			if(designation == undefined || designation == ""){
				designation = "--";
				count++;
			}
			if(email == undefined || email == ""){
				email = "--";
				count++;
			}
			if(employeeNumber == undefined || employeeNumber == ""){
				employeeNumber = "--";
				count++;
			}
			if(mobileNumber == undefined || mobileNumber == ""){
				mobileNumber = "--";
				count++;
			}
			if(namesDenotedByInitials == undefined || namesDenotedByInitials == ""){
				namesDenotedByInitials = "--";
				count++;
			}
			if(nic == undefined || nic == ""){
				nic = "--";
				count++;
			}
			if(presentDivision1 == undefined || presentDivision1 == ""){
				presentDivision1 = "--";
				count++;
			}
			if(surnameWithInitials == undefined || surnameWithInitials == ""){
				surnameWithInitials = "--";
				count++;
			}
			if(telephone == undefined || telephone == ""){
				telephone = "--";
				count++;
			}
			if(title == undefined || title == ""){
				title = "--";
				count++;
			}
			if(type == undefined || type == ""){
				type = "--";
				count++;
			}
			
			var employeeData = {
				employeeNumber:employeeNumber,
				title:title,
				surnameWithInitials:surnameWithInitials,
				namesDenotedByInitials:namesDenotedByInitials,
				nic:nic,
				designation:designation,
				presentDivision1:presentDivision1,
				telephone:telephone,
				type:type,
				email:email,
				mobileNumber:mobileNumber,
				address:address
			};

			if(count == 0){
			$http.post('/adminDashboard/employeeDetails/addEmployee', JSON.stringify(employeeData)).then(function (response) {
				if (response.employeeData)
				console.log("Post Data Submitted Successfully!");
				$scope.getEmployeeDetails();
				}, function (response) {	
					console.log("Service not Exists");
				});
				$scope.pleaseTryAgain = "";
			}else{
				$scope.pleaseTryAgain = "Something went wrong!. Please Try again.";
			}
		};
		
		
		// get employee delete email
		$scope.deleteEmployeeByEmail = function(email){
			$scope.deleteEmployeeEmail = email;
		};
		
		//delete employee
		$scope.deleteEmployee = function(email){
			$http.delete('/adminDashboard/employeeDetails/deleteEmployee/'+email).then(function(res){
				if (res){
				console.log("Post Data Submitted Successfully!");
				$scope.getEmployeeDetails();
				}
				}, function (response) {	
					console.log("Service not Exists");
				});
		};
		
		//search employee
		$scope.empSearch = function(emNumber,empSurname,empDesig,presentDivi,type){
			
			if(emNumber == undefined || emNumber == ""){
				emNumber = "NA";
			}
			if(empSurname == undefined || empSurname == ""){
				empSurname = "NA";
			}
			if(empDesig == undefined || empDesig == ""){
				empDesig = "NA";
			}
			if(presentDivi == undefined || presentDivi == ""){
				presentDivi = "NA";
			}
			if(type == undefined || type == ""){
				type = "NA";
			}
			
			var empSearchData2 = {
				employeeNumber:emNumber,
				surnameWithInitials:empSurname,
				designation:empDesig,
				presentDivision1:presentDivi,
				type:type
			};
			
			
			$scope.employees = null;
			//console.log(empSearchData2);
			$http.get('/adminDashboard/employeeDetails/searchEmployee/'+emNumber+'/'+empSurname+'/'+empDesig+'/'+presentDivi+'/'+type).then(function (response) {
						
				if(response.data != 0){
					$scope.NotFoundError = " ";
					$scope.disabled = " ";
					$scope.employees = response.data;
					//console.log("Summary based on the type of employee and the designation");
					$scope.groupedbydivision = _.countBy($scope.employees, function(employee) {
									  return employee.presentDivision1;
									});
					
					$scope.groupedbytype = _.countBy($scope.employees, function(employee) {
									  return employee.type;
									});
					$scope.groupedbydesignation = _.countBy($scope.employees, function(employee) {
									  return employee.designation;
									});
							
					//console.log($scope.groupedbydesignation.id);
					//console.log($scope.groupedbytype);
					$scope.Total_count = $scope.employees.length;
					
				}else{
					$scope.NotFoundError = "No results were found!";
					$scope.disabled = "disabled";
					$scope.employees = null;
					//console.log(response.data);
				}
			});
		};
		
		//download searched employee
		$scope.empSearchDownload = function(emNumber,empSurname,empDesig,presentDivi,type){
			
			if(emNumber == undefined || emNumber == ""){
				emNumber = "NA";
			}
			if(empSurname == undefined || empSurname == ""){
				empSurname = "NA";
			}
			if(empDesig == undefined || empDesig == ""){
				empDesig = "NA";
			}
			if(presentDivi == undefined || presentDivi == ""){
				presentDivi = "NA";
			}
			if(type == undefined || type == ""){
				type = "NA";
			}
			
			var empSearchData2 = {
				employeeNumber:emNumber,
				surnameWithInitials:empSurname,
				designation:empDesig,
				presentDivision1:presentDivi,
				type:type
			};
			
			$scope.employeesSheetURL = '/adminDashboard/employeeDetails/downloadSearchedEmployees/'+emNumber+'/'+empSurname+'/'+empDesig+'/'+presentDivi+'/'+type;
			
		};
		
		
		
});


//========= STUDENT ============================================================================================================
	
//Student Page controller
PageDetails.controller('StudentPageData', function($scope, $http) {
	
	
		//Get student
		$http.get("/studentDashboard/getStudent").then(function(res) {
					$scope.student= res.data; 
					$scope.firstName=$scope.student['firstName'],
					$scope.lastName=$scope.student['lastName'],
					$scope.address=$scope.student['address'],
					$scope.email=$scope.student['email'],
					$scope.mobileNumber=$scope.student['mobileNumber'],
					$scope.loginStatus=null,
					$scope.role="STUDENT",
					$scope.registrationNo=$scope.student['registrationNo']
					
		});
		
		//date
		$scope.CurrentDate = new Date();


		/*
		//Post application	
		$scope.createApplication = function(
									titlesPrefixing,
									surnameWithInitials,
									NamesDenotedByInitials,
									postalAddress,
									registrationNo,
									field,
									cus_generalProgramme,
									cus_specializationProgramme,
									ore_firstExaminEng,
									ore_finalPart1Exam,
									ore_finalPart2Exam,
									ore_finalPart3Exam,
									pge_nameOfdegreeOrDipl,
									pge_yearCompleted,
									requestMadefor,
									payment,
									paymentPDFId,
									clearenceFormPDFId,
									addressToSendCertificate,
									localOrForieng,
									numberOfCopies){
			//removed
			//finalGPA,
			//finalPassCategory,
			
			var applicationData = {
		
				addressToSendCertificate:addressToSendCertificate,
				applicationType:"TRANSCRIPT/ACADEMIC RANK",
				//clearenceFormPDFId: clearenceFormPDFId,
				cus_generalProgramme:cus_generalProgramme,
				cus_specializationProgramme:cus_specializationProgramme,
				date:  $scope.CurrentDate,
				email:$scope.email,
				field:field,
				localOrForieng:localOrForieng,
				mobileNumber:$scope.mobileNumber,
				numberOfCopies:numberOfCopies,
				ore_finalPart1Exam:ore_finalPart1Exam,
				ore_finalPart2Exam:ore_finalPart2Exam,
				ore_finalPart3Exam:ore_finalPart3Exam,
				ore_firstExaminEng:ore_firstExaminEng,
				payment:payment,
				//paymentPDFId:paymentPDFId,
				pge_nameOfdegreeOrDipl:pge_nameOfdegreeOrDipl,
				pge_yearCompleted:pge_yearCompleted,
				postalAddress:postalAddress,
				registrationNo:registrationNo,
				requestMadefor:requestMadefor,
				status: "new",
				titlesPrefixing:titlesPrefixing,
				namesDenotedByInitials:NamesDenotedByInitials,
				surnameWithInitials:surnameWithInitials,
			};
			
			//removed
				//finalGPA:finalGPA,
				//finalPassCategory:finalPassCategory,
			//
			
			
			//console.log(applicationData);
			$http.post('/studentDashboard/Application', JSON.stringify(applicationData)).then(function (response) {

				if (response.applicationData)

				console.log("Post Data Submitted Successfully!");
				//$scope.getArDetails();

				}, function (response) {	
					console.log("Service not Exists");
				});
		};	
		
		*/
});
		
		

//========= OFFICER ============================================================================================================
		
//Officer page controller
PageDetails.controller('officerPageData', function($scope, $http) {

	//###############################################################################################################################
	/* APPLICATION PROCESS */
	
	//$scope.allApplicationsByRegNo = [];
	
	//Get all applications by registration no
	$scope.getAllApplicationsByRegNo = function(regNo){
		//console.log(regNo);
		if(regNo == "" || regNo == undefined){
			$scope.getAllApplications();
		}else{
			var regNo = regNo.split("/").join("_");
			$http.get("/officerDashboard/searchApplications/"+regNo).then(function(res) {
			$scope.allApplications = res.data;
			//console.log($scope.allApplications);
			});	
		}
	};
	
	//Get all applications
	$http.get("/officerDashboard/allApplications").then(function(res) {
		$scope.allApplications = res.data;
	});
	
	$scope.getAllApplications = function(){
		$http.get("/officerDashboard/allApplications").then(function(res) {
		$scope.allApplications = res.data;
	});
	};
	
	
	
	//Get all new applications
	$http.get("/officerDashboard/allNewApplications").then(function(res) {
		$scope.newApplications = res.data;
	});
	
	$scope.getNewApplications = function(){
		$http.get("/officerDashboard/allNewApplications").then(function(res) {
			$scope.newApplications = res.data;
		});
	};
	
	//Get all accepted applications
	$http.get("/officerDashboard/allAcceptedApplications").then(function(res) {
		$scope.acceptedApplications = res.data;
	});
	
	$scope.getAcceptedApplications = function(){
		$http.get("/officerDashboard/allAcceptedApplications").then(function(res) {
			$scope.acceptedApplications = res.data;
		});
	};
	
	//Get all rejected applications
	$http.get("/officerDashboard/allRejectedApplications").then(function(res) {
		$scope.rejectedApplications = res.data;
	});
	
	$scope.getRejectedApplications = function(){
		$http.get("/officerDashboard/allRejectedApplications").then(function(res) {
			$scope.rejectedApplications = res.data;
		});
	};
	
	//Get all prepared applications
	$http.get("/officerDashboard/allPreparedApplications").then(function(res) {
		$scope.preparedApplications = res.data;
	});
	
	$scope.getPreparedApplications = function(){
		$http.get("/officerDashboard/allPreparedApplications").then(function(res) {
			$scope.preparedApplications = res.data;
		});
	};
	
	//Get all checked OK application
	$http.get("/officerDashboard/allCheckedOKApplications").then(function(res) {
		$scope.checkedOKApplications = res.data;
	});
	
	$scope.getCheckedOKApplications = function(){
		$http.get("/officerDashboard/allCheckedOKApplications").then(function(res) {
			$scope.checkedOKApplications = res.data;
		});
	};
	
	//Get all checked Not OK application
	$http.get("/officerDashboard/allCheckedNotOKApplications").then(function(res) {
		$scope.checkedNotOKApplications = res.data;
	});
	
	$scope.getCheckedNotOKApplications = function(){
		$http.get("/officerDashboard/allCheckedNotOKApplications").then(function(res) {
			$scope.checkedNotOKApplications = res.data;
		});
	};
	
	//Get all completed applications
	$http.get("/officerDashboard/allCompletedTranAcadApplications").then(function(res) {
		$scope.completedTranAcadApplications = res.data;
	});
	
	$scope.getCompletedTranAcadApplications = function(){
		$http.get("/officerDashboard/allCompletedTranAcadApplications").then(function(res) {
			$scope.completedTranAcadApplications = res.data;
		});
	};
	
	//download application
	$scope.downloadPDFApplication = function(applicationId){
		$scope.downloadURL = "/officerDashboard/allApplications/"+applicationId;
		$scope.applicationId = applicationId;
	};
	
	//View application
	$scope.viewApplication = function(applicationId){
		$scope.Formdisplay = "block";
		$scope.OKdisplay = "none";
		$scope.reasonMsg = "";
		
		$scope.pdfURL = "/officerDashboard/Applications/"+applicationId+".pdf";
		$scope.applicationId = applicationId;
	};
	
	//View application for check
	$scope.checkApplication = function(applicationId){
		$scope.CheckedNotOKMessage = "";
		$scope.checkOKdisplay = "none";
		$scope.CheckedNotOKFormdisplay = "block";
					
		$scope.pdfURL = "/officerDashboard/Applications/"+applicationId+".pdf";
		$scope.applicationId = applicationId;
	};
	
	//Accept Application
	$scope.acceptApplication = function(){
	
		$scope.acceptURL="/officerDashboard/allApplications/setNew/"+$scope.applicationId; //take view application if from $scope.viewApplication
		$http.put($scope.acceptURL).then(function (res) {
			
			if(res){
				alert("Status is changed Successfully!");
				location.reload();
				$scope.getNewApplications();
				$scope.getAcceptedApplications();
				$scope.getAllApplications();
			}
			
			
		});	
	};
	
	//Reject Application
	$scope.rejectApplication = function(reasonMsg){
	
		$scope.reason = reasonMsg;
	
		$scope.rejectURL="/officerDashboard/allApplications/setReject/"+$scope.applicationId+"/"+$scope.reason;
		$http.put($scope.rejectURL).then(function () {
					//alert("Status is changed Successfully!");
					$scope.rejectMessage = "Application is rejected!";
					$scope.OKdisplay = "block";
					$scope.Formdisplay = "none";
					location.reload();
					$scope.getNewApplications();
					$scope.getRejectedApplications();
					$scope.getAllApplications();
					
				});
	};
	
	//Prepared Application
	//not need this. Since files are uploaded directly from jsp to controller
	
	//Checked OK Application
	$scope.checkedOKApplication = function(){
	
		$scope.checkedOKURL="/officerDashboard/allApplications/setCheckedOK/"+$scope.applicationId; 
		$http.put($scope.checkedOKURL).then(function () {
			alert("Status is changed Successfully!");
			location.reload();
			$scope.getPreparedApplications(); //get prepared applications to check
			
		});	
	};
	
	//Checked Not OK Application
	$scope.checkedNotOKApplication = function(checkNotOKreasonMsg){
		
		$scope.CheckedNotOKReason = checkNotOKreasonMsg;
	
		$scope.checkedNotOKURL="/officerDashboard/allApplications/setCheckedNotOK/"+$scope.applicationId+"/"+$scope.CheckedNotOKReason;
		$http.put($scope.checkedNotOKURL).then(function () {
					$scope.CheckedNotOKMessage = "Status of Application changed to 'Checked Not OK'.";
					$scope.checkOKdisplay = "block";
					$scope.CheckedNotOKFormdisplay = "none";
					location.reload();
					$scope.getPreparedApplications(); //get prepared applications to check
				});
	};
	
	//Completed Application
	$scope.completedTranAcadApplication = function(completedApplicationId){
		window.location.hash = 'three';
		window.location.reload();
		//location.reload();
		$scope.completeTranAcadURL="/officerDashboard/allApplications/setCompleted/"+completedApplicationId;
		$http.put($scope.completeTranAcadURL).then(function () {
			$scope.getAcceptedApplications();
			$scope.getCompletedTranAcadApplications();
		});	
	};
	
	
	//Done processing TranAcadApplications 
	$scope.emailTranAcadApplication = function(doneApplicationId){
		
		$scope.donetranAcadURL="/officerDashboard/allApplications/setDone/"+doneApplicationId;
		$http.put($scope.donetranAcadURL).then(function () {
			window.location.hash = 'three';
			window.location.reload();
			$scope.getCompletedTranAcadApplications();
		});	
		
	};
	
	//##################################################################################################################################
	
	
	//Get officer
	$http.get("/officerDashboard/getOfficer").then(function(res) {
				$scope.officer= res.data; 
				$scope.firstName=$scope.officer['firstName'],
				$scope.lastName=$scope.officer['lastName'],
				$scope.address=$scope.officer['address'],
				$scope.email=$scope.officer['email'],
				$scope.mobileNumber=$scope.officer['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="OFFICER",
				$scope.nic=$scope.officer['nic']
				
			});
	
	//update Officer details
	$scope.updateOfficer = function (firstName,lastName,nic,address,email,mobileNumber) {
			
			var officerData = {
				id: $scope.officer['id'],
				username: $scope.officer['username'],
				password: $scope.officer['password'],
				firstName:firstName,
				lastName:lastName,
				address:address,
				email:email,
				mobileNumber:mobileNumber,
				loginStatus:null,
				role:"OFFICER",
				nic:nic
		};

		$http.post('/officerDashboard/updateOfficer', JSON.stringify(officerData)).then(function (response) {

				
				$scope.updatedMsg = "Account is updated!";
				$scope.firstName=officerData['firstName'],
				$scope.lastName=officerData['lastName'],
				$scope.address=officerData['address'],
				$scope.email=officerData['email'],
				$scope.mobileNumber=officerData['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="OFFICER",
				$scope.nic=officerData['nic']
				
				if (response.officerData){
				console.log("Post Data Submitted Successfully!");
				
				}
				
				}, function (response) {	
					console.log("Service not Exists");
				});
			
		};	
	
});


//========= AR ============================================================================================================
//AR Page controller
PageDetails.controller('arPageData', function($scope, $http) {
	
	//Application apis
	
	//Get all applications
	$http.get("/arDashboard/allApplications").then(function(res) {
		$scope.allApplications = res.data;
	});
	
	$scope.getAllApplications = function(){
		$http.get("/arDashboard/allApplications").then(function(res) {
		$scope.allApplications = res.data;
	});
	};
	
	//Get all applications by registration no
	$scope.getAllApplicationsByRegNo = function(regNo){
		//console.log(regNo);
		if(regNo == "" || regNo == undefined){
			$scope.getAllApplications();
		}else{
			var regNo = regNo.split("/").join("_");
			$http.get("/arDashboard/searchApplications/"+regNo).then(function(res) {
			$scope.allApplications = res.data;
			//console.log($scope.allApplications);
			});	
		}
	};
	
	//Get all new applications
	$http.get("/arDashboard/allNewApplications").then(function(res) {
		$scope.newApplications = res.data;
	});
	
	$scope.getNewApplications = function(){
		$http.get("/arDashboard/allNewApplications").then(function(res) {
			$scope.newApplications = res.data;
		});
	};
	
	//Get all accepted applications
	$http.get("/arDashboard/allAcceptedApplications").then(function(res) {
		$scope.acceptedApplications = res.data;
	});
	
	$scope.getAcceptedApplications = function(){
		$http.get("/arDashboard/allAcceptedApplications").then(function(res) {
			$scope.acceptedApplications = res.data;
		});
	};
	
	//Get all completed applications
	$http.get("/arDashboard/allCompletedTranAcadApplications").then(function(res) {
		$scope.completedTranAcadApplications = res.data;
	});
	
	$scope.getCompletedTranAcadApplications = function(){
		$http.get("/arDashboard/allCompletedTranAcadApplications").then(function(res) {
			$scope.completedTranAcadApplications = res.data;
		});
	};
	
	
	//Get all rejected applications
	$http.get("/arDashboard/allRejectedApplications").then(function(res) {
		$scope.rejectedApplications = res.data;
	});
	
	$scope.getRejectedApplications = function(){
		$http.get("/arDashboard/allRejectedApplications").then(function(res) {
			$scope.rejectedApplications = res.data;
		});
	};
	
	//download application
	$scope.downloadPDFApplication = function(applicationId){
		$scope.downloadURL = "/arDashboard/allApplications/"+applicationId;
		$scope.applicationId = applicationId;
	};
	
	//View application
	$scope.viewApplication = function(applicationId){
		$scope.pdfURL = "/arDashboard/Applications/"+applicationId+".pdf";
		$scope.applicationId = applicationId;
	};
	
	
	
	//Employee apis
	//Get all employees
		$http.get('/arDashboard/employeeDetails').then(function(res) {
				$scope.employees= res.data; 
				$scope.groupedbydivision = _.countBy($scope.employees, function(employee) {
									  return employee.presentDivision1;
									});
					
					$scope.groupedbytype = _.countBy($scope.employees, function(employee) {
									  return employee.type;
									});
					$scope.groupedbydesignation = _.countBy($scope.employees, function(employee) {
									  return employee.designation;
									});
							
					//console.log($scope.groupedbydesignation.id);
					//console.log($scope.groupedbytype);
					$scope.Total_count = $scope.employees.length;
			});
		
		//get employee details
		$scope.getEmployeeDetails = function() {
			
			$http.get('/arDashboard/employeeDetails').then(function(res) {
				$scope.employees= res.data; 
			});
		};
		
		//search employee
		$scope.empSearch = function(emNumber,empSurname,empDesig,presentDivi,type){
			
			if(emNumber == undefined || emNumber == ""){
				emNumber = "NA";
			}
			if(empSurname == undefined || empSurname == ""){
				empSurname = "NA";
			}
			if(empDesig == undefined || empDesig == ""){
				empDesig = "NA";
			}
			if(presentDivi == undefined || presentDivi == ""){
				presentDivi = "NA";
			}
			if(type == undefined || type == ""){
				type = "NA";
			}
			
			var empSearchData2 = {
				employeeNumber:emNumber,
				surnameWithInitials:empSurname,
				designation:empDesig,
				presentDivision1:presentDivi,
				type:type
			};
			
			
			$scope.employees = null;
			//console.log(empSearchData2);
			$http.get('/arDashboard/employeeDetails/searchEmployee/'+emNumber+'/'+empSurname+'/'+empDesig+'/'+presentDivi+'/'+type).then(function (response) {
						
				if(response.data != 0){
					$scope.NotFoundError = " ";
					$scope.disabled = " ";
					$scope.employees = response.data;
					$scope.groupedbydivision = _.countBy($scope.employees, function(employee) {
									  return employee.presentDivision1;
									});
					
					$scope.groupedbytype = _.countBy($scope.employees, function(employee) {
									  return employee.type;
									});
					$scope.groupedbydesignation = _.countBy($scope.employees, function(employee) {
									  return employee.designation;
									});
							
					//console.log($scope.groupedbydesignation.id);
					//console.log($scope.groupedbytype);
					$scope.Total_count = $scope.employees.length;
					//console.log(response.data);
				}else{
					$scope.NotFoundError = "No results were found!";
					$scope.disabled = "disabled";
					$scope.employees = null;
					//console.log(response.data);
				}
			});
		};
		
		//download searched employee
		$scope.empSearchDownload = function(emNumber,empSurname,empDesig,presentDivi,type){
			
			if(emNumber == undefined || emNumber == ""){
				emNumber = "NA";
			}
			if(empSurname == undefined || empSurname == ""){
				empSurname = "NA";
			}
			if(empDesig == undefined || empDesig == ""){
				empDesig = "NA";
			}
			if(presentDivi == undefined || presentDivi == ""){
				presentDivi = "NA";
			}
			if(type == undefined || type == ""){
				type = "NA";
			}
			
			var empSearchData2 = {
				employeeNumber:emNumber,
				surnameWithInitials:empSurname,
				designation:empDesig,
				presentDivision1:presentDivi,
				type:type
			};
			
			$scope.employeesSheetURL = '/arDashboard/employeeDetails/downloadSearchedEmployees/'+emNumber+'/'+empSurname+'/'+empDesig+'/'+presentDivi+'/'+type;
			
		};
	
	//My Account
	
	//Get ar
	$http.get("/arDashboard/getAr").then(function(res) {
				$scope.ar= res.data; 
				$scope.firstName=$scope.ar['firstName'],
				$scope.lastName=$scope.ar['lastName'],
				$scope.address=$scope.ar['address'],
				$scope.email=$scope.ar['email'],
				$scope.mobileNumber=$scope.ar['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="AR",
				$scope.nic=$scope.ar['nic']
				
			});
	
	
	$scope.updateAr = function (firstName,lastName,nic,address,email,mobileNumber) {
			
			var arData = {
				id: $scope.ar['id'],
				username: $scope.ar['username'],
				password: $scope.ar['password'],
				firstName:firstName,
				lastName:lastName,
				address:address,
				email:email,
				mobileNumber:mobileNumber,
				loginStatus:null,
				role:"AR",
				nic:nic
		};

		$http.post('/arDashboard/updateAr', JSON.stringify(arData)).then(function (response) {

				
				$scope.updatedMsg = "Account is updated!";
				$scope.firstName=arData['firstName'],
				$scope.lastName=arData['lastName'],
				$scope.address=arData['address'],
				$scope.email=arData['email'],
				$scope.mobileNumber=arData['mobileNumber'],
				$scope.loginStatus=null,
				$scope.role="AR",
				$scope.nic=arData['nic']
				
				if (response.arData){
				console.log("Post Data Submitted Successfully!");
				
				}
				
				}, function (response) {	
					console.log("Service not Exists");
				});
			
		};	
 	

});

//######################################################################################################################

	
	
		