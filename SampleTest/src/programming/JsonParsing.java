package programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonParsing {
	
	public static void readDataFromJson(){
		JSONParser parser = new JSONParser();
		
		try {
			Object object = parser.parse(new FileReader(new File("data.json")));
			
			JSONObject jObj = (JSONObject) object;
			//String status_code = (String) jObj.get("statusCode");
			//System.out.println(status_code);
			
			//String msg = (String) jObj.get("message");
			//System.out.println(msg);
			
			JSONObject resp = (JSONObject) jObj.get("response");
			//System.out.println(resp);
			
			JSONArray holi = (JSONArray) resp.get("holidays");
			//System.out.println(holi instanceof JSONArray);
			for (int i = 0; i < holi.size(); i++){
				JSONObject jsonObj = (JSONObject) holi.get(i);
				//System.out.println(jsonObj.size());
				System.out.println("Holiday_ID..> "+jsonObj.get("holidayId")+" Years ..> "+jsonObj.get("year")+" Dates ..> "+jsonObj.get("date")+" Days..> "+jsonObj.get("day")+" Occasion..> "+jsonObj.get("occasion"));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static void main(String...args){
		readDataFromJson();
	}
}
