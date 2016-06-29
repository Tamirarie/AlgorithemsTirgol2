package FireAlgo;

import java.util.ArrayList;

public class FireAlgo {
	
	int deg[];
	ArrayList<Integer> g[];
	int diameter,radius,center1,center2;
	
	
	public FireAlgo(ArrayList<Integer> g[]) {
		this.g = g;
		radius=-1;center1=-1;center2=-1;
		algo();
	}
	

	private void algo() {
		deg = new int[g.length];
		radius = 0;
		ArrayList<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < deg.length; i++) {
			deg[i] = g[i].size();
			if(deg[i] == 1) leaves.add(i);
		}
		
		int n = g.length;
		while(n>2){
			int l = leaves.size();
			for (int i = 0; i < l; i++) {
				int leave = leaves.remove(0);
				deg[leave] = 0;
				n--;
				for (Integer ne : g[leave]) {
					deg[ne]--;
					if(deg[ne]==1) leaves.add(ne);
				}
			}
			radius++;
		}
		
		if(leaves.size()>1){
			center1 = leaves.remove(0);
			center2 = leaves.remove(0);
			diameter = 2*radius-1;
		}
		else {
			center1=center2=leaves.remove(0);
			diameter = 2*radius;
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> g[] = new ArrayList[7];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(1);
		g[1].add(0);
		g[1].add(2);
		g[1].add(5);
		g[2].add(1);
		g[2].add(3);
		g[3].add(2);
		g[3].add(4);
		g[4].add(3);
		g[5].add(1);
		g[6].add(5);
		FireAlgo f = new FireAlgo(g);
		System.out.println(f.center1);
		System.out.println(f.center2);
		System.out.println(f.radius);
		System.out.println(f.diameter);
	}
}
