import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	final int WHITE = 0,GRAY = 1, BLACK = 2;
	int [] pred,color,dist;
	ArrayList<Integer> g[];
	public BFS(ArrayList<Integer> g[]) {
		this.g = g;
		BFSalgo(0);
	}
	private void BFSalgo(int source) {
		init();
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		q.add(source);
		color[source] = GRAY;
		dist[source] = 0;
		while(!q.isEmpty()){
			int u = q.poll();
			color[u] = GRAY;
			for (Integer v : g[u]) {
				if(color[v]==WHITE){
					color[v] = GRAY;
					dist[v] = dist[u] +1;
					pred[v] = u;
					q.add(v);
				}
			}
			color[u] = BLACK;
		}
		
	}
	private void init() {
		int n = g.length;
		pred = new int[n];
		color = new int[n];
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(color, WHITE);
		Arrays.fill(pred, -1);
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
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = initGraph2();
		BFS b = new BFS(g);
		b.printArr();
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
