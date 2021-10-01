package week9_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간제한: 초
public class SWAE_모의역량테스트_탈주범검거 {
	private static int[][] map;
	private static int L;
	private static int C;
	private static int R;
	private static int count;

	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			int mR = Integer.parseInt(st.nextToken());
			int mC = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			bfs(mR, mC);
			sb.append("#" + t + " " + count + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		boolean[][] visited = new boolean[R][C];
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				count++;

				ArrayList<Integer> dirList = new ArrayList<>();
				int[] temp = q.poll();
				int tr = temp[0];
				int tc = temp[1];

				switch (map[tr][tc]) {
				case 1:
					dirList.add(0);
					dirList.add(1);
					dirList.add(2);
					dirList.add(3);
					break;
				case 2:
					dirList.add(0);
					dirList.add(1);
					break;
				case 3:
					dirList.add(2);
					dirList.add(3);
					break;
				case 4:
					dirList.add(0);
					dirList.add(3);
					break;
				case 5:
					dirList.add(1);
					dirList.add(3);
					break;
				case 6:
					dirList.add(1);
					dirList.add(2);
					break;
				case 7:
					dirList.add(0);
					dirList.add(2);
					break;
				}
				for (int d : dirList) {
					int nr = tr + vector[d][0];
					int nc = tc + vector[d][1];
					if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] > 0) {
						q.add(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
			depth++;
			if (depth == L) {
				return;
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
