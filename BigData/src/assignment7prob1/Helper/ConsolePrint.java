package assignment7prob1.Helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ConsolePrint {
	public static void PrintMapperOutput(String id, HashMap<Pair, Integer> keyNeighbourList)
	{
		System.out.println("Mapper " + id + " Output" );
		keyNeighbourList.forEach(
				(k, v) -> System.out.println("< < " + k.term + ", " + k.docId + " > , " + v + " >"));
	}
	
	public static void PrintEmitterOutput(String id, TreeMap<Pair, Integer>[] reducerInput)
	{
		for(Integer i = 0; i < reducerInput.length; i ++)
		{
			TreeMap<Pair, Integer> pair = reducerInput[i];
			System.out.println("Pairs send from Mapper " + id + " Reducer " + i.toString());
			pair.forEach((k, v) -> System.out.println("< < " + k.term + ", " + k.docId + " > , " + v + " >"));
		}
	}
	
	public static void PrintReducerInput(String id, TreeMap<Pair, List<Integer>> inputArray)
	{
		System.out.println("Reducer " + id + " Input" );
		inputArray.forEach((k, v) -> System.out.println("< < " + k.term + ", " + k.docId + " > , " + v.toString() + " >"));
	}
	
	public static void PrintReducerOutput(String id, TreeMap<String, LinkedList<Posting>> outputArray)
	{
		System.out.println("Reducer " + id + " Output" );
		for(Map.Entry<String, LinkedList<Posting>> map : outputArray.entrySet())
		{
			System.out.print(map.getKey());
			for(Posting posting : map.getValue())
			{
				System.out.print(" ---> ( "+ posting.docId + " , " + posting.count + " ) ");
			}
			System.out.println("");
		}
	}
}
