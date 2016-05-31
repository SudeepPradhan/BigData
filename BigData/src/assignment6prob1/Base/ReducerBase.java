package assignment6prob1.Base;

import java.util.List;
import java.util.TreeMap;

import assignment6prob1.Helper.ConsolePrint;
import assignment6prob1.Helper.Pair;

public class ReducerBase {
	protected String Id;
	protected TreeMap<Pair, List<Integer>> InputArray = new TreeMap<Pair, List<Integer>>();
	protected TreeMap<Pair, Double> OutputArray = new TreeMap<Pair, Double>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
