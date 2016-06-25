package BottleProblem;

import java.util.Arrays;

public class BottleProblem {
	
	int mat[][];
	String Paths[][];
	int n,m,size;
	int inf = Integer.MAX_VALUE;
	public BottleProblem(int n, int m) {
		this.n = n;
		this.m = m;
		this.size = (n+1)*(m+1);
		
		init();
	}
	
	private void init() {
		mat = new int[size][size];
		Paths = new String[size][size];
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], inf);
			Arrays.fill(Paths[i], "");
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				
				setPath(i,j,i,0);
				setPath(i,j,0,j);
				
				setPath(i,j,i,m);
				setPath(i,j,n,j);
				
				setPath(i,j,Math.max(i+j-m, 0),Math.min(i+j, m));
				setPath(i,j,Math.min(i+j, n),Math.max(i+j-n, 0));
			}
		}
		FW();
		for (int i = 0; i < mat.length; i++) mat[i][i] = 0;
		
	}

	private void FW() {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(mat[i][k]!=inf && mat[k][j]!=inf && mat[i][j] > mat[i][k]+mat[k][j])
					{
						mat[i][j] = mat[i][k] + mat[k][j];
						Paths[i][j] = Paths[i][k] + Paths[k][j];
					}
				}
			}
		}
		
	}

	private void setPath(int i1, int j1, int i2, int j2) {
		int from = getIndex(i1, j1);
		int to = getIndex(i2, j2);
		if(from==to) return;
		mat[from][to] = 1;
		Paths[from][to] = "->("+i2+","+j2+")";
		
	}
	private int getIndex(int i,int j){
		return (m+1)*i+j;
	}
	public static int [][] bottleProb(int n,int m){
		BottleProblem b = new BottleProblem(n, m);
		return b.mat;
	}
	
	public static void main(String[] args) {
		BottleProblem b = new BottleProblem(2, 1);
		int mat[][] = bottleProb(2, 1);
		System.out.println(numOfEdges(2,1));
		System.out.println(b.getPath(2,1));
		printMat(mat);
	}

	private String getPath(int n, int m) {
		if(mat[getIndex(0, 0)][getIndex(n, m)] == -1 ) return null;
		return "(0,0)"+Paths[getIndex(0, 0)][getIndex(n, m)];
	}

	private static int numOfEdges(int n, int m) {
		BottleProblem b = new BottleProblem(n, m);
		int count = 0;
		for (int i = 0; i < b.mat.length; i++) {
			for (int j = 0; j < b.mat[0].length; j++) {
				if(b.mat[i][j] == 1) count++;
			}
		}
		return count;
	}

	private static void printMat(int[][] mat2) {
		for (int i = 0; i < mat2.length; i++) {
			System.out.println(Arrays.toString(mat2[i]));
		}
		
	}
}
