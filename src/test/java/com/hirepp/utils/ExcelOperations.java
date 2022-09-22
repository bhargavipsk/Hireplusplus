package com.hirepp.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelOperations {
	public AddJD jdInputsExcel(String ExcelPath,int SheetNumber,int jdno) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(ExcelPath);
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet= workbook.getSheetAt(SheetNumber);
        Row row=sheet.getRow(jdno);
        AddJD data=new AddJD();
        data.clientName=row.getCell(1).toString();
        data.HiringManager=row.getCell(2).toString();
        data.location=row.getCell(3).toString();
        data.numberOfOpenings=row.getCell(4).toString();
        data.jdName=row.getCell(5).toString();
        data.preferredDomain=row.getCell(6).toString();
        data.functionalArea=row.getCell(7).toString();
        data.minSalaryBudget=row.getCell(8).toString();
        data.maxSalaryBudget=row.getCell(9).toString();
        return data;
    }

}
