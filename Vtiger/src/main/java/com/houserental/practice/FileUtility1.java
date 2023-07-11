package com.houserental.practice;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility1 {
	/**
	 * used to get the required path of the file like property,excel and json file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	 public String getPathOfTheFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream("./src/test/resources/data/filepath.property");
		 Properties p=new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
		 return value;
		 
	 }
	 /**
	  * used to get the data from the property file
	  * @param path
	  * @param key
	  * @return
	  * @throws IOException
	  */
	 public String getDataFromeThePropertyFile(String path,String key) throws IOException {
		 FileInputStream fis=new FileInputStream(path);
		 Properties p=new Properties();
		 p.load(fis);
		 String value = p.getProperty(key);
		 return value;
		 
	 }

}
