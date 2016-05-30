package assignment5prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reducer {
	String Id;
	HashMap<Pair, List<Integer>> InputArray = new HashMap<Pair, List<Integer>>();
	HashMap<Pair, Integer> OutputArray = new HashMap<Pair, Integer>();
	
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void addInputList(HashMap<Pair, Integer> inputPairs)
	{
		for(Map.Entry<Pair, Integer> map : inputPairs.entrySet())
		{
			if(!this.InputArray.containsKey(map.getKey()))
			{
				this.InputArray.put(map.getKey(), Arrays.asList(map.getValue()));
			}
			else
			{
				List<Integer> newValue = new ArrayList<Integer>();
				newValue.addAll(this.InputArray.get(map.getKey()));
				newValue.add(map.getValue());

				this.InputArray.put(map.getKey(), newValue);
			}
		}
	}
	
	public void Reduce()
	{
		for(Map.Entry<Pair, List<Integer>> map : this.InputArray.entrySet())
		{
			this.OutputArray.put(
					map.getKey(), 
					map.getValue().stream().mapToInt(i -> i.intValue()).sum());
		}
	}
	
	public void PrintReducerInput()
	{
		System.out.println("Reducer " + this.Id + " Input" );
		InputArray.forEach((k, v) -> System.out.println("< (" + k.key + ", " + k.neighbour + ") , " + v.toString() + " >"));
	}
	
	public void PrintReducerOutput()
	{
		System.out.println("Reducer " + this.Id + " Output" );
		OutputArray.forEach((k, v) -> System.out.println("< (" + k.key + ", " + k.neighbour + ") , " + v.toString() + " >"));
	}
}
