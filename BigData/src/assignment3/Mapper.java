package assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
	
	public List<Pair<String, Integer>> Map(String filePath) throws IOException
	{
		List<Pair<String, Integer>> pairList = new ArrayList<Pair<String, Integer>>();
		
		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		String[] splittedContent = content.split("[-\\s]");
		
		for(String s : splittedContent)
		{
			if(s.matches("[a-zA-Z]+"))
			{
				pairList.add(new Pair<String, Integer>(s.toLowerCase(), 1));
			}
		}
		
		return pairList;
	}
}
