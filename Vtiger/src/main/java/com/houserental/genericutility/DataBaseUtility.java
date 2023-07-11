package com.houserental.genericutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * used to connect to Db & perform DB specific Operations
 * @author Deepak
 *
 */
public class DataBaseUtility {
	Driver driver;
	Connection connection;
	ResultSet result;
	String URL;
    String USERNAME;
    String PASSWORD;
    FileUtility f=new FileUtility();
    
    public DataBaseUtility()  {
    	try {
    	String path = f.getPropertyFilePath("jsondata");
    	 URL = f.getPropertyData(path, "url");
    	USERNAME = f.getPropertyData(path, "username");
    	PASSWORD = f.getPropertyData(path, "password");
    	}catch(Exception e) {}
    	
    }
    
    
    /**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	public void connectDB() throws SQLException {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e) {
			
		}
	}
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
		  connection.close();
		}catch (Exception e) {
		}
	}
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet execyteQuery(String query) throws Throwable {	
			result = connection.createStatement().executeQuery(query);
			return result;		
	}
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int execyteUpdate(String query) throws Throwable {
		
			int result = connection.createStatement().executeUpdate(query);
	
		return result;

	}
	/**
	 * This method will execute querry based on querry and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQuerryAndVerify(String querry,int cloumnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(querry);
		while(result.next()) {
			if(result.getString(cloumnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the data base table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
         
	}




	

}
