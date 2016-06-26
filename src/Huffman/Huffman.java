package Huffman;

import java.util.concurrent.ArrayBlockingQueue;

public class Huffman {
	
	final int weight = 0, left=1,right=2,parent=3;
	char chars[];
	int freq[];
	int Tree[][];
	String code[];
	ArrayBlockingQueue<Integer> q1,q2;
	int n;
	public Huffman(char chars[], int freq[]) {
		this.chars = chars;
		this.freq = freq;
		n = freq.length;
		code = new String[n];
		Tree = new int[2*n-1][4];
		q1 = new ArrayBlockingQueue<>(n);
		q2 = new ArrayBlockingQueue<>(n);
		for (int i = 0; i < freq.length; i++) {
			Tree[i][weight] = freq[i];
			q1.add(i);
		}
		buildTree();
		buildCode("",2*n-2);
	}
	
	private void buildTree() {
		int k = n;
		while(q1.size() + q2.size() > 1){
			int l = getMin();
			int r = getMin();
			Tree[l][parent] = k;
			Tree[r][parent] = k;
			Tree[k][weight] = Tree[l][weight] + Tree[r][weight];
			Tree[k][left] = l;
			Tree[k][right] = r;
			q2.add(k);
			k++;
			
		}
		
	}

	private int getMin() {
		if(q1.isEmpty() && q2.isEmpty()) return -1;
		if(q1.isEmpty()) return q2.poll();
		if(q2.isEmpty()) return q1.poll();
		if(Tree[q1.peek()][weight] > Tree[q2.peek()][weight]) return q2.poll();
		return q1.poll();
	}

	private void buildCode(String code, int i) {
		if(i<n){
			this.code[i] = code;
			return;
		}
		buildCode(code + "0", Tree[i][left]);
		buildCode(code + "1", Tree[i][right]);
	}
	public String getCode(){
		String ans = "";
		for (int i = 0; i < n; i++) {
			ans+= chars[i] + ":" + code[i]+"\n";
		}
		return ans;
	}

	public static void main(String[] args) {
		char chars[] = {'f','e','c','b','d','a'};
		int freq[] = {5,9,12,13,16,45};
		Huffman h = new Huffman(chars, freq);
		System.out.println(h.getCode());
		System.out.println();
	}
}
