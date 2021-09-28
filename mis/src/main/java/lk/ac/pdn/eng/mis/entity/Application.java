package lk.ac.pdn.eng.mis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicationId;
	
	private String applicationType;
	private String email;
	private String mobileNumber;

	private String surnameWithInitials;
	private String NamesDenotedByInitials;
	private String titlesPrefixing;
	private String postalAddress;
	private String registrationNo;
	private String field;
	private String cus_generalProgramme;
	private String cus_specializationProgramme;
	private String ore_firstExaminEng;
	private String ore_finalPart1Exam;
	private String ore_finalPart2Exam;
	private String ore_finalPart3Exam;
	private String pge_nameOfdegreeOrDipl;
	private String pge_yearCompleted;
	//private double finalGPA;
	//private String finalPassCategory;
	private String requestMadefor;
	private double payment;
	private String collectionMethod;
	
	private String paymentPDFId;  // deposit slip
	private String paymentPDFId2; //paying in voucher
	private String clearenceFormPDFId; //clearance note
	
	private String addressToSendCertificate;
	private String localOrForieng;
	private int numberOfCopies;
	private String date;

	private String status = "new";
	private String statusDetails;
	
	@Lob
    private byte[] transcriptDocument;
	
	@Lob
    private byte[] academicRankDocument;
	
	
	
	public Application(int applicationId, String applicationType, String email, String mobileNumber,
			String surnameWithInitials, String namesDenotedByInitials, String titlesPrefixing, String postalAddress,
			String registrationNo, String field, String cus_generalProgramme, String cus_specializationProgramme,
			String ore_firstExaminEng, String ore_finalPart1Exam, String ore_finalPart2Exam, String ore_finalPart3Exam,
			String pge_nameOfdegreeOrDipl, String pge_yearCompleted,
			String requestMadefor, double payment, String collectionMethod, String paymentPDFId, String clearenceFormPDFId,
			String addressToSendCertificate, String localOrForieng, int numberOfCopies, String date, String status) {
		// removed  double finalGPA, String finalPassCategory,
		super();
		this.applicationId = applicationId;
		this.applicationType = applicationType;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.surnameWithInitials = surnameWithInitials;
		NamesDenotedByInitials = namesDenotedByInitials;
		this.titlesPrefixing = titlesPrefixing;
		this.postalAddress = postalAddress;
		this.registrationNo = registrationNo;
		this.field = field;
		this.cus_generalProgramme = cus_generalProgramme;
		this.cus_specializationProgramme = cus_specializationProgramme;
		this.ore_firstExaminEng = ore_firstExaminEng;
		this.ore_finalPart1Exam = ore_finalPart1Exam;
		this.ore_finalPart2Exam = ore_finalPart2Exam;
		this.ore_finalPart3Exam = ore_finalPart3Exam;
		this.pge_nameOfdegreeOrDipl = pge_nameOfdegreeOrDipl;
		this.pge_yearCompleted = pge_yearCompleted;
		//this.finalGPA = finalGPA;
		//this.finalPassCategory = finalPassCategory;
		this.requestMadefor = requestMadefor;
		this.payment = payment;
		this.collectionMethod = collectionMethod;
		this.paymentPDFId = paymentPDFId;
		this.clearenceFormPDFId = clearenceFormPDFId;
		this.addressToSendCertificate = addressToSendCertificate;
		this.localOrForieng = localOrForieng;
		this.numberOfCopies = numberOfCopies;
		this.date = date;
		this.status = status;
		
	}



	public Application() {
		super();
	}

	

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	
	public String getSurnameWithInitials() {
		return surnameWithInitials;
	}

	public void setSurnameWithInitials(String surnameWithInitials) {
		this.surnameWithInitials = surnameWithInitials;
	}

	public String getNamesDenotedByInitials() {
		return NamesDenotedByInitials;
	}

	public void setNamesDenotedByInitials(String namesDenotedByInitials) {
		NamesDenotedByInitials = namesDenotedByInitials;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTitlesPrefixing() {
		return titlesPrefixing;
	}

	public void setTitlesPrefixing(String titlesPrefixing) {
		this.titlesPrefixing = titlesPrefixing;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getCus_generalProgramme() {
		return cus_generalProgramme;
	}

	public void setCus_generalProgramme(String cus_generalProgramme) {
		this.cus_generalProgramme = cus_generalProgramme;
	}

	public String getCus_specializationProgramme() {
		return cus_specializationProgramme;
	}

	public void setCus_specializationProgramme(String cus_specializationProgramme) {
		this.cus_specializationProgramme = cus_specializationProgramme;
	}

	public String getOre_firstExaminEng() {
		return ore_firstExaminEng;
	}

	public void setOre_firstExaminEng(String ore_firstExaminEng) {
		this.ore_firstExaminEng = ore_firstExaminEng;
	}

	public String getOre_finalPart1Exam() {
		return ore_finalPart1Exam;
	}

	public void setOre_finalPart1Exam(String ore_finalPart1Exam) {
		this.ore_finalPart1Exam = ore_finalPart1Exam;
	}

	public String getOre_finalPart2Exam() {
		return ore_finalPart2Exam;
	}

	public void setOre_finalPart2Exam(String ore_finalPart2Exam) {
		this.ore_finalPart2Exam = ore_finalPart2Exam;
	}

	public String getOre_finalPart3Exam() {
		return ore_finalPart3Exam;
	}

	public void setOre_finalPart3Exam(String ore_finalPart3Exam) {
		this.ore_finalPart3Exam = ore_finalPart3Exam;
	}

	public String getPge_nameOfdegreeOrDipl() {
		return pge_nameOfdegreeOrDipl;
	}

	public void setPge_nameOfdegreeOrDipl(String pge_nameOfdegreeOrDipl) {
		this.pge_nameOfdegreeOrDipl = pge_nameOfdegreeOrDipl;
	}

	public String getPge_yearCompleted() {
		return pge_yearCompleted;
	}

	public void setPge_yearCompleted(String pge_yearCompleted) {
		this.pge_yearCompleted = pge_yearCompleted;
	}

	/*public double getFinalGPA() {
		return finalGPA;
	}

	public void setFinalGPA(double finalGPA) {
		this.finalGPA = finalGPA;
	}

	public String getFinalPassCategory() {
		return finalPassCategory;
	}

	public void setFinalPassCategory(String finalPassCategory) {
		this.finalPassCategory = finalPassCategory;
	}*/

	public String getRequestMadefor() {
		return requestMadefor;
	}

	public void setRequestMadefor(String requestMadefor) {
		this.requestMadefor = requestMadefor;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPaymentPDFId() {
		return paymentPDFId;
	}

	public void setPaymentPDFId(String paymentPDFId) {
		this.paymentPDFId = paymentPDFId;
	}

	public String getClearenceFormPDFId() {
		return clearenceFormPDFId;
	}

	public void setClearenceFormPDFId(String clearenceFormPDFId) {
		this.clearenceFormPDFId = clearenceFormPDFId;
	}

	public String getAddressToSendCertificate() {
		return addressToSendCertificate;
	}

	public void setAddressToSendCertificate(String addressToSendCertificate) {
		this.addressToSendCertificate = addressToSendCertificate;
	}

	public String getLocalOrForieng() {
		return localOrForieng;
	}

	public void setLocalOrForieng(String localOrForieng) {
		this.localOrForieng = localOrForieng;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getPaymentPDFId2() {
		return paymentPDFId2;
	}



	public void setPaymentPDFId2(String paymentPDFId2) {
		this.paymentPDFId2 = paymentPDFId2;
	}



	public String getCollectionMethod() {
		return collectionMethod;
	}



	public void setCollectionMethod(String collectionMethod) {
		this.collectionMethod = collectionMethod;
	}



	public String getStatusDetails() {
		return statusDetails;
	}



	public void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}
	
	public byte[] getTranscriptDocument() {
		return transcriptDocument;
	}



	public void setTranscriptDocument(byte[] transcriptDocument) {
		this.transcriptDocument = transcriptDocument;
	}



	public byte[] getAcademicRankDocument() {
		return academicRankDocument;
	}



	public void setAcademicRankDocument(byte[] academicRankDocument) {
		this.academicRankDocument = academicRankDocument;
	}

	
}
