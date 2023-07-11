package homerental_register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;





public class InsertDataIntoDB {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			/*register / load the mysql*/
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			/*get conncet to database*/
		    conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement stmt = conn.createStatement();
			String querry="insert into project value('TY_PROJ_111','sachin','30/06/2023','TYSS','Completed','4')";
			int result=stmt.executeUpdate(querry);
			
			
			/*execute statement /querry*/
			if(result==1) {
				System.out.println("data is created ");
			}else {
				System.out.println("data is not created");
			}
			
		} finally {
			/*close the connection*/
			conn.close();
		}
		
		
	}

}
