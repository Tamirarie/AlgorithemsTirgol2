package Best;

import java.util.Arrays;

public class BestCycle {
	
	public static int [] bestCycle(int arr[]){
		int neg[] = new int[arr.length];
		int sum=0;
		for (int i = 0; i < neg.length; i++) {
			sum+=arr[i];
			neg[i]=arr[i]*-1;
		}
		int best[] = best(arr);
		int negBest[] = best(neg);
		if(best[0]>=sum+negBest[0]) return best;
		return new int []{sum+negBest[0],negBest[2]%arr.length+1,negBest[1]-1};

	}
	
	public static int [] best(int arr[]){
		
		int max = arr[0], sum = max;
		int tempBegin = 0,iStart=-1,iEnd=-1,len = arr.length;
		for (int i = tempBegin+1; i < arr.length; i++) {
			sum+= arr[i];
			if(sum<=0){
				tempBegin = i+1;
				sum = 0;
			}
			else if(sum > max){
				max = sum;
				len = i-tempBegin+1;
				iStart = tempBegin;
				iEnd = i;
			}
			else if(len>i-tempBegin+1){
				len = i-tempBegin+1;
				iStart = tempBegin;
				iEnd = i;
				
			}
		}
		
		return new int[]{max,iStart,iEnd,len};
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,-9,3};
		System.out.println(Arrays.toString(bestCycle(arr)));
	}
}
