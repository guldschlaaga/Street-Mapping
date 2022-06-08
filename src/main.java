import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class main extends JFrame {
	static Queue<Vertex> qset = new PriorityQueue<Vertex>();
	static Set<Vertex> eset = new TreeSet<Vertex>();
	static LinkedList<Edge> edges = new LinkedList<Edge>(); 
	static Graph maaap = new Graph();
	
	static double maxLo = -99999999; static double maxLa = -9999999; static double minLo = 99999999; static double minLa = 99999999;
	public static void main(String[] args)  throws NumberFormatException, IOException   {
		boolean visable = false;
		boolean a = false;
		boolean showdirections = false;
		String place1 = "";
		String place2 = "";
		
		
		HashMap<String, Vertex> vlist = new HashMap<String, Vertex>();
		LinkedList<Edge> elist = new LinkedList<Edge>();
		File file = new File(args[0]);
		
		
		for(int i = 1; i < args.length; i++) {  //parses out arguments
			if(args[i].equals("--show")) {
				visable = true;
			}else if(args[i].equals("--directions")) {
				showdirections = true;
				
				if(args.length < i+2) {
					System.out.println("Incorrect parameters");
					showdirections = false;
				}else {
				place1 = args[i+1];
				place2 = args[i+2];
				}
			}
			
			
		}
		
		
		
		JFrame frame = new JFrame();
		
		
		frame.setSize(500,500);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			
			String temp = "";
			
			
			
			final long startTime2 = System.currentTimeMillis();

			while(br.ready()) { //reads the verticies and edges into the graph
				try {
					
					temp = br.readLine();
					
					String[] y = temp.split("\\s+");
					
				
					if(y[0].equals("i")) {
						Double valx = Double.parseDouble(y[3]);
						Double valy = Double.parseDouble(y[2]);
						vlist.put(y[1], new Vertex(y[1], Double.parseDouble(y[3]), Double.parseDouble(y[2])));
						
						
						maaap.addVertex(y[1], valx, valy);
						
						
						//this keeps track of the max and min coordinates to use furing the printing of the map
						
						if(valx > maxLo) {
							maxLo = valx;
							
						}
						if(valx < minLo) {
							minLo = valx;
							
						}
						if(valy > maxLa) {
							maxLa = valy;
							
						}
						if(valy < minLa) {
							minLa = valy;
							
						}
					} 
					else if (y[0].equals("r")) {
						
						
						Edge edge = new Edge(maaap.myVertices.get(y[2]), maaap.myVertices.get(y[3]));
						maaap.addEdge(edge);
						elist.add(edge);
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(showdirections == true) {
			
		//finds and prints directions for the shortest path; also highlights edges for path on map	
		ShortestPath (qset , eset, maaap.myVertices, maaap, maaap.myVertices.get(place2), maaap.myVertices.get(place1));
			
		}
		
		if(visable == true) {
		
		Canvas canvas = new Canvas(maxLo, maxLa, minLo, minLa, elist);
		
		canvas.setVisible(true);
		
		frame.add(canvas);
	
		frame.setVisible(true);
		
		
		}
	
	
		
	}

	public static void ShortestPath (Queue<Vertex> qset , Set<Vertex> eset, HashMap myVertices, Graph g, Vertex v, Vertex a) {
		Vertex v3 = new Vertex("temp");
		Vertex v4 = new Vertex("next");
		Collection<Vertex> rset = new HashSet<Vertex>();
		v.distance = 0;
		qset.add(v);
		int p = 0;
		int n = g.numVertices();
		
		
		
		Iterator value = myVertices.values().iterator();
		
	
		
		while(!qset.isEmpty()) {  //runs until all the possible paths have been checked
			
			
			
				
			v3 = qset.remove();
			
			v3.v = true;
			
			
			
			
			
			
			
			
				
					
					Iterator value2 = g.myAdjList.get(v3).iterator();  //iterates over all the edges attached to the vertex
					
					while(value2.hasNext()) {
						Edge e =(Edge) value2.next();
						v4 = e.returnOther(v3);
						
						
						if(v4.v = true && v4.distance > v3.distance + e.d) {  //relaxes the edges
							
							
							v4.distance = v3.distance + e.d;
							
							v4.predecessor = v3;
							
							
							qset.add(v4);
							v4.v=true;
						}
						
						
					}	
					if(a.v == true) {
						
						break;
						
					}	
				
				
				
				
				
				
			}
		
			
		
		
		
		
		
		if(a.predecessor == null || a.distance == Integer.MAX_VALUE) {  //makes sure that the two verticies can be reached from the other
			System.out.println("There is no path between these two nodes");
		}
		else {
			
		
		
		String[] s = new String[g.myNumVertices];
		Vertex v6 = new Vertex("check");
		Double miles = 0.0;
		v6 = a;
		int i = 0;
		
			while(v6.predecessor != null){ //goes through the quickest path, highlighting edges, printing directions and incrementing miles
				Vertex vprev = v6;
				System.out.println(vprev.name);
				
				
				v6 = v6.predecessor;
				
				Iterator value2 = g.myAdjList.get(vprev).iterator();
				Edge cor = null;
				while(value2.hasNext()) {
					Edge e =(Edge) value2.next();
					if(e.returnOther(vprev).equals(v6)){
						cor = e;
					}
					
				}
				cor.c = Color.BLUE;
				miles = miles + cor.d;
				
				s[i] = vprev.name;
				
				i++;
				
				
				
			}
		System.out.println(v6.name);	
		System.out.println("Total trip length is " + miles + " miles");
		}
	}
	
	
	
	
}
