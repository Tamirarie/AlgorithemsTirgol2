package Test2016moed1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DFS {
	
	boolean isCycle;
	int pred[],color[];
	ArrayList<Integer> graph[];
	String cycle;
	public DFS(ArrayList<Integer> graph[]) {
		this.graph = graph;
		isCycle = false;
		pred = new int[graph.length];
		color = new int[graph.length];
		Arrays.fill(pred, -1);
		cycle = "[";
		DFS(0);
	}
	private void DFS(int source) {
		Stack<Integer> s = new Stack<>();
		s.push(source);
		int visited [] = new int[graph.length];
		int counter = 0;
		color[source] = 1;
		while(!s.isEmpty()){
			int u = s.pop();
			
			for (Integer v : graph[u]) {
				if(color[v] == 1 && v!=source && !isCycle){
					isCycle = true;
					int temp = v;
					while(temp != -1){
						cycle+=temp;
						temp = pred[temp];
					}
					
				}
				if(color[v] == 0){
					visited[counter++] = v;
					color[v] = 1;
					pred[v] = u;
					s.add(v);
				}
			}
		}
		
	}
	
	
}
