package Best;

import java.util.Arrays;

public class BestArr {
	
	public static int [] bestArr(int arr[]){
		int firstPos = getFirstPos(arr);
		int max = arr[firstPos],sum=max;
		int tempBegin = firstPos;
		int iStart=tempBegin,iEnd=tempBegin;
		int len = arr.length;
		for (int i = tempBegin+1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				sum=0;
				tempBegin = i+1;
			}
			else if(sum>max){
				max = sum;
				iStart = tempBegin;
				iEnd = i;
				len = iEnd - iStart+1;
			}
			else if(sum==max){
				if(i - tempBegin + 1 <len){
					len = i - tempBegin + 1;
					iStart = tempBegin;
					iEnd = i;
				}
			}
		}
		
		
		return new int [] {max,iStart,iEnd,len};
	}
	
	private static int getFirstPos(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,-3,0,3};
		System.out.println(Arrays.toString(bestArr(arr)));
	}
}
