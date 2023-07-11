package homerental_register;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;

public class FletchJsonData {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
	JSONParser j=new JSONParser();
	Object parse = j.parse(new FileReader("./src/test/resources/data/jsondata.json"));
	
	JSONObject o=(JSONObject) parse;
	
	
	
	
	System.out.println(o.get("url"));
	System.out.println(o.get("username"));
	System.out.println(o.get("password"));
	}

}
