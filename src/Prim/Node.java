package Prim;

public class Node implements Comparable<Node>{
	int id,weight;
	public Node(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return ((Integer)weight).compareTo((Integer)o.weight);
	}
}
