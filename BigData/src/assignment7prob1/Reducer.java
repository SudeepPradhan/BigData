package assignment7prob1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import assignment7prob1.Base.*;
import assignment7prob1.Helper.*;

public class Reducer extends ReducerBase {
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void addInputList(TreeMap<Pair, Integer> inputPairs)
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
			Posting newPosting = new Posting(map.getKey().docId, map.getValue().get(0));
			
			if(this.OutputArray.containsKey(map.getKey().term))
			{
				LinkedList<Posting> postings = this.OutputArray.get(map.getKey().term);
				postings.addLast(newPosting);
			}
			else
			{
				LinkedList<Posting> postings = new LinkedList<Posting>();
				postings.addLast(newPosting);
				this.OutputArray.put(
						map.getKey().term, 
						postings);
			}	
		}
	}
}
