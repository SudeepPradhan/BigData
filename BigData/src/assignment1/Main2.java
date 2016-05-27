package assignment1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

	public static void main(String[] args) throws IOException {
		List<KeyValuePair> keyValuePairList = new ArrayList<KeyValuePair>();
		String content = new String(Files.readAllBytes(Paths.get("D:\\TextInput\\testDataForW1D1.txt")));
		
		String[] result = content.split("[-\\s]");
		for(String s : result)
		{
			if(s.matches("[a-zA-Z]+"))
			{
				KeyValuePair kvp = new KeyValuePair(s.toLowerCase(), 1);
				if(!keyValuePairList.contains(kvp))
				{
					keyValuePairList.add(kvp);
				}
			}
		}
		
		Collections.sort(keyValuePairList, (a, b) -> a.Key.compareToIgnoreCase(b.Key));
		
		for (KeyValuePair kvp : keyValuePairList) {
			System.out.println("(" + kvp.Key + "," + kvp.Value + ")");
		}
	}
}