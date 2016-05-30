package assignment5prob4next;

import java.nio.file.Path;
import java.util.HashMap;

public class MapperBase {
	String Id;
	Path FilePath;
	HashMap<Key, HashMap<String, Integer>> KeyNeighbourList = new HashMap<Key, HashMap<String, Integer>>();
	Reducer[] Reducers;
	HashMap<String, HashMap<String, Integer>>[] ReducerInputs;
	
	@SuppressWarnings("unchecked")
	public void Initialize(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.Reducers = reducers;
		this.ReducerInputs = (HashMap<String, HashMap<String, Integer>>[]) new HashMap[reducers.length];
		
		for(int i = 0; i < ReducerInputs.length; i++)
			ReducerInputs[i] = new HashMap<String, HashMap<String, Integer>>();
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
