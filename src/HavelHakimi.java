import java.util.Arrays;

public class HavelHakimi {
	
	public static boolean isTree(int deg[]){
		int sum = 0,n = deg.length;
		for (int i = 0; i < deg.length; i++) {
			sum+=deg[i];
			if(deg[i] == 0) return false;
		}
		if(2*n-2 != sum) return false;
		return isGraph(deg);
	}
	
	public static boolean isGraph(int deg[]){
		int sum=0,n=deg.length;
		for (int i = 0; i < deg.length; i++) {
			sum+=deg[i];
		}
		if(sum % 2 != 0) return false;
		Arrays.sort(deg);
		for (int i = n-1 ; i >= 0; i--) {
			int d = deg[i];
			if(i-d<0) return false;
			deg[i] = 0;
			for (int j = i-1; j >= i-d; j--) {
				if(deg[j]==0) return false;
				deg[j]--;
			}
			if(i!=0)
			Arrays.sort(deg, 0, i-1);
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		int deg[] = {1,2,1};
		System.out.println(isTree(deg));
	}
}
