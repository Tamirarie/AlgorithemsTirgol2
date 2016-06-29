
public class DisjointSets {
	int[] parent,rank;
	public DisjointSets(int size) {
		parent = new int[size];
		rank = new int [size];
	}
	
	public void makeSet(int x){
		parent[x] = x;
		rank[x] = 0;
	}
	
	public int find(int x){
		if(x!=parent[x]) x = find(parent[x]);
		return parent[x];
	}
	
	public boolean union(int x, int y){
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot!=yRoot){
			if(rank[xRoot] < rank[yRoot]) parent[xRoot] = yRoot;
			else if(rank[xRoot] > rank[yRoot]) parent[yRoot] = xRoot;
			else{
				parent[yRoot] = xRoot;
				rank[xRoot]++;
			}
			return true;
		}
		
		
		return false;
	}
	
}
