package assignment3next;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Reducer {
	List<Pair<String, Integer>> pairList = new ArrayList<Pair<String, Integer>>();
	
//	public List<Pair<String, Integer>> Reduce()
//	{
//		SortMappedData();
//		List<GroupByPair> groupByPairs = GroupByPair();
//		
//		List<Pair<String, Integer>> pairs = new ArrayList<Pair<String, Integer>>();
//		for(GroupByPair gbp : groupByPairs)
//		{
//			pairs.add(new Pair<String, Integer>(
//					gbp.getKey(), 
//					gbp.getValues().stream().mapToInt(i -> i.intValue()).sum()));
//		}
//		return pairs;
//	}
	
	public List<Pair<String, Integer>> Reduce(List<GroupByPair> groupByPairs)
	{
		List<Pair<String, Integer>> pairs = new ArrayList<Pair<String, Integer>>();
		for(GroupByPair gbp : groupByPairs)
		{
			pairs.add(new Pair<String, Integer>(
					gbp.getKey(), 
					gbp.getValues().stream().mapToInt(i -> i.intValue()).sum()));
		}
		return pairs;
	}
	
	public List<GroupByPair> GroupByPair()
	{
		List<GroupByPair> groupByPair = new ArrayList<GroupByPair>();
		
		for(int i = 0; i < pairList.size(); i++)
		{
			String currentKey = pairList.get(i).getKey();
			GroupByPair gbp = new GroupByPair(currentKey);
			
			while(i < pairList.size() - 1 && 
					pairList.get(i + 1).getKey().equals(currentKey))
			{
				gbp.addValue();
				i++;
			}
			
			groupByPair.add(gbp);
		}
		
		return groupByPair;
	}
	
	public void SortMappedData()
	{
		Collections.sort(pairList, (a, b) -> a.getKey().compareToIgnoreCase(b.getKey()));
	}
}
