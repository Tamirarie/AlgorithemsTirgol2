package ReverseKruskal;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseKruskal {
	
	ArrayList <Edge> tree;
	Edge graph[];
	int sizeTree,sumTree;
	ArrayList<Integer> AL[];
	int numOfVert;
	public ReverseKruskal(Edge ed[]) {
		this.graph = ed;
		init();
		algo();
	}
	
	private void algo() {
		for (int i = 0; i < graph.length; i++) {
			int v1 = graph[i].v1;
			int v2 = graph[i].v2;
			AL[v1].remove((Integer)v2);
			AL[v2].remove((Integer)v1);
			BFS b = new BFS(AL);
			if(!b.checkGraph()){
				AL[v1].add(v2);
				AL[v2].add(v1);
			}
			else{
				tree.remove(graph[i]);
			}
		}
		
	}

	private void init() {
		numOfVert = 0;
		sizeTree=0;sumTree = 0;
		for (int i = 0; i < graph.length; i++) {
			if(graph[i].v1 > numOfVert) numOfVert = graph[i].v1;
			if(graph[i].v2 > numOfVert) numOfVert = graph[i].v2;
		}
		numOfVert++;
		tree = new ArrayList<>();
		
		AL = new ArrayList[numOfVert];
		for (int i = 0; i < AL.length; i++) {
			AL[i] = new ArrayList<>();
		}
		for (Edge ed : graph) {
			if(!AL[ed.v1].contains(ed.v2)){
				AL[ed.v1].add(ed.v2);
			}
			if(!AL[ed.v2].contains(ed.v1)){
				AL[ed.v2].add(ed.v1);
			}
		}
		
		
		for (int i = 0; i < graph.length; i++) {
			graph[i].weight = graph[i].weight *-1;
		}	
		Arrays.sort(graph);
		for (int i = 0; i < graph.length; i++) {
			graph[i].weight = graph[i].weight *-1;
		}
		
		for (Edge ed : graph) {
			tree.add(ed);
		}
		
	}
	public int getSumTree(){
		for (Edge ed : tree) {
			sumTree+= ed.weight;
		}
		return sumTree;
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
		ReverseKruskal k = new ReverseKruskal(edges);
		System.out.println((k.tree));
		System.out.println(k.getSumTree());
	}
}
