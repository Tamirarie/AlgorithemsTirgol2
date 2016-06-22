package Test2016moed1;

import java.util.Arrays;

public class Q3 {
	static int m;
	public static int numEdges(int p, int q){
		int size = (p+1)*(q+1);
		int count = 0;
		int inf = Integer.MAX_VALUE;
		int mat[][] = new int[size][size];
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], inf);
		}
		
		m = q;
		for (int i = 0; i <= p; i++) {
			for (int j = 0; j <= q; j++) {
				setPath(mat,i,j,0,j);
				setPath(mat,i,j,i,0);
				setPath(mat,i,j,i,q);
				setPath(mat,i,j,p,j);
				setPath(mat,i,j,Math.max(i+j-q, 0),Math.min(i+j, q));
				setPath(mat,i,j,Math.min(i+j,p),Math.max(i+j-p, 0));
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = 0;
		}
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) count++;
			}
		}
		return count;
	}
	private static void setPath(int[][] mat, int i1, int j1, int i2, int j2) {
		int from = getIndex(i1,j1);
		int to = getIndex(i2, j2);
		if(from==to) return;
		mat[from][to] = 1;
		
	}
	private static int getIndex(int i,int j) {
		return (m+1)*i+j;
	}
	public static void main(String[] args) {
		System.out.println(numEdges(2, 1));;
	}
}
