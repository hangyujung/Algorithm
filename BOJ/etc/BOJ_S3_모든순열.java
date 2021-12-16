

import java.io.*;
import java.util.*;

public class BOJ_S3_모든순열 {
	private static int N;
	private static int[] answer;
	private static boolean[] selected;

	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		selected = new boolean[N+1];
		permutation(0);
		
	}

	private static void permutation(int cnt) {
		if(cnt==N) {
			for(int i=0;i<N;i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(selected[i]) continue;
			selected[i]=true;
			answer[cnt] = i;
			permutation(cnt+1);
			selected[i]=false;
		}
	}
}