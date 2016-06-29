package Euler;

import java.util.ArrayList;
import java.util.Stack;

public class EulerCycle {
	ArrayList<Integer>[] g;
	int deg[];
	int v_start;
	boolean isPath,isCycle;
	public EulerCycle(ArrayList<Integer>[] g) {
		this.g = g;
		intDeg();
	}

	private void intDeg() {
		deg = new int[g.length];
		int numOfOddVert = 0;
		isCycle = isPath=false;
		for (int i = 0; i < deg.length; i++) {
			deg[i] = g[i].size();
			if(deg[i]%2 == 1){
				numOfOddVert++;
				v_start = i;
			}
		}
		
		if(numOfOddVert == 0) isPath=isCycle = true;
		else if(numOfOddVert == 2) isPath = true;
		
	}

	public static void main(String[] args) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[0].add(4);
		g[1].add(0);
		g[1].add(2);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(5);
		g[4].add(0);
		g[4].add(5);
		g[5].add(4);
		g[5].add(3);
		EulerCycle e = new EulerCycle(g);
		System.out.println(e.eulerPath());
	}

	private String eulerPath() {
		if(!isPath) return null;
		return eulerAlgo();
	}
	private String eulerCycle(){
		if(!isCycle) return null;
		return eulerAlgo();
	}

	private String eulerAlgo() {
		Stack<Integer> s = new Stack<>();
		String ans = "";
		s.push(v_start);
		while(!s.isEmpty()){
			int p = s.peek();
			if(deg[p]==0){
				s.pop();
				if(ans == "") ans+=p;
				else ans = ans+"->"+p;
			}
			else{
				int u = g[p].get(0);
				deg[p]--;
				deg[u]--;
				g[u].remove((Integer)p);
				g[p].remove((Integer)u);
				s.add(u);
			}
		}
		
		return ans;
	}
}
