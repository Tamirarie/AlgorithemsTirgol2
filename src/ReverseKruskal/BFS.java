package ReverseKruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
	int [] pred,color,dist;
	ArrayList<Integer> g[];
	public BFS(ArrayList<Integer> g[]) {
		int n = g.length;
		this.g = g;
		pred = new int[n];
		color = new int[n];
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(pred, -1);
		BFS(0);
	}

	private void BFS(int start) {
		dist[start] = 0;
		color[start] = 1;
		ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(g.length);
		q.add(start);
		while(!q.isEmpty()){
			int u = q.poll();
			color[u] = 1;
			for (Integer v : g[u]) {
				if(color[v] == 0){
					color[v] = 1;
					dist[v] = dist[u] +1;
					pred[v] = u;
					q.add(v);
				}
			}
			color[u] = 2;
		}
		
	}
	public boolean checkGraph(){
		for (int i = 0; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) return false; 
		}
		return true;
	}
}
