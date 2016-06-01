package assignment6prob3;

import java.util.List;

import assignment6prob3.Base.ReducerBase;
import assignment6prob3.Helper.KeyValuePair;

public class Reducer extends ReducerBase {
	Reducer(String id)
	{
		this.Id = id;
	}
	
	public void addInputList(List<KeyValuePair> inputPairs)
	{
		for(KeyValuePair kvp: inputPairs)
		{
			if(!this.InputArray.contains(kvp))
			{
				this.InputArray.add(kvp);
			}
		}
	}
	
	public void Reduce()
	{
		for(KeyValuePair kvp: InputArray)
		{
			this.OutputArray.add(kvp);
		}
	}
}
