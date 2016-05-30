package assignment5prob4next;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reducer extends ReducerBase {
	
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void AddReducerInputList(HashMap<String, HashMap<String, Integer>> reducerInputList)
	{
		for(Map.Entry<String, HashMap<String, Integer>> knl : reducerInputList.entrySet())
		{
			if(!this.ReducerInputList.containsKey(knl.getKey()))
			{
				this.ReducerInputList.put(knl.getKey(), Arrays.asList(knl.getValue()));
			}
			else
			{
				List<HashMap<String, Integer>> currentNeighbourList = this.ReducerInputList.get(knl.getKey());		
				HashMap<String, Integer> inputNeighbourList = reducerInputList.get(knl.getKey());			
				
				List<HashMap<String, Integer>> newNeighbourList = new ArrayList<HashMap<String, Integer>>();	
				newNeighbourList.addAll(currentNeighbourList);
				newNeighbourList.add(inputNeighbourList);
				
				this.ReducerInputList.put(knl.getKey(), newNeighbourList);
			}
		}
	}
	
	public void Reduce()
	{
		for(Map.Entry<String, List<HashMap<String, Integer>>> knl : this.ReducerInputList.entrySet())
		{
			HashMap<String, Integer> neighbourList = new HashMap<String, Integer>();
			
			for(HashMap<String, Integer> nl : knl.getValue())
			{
				for(Map.Entry<String, Integer> n : nl.entrySet())
				{
					if(neighbourList.containsKey(n.getKey()))
						neighbourList.put(n.getKey(), neighbourList.get(n.getKey()) +  n.getValue());
					else
						neighbourList.put(n.getKey(), n.getValue());
				}
			}		
			this.ReducerOutputList.put(knl.getKey(), neighbourList);
		}
	}
}
