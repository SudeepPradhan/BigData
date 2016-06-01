package assignment6prob3.Base;

import java.util.ArrayList;
import java.util.List;

import assignment6prob3.Helper.ConsolePrint;
import assignment6prob3.Helper.KeyValuePair;

public class ReducerBase {
	protected String Id;
	protected List<KeyValuePair> InputArray = new ArrayList<KeyValuePair>();
	protected List<KeyValuePair> OutputArray = new ArrayList<KeyValuePair>();
	
	public void PrintReducerInput()
	{
		ConsolePrint.PrintReducerInput(this.Id, InputArray);
	}
	
	public void PrintReducerOutput()
	{
		ConsolePrint.PrintReducerOutput(this.Id, OutputArray);
	}
}
