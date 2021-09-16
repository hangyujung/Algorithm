package week9_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class SWEA_D3_최장증가부분수열 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			dp[0] = 1;
			for (int i = 1; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && dp[j] + 1 >= dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
			for (int data : dp) {
				answer = Math.max(data, answer);
			}
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

}
