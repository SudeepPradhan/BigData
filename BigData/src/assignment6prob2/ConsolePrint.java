package assignment6prob2;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class ConsolePrint {
	public static void PrintMapperOutput(String id, HashMap<Key, HashMap<String, Integer>> KeyNeighbourList)
	{
		System.out.println("Mapper " + id + " Output" );
		KeyNeighbourList.forEach(
				(k, n) -> System.out.println("< " + k.key + ", " + n.toString() + " >"));
	}
	
	public static void PrintEmitterOutput(String id, TreeMap<Key, HashMap<String, Integer>>[] ReducerInputs)
	{
		for(Integer i = 0; i < ReducerInputs.length; i ++)
		{
			TreeMap<Key, HashMap<String, Integer>> knl = ReducerInputs[i];
			System.out.println("Pairs send from Mapper " + id + " Reducer " + i.toString());
			knl.forEach(
					(k, n) -> System.out.println("< " + k.key + ", " + n.toString() + " >"));
		}
	}
	
	public static void PrintReducerInput(String id, HashMap<String, List<HashMap<String, Integer>>> ReducerInputList)
	{
		System.out.println("Reducer " + id + " Input" );
		ReducerInputList.forEach(
				(k, n) -> System.out.println("< " + k + ", " + n.toString() + " >"));
	}
	
	public static void PrintReducerOutput(String id, HashMap<String, HashMap<String, Double>> ReducerOutputList)
	{
		System.out.println("Reducer " + id + " Output" );
		ReducerOutputList.forEach(
				(k, n) -> System.out.println("< " + k + ", " + n.toString() + " >"));
	}
}
