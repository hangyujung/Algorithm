

import java.util.*;
import java.io.*;

public class BOJ_S2_소가길을건너간이유5 {

	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int disorder = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N+1];
		for(int d=0;d<disorder;d++) {
			arr[Integer.parseInt(br.readLine())] =true;
		}
		
		int MinFixCount=0;
		
		for(int i=1;i<K+1;i++) {
			if(arr[i]) MinFixCount++;
		}
		
		int tempCount= MinFixCount;
		
		for(int i=2;i<=arr.length-K;i++) {
			if(arr[i-1]) tempCount--;
			if(arr[i+K-1]) tempCount++;
			
			MinFixCount=Math.min(tempCount, MinFixCount);
		}
		System.out.println(MinFixCount);

	}
}
