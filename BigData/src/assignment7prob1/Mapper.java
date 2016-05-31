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
		String[] lines = FileHelper.SplitTextByLineBreak(this.FilePath);
		
		for(int l = 0; l < lines.length; l++)
		{
			String[] keys = FileHelper.SplitTextFromContent(lines[l], "\\W+");
			for(int i = 0; i < keys.length; i++)
			{
				for(String n : ShuffleSort.Neighbours(i, keys))
				{ 
					Pair pair = new Pair(keys[i], n);
					if(KeyNeighbourList.containsKey(pair))
						KeyNeighbourList.put(pair, KeyNeighbourList.get(pair) + 1);
					else
						KeyNeighbourList.put(pair, 1);
				}
			}
		}
	}
	
	public void Emit()
	{
		for(Map.Entry<Pair, Integer> map : KeyNeighbourList.entrySet())
		{
			Integer index = ShuffleSort.GetPartition(map.getKey().key, reducers.length);
			this.reducerInput[index].put(map.getKey(), map.getValue());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			TreeMap<Pair, Integer> pair = this.reducerInput[i];
			this.reducers[i].addInputList(pair);
		}
	}
}
