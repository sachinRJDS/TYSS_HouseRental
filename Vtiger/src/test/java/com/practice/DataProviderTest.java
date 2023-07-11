package com.practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;

public class DataProviderTest {
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	
	@Test(dataProvider = "object")
	public void test(String testCaseId,String fullname,String mobile,String email,String houseNo,String available,String country,String state,String city,String rent,String deposit,String address ) {
		System.out.println(testCaseId+" : "+fullname+" : "+mobile);
		System.out.println(email+" : "+houseNo+" : "+available);
		System.out.println(country+" : "+state+" : "+city);
		System.out.println(rent+" : "+deposit+" : "+address);
	}
	@DataProvider
	public Object[][] object() throws IOException{
		String path = fLib.getPropertyFilePath("registerexcelpath");
		
		int lastRowNumber = eLib.getLastRowNumber(path, "Sheet1");
		int lastCellNumber = eLib.getLastCellNumber(path, "Sheet1", 1);
		 
		Object[][]obj=new Object[1][lastCellNumber];
		for(int i=0;i<lastCellNumber;i++) {
			obj[0][i]=eLib.getExcelDataBasedOnRowAndCol(path, "Sheet1", 1, i);
		}
		return obj;
	
	}

}
