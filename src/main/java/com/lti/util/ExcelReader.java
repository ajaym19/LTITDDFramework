package com.lti.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	/*
	 * Excel Read Apache POI
	 * 
	 */
	
	public Object[][] getUserData() {
		String filePath = "./src/test/java/testng/TestData.xlsx";
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet("logindata");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Row Count is ==> "+rowCount);
		System.out.println("Col Count is ==> "+colCount);
		
//		System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
//		System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(2).getCell(1).getStringCellValue());
//		System.out.println(sheet.getRow(3).getCell(0).getStringCellValue());
//		System.out.println(sheet.getRow(3).getCell(1).getStringCellValue());
		
		Object[][] data = new Object[rowCount][colCount];
		
		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				data[row][col] = sheet.getRow(row).getCell(col).getStringCellValue();
			}
		}
		
		return data;
	}
	
}
