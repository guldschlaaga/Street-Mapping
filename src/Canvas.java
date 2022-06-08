import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Canvas extends JComponent {
	double maxLo = 0; double maxLa = 0;  double minLo = 999999999;  double minLa = 999999999;
	
	 public Canvas(double maxLo, double maxLa, double minLo, double minLa, LinkedList<Edge> edges) {
		super();
		this.maxLo = maxLo;
		this.maxLa = maxLa;
		this.minLo = minLo;
		this.minLa = minLa;
		this.edges = edges;
		
		
		this.setBounds(0, 0, 500, 500);
	}
	 
	 



	
	
	LinkedList<Edge> edges; 
	Graph maaap = new Graph();
	
	
	
	
	public void paint(Graphics g){
		super.paintComponent(g);
		long time = 0;
		
		LinkedList<Edge> co = new LinkedList<Edge>();
		LinkedList<Edge> temp = new LinkedList<Edge>();
		
		while(!edges.isEmpty()) {
			Edge e = edges.remove();
		
			co.add(e);
			temp.add(e);
			
		}
		edges = temp;
		int ho = (int) (getHeight() *.05);
		int wo = (int) (getWidth() * .05);
		double h = getHeight()*.9;
		double w = getWidth()*.9;
		int c = 0;
		
		
		
		
		
		while(!co.isEmpty()) { 
		
			
			
			
			Edge e = co.removeLast();
			
			
			
			Double rangex = maxLo-minLo;
			Double rangey = maxLa-minLa;
			
			
			
			Vertex v1 = e.u;
			Vertex v2 = e.v;
			
			
			
			Double xper1 = (v1.lo - minLo)/rangex;
			Double xper2 = (v2.lo - minLo)/rangex;
			Double yper1 = (maxLa - v1.la)/rangey;
			Double yper2 = (maxLa - v2.la)/rangey;
		
			
			int x1 = (int) (xper1 * w) + wo;
			int y1 = (int) (yper1 * h) + ho;
			int x2 = (int) (xper2 * w) + wo;
			int y2 = (int) (yper2 * h) + ho;
			
			
			
			g.setColor(e.c);
			
			g.drawLine(x1,y1,x2,y2);
			
		
			
			
		}
		
		
		
		
		
		
		
		
	}
}
