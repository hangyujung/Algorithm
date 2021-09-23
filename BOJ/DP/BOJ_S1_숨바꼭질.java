


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S1_숨바꼭질 {
	private static int[] dp;
	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 		StringTokenizer st = new StringTokenizer(br.readLine());
 		N = Integer.parseInt(st.nextToken());
 		K = Integer.parseInt(st.nextToken());
 		dp = new int[100001];
 		bfs();
 		System.out.println(dp[K]);
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		dp[N] = 0;
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(K==temp) return;

			if(temp-1>=0  && dp[temp-1]==0) {
				dp[temp-1] = dp[temp]+1;
				que.add(temp-1);
			}
			if(temp+1<=100000 && dp[temp+1]==0) {
				dp[temp+1] = dp[temp]+1;
				que.add(temp+1);
			}
			if(2*temp<=100000 && dp[2*temp]==0) {
				dp[2*temp] = dp[temp]+1;
				que.add(2*temp);
			}
		}
	}
}
