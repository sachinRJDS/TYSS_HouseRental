package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.houserental.genericutility.JavaUtility;
import com.houserental.practice.DataBaseUtility1;
import com.houserental.practice.ExcelUtility1;
import com.houserental.practice.FileUtility1;
import com.houserental.practice.JavaUtility1;
import com.mysql.jdbc.Driver;

public class GeExcelData {
	public static void main(String[] args) throws IOException, SQLException {
		 FileUtility1 f=new FileUtility1();
		 ExcelUtility1 e=new ExcelUtility1();
		 String path = f.getPathOfTheFile("registerexcelpath");
		 String data = e.getExcelDataBasedOnTestID(path, "Sheet1", "tc_02", "Mobile_No");
		 System.out.println(data);
		 
		 
		 JavaUtility1 j=new JavaUtility1();
		 int num1 = j.getRandomNumber();
		 System.out.println(num1);
		 long num2 = j.getRandomPhoneNumber();
		 System.out.println(num2);
		 String date = j.getDate();
		 System.out.println(date);
		 String date2 = j.getDate(10);
		 System.out.println(date2);
		 
		 DataBaseUtility1 d=new DataBaseUtility1();
		 FileUtility1 fLib=new FileUtility1();
		 String path1 = fLib.getPathOfTheFile("databasepath");
		 String username = fLib.getDataFromeThePropertyFile(path1, "username");
		 String url = fLib.getDataFromeThePropertyFile(path1, "url");
		 String password = fLib.getDataFromeThePropertyFile(path1, "password");
		 System.out.println(url+username+password);
		 System.out.println(username);
		 System.out.println(password);
		String pass = url+username+password;
		 
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 Connection connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		 
		 d.updateTheQuerry("insert into project value('PROJ_TYSS_143','Santhu','30/06/2023','vtiger','on going','6')");
		 d.excecuteQuerry("select * from project");
		 
	}

}
