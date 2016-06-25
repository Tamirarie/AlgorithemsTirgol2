package Dijkstra;

public class Vertex implements Comparable<Vertex>{
	Edge [] ed;
	int id,pred;
	double dist;
	boolean isVisited;
	public Vertex(int id,Edge ed[]) {
		this.ed = ed;
		this.id = id;
		dist = Double.MAX_VALUE;
		isVisited = false;
		pred = -1;
	}
	public Vertex(Vertex v) {
		this.id = v.id;
		this.dist = v.dist;
		this.isVisited = v.isVisited;
		this.pred = v.pred;
		this.ed = new Edge[v.ed.length];
		for (int i = 0; i < ed.length; i++) {
			ed[i] = new Edge(v.ed[i].v, v.ed[i].weight);
		}
	}
	@Override
	public int compareTo(Vertex o) {
		return ((Double)this.dist).compareTo(o.dist);
	}
}
