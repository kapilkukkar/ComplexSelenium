package Read_Data_From_Json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class UtilJsonClass 
{
	private JsonObject jsonObject;
	public UtilJsonClass(String filePath) throws FileNotFoundException
	{
		FileReader reader= new FileReader(filePath);
		jsonObject = JsonParser.parseReader(reader).getAsJsonObject();		
	}
	public String getValue(String key)
	{
        return jsonObject.get(key).getAsString();
    }
}
