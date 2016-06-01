package assignment7prob1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

import assignment7prob1.Base.*;
import assignment7prob1.Helper.*;

public class Mapper extends MapperBase{
	Mapper(String id, Path filePath, Reducer[] reducers)
	{
		Initialize(id, filePath, reducers);
	}
	
	public void Map() throws IOException
	{
		String[] keys = FileHelper.SplitTextFromFile(this.FilePath, "\\W+");
		String docId = keys[1];
		
		for(int i = 2; i < keys.length; i++)
		{
			Pair pair = new Pair(keys[i], docId);
			if(PairPosting.containsKey(pair))
				PairPosting.put(pair, PairPosting.get(pair) + 1);
			else
				PairPosting.put(pair, 1);
		}
	}
	
	public void Emit()
	{
		for(Map.Entry<Pair, Integer> map : PairPosting.entrySet())
		{
			Integer index = ShuffleSort.GetPartition(map.getKey().term, reducers.length);
			this.reducerInput[index].put(map.getKey(), map.getValue());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			TreeMap<Pair, Integer> pair = this.reducerInput[i];
			this.reducers[i].addInputList(pair);
		}
	}
}
