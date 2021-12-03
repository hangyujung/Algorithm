package M12W1;

import java.io.*;
import java.util.*;

public class SWEA_D4_동철이의일분배 {
	private static int[][] maps;
	private static boolean[] visited_cols;
	private static int N;
	static double max;
	
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			maps = new int[N][N];
			max=0.0;
			for(int r=0;r<N;r++) {
				st= new StringTokenizer(br.readLine());
				for(int c=0;c<N;c++) {
					maps[r][c]= Integer.parseInt(st.nextToken());
				}
			}
			
			for(int c=0;c<N;c++) {
				visited_cols = new boolean[N];
				visited_cols[c]=true;
				dfs(0,c,maps[0][c]*0.01);
			}
			max*=100;
			String num = String.format("%.6f", max);
			sb.append("#"+t+" "+num+"\n");
			
		}
			System.out.println(sb);
		
	}

	private static void dfs(int r, int c, double total) {
		if(r==N-1) {
			if(max<total)max=total;
			return;
		}
		
		if(total<=max)return;
		for(int next_C=0;next_C<N;next_C++) {
			if(!visited_cols[next_C]) {
//				if( total*maps[r+1][next_C]*0.01 < max ) continue;
				visited_cols[next_C] = true;
				dfs(r+1,next_C,total*maps[r+1][next_C]*0.01);
 				visited_cols[next_C] =false;
			}
		}
		
		
	}
}