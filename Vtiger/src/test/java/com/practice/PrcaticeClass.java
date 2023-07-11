package com.practice;

import java.io.IOException;

import com.houserental.genericutility.FileUtility;
import com.houserental.practice.FileUtility1;

public class PrcaticeClass {
	public static void main(String[] args) throws IOException {
		FileUtility1 flib=new FileUtility1();
		String path = flib.getPathOfTheFile("userpropertypath");
		String url = flib.getDataFromeThePropertyFile(path, "url");
		String username = flib.getDataFromeThePropertyFile(path, "username");
		String password = flib.getDataFromeThePropertyFile(path, "password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
