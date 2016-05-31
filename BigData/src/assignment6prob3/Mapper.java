package assignment6prob3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

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
			
			Pair pair = new Pair(keys[1], keys[0]);
			SensorPair.put(pair, keys[2]);
		}
	}
	
	public void Emit()
	{
		for(Map.Entry<Pair, String> map : SensorPair.entrySet())
		{
			Integer index = ShuffleSort.GetPartition(map.getKey().sensorId, reducers.length);
			this.reducerInput[index].put(map.getKey(), map.getValue());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			TreeMap<Pair, String> pair = this.reducerInput[i];
			this.reducers[i].addInputList(pair);
		}
	}
}
