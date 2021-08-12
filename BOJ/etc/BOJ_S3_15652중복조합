package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_15652 {
	static int N,R;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		answer = new int[R];
		
		con_com(0,0);
		System.out.println(sb);
	}
	private static void con_com(int count, int start) {
		
		if(count==R) {
			for(int data: answer) {
				sb.append(data+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start;i<N;i++) {
			
			answer[count]=i+1;
			con_com(count+1,i);
		}
	}
}
