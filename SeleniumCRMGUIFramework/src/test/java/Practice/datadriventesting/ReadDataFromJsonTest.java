   package Practice.datadriventesting;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable, IOException, ParseException {
		//parse JSON physical file into javaObject using JSONparser class
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\LENOVO\\Desktop\\AppCommonData.json"));
		
		//convert java object into JSON object using downCasting
		
		JSONObject map= (JSONObject)obj;
		
		//get the value from JSON FILE
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
	}

}
 