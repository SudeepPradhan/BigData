package assignment6prob1;

import java.util.ArrayList;
import java.util.List;

public class ShuffleSort {
	public static int GetPartition(String key, Integer divisor){
		return (int) key.hashCode() % divisor;
	}
	
	public static List<String> Neighbours(Integer index, String[] list)
	{
		List<String> neighbours = new ArrayList<String>();
		for(int i = index + 1; i < list.length; i ++)
		{
			if(list[index].equals(list[i]))	break;
			
			neighbours.add(list[i]);
		}
		return neighbours;
	}
}
