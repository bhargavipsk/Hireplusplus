package com.hirepp.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelOperations {
	public AddJD jdInputsExcel(String ExcelPath,int SheetNumber) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(ExcelPath)
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet= workbook.getSheetAt(SheetNumber);
        
    }

}
