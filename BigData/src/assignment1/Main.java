package assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> keyValuePair = new TreeMap<String, Integer>();	
		String content = new String(Files.readAllBytes(Paths.get("D:\\TextInput\\testDataForW1D1.txt")));
		
		String[] result = content.split("[-\\s]");
		for(String s : result)
		{
			if(s.matches("[a-zA-Z]+"))
			{
				keyValuePair.put(s.toLowerCase(), 1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : keyValuePair.entrySet()) {
		    String key = entry.getKey();
		    Integer value = entry.getValue();
			System.out.println("(" + key + "," + value + ")");
		}
	}
}