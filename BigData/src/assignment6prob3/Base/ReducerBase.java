package assignment6prob3.Base;

import java.util.List;
import java.util.TreeMap;

import assignment6prob3.Helper.ConsolePrint;
import assignment6prob3.Helper.Pair;

public class ReducerBase {
	protected String Id;
	protected TreeMap<Pair, List<String>> InputArray = new TreeMap<Pair, List<String>>();
	protected TreeMap<Pair, String> OutputArray = new TreeMap<Pair, String>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
