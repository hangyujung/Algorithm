


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S1_구간합구하기5 {
	private static int[][] maps;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		maps = new int[N+1][N+1];
		dp = new int[N+1][N+1];
		for(int r=1;r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=N;c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = dp[r][c-1]+dp[r-1][c]-dp[r-1][c-1]+maps[r][c];
			}
		}
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(sum(x1,y1,x2,y2));
		}
		
	}

	private static int sum(int x1, int y1, int x2, int y2) {
		return dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
	}
}
