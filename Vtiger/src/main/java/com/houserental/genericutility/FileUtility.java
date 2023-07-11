package com.houserental.genericutility;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;



/**
 *  used to read data from external files like text , proprties
 * @author Sachin
 *
 */
public class FileUtility {
	/**
	 * used to get the filepaths from the  /config/filepath.properties  FILE
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	
	public String getPropertyFilePath(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/data/filepath.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/**
	 * used to get the key : value from the any properties based on file Path parsmeter 
	 * @param filePath
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getPropertyData(String path,String key) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
