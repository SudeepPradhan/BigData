package assignment6prob3;

import java.util.List;
import java.util.TreeMap;

public class ReducerBase {
	String Id;
	TreeMap<Pair, List<String>> InputArray = new TreeMap<Pair, List<String>>();
	TreeMap<Pair, String> OutputArray = new TreeMap<Pair, String>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
