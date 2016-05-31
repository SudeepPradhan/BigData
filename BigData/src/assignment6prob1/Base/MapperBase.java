package assignment6prob1.Base;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

import assignment6prob1.Reducer;
import assignment6prob1.Helper.ConsolePrint;
import assignment6prob1.Helper.Pair;

public class MapperBase {
	protected String Id;
	protected Path FilePath;
	protected HashMap<Pair, Integer> KeyNeighbourList = new HashMap<Pair, Integer>();
	protected Reducer[] reducers;
	protected TreeMap<Pair, Integer>[] reducerInput;
	
	@SuppressWarnings("unchecked")
	public void Initialize(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.reducers = reducers;
		this.reducerInput = (TreeMap<Pair, Integer>[]) new TreeMap[reducers.length];
		
		for(int i = 0; i < reducerInput.length; i++)
		{
			reducerInput[i] = new TreeMap<Pair, Integer>();
		}
	}
	
	public void PrintMapperOutput()
	{
		ConsolePrint.PrintMapperOutput(this.Id, this.KeyNeighbourList);
	}
	
	public void PrintEmitterOutput()
	{
		ConsolePrint.PrintEmitterOutput(this.Id, this.reducerInput);
	}
}
