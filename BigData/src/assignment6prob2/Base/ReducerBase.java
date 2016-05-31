package assignment6prob2.Base;

import java.util.HashMap;
import java.util.List;

import assignment6prob2.Helper.ConsolePrint;

public class ReducerBase {
	protected String Id;
	protected HashMap<String, List<HashMap<String, Integer>>> ReducerInputList = new HashMap<String, List<HashMap<String, Integer>>>();
	protected HashMap<String, HashMap<String, Double>> ReducerOutputList = new HashMap<String, HashMap<String, Double>>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, this.ReducerInputList);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, this.ReducerOutputList);
	}
}
