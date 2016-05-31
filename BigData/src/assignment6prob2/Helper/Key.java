package assignment6prob2.Helper;

public class Key implements Comparable<Key> {
	public String key;
	Integer id;
	Integer line;
	
	public Key(String key, Integer index, Integer line)
	{
		this.key = key;
		this.id = index;
		this.line = line;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Key)) return false;

	    Key other = (Key) o;
	    return this.key.equals(other.key) && this.id.equals(other.id) && this.line.equals(other.line);
	}
	
	@Override
	public int hashCode()
	{
		return this.key.hashCode() + this.id.hashCode() + this.line.hashCode();
	}

	@Override
	public int compareTo(Key o) {
		int lastCmp = this.key.compareTo(o.key);
		lastCmp = lastCmp != 0 ? lastCmp : id.compareTo(o.id);
		return (lastCmp != 0 ? lastCmp : line.compareTo(o.line));
	}
}

