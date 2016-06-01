package assignment7prob1.Base;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import assignment7prob1.Helper.*;

public class ReducerBase {
	protected String Id;
	protected TreeMap<Pair, List<Integer>> InputArray = new TreeMap<Pair, List<Integer>>();
	protected TreeMap<String, LinkedList<Posting>> OutputArray = new TreeMap<String, LinkedList<Posting>>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
