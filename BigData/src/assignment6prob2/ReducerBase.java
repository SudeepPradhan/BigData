package assignment6prob2;

import java.util.HashMap;
import java.util.List;

public class ReducerBase {
	String Id;
	HashMap<String, List<HashMap<String, Integer>>> ReducerInputList = new HashMap<String, List<HashMap<String, Integer>>>();
	HashMap<String, HashMap<String, Double>> ReducerOutputList = new HashMap<String, HashMap<String, Double>>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, this.ReducerInputList);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, this.ReducerOutputList);
	}
}
