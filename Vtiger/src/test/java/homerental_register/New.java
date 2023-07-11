package homerental_register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

public class New {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, SQLException {
	String name="TY_PROJ_111";
	Connection conn = null;
	try {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
	 conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement stmt = conn.createStatement();
		String querry="select * from project";
		ResultSet result = stmt.executeQuery(querry);
		boolean flag=false;
		while(result.next()) {
			String value = result.getString(1);
			if(value.equalsIgnoreCase(name)) {
				System.out.println("project is created");
				flag=true;
				break;
				
			}
		
		
		}
		if(!flag) {
			System.out.println("project is not created");
		}
		
	} finally {
		conn.close();
	}
	
	}

}
