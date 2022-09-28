package com.hirepp.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ExcelOperations {

        public Sheet ExcelData(String ExcelPath,String sheetName) throws IOException {
                FileInputStream fileInputStream=new FileInputStream(ExcelPath);
                Workbook workbook=new XSSFWorkbook(fileInputStream);
                return workbook.getSheet(sheetName);
        }

	public AddJD jdInputsExcel(String ExcelPath,String sheetName,int jdno) throws IOException {
            Sheet sheet = ExcelData(ExcelPath, sheetName);
        Row row=sheet.getRow(jdno);
        AddJD data=new AddJD();
        data.clientName=row.getCell(1).toString();
        data.HiringManager=row.getCell(2).toString();
        data.location=row.getCell(3).toString();
        data.numberOfOpenings=row.getCell(4).getNumericCellValue();
        data.jdName=row.getCell(5).toString();
        data.preferredDomain=row.getCell(6).toString();
        data.functionalArea=row.getCell(7).toString();
        data.minSalaryBudget=row.getCell(8).getNumericCellValue();
        data.maxSalaryBudget=row.getCell(9).getNumericCellValue();

        return data;
    }

    public AddJD JdFillForm(String excelPath,String sheetName, int jdno) throws IOException {
            Sheet sheet = ExcelData(excelPath, sheetName);
            Row row=sheet.getRow(jdno);
            AddJD data=new AddJD();
        data.description=row.getCell(10).toString();
        data.requirements=row.getCell(11).toString();
        data.perks=row.getCell(12).toString();
        data.skillsAsText=row.getCell(13).toString();
        data.moreDetails=row.getCell(14).toString();
        data.skills=skillEntry(excelPath,1);
        return data;


    }

    public List<String> skillEntry(String excelPath, int jdno) throws IOException {
        List<String> skill = null;
        Sheet sheet1 = ExcelData(excelPath, "Skills");
        Row row1=sheet1.getRow(jdno);
        int i=0;
        Iterator<Cell> cell = row1.iterator();
        Cell cell1;
        while (cell.hasNext()){
            cell1=cell.next();
            skill.add(cell1.getStringCellValue());
            i++;
        }
        return skill;
    }

}
