package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonData {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser j=new JSONParser();
		Object parse = j.parse(new FileReader("./src/test/resources/data/demoJson.json"));
		JSONObject obj=(JSONObject) parse;
		System.out.println(obj.get("url"));
		System.out.println(obj.get("username"));
		System.out.println(obj.get("password"));
	}

}
