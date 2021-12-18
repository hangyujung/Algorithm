

import java.io.*;
import java.util.*;

public class BOJ_G5_테트로미노 {
	private static int[][] map;
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static boolean[][] visited;
	private static int R;
	private static int C;
	private static int answer;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				visited[r][c] = true;
				dfs(r, c, 0, map[r][c]);
				visited[r][c] = false;
				fuckyou(r, c, map[r][c]);
			}
		}
		System.out.println(answer);
	}

	private static void fuckyou(int r, int c, int sum) {
		// ㅗ , ㅜ , ㅏ , ㅓ
		if (c - 1 >= 0 && c + 1 < C && r - 1 >= 0)
			answer=Math.max(answer, map[r][c] + map[r - 1][c] + map[r][c - 1] + map[r][c + 1]);
		if (c - 1 >= 0 && c + 1 < C && r + 1 < R)
			answer=Math.max(answer, map[r][c] + map[r + 1][c] + map[r][c - 1] + map[r][c + 1]);
		if (c + 1 < C && r + 1 < R && r - 1 >= 0)
			answer=Math.max(answer, map[r][c] + map[r][c+1] + map[r+1][c ] + map[r-1][c ]);
		if (c - 1 >= 0 && r + 1 < R && r - 1 >= 0)
			answer=Math.max(answer, map[r][c] + map[r - 1][c] + map[r][c - 1] + map[r+1][c ]);

	}

	private static void dfs(int r, int c, int count, int sum) {
		if (count == 3) {
			answer = Math.max(sum, answer);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + vector[d][0];
			int nc = c + vector[d][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, count + 1, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}

	}
}