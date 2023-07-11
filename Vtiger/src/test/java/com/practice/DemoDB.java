package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.houserental.practice.DataBaseUtility1;
import com.houserental.practice.FileUtility1;
import com.mysql.cj.jdbc.Driver;


public class DemoDB {
	public static void main(String[] args) throws SQLException, IOException {
		FileUtility1 fLib=new FileUtility1();
		DataBaseUtility1 dLib=new DataBaseUtility1();
		
		
			String path = fLib.getPathOfTheFile("databasepath");
			String url = fLib.getDataFromeThePropertyFile(path, "url");
			String username = fLib.getDataFromeThePropertyFile(path, "username");
			String password = fLib.getDataFromeThePropertyFile(path, "password");
			
			dLib.getDBConnection();
			String querry="insert into project value('PROJECT_TYSS_090','SHBZ','02/07/2023','TYSS','COMPLETED','4')";
			dLib.updateTheQuerry(querry);
			dLib.closeTheConnection();
			
			
	
	}

}
