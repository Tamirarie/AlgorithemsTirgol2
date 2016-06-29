import java.util.Arrays;

public class BottleProblem {
	
	String paths[][];
	int mat[][],n,m;
	int size;
	final int inf = Integer.MAX_VALUE;
	int numOfDirE;
	public BottleProblem(int n, int m) {
		this.n = n;
		this.m = m;
		this.size = (n+1)*(m+1);
		initMat();
	}
	
	
	private void initMat() {
		mat = new int[size][size];
		paths = new String[size][size];
		numOfDirE = 0;
		
		for (int i = 0; i < mat.length; i++) {
			Arrays.fill(mat[i], inf);
			Arrays.fill(paths[i], "");
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				setPath(i,j,0,j);
				setPath(i,j,i,0);
				setPath(i,j,n,j);
				setPath(i,j,i,m);
				
				setPath(i,j,Math.max(0,  i -(m-j)), Math.min(i+j, m));
				setPath(i,j,Math.min(i+j,n), Math.max(0, j -(n-i)));
				
			}
		}
		
		for (int i = 0; i < mat.length; i++)mat[i][i] = 0;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1) numOfDirE++;
			}
		}
		FW();
		
	}


	private void FW() {
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(mat[i][k] != inf && mat[k][j] != inf && mat[i][j] > mat[i][k]+mat[k][j]){
						mat[i][j] = mat[i][k] + mat[k][j];
						paths[i][j] = paths[i][k] + paths[k][j];
					}
				}
			}
		}
		
	}


	private void setPath(int i1, int j1, int i2, int j2) {
		int from = getIndex(i1,j1);
		int to = getIndex(i2, j2);
		if(from==to) return;
		mat[from][to] = 1;
		paths[from][to] = "->("+i2+","+ j2+")";
		
	}

	public String getPath(int i,int j){
		if(mat[getIndex(0, 0)][getIndex(i, j)] == inf) return "";
		return "(0,0)"+paths[getIndex(0, 0)][getIndex(i, j)];
	}

	private int getIndex(int i, int j) {
		return (m+1)*i + j;
	}


	public static void main(String[] args) {
		BottleProblem  b = new BottleProblem(2, 1);
		System.out.println(b.getPath(1, 1));
	}
} 
