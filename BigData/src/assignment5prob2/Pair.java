package assignment5prob2;

public class Pair {
	public String key;
	public String neighbour;
	
	Pair(String key, String neighbour)
	{
		this.key = key;
		this.neighbour = neighbour;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Pair)) return false;

	    Pair other = (Pair) o;
	    return this.key.equals(other.key) && this.neighbour.equals(other.neighbour);
	}
	
	@Override
	public int hashCode()
	{
		return this.key.hashCode() + this.neighbour.hashCode();
	}
}
