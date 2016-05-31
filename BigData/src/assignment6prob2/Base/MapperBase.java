package assignment6prob2.Base;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

import assignment6prob2.Reducer;
import assignment6prob2.Helper.ConsolePrint;
import assignment6prob2.Helper.Key;

public class MapperBase {
	String Id;
	protected Path FilePath;
	protected HashMap<Key, HashMap<String, Integer>> KeyNeighbourList = new HashMap<Key, HashMap<String, Integer>>();
	protected Reducer[] Reducers;
	protected TreeMap<Key, HashMap<String, Integer>>[] ReducerInputs;
	
	@SuppressWarnings("unchecked")
	public void Initialize(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.Reducers = reducers;
		this.ReducerInputs = (TreeMap<Key, HashMap<String, Integer>>[]) new TreeMap[reducers.length];
		
		for(int i = 0; i < ReducerInputs.length; i++)
			ReducerInputs[i] = new TreeMap<Key, HashMap<String, Integer>>();
	}
	
	public void PrintMapperOutput()
	{
		ConsolePrint.PrintMapperOutput(this.Id, this.KeyNeighbourList);
	}
	
	public void PrintEmitterOutput()
	{
		ConsolePrint.PrintEmitterOutput(this.Id, this.ReducerInputs);
	}
}
