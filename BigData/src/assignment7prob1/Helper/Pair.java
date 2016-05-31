package assignment7prob1.Helper;

public class Pair implements Comparable<Pair> {
	public String key;
	public String neighbour;
	
	public Pair(String key, String neighbour)
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

	@Override
	public int compareTo(Pair o) {
		int lastCmp = this.key.compareTo(o.key);
		return (lastCmp != 0 ? lastCmp : neighbour.compareTo(o.neighbour));
	}
}
