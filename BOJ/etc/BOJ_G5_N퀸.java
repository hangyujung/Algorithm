

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G5_N퀸 {
	private static int[] arr;
	private static int N,answer;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int r=1;r<=N;r++) {
			arr[1]=r;
			dfs(1);
		}
		System.out.println(answer);
	}

	private static void dfs(int c) {
		if(c==N) {
			answer++;
			return;
		}
		
		for(int r=1;r<=N;r++) {
			arr[c+1]=r;
			if(isOk(arr,c+1)) {				
				dfs(c+1);
			}
		}
			
		
	}

	private static boolean isOk(int[] arr, int c) {
		for(int i=1;i<c;i++) {
			if(arr[i] == arr[c]) return false;
			if(Math.abs(i-c) == Math.abs(arr[i]-arr[c])) return false;
		}
		
		return true;
	}

}
