package assignment4prob2;

import java.util.Collection;
import java.util.HashMap;

import com.google.common.collect.Multimap;

public class Reducer {
	Multimap<Character, CharStatisticPair> pairs;
	Reducer(Multimap<Character, CharStatisticPair> pairs)
	{
		this.pairs = pairs;
	}
	
	public HashMap<Character, Double> Reduce()
	{
		HashMap<Character, Double> result = new HashMap<Character, Double>();
		
		for (Character key : pairs.keySet()) 
		{
			Collection<CharStatisticPair> list = pairs.get(key);
			Double sum = 0.0;
			Double count = 0.0;
			Double average = 0.0;
			for (CharStatisticPair value : list)
			{
			    sum += value.length;
			    count += value.count;
			}
			average = sum / count;
			result.put(key, average);
		}
		
		return result;
	}
}
