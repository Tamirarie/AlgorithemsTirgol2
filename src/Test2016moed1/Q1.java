package Test2016moed1;

import java.util.ArrayList;
import java.util.Arrays;

public class Q1 {
	
	boolean isCycle;
	int color[],pred[];
	ArrayList<Integer> graph[];
	String cycle;
	public Q1(ArrayList<Integer> graph[]) {
		this.graph = graph;
		color = new int[graph.length];
		pred = new int[graph.length];
		Arrays.fill(color, 0);
		Arrays.fill(pred, -1);
		isCycle = false;
		cycle = "[";
	}
	public static boolean hasCycle(ArrayList<Integer> graph[]){
		Q1 q = new Q1(graph);
		
		 for (int i = 0; i < graph.length; i++) {
			if(q.color[i]==0)
			{
				DFS(i,q);
			}
		}
		 
		 System.out.println(Arrays.toString(q.pred));
		 DFS(0,q);
		 return q.isCycle;
		 
		
	}

	private static void DFS(int i,Q1 q) {
		q.color[i] = 1;
		for (Integer u  : q.graph[i]) {
			if(q.color[u] == 1 && u != q.pred[i] && q.isCycle==false) {
				q.isCycle = true;
				q.cycle += u;
				int par = i;
				while(par != -1){
					q.cycle+= q.pred[i];
					par = q.pred[i];
				}
				q.cycle+="]";
			}
			if(q.color[u] == 0){
				q.color[u] = 1;
				q.pred[u] = i;
				DFS(u,q);
			}
			
		}
		
	}
	private static boolean hasCycle(int i,boolean isVisited[],int parent,ArrayList<Integer> graph[]) {
		isVisited[i] = true;
		
		for (Integer u : graph[i]) {
			if(isVisited[u] == false){
				isVisited[u] = true;
				if(hasCycle(u, isVisited,parent, graph)) return true;
			}
			else if(i!=parent) return true;

		}
		return false;
	}
	public static String getCycle(ArrayList<Integer> graph[]){
		if(!hasCycle(graph)) return "[]";
		Q1 q = new Q1(graph);
		
		 for (int i = 0; i < graph.length; i++) {
			if(q.color[i]==0)
			{
				DFS(i,q);
			}
		}
		return q.cycle;
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
