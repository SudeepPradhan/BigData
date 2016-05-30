package assignment5prob4next;

public class Key {
	String key;
	Integer id;
	
	Key(String key, Integer index)
	{
		this.key = key;
		this.id = index;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Key)) return false;

	    Key other = (Key) o;
	    return this.key.equals(other.key) && this.id.equals(other.id);
	}
	
	@Override
	public int hashCode()
	{
		return this.key.hashCode() + this.id.hashCode();
	}
}
