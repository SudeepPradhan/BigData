package assignment7prob1.Helper;

public class Posting implements Comparable<Posting> {
	public String docId;
	public Integer count;
	
	public Posting(String term, Integer docId)
	{
		this.docId = term;
		this.count = docId;
	}
	
	public boolean equals(Object o)
	{
	    if(o == null) return false;
	    if(!(o instanceof Posting)) return false;

	    Posting other = (Posting) o;
	    return this.docId.equals(other.docId) && this.count.equals(other.count);
	}
	
	@Override
	public int hashCode()
	{
		return this.docId.hashCode() + this.count.hashCode();
	}

	@Override
	public int compareTo(Posting o) {
		int lastCmp = this.docId.compareTo(o.docId);
		return (lastCmp != 0 ? lastCmp : count.compareTo(o.count));
	}
}
