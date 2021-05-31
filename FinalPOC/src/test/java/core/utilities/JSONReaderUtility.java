package core.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONReaderUtility 
{
	
	public JSONArray readJSONWithName(String fileName) throws IOException, ParseException
	{
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/JSONs/" + fileName;

		File srcFile = new File(filePath); 
		// Parsing Json file to array
		JSONParser parser = new JSONParser(); 
		JSONArray jsonArray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		return jsonArray;
	}
}