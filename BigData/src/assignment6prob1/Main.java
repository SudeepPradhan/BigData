package assignment6prob1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	static String SourceFolderPath = "src\\assignment5prob2\\InputFile";
	static Mapper[] Mappers = new Mapper[2];
	static Reducer[] Reducers = new Reducer[4];
	
	public static void main(String[] args) throws IOException {
		Initialize();
		Map();
		Reduce();
	}

	public static void Map() throws IOException
	{
		for(Integer i = 0; i < Mappers.length; i++)
		{
			Mappers[i] = new Mapper(i.toString() , Paths.get(SourceFolderPath, "File" + i.toString()), Reducers);	
			Mappers[i].Map();
			Mappers[i].PrintMapperOutput();
		}
		
		for(Integer i = 0; i < Mappers.length; i++)
		{
			Mappers[i].Emit();
			Mappers[i].PrintEmitterOutput();
		}
	}
	
	public static void Reduce()
	{		
		Arrays.stream(Reducers).forEach(Reducer::PrintReducerInput);		
		Arrays.stream(Reducers).forEach(Reducer::Reduce);		
		Arrays.stream(Reducers).forEach(Reducer::PrintReducerOutput);
	}

	public static void Initialize()
	{
		IntStream.range(0, Reducers.length).forEach(i -> Reducers[i] = new Reducer(Integer.toString(i)));
	}
}
