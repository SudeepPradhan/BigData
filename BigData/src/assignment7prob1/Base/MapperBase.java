package assignment7prob1.Base;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

import assignment7prob1.*;
import assignment7prob1.Helper.*;

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
