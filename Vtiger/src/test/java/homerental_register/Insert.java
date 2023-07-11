package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Insert {
	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
	try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		String s="insert into project value('TY_PROJ_777','Raj','31/06/2023','TYSS','Completed','5')";
		
		int update = statement.executeUpdate(s);
		if(update==1) {
			System.out.println("data is cretaed");
		}else {
			System.out.println("data is not created");
		}
	} finally {
		connection.close();
	}
	}

}
