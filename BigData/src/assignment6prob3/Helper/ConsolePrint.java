package assignment6prob3.Helper;

import java.util.List;

public class ConsolePrint {
	public static void PrintMapperOutput(String id, List<KeyValuePair> keyNeighbourList)
	{
		System.out.println("Mapper " + id + " Output" );
		keyNeighbourList.forEach(
				(k) -> System.out.println(
						"< <" + k.sensorTimePair.sensorId + 
						", " + k.sensorTimePair.time + 
						"> , " + k.value + 
						" >"));
	}
	
	public static void PrintEmitterOutput(String id, List<KeyValuePair>[] reducerInput)
	{
		for(Integer i = 0; i < reducerInput.length; i ++)
		{
			List<KeyValuePair> kvp = reducerInput[i];
			System.out.println("Pairs send from Mapper " + id + " Reducer " + i.toString());
			kvp.forEach((k) -> System.out.println(
					"< <" + k.sensorTimePair.sensorId + 
					", " + k.sensorTimePair.time + 
					"> , " + k.value + 
					" >"));
		}
	}
	
	public static void PrintReducerInput(String id, List<KeyValuePair> inputArray)
	{
		System.out.println("Reducer " + id + " Input" );
		inputArray.forEach(
				(k) -> System.out.println(
						"< <" + k.sensorTimePair.sensorId + 
						", " + k.sensorTimePair.time + 
						"> , [ " + k.value + 
						" ] >"));
	}
	
	public static void PrintReducerOutput(String id, List<KeyValuePair> outputArray)
	{
		System.out.println("Reducer " + id + " Output" );
		outputArray.forEach(
				(k) -> System.out.println(
						"< " + k.sensorTimePair.sensorId + 
						", " + k.sensorTimePair.time + 
						" , " + k.value + 
						" >"));
	}
}
