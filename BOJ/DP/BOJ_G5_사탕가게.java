

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_G5_사탕가게 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true) {
			st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = (int)(Double.parseDouble(st.nextToken())*100+0.5);
			if(N==0 && W ==0) {
				break;
			}
			int dp[][] = new int[N+1][W+1];
			int[][] things = new int[N+1][2];
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				things[n][0] =Integer.parseInt(st.nextToken()); // 칼로리
				things[n][1] = (int)(Double.parseDouble(st.nextToken())*100+0.5); // 돈
			}

			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < W + 1; j++) {
					if (things[i][1] > j)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][(int) (j - things[i][1])] + things[i][0]);
				}
			}

			System.out.println((int) dp[N][W]);
		}
	}
}
