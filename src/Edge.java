import java.awt.Color;

public class Edge extends Object {
	String p1;
	String p2;
	
	Vertex u;
	Vertex v;
	Double d;
	Color c = Color.black;
	int flag = 0;
	public Edge(Vertex u, Vertex v){
		this.p1 = u.name;
		this.p2 = v.name;
		
		this.u = u;
		this.v = v;
		
		//calculation of the distance of the edge based on the coordinates
		
		Double R = 3958.8;
		double a = Math.pow(Math.sin(Math.toRadians(v.la - u.la)/2),2) + Math.cos(Math.toRadians(u.la)) * Math.cos(Math.toRadians(v.la)) * Math.pow(Math.sin(Math.toRadians(v.lo - u.lo)/2),2); 
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		this.d = R*c;
	}
	
	public Vertex returnOther(Vertex t) {  //returns whatever member of the edge is not the included edge
		if(u.equals(t)) {
			return v;
		}
		else {
			return u;
		}
	}
	

}
