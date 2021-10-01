package week9_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class SWEA_D4_보급로 {
	static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1} };
	private static int N;
	private static int[][] map;
	static int min;
	private static int[][] cost;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 4; t++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cost = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				String s = br.readLine();
				char[] carr = s.toCharArray();
				for (int c = 0; c < N; c++) {
					map[r][c] = carr[c] - '0';
					cost[r][c] = Integer.MAX_VALUE;
				}
			}
			cost[0][0] =0;
			dfs(0, 0, visited);
			sb.append("#" + t + " " + cost[N - 1][N - 1] + "\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int r, int c, boolean[][] visited) {
		if(cost[r][c]>=cost[N-1][N-1]) return;
		if (r == N - 1 && c == N - 1) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + vector[d][0];
			int nc = c + vector[d][1];
			if (isIn(nr, nc) && !visited[nr][nc] && cost[nr][nc] > cost[r][c] + map[nr][nc]) {
				visited[nr][nc] = true;
				cost[nr][nc] = map[nr][nc] + cost[r][c];
				dfs(nr, nc, visited);
				visited[nr][nc]=false;
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
