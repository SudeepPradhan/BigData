package assignment4prob2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ShuffleSort {
	
	static List<Multimap<Character, CharStatisticPair>> list = 
			new ArrayList<Multimap<Character, CharStatisticPair>>();
	
	
	public static List<Multimap<Character, CharStatisticPair>> 
	process(Multimap<Character, CharStatisticPair> pairs, int reducers)
	{
		for(int i = 0; i < reducers; i++)
		{
			Multimap<Character, CharStatisticPair> multimap = ArrayListMultimap.create();	
			list.add(multimap);
		}

		for(Map.Entry<Character, CharStatisticPair> entry : pairs.entries()) {   
			Multimap<Character, CharStatisticPair> hm = list.get(getPartition(entry.getKey(), reducers));
			Character abc = entry.getKey();
			hm.put(abc, entry.getValue());
		}
		
		for(Multimap<Character, CharStatisticPair> pair : list)
		{
			System.out.println("-----------ShuffleSort-------------");
			for (Map.Entry<Character, CharStatisticPair> entry : pair.entries())
			{
				System.out.println(
						"key: " + entry.getKey() + 
						" length:" + ((CharStatisticPair)entry.getValue()).length + 
						" count:" + ((CharStatisticPair)entry.getValue()).count);
			}
		}
		return list;
	}
	
	public static int getPartition(Character key, Integer reducers){
		return (int) key.hashCode() % reducers;
	}
}
