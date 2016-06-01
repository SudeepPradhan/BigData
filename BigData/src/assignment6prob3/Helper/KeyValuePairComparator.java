package assignment6prob3.Helper;

import java.util.Comparator;

public class KeyValuePairComparator implements Comparator<KeyValuePair> {
	@Override
	public int compare(KeyValuePair o1, KeyValuePair o2) {
		int lastCmp = o1.sensorTimePair.sensorId.compareTo(o2.sensorTimePair.sensorId);
		return (lastCmp != 0 ? lastCmp : o1.sensorTimePair.time.compareTo(o2.sensorTimePair.time));
	}
}