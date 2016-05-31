package assignment6prob2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Reducer extends ReducerBase {
	
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void AddReducerInputList(TreeMap<Key, HashMap<String, Integer>> reducerInputList)
	{
		for(Map.Entry<Key, HashMap<String, Integer>> knl : reducerInputList.entrySet())
		{
			if(!this.ReducerInputList.containsKey(knl.getKey().key))
			{
				this.ReducerInputList.put(knl.getKey().key, Arrays.asList(knl.getValue()));
			}
			else
			{
				List<HashMap<String, Integer>> currentNeighbourList = this.ReducerInputList.get(knl.getKey().key);		
				HashMap<String, Integer> inputNeighbourList = reducerInputList.get(knl.getKey());			
				
				List<HashMap<String, Integer>> newNeighbourList = new ArrayList<HashMap<String, Integer>>();	
				newNeighbourList.addAll(currentNeighbourList);
				newNeighbourList.add(inputNeighbourList);
				
				this.ReducerInputList.put(knl.getKey().key, newNeighbourList);
			}
		}
	}
	
	public void Reduce()
	{
		for(Map.Entry<String, List<HashMap<String, Integer>>> knl : this.ReducerInputList.entrySet())
		{
			int total = 0;
			HashMap<String, Double> neighbourList = new HashMap<String, Double>();
			
			for(HashMap<String, Integer> nl : knl.getValue())
			{
				for(Map.Entry<String, Integer> n : nl.entrySet())
				{
					if(neighbourList.containsKey(n.getKey()))
						neighbourList.put(n.getKey(), neighbourList.get(n.getKey()) +  n.getValue());
					else
						neighbourList.put(n.getKey(), (double)n.getValue());
					
					total += n.getValue();
				}
			}		
			
			for(Map.Entry<String, Double> n : neighbourList.entrySet())
			{
				neighbourList.put(n.getKey(), n.getValue() / total);
			}
			
			this.ReducerOutputList.put(knl.getKey(), neighbourList);
		}
	}
}
