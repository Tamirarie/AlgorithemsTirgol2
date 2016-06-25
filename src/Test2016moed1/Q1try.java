package Test2016moed1;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1try {
	
	
	public static boolean hasCycle(ArrayList<Integer> graph[]){
		DFS d = new DFS(graph);
		return d.isCycle;
		 
		
	}
	public static String getCycle(ArrayList<Integer> graph[]){
		DFS d = new DFS(graph);
		if(!d.isCycle) return "[]";
		System.out.println(Arrays.toString(d.pred));
		return d.cycle;
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
		System.out.println(getCycle(g));
	}
}
