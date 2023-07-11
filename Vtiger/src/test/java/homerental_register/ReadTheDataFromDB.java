package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadTheDataFromDB {
	public static void main(String[] args) throws SQLException {
		Connection connection =null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stmt = connection.createStatement();
			String querry="select * from project";
			ResultSet result = stmt.executeQuery(querry);
			while(result.next()) {
				
				String value = result.getString(1)+" "+result.getString(2)+" "+result.getInt(6);
				System.out.println(value);
			}
		} finally {
			connection.close();
		}
		
	}

}
