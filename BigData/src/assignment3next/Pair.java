package assignment3next;

public class Pair<k extends Comparable<k>, v> implements Comparable<Pair<k, v>> {
	private final k key;
	private final v value;
	
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