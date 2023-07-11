package homerental_register;

import java.io.IOException;

import com.houserental.genericutility.FileUtility;

public class FetchDataFromGenericLib {
	public static void main(String[] args) throws IOException {
		FileUtility f=new FileUtility();
		String path=f.getPropertyFilePath("userpropertypath");
		String url = f.getPropertyData(path, "url");
		String username = f.getPropertyData(path, "username");
		String password = f.getPropertyData(path, "password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
		
		String path1 = f.getPropertyFilePath("adminpropertypath");
		String un = f.getPropertyData(path1, "username");
		String pw=f.getPropertyData(path1, "password");
		System.out.println(un);
		System.out.println(pw);
		
		
		
	}

}
