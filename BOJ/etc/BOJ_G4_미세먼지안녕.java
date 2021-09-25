

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간제한: 초
class Munji {
	int x;
	int y;
	int m;

	public Munji(int x, int y, int m) {
		this.x = x;
		this.y = y;
		this.m = m;
	}

}

public class BOJ_G4_미세먼지안녕 {
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int T;
	private static int C;
	private static int R;
	private static int[][] map;
	static Queue<Munji> que = new LinkedList<>();

	private static int machine;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		machine = 0;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == -1) {
					machine = r;
				}
			}
		}

		for (int t = 0; t < T; t++) {
			// 새 큐에다가 이동할수 있는 먼지들 저장한다.
			que.clear();
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] >= 5) {
						que.add(new Munji(r, c, map[r][c]));
					}
				}
			}
			// 먼지들을 이동시킨다
			moveMunji();
			breathe();
		}
		System.out.println(sum());
//		for(int arr[]:map) {
//			System.out.println(Arrays.toString(arr));
//		}
	}

	private static int sum() {
		int sum=0;
	
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] >0) {
					sum+=map[r][c];
				}
			}
		}
		return sum;
	}

	private static void breathe() {
		back(machine-1);
		forward(machine);

	}

	private static void forward(int r) {
		int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		int d = 0;
		r++;
		int c = 0;
		while(true) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			if (nr<machine||nr>=R||nc<0||nc>=C ) {
				d = (d + 1) % 4;
				nr = r + delta[d][0];
				nc = c + delta[d][1];
			}
			if(map[nr][nc]==-1) {
				map[r][c]=0;
				break;
			}
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
		}
		
	}

	private static void back(int r) {
		int delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		int d = 0;
		r--;
		int c = 0;
		while(true) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			if (nr<0||nr>=machine||nc<0||nc>=C ) {
				d = (d + 1) % 4;
				nr = r + delta[d][0];
				nc = c + delta[d][1];
			}
			if(map[nr][nc]==-1) {
				map[r][c]=0;
				break;
			}
			map[r][c] = map[nr][nc];
			r = nr;
			c = nc;
		}
	}

	private static void moveMunji() {

		while (!que.isEmpty()) {
			Munji temp = que.poll();
			int count = 0;
			int r = temp.x;
			int c = temp.y;
			int m = temp.m;
			for (int d = 0; d < 4; d++) {
				int nr = r + vector[d][0];
				int nc = c + vector[d][1];
				if (isIn(nr, nc) && map[nr][nc] != -1) {
					map[nr][nc] += m / 5;
					count++;
				}
			}
			map[r][c] -= m / 5 * count;
		}

	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
