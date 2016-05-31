package assignment6prob2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import assignment6prob2.Base.MapperBase;
import assignment6prob2.Helper.FileHelper;
import assignment6prob2.Helper.Key;
import assignment6prob2.Helper.ShuffleSort;

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
					Key key = new Key(keys[i], i, l);
					if(!KeyNeighbourList.containsKey(key))
					{
						HashMap<String, Integer> neighbourList = new HashMap<String, Integer>();
						neighbourList.put(n, 1);
						KeyNeighbourList.put(key, neighbourList);
					}
					else
					{
						HashMap<String, Integer> neighbourList = KeyNeighbourList.get(key);
						if(neighbourList.containsKey(n))
							neighbourList.put(n, neighbourList.get(n) + 1);
						else
							neighbourList.put(n, 1);
					}
				}
			}
		}
	}
	
	public void Emit()
	{
		for(Map.Entry<Key, HashMap<String, Integer>> knl : KeyNeighbourList.entrySet())
		{
			Integer index = ShuffleSort.GetPartition(knl.getKey().key, Reducers.length);
			this.ReducerInputs[index].put(knl.getKey(), knl.getValue());
		}
		
		for(Integer i = 0; i < this.ReducerInputs.length; i ++)
		{
			TreeMap<Key, HashMap<String, Integer>> knl = this.ReducerInputs[i];
			this.Reducers[i].AddReducerInputList(knl);
		}
	}
}
