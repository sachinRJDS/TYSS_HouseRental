package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertToDB {
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		
		Statement statement = connection.createStatement();
		String querry="insert into project value('TYSS_PROJECT_771','Sachin raj','30/06/2023','TYSS','Complete',5)";
		
		int result = statement.executeUpdate(querry);
		
		if(result==1) {
			System.out.println("created");
		}else {
			System.out.println("not created");
		}
		
	} finally {
		connection.close();
	}
		
	}

}
