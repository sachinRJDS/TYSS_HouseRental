package com.houserental.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.houserental.practice.FileUtility1;

public class ExcelUtility1 {
	FileUtility1 flib=new FileUtility1();
	/**
	 * used to get the data from the excel file based on row and column
	 * @param path
	 * @param sheetName
	 * @param row
	 * @param column
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromTheExcel(String path,String sheetName,int row,int column) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		String value = sheet.getRow(row).getCell(column).toString();
		return value;
	}
	/**
	 * used to get the last row number of the sheet
	 * @param path
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNumber(String path,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;
	}
	/**
	 * used to get the data from the excel file based on the testID 
	 * @param path
	 * @param sheetName
	 * @param testID
	 * @param colName
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelDataBasedOnTestID(String path,String sheetName,String testID,String colName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int rowCount=0;
		for(int i=0;i<=lastRow;i++) {
			String value = sheet.getRow(i).getCell(0).toString();
			if(value.equalsIgnoreCase(testID)) {
				break;
			}
			rowCount++;			
		}
		int colCount=0;
		int lastCellNum = sheet.getRow(rowCount-1).getLastCellNum();
		for(int i=0;i<lastCellNum;i++) {
			String value = sheet.getRow(rowCount-1).getCell(i).toString();
			if(value.equalsIgnoreCase(colName)) {
				break;
			}
			colCount++;
		}
		String data = sheet.getRow(rowCount).getCell(colCount).toString();
		wb.close();
		return data;
		
	}

}
