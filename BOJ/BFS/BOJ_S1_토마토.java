package day0813;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S1_토마토 {
	static ArrayList<int[]> tomato = new ArrayList<>();
	static int[][] map;
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visited;
	static int R,C,day;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					tomato.add(new int[] { r, c });
				}
			}
		}

		bfs();
		sb.append(search());
		System.out.println(sb);

	}


	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for(int[] to : tomato) {
			q.add(to);
		}
		while(!q.isEmpty()) {              // 토마토가 여러개일 때 병렬적으로 처리가 안됨
			int[] temp=q.poll();
			
			for(int d=0;d<4;d++) {
				int nr = temp[0]+ vector[d][0];
				int nc = temp[1]+ vector[d][1];
				if(isIn(nr,nc)&&map[nr][nc]==0&&!visited[nr][nc]) {
					map[nr][nc] = map[temp[0]][temp[1]]+1;
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			day++;
		}
	}
	private static int search() {
		int max=0;
		for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, map[i][j]);
            }
        }
		return max-1;
		//System.out.println(max - 1);
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
