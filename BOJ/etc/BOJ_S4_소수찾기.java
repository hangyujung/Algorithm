

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_소수찾기 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int answer=0;
		st = new StringTokenizer(br.readLine());
		label: for(int n=0;n<N;n++) {
			int num=Integer.parseInt(st.nextToken());
			if(num==1) continue label;
			for(int i=2;i<num;i++) {
				if(num%i==0) continue label;
			}
			answer++;
		}
		
		System.out.println(answer);
		
	}
}	
