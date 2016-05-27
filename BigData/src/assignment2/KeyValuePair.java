package assignment2;

public class KeyValuePair<k extends Comparable<k>, v> implements Comparable<KeyValuePair<k, v>> {
	private final k key;
	private final v value;
	
	public KeyValuePair(k key, v value) {
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
	public int compareTo(KeyValuePair<k, v> o) {
		return key.compareTo(o.getKey());
	}
	
	@Override
	public String toString()
	{
		return "< " + key + " , " + value + " >";
	}
}