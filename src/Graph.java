

import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Graph {
	HashMap<Vertex, HashSet<Edge>> myAdjList;
	 HashMap<String, Vertex> myVertices;
	private static final HashSet<Vertex> EMPTY_SET = new HashSet<Vertex>();
	int myNumVertices;
	private int myNumEdges;

	/**
	 * Construct empty Graph
	 */
	public Graph() {
		myAdjList = new HashMap<Vertex, HashSet<Edge>>();
		myVertices = new HashMap<String, Vertex>();
		myNumVertices = myNumEdges = 0;
		
	}

	/**
	 * Add a new vertex name with no neighbors (if vertex does not yet exist)
	 * 
	 * @param name
	 *            vertex to be added
	 */
	public Vertex addVertex(String name, Double lo, Double la) {
		Vertex v;
		v = myVertices.get(name);
		
		if (v == null) {
			v = new Vertex(name);
			v.lo = lo;
			v.la = la;
			myVertices.put(name, v);
			myAdjList.put(v, new HashSet<Edge>());
			myNumVertices += 1;
		}
		return v;
	}
	
	public Vertex addVertex(String name) {
		Vertex v;
		v = myVertices.get(name);
		if (v == null) {
			v = new Vertex(name);
		
			myVertices.put(name, v);
			myAdjList.put(v, new HashSet<Edge>());
			myNumVertices += 1;
		}
		return v;
	}

	/**
	 * Returns the Vertex matching v
	 * @param name a String name of a Vertex that may be in
	 * this Graph
	 * @return the Vertex with a name that matches v or null
	 * if no such Vertex exists in this Graph
	 */
	public Vertex getVertex(String name) {
		return myVertices.get(name);
	}

	/**
	 * Returns true iff v is in this Graph, false otherwise
	 * @param name a String name of a Vertex that may be in
	 * this Graph
	 * @return true iff v is in this Graph
	 */
	public boolean hasVertex(String name) {
		return myVertices.containsKey(name);
	}

	/**
	 * Is from-to, an edge in this Graph. The graph is 
	 * undirected so the order of from and to does not
	 * matter.
	 * @param from the name of the first Vertex
	 * @param to the name of the second Vertex
	 * @return true iff from-to exists in this Graph
	 */
	public boolean hasEdge(String from, String to) {

		if (!hasVertex(from) || !hasVertex(to))
			return false;
		return myAdjList.get(myVertices.get(from)).contains(myVertices.get(to));
	}
	
	/**
	 * Add to to from's set of neighbors, and add from to to's
	 * set of neighbors. Does not add an edge if another edge
	 * already exists
	 * @param from the name of the first Vertex
	 * @param to the name of the second Vertex
	 */
	public void addEdge(String from, String to) {
		Vertex v, w;
		
		
		myNumEdges += 1;
		v = myVertices.get(from);
		w = myVertices.get(to);
		
		
		
		Edge n = new Edge(v,w);
		myAdjList.get(v).add(n);
		
		System.out.println(myAdjList.get(w).add(n));
		
		
		
	}
	
	public void addEdge(Edge edge) {
		Vertex v, w;
		
	
		myNumEdges += 1;
		v = edge.u;
		w = edge.v;
		
		
	
		
		myAdjList.get(v).add(edge);
		
		myAdjList.get(w).add(edge);
		
		
		
	}

	/**public Vertex addVertex(String name, Double x, Double y) {
		Vertex v;
		v = myVertices.get(name);
		if (v == null) {
			v = new Vertex(name);
			v.x = x;
			v.y = y;
			myVertices.put(name, v);
			myAdjList.put(v, new TreeSet<Vertex>());
			myNumVertices += 1;
		}
		return v;
	}

	/**
	 * Return an iterator over the neighbors of Vertex v
	 * @param v the Vertex
	 * @return an Iterator over Vertices that are adjacent
	 * to the Vertex v, empty set if v is not in graph
	 */
	
	/**
	 * Returns an Iterator over all Vertices in this Graph
	 * @return an Iterator over all Vertices in this Graph
	 */
	public Iterable<Vertex> getVertices() {
		return myVertices.values();
	}

	public int numVertices()
	{
		return myNumVertices;
	}
	
	public int numEdges()
	{
		return myNumEdges;
	}
	
	/**
	 * Sets each Vertices' centrality field to
	 * the degree of each Vertex (i.e. the number of
	 * adjacent Vertices)
	 */
	public void degreeCentrality()
	{
		// TODO: complete degreeCentrality
	}
	
	/**
	 * Sets each Vertices' centrality field to
	 * the average distance to every Vertex
	 */
	public void closenessCentrality()
	{
		// TODO: complete closenessCentrality
	}
	/**
	 * Sets each Vertices' centrality field to
	 * the proportion of geodesics (shortest paths) that
	 * this Vertex is on
	 */
	public void betweennessCentrality()
	{
		// TODO: complete betweennessCentrality
	}
	
	private String escapedVersion(String s) {
		return "\'"+s+"\'";

	}
}