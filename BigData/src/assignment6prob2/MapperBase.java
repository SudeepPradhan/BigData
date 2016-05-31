package assignment6prob2;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

public class MapperBase {
	String Id;
	Path FilePath;
	HashMap<Key, HashMap<String, Integer>> KeyNeighbourList = new HashMap<Key, HashMap<String, Integer>>();
	Reducer[] Reducers;
	TreeMap<Key, HashMap<String, Integer>>[] ReducerInputs;
	
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
