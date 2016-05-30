package assignment5prob4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reducer {
	String Id;
	HashMap<String, List<HashMap<String, Integer>>> InputArray = new HashMap<String, List<HashMap<String, Integer>>>();
	HashMap<String, HashMap<String, Integer>> OutputArray = new HashMap<String, HashMap<String, Integer>>();
	
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void addInputList(HashMap<String, HashMap<String, Integer>> inputPairs)
	{
		for(Map.Entry<String, HashMap<String, Integer>> map : inputPairs.entrySet())
		{
			if(!this.InputArray.containsKey(map.getKey()))
			{
				this.InputArray.put(map.getKey(), Arrays.asList(map.getValue()));
			}
			else
			{
				List<HashMap<String, Integer>> currentHashMaps = this.InputArray.get(map.getKey());
				
				HashMap<String, Integer> newHashMap = inputPairs.get(map.getKey());
				
				List<HashMap<String, Integer>> allHashMap = new ArrayList<HashMap<String, Integer>>();
				
				allHashMap.addAll(currentHashMaps);
				allHashMap.add(newHashMap);
				
				this.InputArray.put(map.getKey(), allHashMap);
			}
		}
	}
	
	public void Reduce()
	{
		for(Map.Entry<String, List<HashMap<String, Integer>>> map : this.InputArray.entrySet())
		{
			HashMap<String, Integer> newMap = new HashMap<String, Integer>();
			
			for(HashMap<String, Integer> mm : map.getValue())
			{
				for(Map.Entry<String, Integer> map1 : mm.entrySet())
				{
					newMap.put(map1.getKey(), map1.getValue());
				}
			}		
			this.OutputArray.put(map.getKey(), newMap);
		}
	}
	
	public void PrintReducerInput()
	{
		System.out.println("Reducer " + this.Id + " Input" );
		InputArray.forEach(
				(k, v) -> System.out.println("< " + k + ", " + v.toString() + " >"));
	}
	
	public void PrintReducerOutput()
	{
		System.out.println("Reducer " + this.Id + " Output" );
		OutputArray.forEach(
				(k, v) -> System.out.println("< " + k + ", " + v.toString() + " >"));
	}
}
