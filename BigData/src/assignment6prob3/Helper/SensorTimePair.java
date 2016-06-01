package assignment6prob3.Helper;

public class SensorTimePair {
	public String sensorId;
	public String time;
	
	public SensorTimePair(String sensorId, String time)
	{
		this.sensorId = sensorId;
		this.time = time;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof SensorTimePair)) return false;

	    SensorTimePair other = (SensorTimePair) o;
	    return this.sensorId.equals(other.sensorId) && this.time.equals(other.time);
	}
	
	@Override
	public int hashCode()
	{
		return this.sensorId.hashCode() + this.time.hashCode();
	}
}
