package assignment3next;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCount {
	static String DirPath = "D:\\Courses\\BigData\\TextInput\\";
	static Mapper[] mappers;
	static Reducer[] reducers;
	static List<Pair<String, Integer>> pairAllList = new ArrayList<Pair<String, Integer>>();
	
	public static void MapReduce(String dirPath, int m, int r) throws IOException
	{
		mappers = new Mapper[m];
		reducers = new Reducer[r];
		
		for (int i = 0; i < reducers.length; i++) {
			reducers[i] = new Reducer();
		}
		
		Map(dirPath);
		List<GroupByPair>[] shuffledPair = ShuffleSort.ShuffleSorting(pairAllList, r);
		Reduce(shuffledPair);
	}
	
	public static void Map(String dirPath) throws IOException 
	{
		for(int i = 0; i < mappers.length; i++)
		{
			mappers[i] = new Mapper();
			List<Pair<String, Integer>> pairList = mappers[i].Map(dirPath + "testDataFor" + i + ".txt");	
			System.out.println("Mapper " + i +" Output");
			pairList.forEach(System.out::println);
			
			pairAllList.addAll(pairList);
		}
	}
	
	public static void Reduce(List<GroupByPair>[] list)
	{
		for(int i = 0; i < reducers.length; i++)
		{
			List<Pair<String, Integer>> reducedOutput = reducers[i].Reduce(list[i]);
			System.out.println("Reducer " + i +" Output");
			reducedOutput.forEach(System.out::println);
		}
	}
	
	public static void main(String[] args) throws IOException {	
		MapReduce(DirPath, 3, 4);
	}
}