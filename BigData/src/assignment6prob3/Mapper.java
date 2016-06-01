package assignment6prob3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;


import assignment6prob3.Base.MapperBase;
import assignment6prob3.Helper.FileHelper;
import assignment6prob3.Helper.KeyValuePair;
import assignment6prob3.Helper.KeyValuePairComparator;
import assignment6prob3.Helper.SensorTimePair;
import assignment6prob3.Helper.ShuffleSort;

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
			
			SensorTimePair pair = new SensorTimePair(keys[1], keys[0]);
			SensorKeyValuePair.add(new KeyValuePair(pair, keys[2]));
		}
	}
	
	public void Emit()
	{
		for(KeyValuePair pair: SensorKeyValuePair)
		{
			Integer index = ShuffleSort.GetPartition(pair.sensorTimePair.sensorId, reducers.length);
			this.reducerInput[index].add(pair);
			//Collections.sort(this.reducerInput, new KeyValuePairComparator());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			List<KeyValuePair> pair = this.reducerInput[i];
			this.reducers[i].addInputList(pair);
		}
	}
}
