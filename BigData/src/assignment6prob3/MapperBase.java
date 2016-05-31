package assignment6prob3;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

public class MapperBase {
	String Id;
	Path FilePath;
	HashMap<Pair, String> SensorPair = new HashMap<Pair, String>();
	Reducer[] reducers;
	TreeMap<Pair, String>[] reducerInput;
	
	@SuppressWarnings("unchecked")
	public void Initialize(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.reducers = reducers;
		this.reducerInput = (TreeMap<Pair, String>[]) new TreeMap[reducers.length];
		
		for(int i = 0; i < reducerInput.length; i++)
		{
			reducerInput[i] = new TreeMap<Pair, String>();
		}
	}
	
	public void PrintMapperOutput()
	{
		ConsolePrint.PrintMapperOutput(this.Id, this.SensorPair);
	}
	
	public void PrintEmitterOutput()
	{
		ConsolePrint.PrintEmitterOutput(this.Id, this.reducerInput);
	}
}
