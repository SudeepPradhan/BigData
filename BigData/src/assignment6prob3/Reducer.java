package assignment6prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Reducer extends ReducerBase {
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void addInputList(TreeMap<Pair, String> inputPairs)
	{
		for(Map.Entry<Pair, String> map : inputPairs.entrySet())
		{
			if(!this.InputArray.containsKey(map.getKey()))
			{
				this.InputArray.put(map.getKey(), Arrays.asList(map.getValue()));
			}
			else
			{
				List<String> newValue = new ArrayList<String>();
				newValue.addAll(this.InputArray.get(map.getKey()));
				newValue.add(map.getValue());

				this.InputArray.put(map.getKey(), newValue);
			}
		}
	}
	
	public void Reduce()
	{
		for(Map.Entry<Pair, List<String>> map : this.InputArray.entrySet())
		{
			this.OutputArray.put(
					map.getKey(), 
					String.join("-", map.getValue()));
		}
	}
}
