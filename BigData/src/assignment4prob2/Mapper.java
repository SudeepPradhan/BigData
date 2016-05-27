package assignment4prob2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Mapper {
	Path filePath;
	HashMap<Character, CharStatisticPair> charPair = new HashMap<Character, CharStatisticPair>();
	
	Mapper(Path path)
	{
		this.filePath = path;
	}
	
	public HashMap<Character, CharStatisticPair> Map() throws IOException
	{
		String content = new String(Files.readAllBytes(filePath));
		String[] splittedContent = content.split("[-\\s]");
		
		for(String s : splittedContent)
		{
			Character firstChar = Character.toLowerCase(s.charAt(0));
			if(charPair.containsKey(firstChar))
			{
				CharStatisticPair csp = charPair.get(firstChar);
				csp.length = csp.length + s.length();
				csp.count = csp.count + 1;
			}
			else
			{
				charPair.put(firstChar, new CharStatisticPair(s.length(), 1));
			}
		}
		
		System.out.println("-----------Mapper-------------");
		charPair.forEach((k,v) -> System.out.println("key: " + k + " length:" + v.length + " count:" + v.count));
		
		return charPair;
	}
}
