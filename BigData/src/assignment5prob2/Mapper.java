package assignment5prob2;

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
	HashMap<Pair, Integer> AssociativeArray = new HashMap<Pair, Integer>();
	Reducer[] reducers;
	HashMap<Pair, Integer>[] reducerInput;
	
	@SuppressWarnings("unchecked")
	Mapper(String id, Path filePath, Reducer[] reducers)
	{
		this.Id = id;
		this.FilePath = filePath;
		this.reducers = reducers;
		this.reducerInput = (HashMap<Pair, Integer>[]) new HashMap[reducers.length];
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
				Pair pair = new Pair(keys[i], n);
				if(AssociativeArray.containsKey(pair))
				{
					AssociativeArray.put(pair, AssociativeArray.get(pair) + 1);
				}
				else
				{
					AssociativeArray.put(pair, 1);
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
		for(Map.Entry<Pair, Integer> map : AssociativeArray.entrySet())
		{
			Integer index = getPartition(map.getKey().key);
			this.reducerInput[index].put(map.getKey(), map.getValue());
		}
		
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			HashMap<Pair, Integer> pair = this.reducerInput[i];
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
			reducerInput[i] = new HashMap<Pair, Integer>();
		}
	}
	
	public void PrintMapperOutput()
	{
		System.out.println("Mapper " + this.Id + " Output" );
		AssociativeArray.forEach(
				(k, v) -> System.out.println("< (" + k.key + ", " + k.neighbour + ") , " + v + " >"));
	}
	
	public void PrintEmitterOutput()
	{
		for(Integer i = 0; i < this.reducerInput.length; i ++)
		{
			HashMap<Pair, Integer> pair = this.reducerInput[i];
			System.out.println("Pairs send from Mapper " + this.Id + " Reducer " + i.toString());
			pair.forEach((k, v) -> System.out.println("< (" + k.key + ", " + k.neighbour + ") , " + v + " >"));
		}
	}
}
