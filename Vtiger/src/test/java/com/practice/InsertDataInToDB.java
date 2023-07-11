package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataInToDB {
	public static void main(String[] args) throws SQLException {
		Connection conn =null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			 conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stmt = conn.createStatement();
			String querry="insert into project value('TY_PROJ_122','GURU','30/06/2023','TYSS','Process','7')";
			int update = stmt.executeUpdate(querry);
			if(update==1) {
				System.out.println("created");
			}else {
				System.out.println("not created");
			}
		} finally {
			conn.close();
		}
	}

}
