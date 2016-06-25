package Kruskal;

import java.util.Arrays;

public class Kruskal {
	
	Edge[] Tree,graph;
	int numOfVert;
	DisjointSets set;
	int sizeTree;
	private int sumTree;
	public Kruskal(Edge[] ed) {
		this.graph = ed;
		Arrays.sort(graph);
		numOfVertecis();
		Tree = new Edge[numOfVert-1];
		set = new DisjointSets(numOfVert);
		for (int i = 0; i < numOfVert; i++) {
			set.makeSet(i);
		}
		makeMST();
	}
	
	private void makeMST() {
		int i = 0;sizeTree = 0;
		while(i < graph.length && sizeTree <numOfVert-1){
			if(set.union(graph[i].v1, graph[i].v2)){
				Tree[sizeTree++] = graph[i];
				sumTree+= graph[i].weight;
			}
			i++;
		}
		
	}

	private void numOfVertecis() {
		numOfVert=0;
		for (int i = 0; i < graph.length; i++) {
			if(graph[i].v1 > numOfVert) numOfVert = graph[i].v1;
			if(graph[i].v2 > numOfVert) numOfVert = graph[i].v2;
		}
		numOfVert++;
		
	}

	public static void main(String[] args) {
		Edge e1 = new Edge(0, 1, 19);
		Edge e2 = new Edge(0, 2, 6);
		Edge e3 = new Edge(0, 6, 25);
		Edge e4 = new Edge(1, 4, 9);
		Edge e5 = new Edge(2, 5, 17);
		Edge e6 = new Edge(2, 6, 11);
		Edge e7 = new Edge(3, 4, 14);
		Edge e8 = new Edge(3, 6, 2);
		Edge e9 = new Edge(3, 7, 21);
		Edge e10 = new Edge(5, 6, 8);
		Edge edges [] = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10};
		Edge ans[] = buildTree(edges);
		System.out.println(Arrays.toString(ans));
		
	}

	private static Edge[] buildTree(Edge[] ed) {
		Kruskal k = new Kruskal(ed);
		System.out.println(k.sumTree);
		return k.Tree;
	}
}
