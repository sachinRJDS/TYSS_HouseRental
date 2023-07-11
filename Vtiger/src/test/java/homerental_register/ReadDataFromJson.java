package homerental_register;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JSONParser j=new JSONParser();
		Object parse = j.parse(new FileReader("./src/test/resources/data/jsondata.json"));
		
		JSONObject obj=(JSONObject) parse;
		System.out.println(obj.get("username"));
		
		
	}

}
