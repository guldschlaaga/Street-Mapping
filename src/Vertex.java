

public class Vertex extends Object implements Comparable<Vertex> {
	double lo;
	double la;
	boolean v = false;
	/**
	 * label for Vertex
	 */
	public String name;  
	/**
	 * length of shortest path from source
	 */
	public double distance; 
	/**
	 * previous vertex on path from sourxe
	 */
	public Vertex predecessor; // previous vertex
	
	/**
	 * a measure of the structural importance of a vertex.
	 * The value should initially be set to zero. A higher
	 * centrality score should mean a Vertex is more central.
	 */
	public double centrality;
	/**
	 * Infinite distance indicates that there is no path
	 * from the source to this vertex
	 */
	public static final int INFINITY = Integer.MAX_VALUE;

	public Vertex(String v)
	{
		
		name = v;
		distance = INFINITY; // start as infinity away
		predecessor = null;
		centrality = 0.0;
		
	}
	
	public Vertex(String v, double lo, double la) {
		
		name = v;
		this.lo = lo;
		this.la= la;
	}
	
	public double getLo() {
		return lo;
	}
	
	public void setLo(double lo) {
		this.lo = lo;
		
	}
	
	public double getLa() {
		return la;
	}
	
	public void setLa(double la) {
		this.la = la;
		
	}
	
	/**
	 * The name of the Vertex is assumed to be unique, so it
	 * is used as a HashCode
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return name.hashCode();
	}
	
	
	/**
	 * Compare on the basis of distance from source first and 
	 * then lexicographically
	 */
	public int compareTo(Vertex other)
	{
		int diff = (int) (distance - other.distance);
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.name);
	}
}