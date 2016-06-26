package Prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import javax.swing.text.GapContent;

import Kruskal.Edge;

public class Prim {
	public final int WHITE = 0, GRAY = 1, BLACK = 2, inf = Integer.MAX_VALUE;
	int[] pred,color,weight;
	ArrayList<Node>[] g;
	Edge tree[];
	int sumTree;
	
	public Prim(ArrayList<Node>[] g,int root) {
		int n = g.length;
		this.g = g;
		tree = new Edge[n-1];
		pred = new int[n];
		color = new int[n];
		weight = new int[n];
		Arrays.fill(pred, -1);
		Arrays.fill(weight, inf);
		MakeMST(root);
		buildTree();
	}

	private void buildTree() {
		int treeSize = 0;
		for (int i = 0; i < g.length; i++) {
			if(pred[i]!=-1){
				tree[treeSize++] = new Edge(i, pred[i], weight[i]);
				sumTree+=weight[i];
			}
		}
	}

	private void MakeMST(int root) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(root, 0));
		color[root] = GRAY;
		weight[root] = 0;
		while(!q.isEmpty()){
			Node v = q.poll();
			int v_id = v.id;
			for (Node n : g[v_id]) {
				if(color[n.id] == WHITE){
					color[n.id] = GRAY;
					pred[n.id] = v_id;
					weight[n.id] = n.weight;
					q.add(new Node(n.id,n.weight));
				}
				else if(color[n.id] == GRAY){
					if(weight[n.id] > n.weight){
						pred[n.id] = v_id;
						weight[n.id] = n.weight;
					}
				}
			}
			color[v_id] = BLACK;
		}
		
	}
	
	public static void main(String[] args) {
		ArrayList<Node> g [] = initGraph();
		System.out.println(Arrays.toString(getTree(g)));
	}
	private static Edge[] getTree(ArrayList<Node>[] g) {
		Prim p = new Prim(g, 0);
		System.out.println(p.sumTree);
		return p.tree;
	}

	public static ArrayList<Node>[] initGraph(){
		ArrayList<Node>[] g = new ArrayList[5];
		for (int i = 0; i < g.length; i++) {
			g[i] = new ArrayList<>();
		}
		g[0].add(new Node(1,4));
		g[0].add(new Node(4,5));
		
		g[1].add(new Node(0,4));
		g[1].add(new Node(2,3));
		g[1].add(new Node(3,6));
		g[1].add(new Node(4,1));
		
		g[2].add(new Node(1,3));
		g[2].add(new Node(3,6));
		g[2].add(new Node(4,2));
		
		g[3].add(new Node(1,6));
		g[3].add(new Node(2,6));
		g[3].add(new Node(4,7));

		g[4].add(new Node(0,5));
		g[4].add(new Node(1,1));
		g[4].add(new Node(2,2));
		g[4].add(new Node(3,7));

		return g;
	}
}
