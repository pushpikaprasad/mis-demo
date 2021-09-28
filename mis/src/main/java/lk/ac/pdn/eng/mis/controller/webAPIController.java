package lk.ac.pdn.eng.mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lk.ac.pdn.eng.mis.entity.Application;
import lk.ac.pdn.eng.mis.service.ApplicationService;
import lk.ac.pdn.eng.mis.service.OfficerService;

@RestController
public class webAPIController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private OfficerService officerService;
	
	/*APIs for common use*/
	
	@PostMapping(value = "/sendApplication", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public void submitApplication(HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("mobile") String mobile,
			
			@RequestParam("titlesPrefixing") String titlesPrefixing,
			@RequestParam("surnameWithInitials") String surnameWithInitials,
			@RequestParam("NamesDenotedByInitials") String NamesDenotedByInitials,
			@RequestParam("postalAddress") String postalAddress, @RequestParam("registrationNo") String registrationNo,
			@RequestParam("field") String field, @RequestParam("cus_generalProgramme") String cus_generalProgramme,
			@RequestParam("cus_specializationProgramme") String cus_specializationProgramme,
			@RequestParam("ore_firstExaminEng") String ore_firstExaminEng,
			@RequestParam("ore_finalPart1Exam") String ore_finalPart1Exam,
			@RequestParam("ore_finalPart2Exam") String ore_finalPart2Exam,
			@RequestParam("ore_finalPart3Exam") String ore_finalPart3Exam,
			@RequestParam("pge_nameOfdegreeOrDipl") String pge_nameOfdegreeOrDipl,
			@RequestParam("pge_yearCompleted") String pge_yearCompleted,
			@RequestParam("requestMadefor") String requestMadefor, @RequestParam("payment") double payment,
			@RequestParam("collectionMethod") String collectionMethod,
			@RequestParam("addressToSendCertificate") String addressToSendCertificate,
			@RequestParam(value ="localOrForieng", required = false) String localOrForieng, @RequestParam("numberOfCopies") int numberOfCopies,
			@RequestParam("paymentReceipt") MultipartFile paymentReceipt,
			@RequestParam("paymentReceipt2") MultipartFile paymentReceipt2,
			@RequestParam("clearenceForm") MultipartFile clearenceForm) throws IOException, AddressException, MessagingException {
		
		/*
		 * removed 
		 * @RequestParam("finalGPA") double finalGPA,
		 * @RequestParam("finalPassCategory") String finalPassCategory,
		 */
		//UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		String paymentReceiptName = StringUtils.cleanPath(paymentReceipt.getOriginalFilename());
		String paymentReceiptName2 = StringUtils.cleanPath(paymentReceipt2.getOriginalFilename());
		String clearenceFormName = StringUtils.cleanPath(clearenceForm.getOriginalFilename());

		String uploadPaymentReceiptDir = "src/main/resources/META-INF/resources/WEB-INF/views/files/paymentReceipts/"
				+"_"+ mobile + "/";
		String uploadPaymentReceiptDir2 = "src/main/resources/META-INF/resources/WEB-INF/views/files/paymentReceipts2/"
				+"_"+ mobile + "/";
		String uploadClearenceFormNameDir = "src/main/resources/META-INF/resources/WEB-INF/views/files/clearenceForms/"
				+"_"+ mobile + "/";

		Path uploadPaymentReceiptPath = Paths.get(uploadPaymentReceiptDir);
		Path uploadPaymentReceiptPath2 = Paths.get(uploadPaymentReceiptDir2);
		Path uploadClearenceFormNamePath = Paths.get(uploadClearenceFormNameDir);

		if (!Files.exists(uploadPaymentReceiptPath)) {
			Files.createDirectories(uploadPaymentReceiptPath);
		}
		
		if (!Files.exists(uploadPaymentReceiptPath2)) {
			Files.createDirectories(uploadPaymentReceiptPath2);
		}
		
		if (!Files.exists(uploadClearenceFormNamePath)) {
			Files.createDirectories(uploadClearenceFormNamePath);
		}

		Path PaymentReceiptfilePath = null;
		Path PaymentReceiptfilePath2 = null;
		Path ClearenceFormfilePath = null;
		
		
		try (InputStream inputStream = paymentReceipt.getInputStream()) {
			PaymentReceiptfilePath = uploadPaymentReceiptPath.resolve(paymentReceiptName);
			Files.copy(inputStream, PaymentReceiptfilePath, StandardCopyOption.REPLACE_EXISTING);
			//System.out.println(inputStream + "\n" + PaymentReceiptfilePath);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + paymentReceiptName, ioe);

		}
		
		if(!paymentReceipt2.isEmpty()) {
		try (InputStream inputStream = paymentReceipt2.getInputStream()) {
			PaymentReceiptfilePath2 = uploadPaymentReceiptPath2.resolve(paymentReceiptName2);
			Files.copy(inputStream, PaymentReceiptfilePath2, StandardCopyOption.REPLACE_EXISTING);
			//System.out.println(inputStream + "\n" + PaymentReceiptfilePath);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + paymentReceiptName2, ioe);

		}
		}
		
		if(!clearenceForm.isEmpty()) {
		try (InputStream inputStream = clearenceForm.getInputStream()) {
			ClearenceFormfilePath = uploadClearenceFormNamePath.resolve(clearenceFormName);
			Files.copy(inputStream, ClearenceFormfilePath, StandardCopyOption.REPLACE_EXISTING);
			//System.out.println(inputStream + "\n" + ClearenceFormfilePath);
		} catch (IOException ioe) {
			throw new IOException("Could not save file: " + clearenceFormName, ioe);

		}
		}

		Application application = new Application();
		application.setTitlesPrefixing(titlesPrefixing);
		application.setSurnameWithInitials(surnameWithInitials);
		application.setStatus("new");
		application.setRequestMadefor(requestMadefor);
		application.setRegistrationNo(registrationNo);
		application.setPostalAddress(postalAddress);
		application.setPge_yearCompleted(pge_yearCompleted);
		application.setPge_nameOfdegreeOrDipl(pge_nameOfdegreeOrDipl);
		application.setPaymentPDFId(PaymentReceiptfilePath.toString());
		if(PaymentReceiptfilePath2 != null) {
		application.setPaymentPDFId2(PaymentReceiptfilePath2.toString());
		}
		application.setPayment(payment);
		application.setOre_firstExaminEng(ore_firstExaminEng);
		application.setOre_finalPart3Exam(ore_finalPart3Exam);
		application.setOre_finalPart2Exam(ore_finalPart2Exam);
		application.setOre_finalPart1Exam(ore_finalPart1Exam);
		application.setNumberOfCopies(numberOfCopies);
		application.setNamesDenotedByInitials(NamesDenotedByInitials);
		System.out.println(localOrForieng);
		application.setMobileNumber(mobile);
		if(localOrForieng != null) {
			application.setLocalOrForieng(localOrForieng);
		}
		else {
			application.setLocalOrForieng("");
		}
		//application.setFinalPassCategory(finalPassCategory);
		//application.setFinalGPA(finalGPA);
		application.setField(field);
		application.setEmail(email);
		application.setDate(new Date().toString());
		application.setCus_specializationProgramme(cus_specializationProgramme);
		application.setCus_generalProgramme(cus_generalProgramme);
		if(ClearenceFormfilePath != null) {
		application.setClearenceFormPDFId(ClearenceFormfilePath.toString());
		}
		application.setApplicationType("TRANSCRIPT/ACADEMIC RANK");
		
		String ifEmail = "";
		if(collectionMethod.equals("From Email")) {
			ifEmail = " (To "+email+" )";
		}
		application.setCollectionMethod(collectionMethod+ifEmail);
		application.setAddressToSendCertificate(addressToSendCertificate);

		applicationService.createApplication(application);
		

		int applicationId = applicationService.getApplicationByDate(application.getDate()).getApplicationId();
		
		//send email to relevant officer
				officerService.sendEmailToList(officerService.getEmailListofOfficersByWCID(1), "Received new application",
						"Dear Officer, <br><br>You have received new Transcript/Academic Rank Certificate application.<br><br> Thank you ");
		
		
		// send with attachment int applicationId 
		applicationService.getApplicationByDate(application.getDate()).getApplicationId();
		String title2 = "TRANSCRIPT/ACADEMIC RANK CERTIFICATE APPLICATION"; 
		String msg2 = "Dear Student,\n\nYou have successfully submitted the application.";
		try { 
			applicationService.sendEmailWithPDF(application.getEmail(), title2, msg2,
		applicationId); } catch (MessagingException e) { e.printStackTrace(); }
		
		
		//response.sendRedirect("/studentDashboard");
	}

}
