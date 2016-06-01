package assignment7prob1.Helper;

public class Pair implements Comparable<Pair> {
	public String term;
	public String docId;
	
	public Pair(String term, String docId)
	{
		this.term = term;
		this.docId = docId;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Pair)) return false;

	    Pair other = (Pair) o;
	    return this.term.equals(other.term) && this.docId.equals(other.docId);
	}
	
	@Override
	public int hashCode()
	{
		return this.term.hashCode() + this.docId.hashCode();
	}

	@Override
	public int compareTo(Pair o) {
		int lastCmp = this.term.compareTo(o.term);
		return (lastCmp != 0 ? lastCmp : docId.compareTo(o.docId));
	}
}
