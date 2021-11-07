

import java.io.*;
import java.util.*;

	//시간제한
public class BOJ_S1_정수삼각형 {
	static int N;
	static int max;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		 
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=1;r<=N;r++) {
			for (int c = 1; c <= r; c++) {
				map[r][c] += Math.max(map[r-1][c-1], map[r-1][c]);
				max = Math.max(map[r][c],max);
			}
		}
		System.out.println(max);
	}
}


