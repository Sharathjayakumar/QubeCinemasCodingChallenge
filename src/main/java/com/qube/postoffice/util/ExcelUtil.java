package com.qube.postoffice.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	
public static Object[][] getTestData(int sheetindex) throws Throwable {
		
		Object[][] data;
		FileInputStream file = new FileInputStream("/Users/sds-sarath.kj/Documents/eclipse-workspace/QubeCodingChallengeSJ/"
				+ "src/main/java/com/qube/postoffice/testdata/TestDataSheet.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		int lastRowNum = sheet.getLastRowNum();
		
		data = new Object[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<=lastRowNum;i++) {
			int lastCellNum = sheet.getRow(i).getLastCellNum();
			for (int j=0;j<lastCellNum;j++) {
				int cellType = sheet.getRow(i).getCell(j).getCellType();
				if(cellType==0) {
					double b = sheet.getRow(i).getCell(j).getNumericCellValue();
					String s = b+"";
					int indexOfDot = s.indexOf(".");
					data[i][j] = s.substring(0, indexOfDot);
				}
				else if(cellType==1) {
					sheet.getRow(i).getCell(j).getStringCellValue();
					data[i][j] =sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}	
		}
		return data;
	}

}
