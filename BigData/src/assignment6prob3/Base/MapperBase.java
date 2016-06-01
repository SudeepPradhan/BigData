package assignment6prob3.Base;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import assignment6prob3.Reducer;
import assignment6prob3.Helper.ConsolePrint;
import assignment6prob3.Helper.KeyValuePair;

public class MapperBase {
	String Id;
	protected Path FilePath;
	protected List<KeyValuePair> SensorKeyValuePair = new ArrayList<KeyValuePair>();
	protected Reducer[] reducers;
	protected List<KeyValuePair>[] reducerInput;
	
	@SuppressWarnings("unchecked")
	public void Initialize(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.reducers = reducers;
		this.reducerInput = (List<KeyValuePair>[]) new ArrayList[reducers.length];
		
		for(int i = 0; i < reducerInput.length; i++)
		{
			reducerInput[i] = new ArrayList<KeyValuePair>();
		}
	}
	
	public void PrintMapperOutput()
	{
		ConsolePrint.PrintMapperOutput(this.Id, this.SensorKeyValuePair);
	}
	
	public void PrintEmitterOutput()
	{
		ConsolePrint.PrintEmitterOutput(this.Id, this.reducerInput);
	}
}
