package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_알파벳 {
	static char[][] map;
	static int R, C , max = Integer.MIN_VALUE;
	static String visited = "";
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		visited += map[0][0]; // String에 char 더하기 연산 가능하네?
		dfs(0, 0,1);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int count) {
		if(count>max) {
			max = count;
		}
		
		for(int d=0;d<4;d++) {
			int nr = r+vector[d][0];
			int nc = c+vector[d][1];
			if( isIn(nr,nc) && !visited.contains(Character.toString(map[nr][nc])) ) {
				visited+= map[nr][nc];
				dfs(nr,nc, count+1);
				visited=visited.substring(0,visited.length()-1);
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
