package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_N과M {
	static int N,R;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		answer = new int[R];
		
		con_per(0);
		System.out.println(sb);
	}
	private static void con_per(int count) {
		
		if(count==R) {
			for(int data: answer) {
				sb.append(data+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			answer[count]=i+1;
			con_per(count+1);
		}
	}
}
