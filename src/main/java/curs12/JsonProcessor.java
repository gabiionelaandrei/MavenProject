package curs12;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JsonProcessor{	

	@SuppressWarnings("unchecked")
	public void writeJson() {
		JSONObject obj =  new JSONObject();
		obj.put("name", "Test");
		obj.put("email", "email@test.com");
		
		
		try(FileWriter file = new FileWriter("test.json")){
			file.write(obj.toJSONString());
		}catch(IOException e) {
			
		}
	}

	
}
