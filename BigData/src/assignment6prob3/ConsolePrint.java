package assignment6prob3;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class ConsolePrint {
	public static void PrintMapperOutput(String id, HashMap<Pair, String> keyNeighbourList)
	{
		System.out.println("Mapper " + id + " Output" );
		keyNeighbourList.forEach(
				(k, v) -> System.out.println("< <" + k.sensorId + ", " + k.time + "> , " + v + " >"));
	}
	
	public static void PrintEmitterOutput(String id, TreeMap<Pair, String>[] reducerInput)
	{
		for(Integer i = 0; i < reducerInput.length; i ++)
		{
			TreeMap<Pair, String> pair = reducerInput[i];
			System.out.println("Pairs send from Mapper " + id + " Reducer " + i.toString());
			pair.forEach((k, v) -> System.out.println("< <" + k.sensorId + ", " + k.time + "> , " + v + " >"));
		}
	}
	
	public static void PrintReducerInput(String id, TreeMap<Pair, List<String>> inputArray)
	{
		System.out.println("Reducer " + id + " Input" );
		inputArray.forEach((k, v) -> System.out.println("< <" + k.sensorId + ", " + k.time + "> , " + v.toString() + " >"));
	}
	
	public static void PrintReducerOutput(String id, TreeMap<Pair, String> outputArray)
	{
		System.out.println("Reducer " + id + " Output" );
		outputArray.forEach((k, v) -> System.out.println("< " + k.sensorId + ", " + k.time + " , " + v.toString() + " >"));
	}
}
