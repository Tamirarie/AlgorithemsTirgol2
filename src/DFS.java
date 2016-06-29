import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
	final int WHITE = 0, GRAY = 1,BLACK = 2;
	int [] color,pred,first,last;
	ArrayList<Integer> g[];
	private int time;
	
	public DFS(ArrayList<Integer> g[]) {
		this.g = g;
		init();
		for (int i = 0; i < g.length; i++) {
			if(color[i] == WHITE) DFSalgo(i);
		}
	}

	private void DFSalgo(int source) {
		first[source] = ++time;
		color[source] = GRAY;
		for (int v : g[source]) {
			if(color[v] == WHITE){
				pred[v] = source;
				DFSalgo(v);
			}
		}
		color[source] = BLACK;
		last[source] = ++time;		
	}

	private void init() {
		int n = g.length;
		time = 0;
		color = new int[n];
		pred = new int[n];
		first = new int[n];
		last = new int[n];
		Arrays.fill(color, WHITE);
		Arrays.fill(pred, -1);
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
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = initGraph();
		DFS d = new DFS(g);
		d.printMats();
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
