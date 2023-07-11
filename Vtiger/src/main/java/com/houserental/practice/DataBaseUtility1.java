package com.houserental.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility1 {
	FileUtility1 fLib=new FileUtility1();
	String url;
	String username;
	String password;
	Driver driver;
	Connection connection;
	ResultSet executeQuery;

	public DataBaseUtility1() throws IOException {
		String path = fLib.getPathOfTheFile("databasepath");
		url = fLib.getDataFromeThePropertyFile(path, "url");
		username = fLib.getDataFromeThePropertyFile(path, "username");
		password = fLib.getDataFromeThePropertyFile(path, "password");
	}
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	public void getDBConnection() throws SQLException {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(url,username,password);
	}
	/**
	 * used to write the uqerry into the database
	 * @param uqerry
	 * @return 
	 * @throws SQLException
	 */
	public int updateTheQuerry(String uqerry) throws SQLException {
		Statement stmt = connection.createStatement();
		int executeUpdate = stmt.executeUpdate(uqerry);
		System.out.println("created");
		return executeUpdate;
		
	}
	/**
	 * This method will execute the querry
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet excecuteQuerry(String querry) throws SQLException {
		Statement stmt = connection.createStatement();
		 executeQuery = stmt.executeQuery(querry);
		return executeQuery;
	}
	/**
	 * used to close the database connection
	 * @throws SQLException
	 */
	public void closeTheConnection() throws SQLException {
		connection.close();
	}
}
