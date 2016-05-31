package assignment6prob1;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.TreeMap;

public class MapperBase {
	String Id;
	Path FilePath;
	HashMap<Pair, Integer> KeyNeighbourList = new HashMap<Pair, Integer>();
	Reducer[] reducers;
	TreeMap<Pair, Integer>[] reducerInput;
	
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
