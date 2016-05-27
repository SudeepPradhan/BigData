package assignment4prob2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main {

	static String SourceFolderPath = "src\\assignment4prob2\\InputFile";
	static Multimap<Character, CharStatisticPair> allCharPairMap = ArrayListMultimap.create();
	static List<Multimap<Character, CharStatisticPair>> shuffledCharPairsList = 
			new ArrayList<Multimap<Character, CharStatisticPair>>();
	static final int reducers = 3;
	
	public static void main(String[] args) throws IOException {
		Map();
		ShuffleSort();
		Reduce();
	}

	public static void Map() throws IOException
	{
		Files.walk(Paths.get(SourceFolderPath)).forEach(filePath -> {
		    if (Files.isRegularFile(filePath)) {
		        Mapper mapper = new Mapper(filePath);		        
		        try {
		        	HashMap<Character, CharStatisticPair> map = mapper.Map();
		        	for(Entry<Character, CharStatisticPair> entry : map.entrySet()) {
		        		allCharPairMap.put(entry.getKey(), entry.getValue());
		        	}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    }
		});
	}
	
	public static void ShuffleSort()
	{
		shuffledCharPairsList = ShuffleSort.process(allCharPairMap, reducers);
	}
	
	public static void Reduce()
	{
		for(Multimap<Character, CharStatisticPair> reducerInput : shuffledCharPairsList)
		{
			Reducer reducer = new Reducer(reducerInput);
			HashMap<Character, Double> result = reducer.Reduce();
			
			System.out.println("-----------Reducer-------------");
			result.forEach((k,v) -> System.out.println("key: " + k + " average:" + String.format("%.2f", v)));
		}
	}
}