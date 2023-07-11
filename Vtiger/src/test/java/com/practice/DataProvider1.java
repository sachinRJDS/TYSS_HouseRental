package com.practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;

public class DataProvider1 {
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	@Test(dataProvider = "object")
	public void test(String a,String b,String c,String d) {
		System.out.println(a+":"+b+":"+c+":"+":"+d);
	}
	
	
	
	@DataProvider
	public Object[][] object() throws IOException{
		String path = fLib.getPropertyFilePath("registerexcelpath");
		Object[][]obj=new Object[2][4];
		
		for(int j=0;j<obj.length;j++) {
		
		for(int i=0;i<4;i++) {
			obj[j][i]=eLib.getExcelDataBasedOnRowAndCol(path, "Sheet1", i, i);
		}
		
	}
		return obj;
	}
	
}
