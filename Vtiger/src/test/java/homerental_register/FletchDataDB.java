package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FletchDataDB {
	public static void main(String[] args) throws SQLException {
		String s="TYSS_PROJECT_771";
		Connection connection=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement = connection.createStatement();
			String querry="select * from project";
			ResultSet result = statement.executeQuery(querry);
			boolean verify=false;
			while(result.next()) {
				String value = result.getString(1);
				if(value.equalsIgnoreCase(s)) {
					System.out.println("project is present in database");
					verify=true;
					break;					
				}
			
			}
			if(!verify) {
				System.out.println("project is not present in database");
			}
		} finally {
			connection.close();
		}
		
		
	}

}
