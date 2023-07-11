package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FletchDataFromDB {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
		 conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stmt = conn.createStatement();
			String querry="select * from project";
			ResultSet result = stmt.executeQuery(querry);
			while(result.next()) {
				String value = result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getInt(6);
		System.out.println(value);
			}
			
		} finally {
			conn.close();
		}
		
	}

}
