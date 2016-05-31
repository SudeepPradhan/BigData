package assignment6prob3;

public class Pair implements Comparable<Pair> {
	public String sensorId;
	public String time;
	
	Pair(String sensorId, String time)
	{
		this.sensorId = sensorId;
		this.time = time;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Pair)) return false;

	    Pair other = (Pair) o;
	    return this.sensorId.equals(other.sensorId) && this.time.equals(other.time);
	}
	
	@Override
	public int hashCode()
	{
		return this.sensorId.hashCode() + this.time.hashCode();
	}

	@Override
	public int compareTo(Pair o) {
		int lastCmp = this.sensorId.compareTo(o.sensorId);
		return (lastCmp != 0 ? lastCmp : time.compareTo(o.time));
	}
}
