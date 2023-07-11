package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.houserental.practice.FileUtility1;
import com.mysql.jdbc.Driver;


public class WriteDataIntoDB {
	
	public static void main(String[] args) throws SQLException, IOException {
		Connection connection = null;
		FileUtility1 fLib=new FileUtility1();
		try {
			String path = fLib.getPathOfTheFile("databasepath");
			String url = fLib.getDataFromeThePropertyFile(path,"url");
			String username = fLib.getDataFromeThePropertyFile(path, "username");
			String password = fLib.getDataFromeThePropertyFile(path, "password");
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
		   connection = DriverManager.getConnection(url,username,password);
		   Statement stmt = connection.createStatement();
		   String querry="insert into project value('Project_TYSS_007','Prajwal','03/07/2023','TYSS','Completed','7')";
		   int executeUpdate = stmt.executeUpdate(querry);
		   if(executeUpdate==1) {
			   System.out.println("created");
		   }else {
			   System.out.println("not created");
		   }
		} finally {
		connection.close();
		}
	}

}
