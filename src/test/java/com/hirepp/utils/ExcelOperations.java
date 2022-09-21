package com.hirepp.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelOperations {
	public AddJD jdInputsExcel(String ExcelPath,int SheetNumber) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(ExcelPath);
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet= workbook.getSheetAt(SheetNumber);
        AddJD data=new AddJD();
        data.clientName=sheet.getRow(1).getCell(1).toString();
        data.HiringManager=sheet.getRow(2).getCell(1).toString();
        data.location=sheet.getRow(3).getCell(1).toString();
        data.numberOfOpenings=sheet.getRow(4).getCell(1).toString();
        data.jdName=sheet.getRow(5).getCell(1).toString();
        data.preferredDomain=sheet.getRow(6).getCell(1).toString();
        data.functionalArea=sheet.getRow(7).getCell(1).toString();
        data.minSalaryBudget=sheet.getRow(8).getCell(1).toString();
        data.maxSalaryBudget=sheet.getRow(9).getCell(1).toString();
        return data;
    }

}
