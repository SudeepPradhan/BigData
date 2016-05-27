package assignment3next;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ShuffleSort {
	public static List<GroupByPair>[] ShuffleSorting(List<Pair<String, Integer>> pairAllList, int reducers) 
	{
		@SuppressWarnings("unchecked")
		List<GroupByPair>[] groupByPairListList = (ArrayList<GroupByPair>[])new ArrayList[reducers];
		@SuppressWarnings("unchecked")
		List<Pair<String, Integer>>[] pairListList = (ArrayList<Pair<String, Integer>>[])new ArrayList[reducers];
		
		for (int i = 0; i < pairListList.length; i++) {
			pairListList[i] = new ArrayList<Pair<String, Integer>>();
		}
		
		for (int i = 0; i < groupByPairListList.length; i++) {
			groupByPairListList[i] = new ArrayList<GroupByPair>();
		}
		
		for(Pair<String, Integer> pair : pairAllList)
		{
			pairListList[getPartition(pair.getKey(), reducers)].add(pair);
		}
		
		for(int i = 0; i < pairListList.length; i++)
		{
			SortMappedData(pairListList[i]);
			groupByPairListList[i].addAll(GroupByPair(pairListList[i]));
		}
		
		return groupByPairListList;
	}
	
	public static int getPartition(String key, Integer reducers){
		return (int) key.hashCode() % reducers;
	}
	
	public static List<GroupByPair> GroupByPair(List<Pair<String, Integer>> pairList)
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
	
	public static void SortMappedData(List<Pair<String, Integer>> pairList)
	{
		Collections.sort(pairList, (a, b) -> a.getKey().compareToIgnoreCase(b.getKey()));
	}
}
