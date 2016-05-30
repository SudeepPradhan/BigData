package assignment5prob4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {
	String Id;
	Path FilePath;
	HashMap<String, HashMap<String, Integer>> AssociativeArray = new HashMap<String, HashMap<String, Integer>>();
	Reducer[] reducers;
	HashMap<String, HashMap<String, Integer>>[] reducerInput;
	
	@SuppressWarnings("unchecked")
	Mapper(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.reducers = reducers;
		this.reducerInput = (HashMap<String, HashMap<String, Integer>>[]) new HashMap[reducers.length];
		Initialize();
	}
	
	public void Map() throws IOException
	{
		String content = new String(Files.readAllBytes(this.FilePath));
		String[] keys = content.split("\\W+");
		
		for(int i = 0; i < keys.length; i++)
		{
			for(String n : Neighbours(i, keys))
			{ 
				if(!AssociativeArray.containsKey(keys[i]))
				{
					HashMap<String, Integer> value = new HashMap<String, Integer>();
					value.put(n, 1);
					AssociativeArray.put(keys[i], value);
				}
				else
				{
					HashMap<String, Integer> value = AssociativeArray.get(keys[i]);
					if(value.containsKey(n))
					{
						value.put(n, value.get(n) + 1);
					}
					else
					{
						value.put(n, 1);
					}
				}
			}
		}
	}
	
	public List<String> Neighbours(Integer index, String[] list)
	{
		List<String> neighbours = new ArrayList<String>();
		for(int i = index + 1; i < list.length; i ++)
		{
			if(list[index].equals(list[i]))
				break;
			
			neighbours.add(list[i]);
		}
		return neighbours;
	}
	
	public void Emit()
	{
		for(Map.Entry<String, HashMap<String, Integer>> map : AssociativeArray.entrySet())
		{
			Integer index = getPartition(map.getKey());
			this.reducerInput[index].put(map.getKey(), map.getValue());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			HashMap<String, HashMap<String, Integer>> pair = this.reducerInput[i];
			this.reducers[i].addInputList(pair);
		}
	}
	
	public int getPartition(String key){
		return (int) key.hashCode() % (this.reducers.length);
	}
	
	public void Initialize()
	{
		for(int i = 0; i < reducerInput.length; i++)
		{
			reducerInput[i] = new HashMap<String, HashMap<String, Integer>>();
		}
	}
	
	public void PrintMapperOutput()
	{
		System.out.println("Mapper " + this.Id + " Output" );
		AssociativeArray.forEach(
				(k, v) -> System.out.println("< " + k + ", " + v.toString() + " >"));
	}
	
	public void PrintEmitterOutput()
	{
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			HashMap<String, HashMap<String, Integer>> pair = this.reducerInput[i];
			System.out.println("Pairs send from Mapper " + this.Id + " Reducer " + i.toString());
			pair.forEach(
					(k, v) -> System.out.println("< " + k + ", " + v.toString() + " >"));
		}
	}
}
