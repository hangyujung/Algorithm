package day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15650 {
	static int N,R;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		answer = new int[R];
		
		combination(0,0);
		System.out.println(sb);
	}
	private static void combination(int start_idx, int count) {
		
		if(count==R) {
			for(int data: answer) {
				sb.append(data+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start_idx;i<N;i++) {
			
			answer[count]=i+1;
			combination(i+1,count+1);
		}
	}
}
