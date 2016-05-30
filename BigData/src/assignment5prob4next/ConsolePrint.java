package assignment5prob4next;

import java.util.HashMap;
import java.util.List;

public class ConsolePrint {
	public static void PrintMapperOutput(String id, HashMap<Key, HashMap<String, Integer>> KeyNeighbourList)
	{
		System.out.println("Mapper " + id + " Output" );
		KeyNeighbourList.forEach(
				(k, n) -> System.out.println("< " + k.key + ", " + n.toString() + " >"));
	}
	
	public static void PrintEmitterOutput(String id, HashMap<String, HashMap<String, Integer>>[] ReducerInputs)
	{
		for(Integer i = 0; i < ReducerInputs.length; i ++)
		{
			HashMap<String, HashMap<String, Integer>> knl = ReducerInputs[i];
			System.out.println("Pairs send from Mapper " + id + " Reducer " + i.toString());
			knl.forEach(
					(k, n) -> System.out.println("< " + k + ", " + n.toString() + " >"));
		}
	}
	
	public static void PrintReducerInput(String id, HashMap<String, List<HashMap<String, Integer>>> ReducerInputList)
	{
		System.out.println("Reducer " + id + " Input" );
		ReducerInputList.forEach(
				(k, n) -> System.out.println("< " + k + ", " + n.toString() + " >"));
	}
	
	public static void PrintReducerOutput(String id, HashMap<String, HashMap<String, Integer>> ReducerOutputList)
	{
		System.out.println("Reducer " + id + " Output" );
		ReducerOutputList.forEach(
				(k, n) -> System.out.println("< " + k + ", " + n.toString() + " >"));
	}
}
