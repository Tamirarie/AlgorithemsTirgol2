package Best;

import java.util.Arrays;

public class BestMatrix {
	
	public static int [] bestMatrix(int mat[][]){
		int h[][] = buildHelp(mat);
		int iStart=-1,iEnd=-1,jStart=-1,jEnd=-1;
		int max = Integer.MIN_VALUE;
		int sizeMat = -1;
		for (int i1 = 0; i1 < mat.length; i1++) {
			for (int j1 = 0; j1 < mat[0].length; j1++) {
				for (int i2 = i1; i2 < mat.length; i2++) {
					for (int j2 = j1; j2 < mat[0].length; j2++) {
						int sum=h[i2+1][j2+1] - h[i2+1][j1] - h[i1][j2+1] + h[i1][j1];
						int currSize = (i2-i1+1)*(j2-j1+1);
						if(sum>max){
							max = sum;
							iStart = i1;
							iEnd = i2;
							jStart = j1;
							jEnd = j2;
							sizeMat = currSize;
						}
						if(sum==max){
							if(currSize<sizeMat){
								iStart = i1;
								iEnd = i2;
								jStart = j1;
								jEnd = j2;
								sizeMat = currSize;
							}
						}
					}
				}
			}
		}
		
		return new int[]{max,iStart,jStart,iEnd,jEnd,sizeMat};
	}
	
	private static int[][] buildHelp(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int h[][] = new int[n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			h[i+1][1] = h[i][1] + mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			h[1][i+1] = h[1][i] + mat[0][i];
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				h[i+1][j+1] = h[i+1][j] + h[i][j+1] - h[i][j] + mat[i][j];
			}
		}
		return h;
	}

	public static void main(String[] args) {
		int mat[][] = {{1,-40}
						,{2,-30}
						,{3,-40},
						{-50,6}};
		int[][] mat2 = {
				{1,5,4,-2,4},
				{8,2,-4,9,2},
				{-8,-2,1,1,1},
				{3,1,-5,2,2}
		};
		System.out.println(Arrays.toString(bestMatrix(mat)));
		System.out.println(Arrays.toString(bestMatrix(mat2)));
	}
}
