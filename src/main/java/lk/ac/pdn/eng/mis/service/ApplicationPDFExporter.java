package lk.ac.pdn.eng.mis.service;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import lk.ac.pdn.eng.mis.entity.Application;

public class ApplicationPDFExporter{// extends AbstractITextPdfView {
	
	private Application application;

	
	public ApplicationPDFExporter(Application application) {
		this.application = application; 
	}
	
	public void export(HttpServletResponse response) throws SocketTimeoutException, DocumentException, IOException {
		
		 Document document = new Document(PageSize.A4);
	     PdfWriter.getInstance(document, response.getOutputStream());
	     PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		   
	         
	     document.open();
	     Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	     font.setSize(14);
	     font.setColor(Color.BLACK);
	     font.setStyle(2);
	     
	     Paragraph p = new Paragraph("FACULTY OF ENGINEERING - UNIVERSITY OF PERADENIYA\r\nAPPLICATION FOR TRANSCRIPT/ACADEMIC RANK CERTIFICATE", font);
	     p.setAlignment(Paragraph.ALIGN_CENTER);
	     p.setFont(font);
	     
	     document.add(p);
	     
	     //create application
	     PdfPTable table = new PdfPTable(2);
	     table.setWidthPercentage(100f);
	     table.setWidths(new float[] {5f, 7.5f});
	     table.setSpacingBefore(10);
	     
	     PdfPCell cellStatus = new PdfPCell();
	     cellStatus.setBackgroundColor(Color.WHITE);
	     cellStatus.setPadding(10);
	     cellStatus.setBorderWidth(1);
	     cellStatus.setVerticalAlignment(1);
	     
	     Font cellStatusfont = FontFactory.getFont(FontFactory.HELVETICA);
	     cellStatusfont.setColor(Color.DARK_GRAY);
	    
	     
	     cellStatus.setPhrase(new Phrase("Application Status: ", cellStatusfont));
	     table.addCell(cellStatus);
	     cellStatus.setPhrase(new Phrase(application.getStatusDetails()+"\n "));
	     table.addCell(cellStatus);
	     
	     
	     
	     PdfPCell cell = new PdfPCell();
	     cell.setBackgroundColor(Color.WHITE);
	     cell.setPadding(5);
	     cell.setBorderWidth(0);
	     
	     Font cellfont = FontFactory.getFont(FontFactory.HELVETICA);
	     cellfont.setColor(Color.DARK_GRAY);
	     
	       
	     Font contentfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	     contentfont.setSize(12);
	     contentfont.setColor(Color.BLACK);

	     cell.setPhrase(new Phrase("", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("", cellfont));
	     table.addCell(cell);
	     
	     cell.setPhrase(new Phrase("1.\tSurname with initials: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getTitlesPrefixing()+" "+application.getSurnameWithInitials(), contentfont));    
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("2.\tNames denoted by initials: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getNamesDenotedByInitials(), contentfont));    
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("3.\tPostal address: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getPostalAddress(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("4.\tRegistration No: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getRegistrationNo(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\tField: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getField(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("5.\tParticulars of examinations passed: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\tCourse Unit System ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));  
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("\t\ta). General Programme: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getCus_generalProgramme(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tb). Specialization Programme: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getCus_specializationProgramme(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\tOld Regulation Examinations ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\ta) First Examination In Engineering: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getOre_firstExaminEng(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tb) Final Part I Examination: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getOre_finalPart1Exam(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tc) Final Part II Examination: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getOre_finalPart2Exam(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\td) Final Part III Examination: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getOre_finalPart3Exam(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\tPostgraduate Examinations ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));    
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("\t\ta) Name of the Degree/Diploma: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getPge_nameOfdegreeOrDipl(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tb) Year Completed: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getPge_yearCompleted(), contentfont));    
	     table.addCell(cell);   
	     //cell.setPhrase(new Phrase("6.\tFinal course GPA: ", cellfont));	
	     //table.addCell(cell);
	     //cell.setPhrase(new Phrase(" "+application.getFinalGPA(), contentfont));    
	     //table.addCell(cell);   
	     //cell.setPhrase(new Phrase("7.\tFinal course pass category: ", cellfont));
	     //table.addCell(cell);
	     //cell.setPhrase(new Phrase(application.getFinalPassCategory(), contentfont));    
	     //table.addCell(cell);   
	     cell.setPhrase(new Phrase("8.\t", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\ta) Request Made for: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getRequestMadefor(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tb) Payment made (Rs.): ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""+application.getPayment(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("9.\t", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\ta) The full address to which the transcript/academic rank \ncertificate should be sent: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getAddressToSendCertificate(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\t\tb) Local or Foreign address: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getLocalOrForieng(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("10.\tNumber of copies: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(""+application.getNumberOfCopies(), contentfont));    
	     table.addCell(cell);   
	     cell.setPhrase(new Phrase("\tDate: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getDate(), contentfont));    
	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("\tCollection Method: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getCollectionMethod(), contentfont));    
	     table.addCell(cell);
	     
	     
	     document.add(table);
	     
		    //Add payment receipts
		     
		    document.add(new Paragraph("Payment Receipts:"));
		    
		  //deposit slip
		    
		    if(application.getPaymentPDFId() != null) {
		    String paymentReceiptImage = application.getPaymentPDFId();
		    //System.out.println(paymentReceiptImage);
		    Image img = null;
			try {
				String path = paymentReceiptImage;
				img = Image.getInstance(path);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

				img.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img);
		    }	 
		    
		  //paying in voucher
		     
		    if(application.getPaymentPDFId2()!= null) {
		    String paymentReceiptImage2 = application.getPaymentPDFId2();
		    //System.out.println(paymentReceiptImage2);
		    Image img2 = null;
			try {
				String path = paymentReceiptImage2;
				img2 = Image.getInstance(path);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

				img2.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img2);
		    }
	   	     
		     //Add payment receipt
		     
			    document.add(new Paragraph("Clearance Form:"));
			    if(application.getClearenceFormPDFId() != null) {
			    String clearenceFormImage = application.getClearenceFormPDFId();
			    //System.out.println(clearenceFormImage);
			    Image img3 = null;
				try {
					String path = clearenceFormImage;
					img3 =Image.getInstance(path);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				img3.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img3);
			    }
			    
 document.newPage();
				
				if(application.getTranscriptDocument()!= null) {
					
					PdfContentByte pageContentByte = writer.getDirectContent();
					int currentPdfReaderPage = 1;
					
					    
					byte data1[]=application.getTranscriptDocument();
					//InputStream inputStream = new ByteArrayInputStream(data1);
					
					PdfReader reader = null;
					try {
						reader = new PdfReader(data1);
						PdfImportedPage pdfImportpage;
						
						 while (currentPdfReaderPage <= reader.getNumberOfPages()) {
			                  document.newPage();
			                  pdfImportpage = writer.getImportedPage(reader, currentPdfReaderPage);
			                  pageContentByte.addTemplate(pdfImportpage, 0, 0);
			                  currentPdfReaderPage++;
			            }
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					
				}
				
		        document.newPage();
				
				if(application.getAcademicRankDocument()!= null) {
					PdfContentByte pageContentByte = writer.getDirectContent();
					int currentPdfReaderPage = 1;
					
					    
					byte data1[]=application.getAcademicRankDocument();
					//InputStream inputStream = new ByteArrayInputStream(data1);
					
					PdfReader reader = null;
					try {
						reader = new PdfReader(data1);
						PdfImportedPage pdfImportpage;
						
						 while (currentPdfReaderPage <= reader.getNumberOfPages()) {
			                  document.newPage();
			                  pdfImportpage = writer.getImportedPage(reader, currentPdfReaderPage);
			                  pageContentByte.addTemplate(pdfImportpage, 0, 0);
			                  currentPdfReaderPage++;
			            }
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
	     document.close();
	        
	}
	
	public static ByteArrayInputStream pdfDocument(Application application) {
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        PdfWriter.getInstance(document, out);
	    PdfWriter writer = PdfWriter.getInstance(document, out);
	   
        try {
        	
        	document.open();
        	Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
   	     font.setSize(14);
   	     font.setColor(Color.BLACK);
   	     font.setStyle(2);
   	     
   	     Paragraph p = new Paragraph("FACULTY OF ENGINEERING - UNIVERSITY OF PERADENIYA\r\nAPPLICATION FOR TRANSCRIPT/ACADEMIC RANK CERTIFICATE", font);
   	     p.setAlignment(Paragraph.ALIGN_CENTER);
   	     p.setFont(font);
   	     
   	     document.add(p);
   	     
   	     //create application
   	     PdfPTable table = new PdfPTable(2);
   	     table.setWidthPercentage(100f);
   	     table.setWidths(new float[] {5f, 7.5f});
   	     table.setSpacingBefore(10);
   	     
   	  PdfPCell cellStatus = new PdfPCell();
	     cellStatus.setBackgroundColor(Color.WHITE);
	     cellStatus.setPadding(10);
	     cellStatus.setBorderWidth(1);
	     cellStatus.setVerticalAlignment(1);
	     
	     Font cellStatusfont = FontFactory.getFont(FontFactory.HELVETICA);
	     cellStatusfont.setColor(Color.DARK_GRAY);
	    
	     
	     cellStatus.setPhrase(new Phrase("Application Status: ", cellStatusfont));
	     table.addCell(cellStatus);
	     cellStatus.setPhrase(new Phrase(application.getStatusDetails()+"\n "));
	     table.addCell(cellStatus);
	     
	     
	     
	     PdfPCell cell = new PdfPCell();
	     cell.setBackgroundColor(Color.WHITE);
	     cell.setPadding(5);
	     cell.setBorderWidth(0);
	     
	     Font cellfont = FontFactory.getFont(FontFactory.HELVETICA);
	     cellfont.setColor(Color.DARK_GRAY);
	     
	       
	     Font contentfont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	     contentfont.setSize(12);
	     contentfont.setColor(Color.BLACK);

	     cell.setPhrase(new Phrase("", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase("", cellfont));
	     table.addCell(cell);
	     
	     cell.setPhrase(new Phrase("1.\tSurname with initials: ", cellfont));
	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getTitlesPrefixing()+" "+application.getSurnameWithInitials(), contentfont));    
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("2.\tNames denoted by initials: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getNamesDenotedByInitials(), contentfont));    
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("3.\tPostal address: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getPostalAddress(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("4.\tRegistration No: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getRegistrationNo(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\tField: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getField(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("5.\tParticulars of examinations passed: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\tCourse Unit System ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));  
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("\t\ta). General Programme: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getCus_generalProgramme(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tb). Specialization Programme: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getCus_specializationProgramme(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\tOld Regulation Examinations ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\ta) First Examination In Engineering: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getOre_firstExaminEng(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tb) Final Part I Examination: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getOre_finalPart1Exam(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tc) Final Part II Examination: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getOre_finalPart2Exam(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\td) Final Part III Examination: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getOre_finalPart3Exam(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\tPostgraduate Examinations ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));    
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("\t\ta) Name of the Degree/Diploma: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getPge_nameOfdegreeOrDipl(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tb) Year Completed: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getPge_yearCompleted(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("8.\t", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\ta) Request Made for: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getRequestMadefor(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tb) Payment made (Rs.): ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""+application.getPayment(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("9.\t", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\ta) The full address to which the transcript/academic rank \ncertificate should be sent: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getAddressToSendCertificate(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\t\tb) Local or Foreign address: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getLocalOrForieng(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("10.\tNumber of copies: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(""+application.getNumberOfCopies(), contentfont));    
   	     table.addCell(cell);   
   	     cell.setPhrase(new Phrase("\tDate: ", cellfont));
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase(application.getDate(), contentfont));    
   	     table.addCell(cell);
   	     cell.setPhrase(new Phrase("\tCollection Method: ", cellfont));
	     table.addCell(cell);
	     cell.setPhrase(new Phrase(application.getCollectionMethod(), contentfont));    
	     table.addCell(cell);
   	     
   	     cell.setPhrase(new Phrase("\tPayment Receipt: ", cellfont));
	     table.addCell(cell);
	     
	     
	     document.add(table);
	     
	     
	   //Add payment receipts
	     
		    document.add(new Paragraph("Payment Receipts:"));
		    
		  //deposit slip
		    
		    if(application.getPaymentPDFId() != null) {
		    String paymentReceiptImage = application.getPaymentPDFId();
		    //System.out.println(paymentReceiptImage);
		    Image img = null;
			try {
				String path = paymentReceiptImage;
				img = Image.getInstance(path);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

				img.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img);
		    }	 
		    
		  //paying in voucher
		     
		    if(application.getPaymentPDFId2()!= null) {
		    String paymentReceiptImage2 = application.getPaymentPDFId2();
		    //System.out.println(paymentReceiptImage2);
		    Image img2 = null;
			try {
				String path = paymentReceiptImage2;
				img2 = Image.getInstance(path);
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

				img2.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img2);
		    }
	   	     
		     //Add payment receipt
		     
			    document.add(new Paragraph("Clearance Form:"));
			    if(application.getClearenceFormPDFId() != null) {
			    String clearenceFormImage = application.getClearenceFormPDFId();
			    //System.out.println(clearenceFormImage);
			    Image img3 = null;
				try {
					String path = clearenceFormImage;
					img3 =Image.getInstance(path);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				img3.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getWidth()/2);
				document.add(img3);
			    }
			    document.newPage();
				
				if(application.getTranscriptDocument()!= null) {
					
					PdfContentByte pageContentByte = writer.getDirectContent();
					int currentPdfReaderPage = 1;
					
					    
					byte data1[]=application.getTranscriptDocument();
					//InputStream inputStream = new ByteArrayInputStream(data1);
					
					PdfReader reader = null;
					try {
						reader = new PdfReader(data1);
						PdfImportedPage pdfImportpage;
						
						 while (currentPdfReaderPage <= reader.getNumberOfPages()) {
			                  document.newPage();
			                  pdfImportpage = writer.getImportedPage(reader, currentPdfReaderPage);
			                  pageContentByte.addTemplate(pdfImportpage, 0, 0);
			                  currentPdfReaderPage++;
			            }
					} catch (IOException e) {
						e.printStackTrace();
					}
					 
					
				}
				
		        document.newPage();
				
				if(application.getAcademicRankDocument()!= null) {
					PdfContentByte pageContentByte = writer.getDirectContent();
					int currentPdfReaderPage = 1;
					
					//System.out.println(application.getAcademicRankDocument().toString()); 
					byte data1[]=application.getAcademicRankDocument();
					//System.out.print(data1.toString());
					//InputStream inputStream = new ByteArrayInputStream(data1);
					
					PdfReader reader = null;
					try {
						reader = new PdfReader(data1); 
						PdfImportedPage pdfImportpage;
						
						 while (currentPdfReaderPage <= reader.getNumberOfPages()) {
			                  document.newPage();
			                  pdfImportpage = writer.getImportedPage(reader, currentPdfReaderPage);
			                  pageContentByte.addTemplate(pdfImportpage, 0, 0);
			                  currentPdfReaderPage++;
			            }
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
   	     document.close();
        	
        	
        }catch (DocumentException ex) {

                System.out.println(ex.getMessage());
            }

            return new ByteArrayInputStream(out.toByteArray());
            
        }
        
        
	
}
