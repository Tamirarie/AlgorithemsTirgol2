package Dijkstra;

import java.util.PriorityQueue;

public class Dijkstra {
	
	Vertex ver[];
	int start;
	public Dijkstra(Vertex v[],int start) {
		this.ver = v;
		this.start = start;
		DijkstraSP();
	}
	
	private void DijkstraSP() {
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.add(ver[start]);
		ver[start].dist = 0;
		ver[start].isVisited = true;
		while(!q.isEmpty()){
			int u = q.poll().id;
			ver[u].isVisited = true;
			for (Edge ed : ver[u].ed) {
				int v = ed.v;
				if(!ver[v].isVisited){
					if(ver[v].dist > ver[u].dist + ed.weight ){
						ver[v].dist = ver[u].dist + ed.weight;
						ver[v].pred = u;
						q.remove(ver[v]);
						q.add(ver[v]);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		Vertex v0 = new Vertex(0, null); 
		Vertex v1 = new Vertex(1, null); 
		Vertex v2 = new Vertex(2, null);
		Vertex v3 = new Vertex(3, null);
		Vertex v4 = new Vertex(4, null);
		Vertex v5 = new Vertex(5, null);
		v0.ed = new Edge[]{new Edge(1,7), new Edge(2,9), new Edge(5,14)};
		v1.ed = new Edge[]{new Edge(0,7), new Edge(2,10), new Edge(3,115)};
		v2.ed = new Edge[]{new Edge(0,9), new Edge(1, 10), new Edge(3,11), new Edge(5,2)};
		v3.ed = new Edge[]{new Edge(1,15), new Edge(2,11), new Edge(4, 6)};
		v4.ed = new Edge[]{new Edge(3,6), new Edge(5,9)};
		v5.ed = new Edge[]{new Edge(4,9), new Edge(2,2), new Edge(0,14)};
		Vertex[] vs = {v0,v1,v2,v3,v4,v5};
		System.out.println(getPath(vs,0,5));
		System.out.println(getDist(vs,0,4));
	}

	private static double getDist(Vertex[] vs, int source, int dest) {
		Dijkstra d = new Dijkstra(vs, source);
		return d.ver[dest].dist;
	}

	private static String getPath(Vertex[] vs, int source, int dest) {
		String ans = ""+dest;
		Dijkstra d = new Dijkstra(vs, source);
		while(d.ver[dest].pred!=-1){
			ans = d.ver[dest].pred +"->"+ ans;
			dest = d.ver[dest].pred;
			
		}
		return ans;
	}
}
