
public class Best {

	int max,start,end,arr[];

	public Best(int arr[]) {
		this.arr = arr;
		algo();
	}

	private void algo() {
		max = getFirstPos();
		start = getFirstPos();
		end = start;
		int tempBegin = start,sum = arr[max];
		for (int i = tempBegin+1; i < arr.length; i++) {
			sum+=arr[i];
			if(sum<=0){
				sum = 0;
				tempBegin = i+1;
			}
			else if(sum > max){
				max = sum;
				start = tempBegin;
				end = i;
			}
		}

	}

	private int getFirstPos() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) return i;
		}
		return 0;
	}

	public static boolean gasStationProb(int gasStations[],int gasPrices[]){
		int dif [] = new int[gasPrices.length];
		for (int i = 0; i < dif.length; i++) {
			dif[i] = gasStations[i] - gasPrices[i];
		}

		int best [] = getBestSum(dif);
		int sum = 0;
		for (int i = 0; i < dif.length; i++) {
			sum+= dif[(best[1]+i)%dif.length];
			if(sum < 0) return false;
		}

		return true;
	}

	private static int[] getBestSum(int[] dif) {
		int negDif[] = new int[dif.length];
		int sum = 0;
		int len = dif.length;
		for (int i = 0; i < negDif.length; i++) {
			sum+=dif[i];
			negDif[i] = dif[i]*-1;
		}

		Best bDif = new Best(dif);
		Best bNegDif = new Best(negDif);

		if(bDif.max < 0 || bDif.max >= sum + bNegDif.max) return new int [] {bDif.max,bDif.start,bDif.end};
		return new int [] {sum+bNegDif.max,bNegDif.end%len,bNegDif.start-1};
	}


	public static void main(String[] args) {
		int gasStations[] = {1,4,3,7,2,4,8};
		int gasPrices[] = {3,5,2,1,4,3,9};
		System.out.println(gasStationProb(gasStations, gasPrices));
		Best b = new Best(gasStations);
		System.out.println(b.max);
	}
}
