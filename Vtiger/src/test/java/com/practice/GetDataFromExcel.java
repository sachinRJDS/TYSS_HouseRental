package com.practice;

import java.io.IOException;

import com.houserental.genericutility.ExcelUtility;

public class GetDataFromExcel {
	public static void main(String[] args) throws IOException {
		ExcelUtility ex=new ExcelUtility();
		String path = ex.getPathOfExcel("registerexcelpath");
		 String excelData = ex.getExcelDataBasedOnTestID(path, "Sheet1","tc_07", "Mobile_No");
		 System.out.println(excelData);
	}

}
