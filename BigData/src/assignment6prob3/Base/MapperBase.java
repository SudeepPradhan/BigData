package assignment6prob3.Base;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

import assignment6prob3.Reducer;
import assignment6prob3.Helper.ConsolePrint;
import assignment6prob3.Helper.Pair;

public class MapperBase {
	String Id;
	protected Path FilePath;
	protected HashMap<Pair, String> SensorPair = new HashMap<Pair, String>();
	protected Reducer[] reducers;
	protected TreeMap<Pair, String>[] reducerInput;
	
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
