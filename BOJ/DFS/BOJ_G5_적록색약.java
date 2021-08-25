

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_G5_적록색약 {
	private static char[][] maps;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int count1=0, count2=0;
		N = Integer.parseInt(br.readLine());
		maps = new char[N][N];
		visited = new boolean[N][N];
		for (int n = 0; n < N; n++) {
			maps[n] = br.readLine().toCharArray();
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					count1++;
					dfs(r, c, maps[r][c]);
				}
			}
		}
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					count2++;
					dfs2(r, c, maps[r][c]);
				}
			}
		}
		System.out.println(count1+" "+count2);
	}

	private static void dfs2(int r, int c, char color) {
		visited[r][c]=true;

		for (int d = 0; d < vector.length; d++) {
			int nr = r + vector[d][0];
			int nc = c + vector[d][1];
				if ((color =='R' || color=='G') && isIn(nr, nc) && !visited[nr][nc] && (maps[nr][nc] == 'R' || maps[nr][nc]=='G')) {
					dfs2(nr, nc, color);
				}
				else if ( color=='B' && isIn(nr,nc) && !visited[nr][nc]&& maps[nr][nc]=='B') {
					dfs2(nr,nc,color);
				}
		}
		
	}

	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int N;

	private static void dfs(int r, int c, char color) {
		
		visited[r][c]=true;

		for (int d = 0; d < vector.length; d++) {
			int nr = r + vector[d][0];
			int nc = c + vector[d][1];
			if (isIn(nr, nc) && !visited[nr][nc] && maps[nr][nc] == color) {
				dfs(nr, nc, color);
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
