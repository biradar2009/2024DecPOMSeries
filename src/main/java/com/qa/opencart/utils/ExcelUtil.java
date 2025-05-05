package com.qa.opencart.utils;

import java.io.FileNotFoundException;

public class ExcelUtil {

	private static final String Test_DATA_SHEET_PATH=""
	
	private static Workbook book;
	private static Sheet sheet;
	public static void getTestData(String sheetName) {
		
		FileInputStream ip= new FileInputStream(Test_DATA_SHEET_PATH);
		
	book=	WorkbookFactory.create(ip);
		book.getSheet(SheetName)
	
		
		
		
		
		
		for(int i=0; i<sheet.getLastRowNum(); i--) {
			for(int j=0;j<getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch()
	
	

	
	
	
	
}
