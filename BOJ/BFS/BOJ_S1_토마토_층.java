package m11w3;

import java.io.*;
import java.util.*;

//시간제한
public class BOJ_S1_토마토_층 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][][] map = new int[N][R][C];
		Queue<int[]> que = new LinkedList<int[]>();
		for (int n = 0; n < N; n++) {
			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[n][r][c] = Integer.parseInt(st.nextToken());
					if (map[n][r][c] == 1)
						que.add(new int[] { n, r, c });
				}
			}
		}
		
		int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		int[] updown = { -1, 1 };
		int day = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			boolean flag=false;
			for (int i = 0; i < size; i++) {
				int[] temp = que.poll();
				int n = temp[0];
				int r = temp[1];
				int c = temp[2];

				
				for (int d = 0; d < 4; d++) {
					int nr = r + vector[d][0];
					int nc = c + vector[d][1];
					if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[n][nr][nc]==0) {
						map[n][nr][nc] = 2;
						que.add(new int[] {n,nr,nc});
						flag=true;
					}
				}
				for(int e=0;e<2;e++) {
					int nu = n+updown[e];
					if(nu>=0&&nu<N&&map[nu][r][c]==0) {
						map[nu][r][c] = 2;
						que.add(new int[] {nu,r,c});
						flag=true;
					}
				}
			}
			if(flag) day++;
		}
		for(int n=0;n<N;n++) {
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					if(map[n][r][c]==0) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		System.out.println(day);

	}

}
