

import java.io.*;
import java.util.*;

public class BOJ_S2_로또 {
	private static int arr[];
	private static int[] answer;
	private static int N;

	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) break;
			answer = new int[6];
			arr = new int[N];
			for(int n=0;n<N;n++) {
				arr[n]=Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			System.out.println();
		}
		
	}

	private static void combination(int start,int count) {
		if(count==6) {
			for(int i=0;i<6;i++) {
				System.out.print(answer[i]);
				if(i!=5) System.out.print(" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++) {
			answer[count]=arr[i];
			combination(i+1, count+1);
		}
		
	}
}
