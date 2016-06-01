package assignment6prob3.Helper;

public class KeyValuePair {
	public SensorTimePair sensorTimePair;
	public String value;
	
	public KeyValuePair(SensorTimePair sensorTimePair, String value)
	{
		this.sensorTimePair = sensorTimePair;
		this.value = value;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof KeyValuePair)) return false;

	    KeyValuePair other = (KeyValuePair) o;
	    return this.sensorTimePair.equals(other.sensorTimePair) && this.value.equals(other.value);
	}
	
	@Override
	public int hashCode()
	{
		return this.sensorTimePair.hashCode() + this.value.hashCode();
	}
}