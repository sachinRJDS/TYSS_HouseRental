package com.houserental.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * used to perfrom Workbook releated operations like read , write , getcount etc
 * @author Deepak
 *
 */


public class ExcelUtility {
	/**
	 * used to get the path of the excel file
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPathOfExcel(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/filepath.property");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	/**
	 * read the data from excel based on testID
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	
	public String getExcelDataBasedOnTestID(String path,String sheetName,String testID,String colName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int rowCount=0;
		String value="";
		for(int i=0;i<=lastRowNum;i++) {
			try {
				 value = sheet.getRow(i).getCell(0).getStringCellValue();
			} catch (Exception e) {
				
			}
			if(value.equalsIgnoreCase(testID)) {
				break;
			}
			rowCount++;
		}
		String cellValue="";
		int cellCount=0;
		int lastCellNum = sheet.getRow(rowCount-1).getLastCellNum();
		for(int i=0;i<lastCellNum;i++) {
			try {
				 cellValue = sheet.getRow(rowCount-1).getCell(i).getStringCellValue();
			} catch (Exception e) {
				
			}
			if(cellValue.equalsIgnoreCase(colName)) {
				break;
			}
			cellCount++;
		}
		String data = sheet.getRow(rowCount).getCell(cellCount).getStringCellValue();
		return data;
		
	}
	/**
	 * read the data from excel based on row and column
	 * @param filePath
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return value
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getExcelDataBasedOnRowAndCol(String path,String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			String value = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
			return value;
			
	}
	/**
	 * used to get the last row number of the excel sheet
	 * @param path
	 * @param sheetName
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNumber(String path,String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int value = wb.getSheet(sheetName).getLastRowNum();
		return value;
		
	}
	
	/**
	 * used to get the last cell number of the excel sheet
	 * @param path
	 * @param sheetName
	 * @param row
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastCellNumber(String path,String sheetName,int row) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		short lastCellNum = wb.getSheet(sheetName).getRow(row).getLastCellNum();
		return lastCellNum;
	}

}
