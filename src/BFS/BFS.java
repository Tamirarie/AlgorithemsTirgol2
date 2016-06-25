package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {

	int [] pred,color,dist;
	private boolean isGraph;
	ArrayList<Integer>[] g;
	final int inf = Integer.MAX_VALUE;
	public BFS(ArrayList<Integer>[] g) {
		isGraph = true;
		this.g = g;
		init();
		algo(0);
	}



	private void algo(int source) {
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		q.add(source);
		color[source] = 1;
		dist[source] = 0;
		while(!q.isEmpty()){
			int u = q.poll();
			for (Integer v : g[u]) {
				if(color[v]==0){
					color[v] = 1;
					dist[v] = dist[u] +1;
					pred[v] = u;
					q.add(v);
				}
				else if(color[v]==1){
					///trying to go to the neighbors of v until reaching the same v1
					int n1 = g[v].remove(0);
					int n2 = g[v].remove(0);
					g[v].add(n1);
					g[v].add(n2);
					String s1=""+v+n1,s2=""+n2;
					while(pred[n1]!=pred[n2]){
						if(pred[n1]!=-1){
						s1 = s1 + pred[n1];
						n1 = pred[n1];
						}
						if(pred[n2]!=-1){
						s2 = pred[n2]+s2;
						n2 = pred[n2];
						}
					}
					s2 = s2+v;
					int f=s2.indexOf(Integer.toString(n2));
					String sub = s2.substring(f+1);
					s1 = s1+sub;
					System.out.println(s1);
					System.out.println("tried to visit "+v + " from " +u);
				}
			}
			color[u] = 2;
		}
		checkGraph();
		
	}



	private void checkGraph() {
		for (int i = 0; i < dist.length; i++) {
			if(dist[i]==inf) {
				isGraph = false;
				System.out.println("vertex "+i+" is not connected!");
			}
		}
	}



	private void init() {
		int n = g.length;
		pred = new int[n];
		color = new int[n];
		dist = new int[n];
		Arrays.fill(pred, -1);
		Arrays.fill(dist, inf);
		
	}
	public void printArr(){
		System.out.println("====Color====");
		System.out.println(Arrays.toString(color));
		System.out.println("=============");
		System.out.println("====Pred=====");
		System.out.println(Arrays.toString(pred));
		System.out.println("=============");
		System.out.println("====Dist=====");
		System.out.println(Arrays.toString(dist));
		System.out.println("=============");
	}



	private static boolean isGraph(ArrayList<Integer>[] g) {
		BFS b = new BFS(g);
		b.printArr();
		return b.isGraph;
	}



	public static void main(String[] args) {
		ArrayList<Integer> g[] = initGraph2();
		System.out.println(isGraph(g));
	}
	
	private static ArrayList<Integer>[] initGraph() {
		ArrayList<Integer> g[] = new ArrayList[5];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[0].add(2);
		g[1].add(0);
		g[1].add(3);
		g[2].add(0);
		g[3].add(4);
		g[4].add(3);
		
		///now we create cycle!
		g[2].add(4);
		g[4].add(2);
	
		
		return g;
	}
	public static ArrayList<Integer>[] initGraph2(){
		int n = 5;
		ArrayList []graph = new ArrayList[n];
		for (int i=0; i<n; i++){
		graph [i] = new ArrayList<Integer>(n);
		}
		graph[0].add(3); graph[0].add(4); graph[1].add(3); graph[1].add(4);
		graph[2].add(3); graph[2].add(4);
		graph[3].add(0); graph[3].add(1); graph[3].add(2);
		graph[4].add(0); graph[4].add(1); graph[4].add(2);
		return graph;
		}
}
