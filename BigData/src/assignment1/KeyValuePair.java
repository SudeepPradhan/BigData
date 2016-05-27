package assignment1;

public class KeyValuePair {
	String Key;
	Integer Value;
	
	KeyValuePair(String key, Integer value)
	{
		this.Key = key;
		this.Value = value;
	}
	
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyValuePair)) {
            return false;
        }
        KeyValuePair other = (KeyValuePair) obj;
        return this.Key.equals(other.Key);
    }
    
    public int hashCode() {
        return Key.hashCode();
    }
}