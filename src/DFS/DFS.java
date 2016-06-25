package DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
	private final int WHITE = 0 , GRAY = 1, BLACK = 2;
	ArrayList<Integer> g[];
	int [] pred,color,first,last;
	int time ;
	boolean isCycle;
	String cycle;
	
	public DFS(ArrayList<Integer> g[]) {
		this.g = g;
		init();
		for (int i = 0; i < g.length; i++) {
			if(color[i] == WHITE) buildDFS(i);
		}
		
	}
	
	private void buildDFS(int source) {
		first[source] = ++time;
		color[source] = GRAY;
		for (int v : g[source]) {
			if(color[v] == WHITE){
				pred[v] = source;
				buildDFS(v);
			}
			else if(color[v] == GRAY && v != pred[source] && !isCycle){
				System.out.println(v+ "tried to be visited from "+ source);
				isCycle = true;
				int temp = source;
				while(temp!=-1){
					cycle += temp;
					temp = pred[temp];
				}
				cycle += source;
			}
		}
		last[source] = ++time;
		color[source] = BLACK;
		
	}

	private void init() {
		color = new int[g.length];
		pred = new int[g.length];
		first = new int[g.length];
		last = new int[g.length];
		Arrays.fill(pred, -1);
		time = 0;
		isCycle = false;
		cycle = "";
	}

	public static void main(String[] args) {
		ArrayList<Integer> g[] = initGraph();
		DFS d = new DFS(g);
		System.out.println(d.cycle);
	}
	
	public static ArrayList<Integer>[] initGraph(){
		int n = 5;
		ArrayList []graph = new ArrayList[n];
		for (int i=0; i<n; i++){
			graph [i] = new ArrayList<Integer>(n);
		}
		graph[0].add(3); graph[0].add(4);
		graph[1].add(3); graph[1].add(4);
		graph[2].add(3); graph[2].add(4);
		graph[3].add(0); graph[3].add(1); graph[3].add(2);
		graph[4].add(0); graph[4].add(1); graph[4].add(2);

		return graph;

	}
	
	private static int getDist(ArrayList<Integer> g[],int source, int dest) {
		DFS d = new DFS(g);
		d.printMats();
		return d.first[dest];
	}

	private void printMats() {
		System.out.println("====Color====");
		System.out.println(Arrays.toString(color));
		System.out.println("=============");
		System.out.println("====Pred=====");
		System.out.println(Arrays.toString(pred));
		System.out.println("=============");
		System.out.println("====First=====");
		System.out.println(Arrays.toString(first));
		System.out.println("=============");
		System.out.println("====Last======");
		System.out.println(Arrays.toString(last));
		System.out.println("=============");
	}
}
