package assignment4;

public class Pair<k extends Comparable<k>, v> implements Comparable<Pair<k, v>> {
	private k key;
	private v value;
	
	public Pair(k key, v value) {
		this.key = key;
		this.value = value;
	}

	public k getKey() {
		return key;
	}

	public v getValue() {
		return value;
	}
	
	public void setValue(v value)
	{
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Pair<?, ?>)) return false;

	    Pair<String, Integer> other = (Pair<String, Integer>) o;
	    return this.key.equals(other.getKey());
	}
	
	@Override
	public int hashCode()
	{
		return (Integer)this.key;
	}
	
	@Override
	public int compareTo(Pair<k, v> o) {
		return key.compareTo(o.getKey());
	}
	
	@Override
	public String toString()
	{
		return "< " + key + " , " + value + " >";
	}
}