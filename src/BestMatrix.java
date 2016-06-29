import java.util.Arrays;

public class BestMatrix {

	int help[][],mat[][];
	int n,m;
	int max,iStart,iEnd,jStart,jEnd;
	public BestMatrix(int mat[][]) {
		this.n = mat.length;
		this.m = mat[0].length;
		this.mat = mat;
		initHelp();
		BestMatrixAlgo();
	}
	private void BestMatrixAlgo() {
		
		max = Integer.MIN_VALUE;
		for (int i1 = 0; i1 < mat.length; i1++) {
			for (int j1 = 0; j1 < mat[0].length; j1++) {
				for (int i2 = i1; i2 < mat.length; i2++) {
					for (int j2 = j1; j2 < mat[0].length; j2++) {
						int sum = help[i2+1][j2+1] - help[i2+1][j1] - help[i1][j2+1] + help[i1][j1];
						if(sum>max){
							max = sum;
							iStart = i1;
							iEnd = i2;
							jStart = j1;
							jEnd = j2;
						}
					}
				}
			}
		}
		
	}
	public int []getBest(){
		return new int []{max,iStart,iEnd,jStart,jEnd};
	}
	
	private void initHelp() {
		help = new int [n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			help[i+1][1] = help[i][1] + mat[i][0];
		}
		for (int i = 0; i < m; i++) {
			help[1][i+1] = help[1][i] + mat[0][i];
		}
		
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < m; j++) {
				help[i+1][j+1] = help[i+1][j] + help[i][j+1] - help[i][j] + mat[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		int m[][] = {
				{1,2,3},
				{-3,4,5},
				{-1,-2,-4}};
		BestMatrix b = new BestMatrix(m);
		System.out.println(Arrays.toString(b.getBest()));
	}
}
