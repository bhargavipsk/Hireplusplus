package com.hirepp.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelOperations {

	/**
	 * Returns the worksheet from the Excel document
	 *
	 * @author rakesh
	 * @param ExcelPath     is the Text which specifies the path of the Excel document
	 * @param sheetName 	is the test that specifies the title of the sheet in the Excel
	 * @throws IOException
	 * @return returns excel data from sheet as Sheet
	 *
	 */
	public Sheet ExcelData(String ExcelPath, String sheetName) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(ExcelPath);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		return workbook.getSheet(sheetName);
	}


	/**
	 * Writes the data in Excel
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param workbook		is the workbook that has the data to be stored in Excel
	 * @throws IOException
	 * @return no return value
	 *
	 */
	public void WritingExcel(String excelPath,Workbook workbook) throws IOException {
		FileOutputStream  fileOutputStream=new FileOutputStream(excelPath);
		workbook.write(fileOutputStream);
	}

	/**
	 * Stores the data in respective variables for adding jd and return the object
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param sheetName 	is the text that specifies the title of the sheet in the Excel
	 * @param jdno			is the number that specifies the row in the worksheet
	 * @throws IOException
	 * @return returns object of AddJD with data to create the jd
	 *
	 */
	public AddJD jdInputsExcel(String excelPath, String sheetName, int jdno) throws IOException {
		Sheet sheet = ExcelData(excelPath, sheetName);
		Row row = sheet.getRow(jdno);
		AddJD data = new AddJD();
		data.clientName = row.getCell(1).toString();
		data.HiringManager = row.getCell(2).toString();
		data.location = row.getCell(3).toString();
		data.numberOfOpenings = (int) row.getCell(4).getNumericCellValue();
		data.jdName = row.getCell(5).toString();
		data.preferredDomain = row.getCell(6).toString();
		data.functionalArea = row.getCell(7).toString();
		data.minSalaryBudget = (long) row.getCell(8).getNumericCellValue();
		data.maxSalaryBudget = (long) row.getCell(9).getNumericCellValue();
		List<Object> skill_weightage = null;
		skill_weightage= skillEntry(excelPath, 1);
		data.skills= (List<String>) skill_weightage.get(0);
		data.weightage= (int[]) skill_weightage.get(1);
		return data;
	}

	/**
	 * Stores the data in respective variables for adding jd and return the object
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param sheetName 	is the text that specifies the title of the sheet in the Excel
	 * @param jdno			is the number that specifies the row in the worksheet
	 * @throws IOException
	 * @return returns object of AddJD with data to create the jd
	 *
	 */
	public AddJD JdFillForm(String excelPath, String sheetName, int jdno) throws IOException {
		Sheet sheet = ExcelData(excelPath, sheetName);
		Row row = sheet.getRow(jdno);
		AddJD data = new AddJD();
		data.description = row.getCell(10).toString();
		data.requirements = row.getCell(11).toString();
		data.perks = row.getCell(12).toString();
		data.skillsAsText = row.getCell(13).toString();
		data.moreDetails = row.getCell(14).toString();
		return data;

	}

	/**
	 * Stores the data in respective variables for adding skills and weightage of skills and return the object
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param jdno			is the number that specifies the row in the worksheet
	 * @throws IOException
	 * @return returns object of AddJD with data to enter skills and weightage
	 *
	 */
	public List<Object> skillEntry(String excelPath, int jdno) throws IOException {
		List<String> skill = new ArrayList<String>();
		int[] weightage=new int[20];
		Sheet sheet1 = ExcelData(excelPath, "Skills");
		Row row1 = sheet1.getRow(jdno);
		int i = 0;
		Iterator<Cell> cell = row1.iterator();
		Cell cell1;
		while (cell.hasNext()) {
			cell1 = cell.next();
			skill.add(cell1.getStringCellValue());
			cell1 = cell.next();
			weightage[i]= (int) cell1.getNumericCellValue();
			i++;
		}
		List<Object> skill_weightage=new ArrayList<>();
		skill_weightage.add(skill);
		skill_weightage.add(weightage);
		return skill_weightage;
	}

	public AddCandidate candidateExcelRead(String ExcelPath, String sheetName, int row_no) throws IOException {
		Reporter.log("Inside the ExcelOperations Class-candidateExcelRead()",true);

		Reporter.log("Reading the sheet",true);
		Sheet sheet = ExcelData(ExcelPath, sheetName);
		Reporter.log("Getting the rowdata",true);
		Row row = sheet.getRow(row_no);
		Reporter.log("Creating object of AddCandidate",true);
		AddCandidate data = new AddCandidate();
		Reporter.log("Reading  the firstname",true);
		data.first_Name = row.getCell(0).toString();
		Reporter.log("Reading  the lastname",true);

		data.last_Name = row.getCell(1).toString();
		Reporter.log("Reading  the EmailID",true);
		data.email_id = row.getCell(2).toString();
		data.country = row.getCell(9).toString();
		Reporter.log("Reading  the contact Number",true);

		data.contact_no = (long)row.getCell(3).getNumericCellValue();
		Reporter.log("Reading  the notice period",true);

		data.notice_period = row.getCell(4).toString();
		Reporter.log("Reading  the currency ",true);

		data.currency = row.getCell(5).toString();
		Reporter.log("Reading  the company ",true);

		data.current_Company = row.getCell(6).toString();
		Reporter.log("Reading  the currentCTC ",true);

		data.current_CTC = (long) row.getCell(7).getNumericCellValue();
		Reporter.log("Reading  the Expected CTC ",true);

		data.expected_CTC = (long) row.getCell(8).getNumericCellValue();	
		Reporter.log("data value is " +data,true);
		return data;

	}

	/**
	 * Gets the JdId for the particular jd stored in Excel
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param sheetName 	is the text that specifies the title of the sheet in the Excel
	 * @param jdno			is the number that specifies the row in the worksheet
	 * @throws IOException
	 * @return returns String of Jdid
	 *
	 */
	public String getJobId(String excelPath, String sheetName, int jdno) throws IOException {
		Sheet sheet = ExcelData(excelPath, sheetName);
		Row row = sheet.getRow(jdno);
		AddJD data = new AddJD();
		data.jobId=row.getCell(15).toString();
		return data.jobId;
	}


	/**
	 * Stores the JdId in the Excel for that particular jd
	 *
	 * @author rakesh
	 * @param ExcelPath     is the text which specifies the path of the Excel document
	 * @param sheetName 	is the text that specifies the title of the sheet in the Excel
	 * @param jdno			is the number that specifies the row in the worksheet
	 * @throws IOException
	 * @return no return value
	 *
	 */
	public void JdIdStoring(String excelPath,String sheetName, int row_no,String jdId) throws IOException {
		Sheet sheet = ExcelData(excelPath, sheetName);
		Row row = sheet.getRow(row_no);
		row.getCell(15).setCellValue(jdId);
		WritingExcel(excelPath, sheet.getWorkbook());
	}

}
