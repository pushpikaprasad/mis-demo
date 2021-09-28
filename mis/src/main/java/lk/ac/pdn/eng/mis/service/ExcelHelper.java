
package lk.ac.pdn.eng.mis.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lk.ac.pdn.eng.mis.entity.Employee;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Emp. No","Title","Name","Names of Initials","NIC","Designation","Present Division 1","Telephone","Type","Email","Mobile Number","Address"};
	static String SHEET = "Employees";

	public static List<Employee> excelToEmployees(InputStream inputStream) {
		try {
			Workbook workbook = new XSSFWorkbook(inputStream);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<Employee> employees = new ArrayList<Employee>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();
				
				Employee employee = new Employee();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					String cellValue;
					////System.out.print(currentCell.getCellType().toString());
					
					switch (cellIdx) {
					case 0:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setEmployeeNumber"+cellValue);
						employee.setEmployeeNumber(cellValue);
						break;
					case 1:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setTitle"+cellValue);
						employee.setTitle(cellValue);
						break;
					case 2:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setSurnameWithInitials"+cellValue);
						employee.setSurnameWithInitials(cellValue);
						break;
					case 3:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println(currentCell.getStringCellValue());
						//System.out.println("setNamesDenotedByInitials"+cellValue);
						employee.setNamesDenotedByInitials(cellValue);
						break;
					case 4:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setNic"+cellValue);
						employee.setNic(cellValue);
						break;
					case 5:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setDesignation"+cellValue);
						employee.setDesignation(cellValue);
						break;
					case 6:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setPresentDivision1"+cellValue);
						employee.setPresentDivision1(cellValue);
						break;
					case 7:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setTelephone"+cellValue);
						employee.setTelephone(cellValue);
						break;
					case 8:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setType"+cellValue);
						employee.setType(cellValue);
						break;
					case 9:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setEmail"+cellValue);
						employee.setEmail(cellValue);
						break;
					case 10:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setMobileNumber"+cellValue);
						employee.setMobileNumber(cellValue);
						break;
					case 11:
						if(currentCell.getStringCellValue().equals("")) {
							cellValue = null;
						}else {
							cellValue= currentCell.getStringCellValue();
						}
						//System.out.println("setAddress"+cellValue);
						employee.setAddress(cellValue);
						break;
					default:
						break;
					}

					cellIdx++;
				}

				employees.add(employee);
			}

			workbook.close();

			return employees;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public static ByteArrayInputStream employeesToExcel(List<Employee> employees) {
		
		try (
				Workbook workbook = new XSSFWorkbook(); 
				ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		        Sheet sheet = workbook.createSheet(SHEET);

		      // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < HEADERs.length; col++) {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(HEADERs[col]);
		      }

		      int rowIdx = 1;
		      for (Employee emp : employees) {
		        Row row = sheet.createRow(rowIdx++);

		        if(emp.getEmployeeNumber() != null) {
		        	row.createCell(0).setCellValue(emp.getEmployeeNumber());
		        }else {
		        	row.createCell(0).setCellValue("");
		        }
		        if(emp.getTitle() != null) {
		        	row.createCell(1).setCellValue(emp.getTitle());
		        }else {
		        	row.createCell(1).setCellValue("");
		        }
		        
		        if(emp.getSurnameWithInitials() != null) {
		        	row.createCell(2).setCellValue(emp.getSurnameWithInitials());
		        }else {
		        	row.createCell(2).setCellValue("");
		        }
		        
		        if(emp.getNamesDenotedByInitials() != null) {
		        	row.createCell(3).setCellValue(emp.getNamesDenotedByInitials());
		        }else {
		        	row.createCell(3).setCellValue("");
		        }
		        
		        if(emp.getNic() != null) {
		        	row.createCell(4).setCellValue(emp.getNic());
		        }else {
		        	row.createCell(4).setCellValue("");
		        }
		        
		       
		        if(emp.getDesignation() != null) {
		        	 row.createCell(5).setCellValue(emp.getDesignation());
		        }else {
		        	 row.createCell(5).setCellValue("");
		        }
		        
		       
		        if(emp.getPresentDivision1() != null) {
		        	 row.createCell(6).setCellValue(emp.getPresentDivision1());
		        }else {
		        	 row.createCell(6).setCellValue("");
		        }
		       
		        if(emp.getTelephone() != null) {
		        	row.createCell(7).setCellValue(emp.getTelephone());
		        }else {
		        	row.createCell(7).setCellValue("");
		        }
		        
		        
		        if(emp.getType() != null) {
		        	 row.createCell(8).setCellValue(emp.getType());
		        }else {
		        	 row.createCell(8).setCellValue("");
		        }
		       
		        
		        if(emp.getEmail() != null) {
		        	row.createCell(9).setCellValue(emp.getEmail());
		        }else {
		        	row.createCell(9).setCellValue("");
		        }
		        
		        
		        if(emp.getMobileNumber() != null) {
		        	row.createCell(10).setCellValue(emp.getMobileNumber());
		        }else {
		        	row.createCell(10).setCellValue("");
		        }
		        
		        
		        if(emp.getAddress() != null) {
		        	row.createCell(11).setCellValue(emp.getAddress());
		        }else {
		        	row.createCell(11).setCellValue("");
		        }
		        
		      }

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
	}

}
