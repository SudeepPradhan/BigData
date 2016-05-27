package assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<KeyValuePair<String, Integer>> keyValuePairList = new ArrayList<KeyValuePair<String, Integer>>();
	static List<GroupByPair> groupByPair = new ArrayList<GroupByPair>();
	static String FilePath = "D:\\Courses\\BigData\\TextInput\\testDataForW1D1.txt";
	
	public static void main(String[] args) throws IOException {
			
		System.out.println(" ==============Key Value Pair================ ");
		MapData(FilePath);
		SortMappedData();
		for (KeyValuePair<String, Integer> kvp : keyValuePairList) {
			System.out.println(kvp.toString());
		}
		
		System.out.println(" ==============Reducer Input================ ");
		GroupByPair();
		for (GroupByPair gbp : groupByPair) {
			System.out.println(gbp.toString());
		}
		
		System.out.println(" =============Reducer Output================= ");	
		for (GroupByPair gbp : groupByPair) {
			System.out.println(Reducer(gbp));
		}
	}

	public static void MapData(String filePath) throws IOException
	{
		String content = new String(Files.readAllBytes(Paths.get(filePath)));
		String[] result = content.split("[-\\s]");
		for(String s : result)
		{
			if(s.matches("[a-zA-Z]+"))
			{
				keyValuePairList.add(new KeyValuePair<String, Integer>(s.toLowerCase(), 1));
			}
		}
	}
	
	public static void GroupByPair()
	{
		for(int i = 0; i < keyValuePairList.size(); i++)
		{
			String currentKey = keyValuePairList.get(i).getKey();
			GroupByPair gbp = new GroupByPair(currentKey);
			
			while(i < keyValuePairList.size() - 1 && 
					keyValuePairList.get(i + 1).getKey().equals(currentKey))
			{
				gbp.addValue();
				i++;
			}
			
			groupByPair.add(gbp);
		}
	}
	
	public static void SortMappedData()
	{
		Collections.sort(keyValuePairList, (a, b) -> a.getKey().compareToIgnoreCase(b.getKey()));
	}
	
	public static String Reducer(GroupByPair gbp)
	{
		return "< " + gbp.getKey() + " , " + gbp.getValues().stream().mapToInt(i -> i.intValue()).sum() + " >";
	}
}