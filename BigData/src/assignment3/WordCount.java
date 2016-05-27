package assignment3;

import java.io.IOException;
import java.util.List;

public class WordCount {
	static String DirPath = "D:\\Courses\\BigData\\TextInput\\";
	static Mapper[] mappers;
	static Reducer[] reducers;
	
	public static void MapReduce(String dirPath, int m, int r) throws IOException
	{
		mappers = new Mapper[m];
		reducers = new Reducer[r];
		
		for (int i = 0; i < reducers.length; i++) {
			reducers[i] = new Reducer();
		}
		
		Map(dirPath);
		Reduce();
	}
	
	public static void Map(String dirPath) throws IOException 
	{
		for(int i = 0; i < mappers.length; i++)
		{
			mappers[i] = new Mapper();
			List<Pair<String, Integer>> pairList = mappers[i].Map(dirPath + "testDataFor" + i + ".txt");	
			System.out.println("Mapper " + i +" Output");
			pairList.forEach(System.out::println);
			
			for(Pair<String, Integer> pair : pairList)
			{
				reducers[getPartition(pair.getKey())].pairList.add(pair);
			}
		}
	}
	
	public static void Reduce()
	{
		for(int i = 0; i < reducers.length; i++)
		{
			List<Pair<String, Integer>> output = reducers[i].Reduce();
			System.out.println("Reducer " + i +" Output");
			output.forEach(System.out::println);
		}
	}
	
	public static void main(String[] args) throws IOException {		
		MapReduce(DirPath, 3, 4);
	}
	
	public static int getPartition(String key){
		return (int) key.hashCode() % reducers.length;
	}
}