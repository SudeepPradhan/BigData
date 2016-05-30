package assignment5prob4;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
	static String SourceFolderPath = "src\\assignment5prob2\\InputFile";
	static Mapper[] mapppers = new Mapper[2];
	static Reducer[] reducers = new Reducer[4];
	
	public static void main(String[] args) throws IOException {
		Initialize();
		Map();
		Reduce();
	}

	public static void Map() throws IOException
	{
		for(Integer i = 0; i <= 1; i++)
		{
			mapppers[i] = new Mapper(i.toString() , Paths.get(SourceFolderPath, "File" + i.toString()), reducers);	
			mapppers[i].Map();
			mapppers[i].PrintMapperOutput();
		}
		
		for(Integer i = 0; i <= 1; i++)
		{
			mapppers[i].Emit();
			mapppers[i].PrintEmitterOutput();
		}
	}
	
	public static void Reduce()
	{
		for(Reducer reducer : reducers)
		{
			reducer.PrintReducerInput();
		}
		
		for(Reducer reducer : reducers)
		{
			reducer.Reduce();
		}
		
		for(Reducer reducer : reducers)
		{
			reducer.PrintReducerOutput();
		}
	}

	public static void Initialize()
	{
		for(Integer i = 0; i < reducers.length; i++)
		{
			reducers[i] = new Reducer(i.toString());
		}
	}
}
