package assignment6prob1;

import java.util.List;
import java.util.TreeMap;

public class ReducerBase {
	String Id;
	TreeMap<Pair, List<Integer>> InputArray = new TreeMap<Pair, List<Integer>>();
	TreeMap<Pair, Double> OutputArray = new TreeMap<Pair, Double>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
