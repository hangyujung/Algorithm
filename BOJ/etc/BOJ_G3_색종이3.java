


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_G3_색종이3 {
	private static int[][] map;
	static int size = 100;
	static int max = 0;
	static int answer;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		map = new int[100][100];
		int answer=100;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					map[r][c] = 1;
				}
			}
		}
//		for(int d[]:map) {
//			System.out.println(Arrays.toString(d));
//		}
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] == 1) {
					answer=Math.max(answer, find(r,c));
				}
			}
		}
		System.out.println(answer);
	}
//
//	private static void calc(int r, int c, int check_vert, int check_para) {
//		for (int rr = r; rr < check_vert; rr++) {
//			for (int cc = c; cc < check_para; cc++) {
//				max = Math.max(sum(r, c, rr, cc), max);
//			}
//		}
//	}

	private static int sum(int r, int c, int rr, int cc) {
		int cnt=0;
		for (int i = r; i < rr; i++) {
			for (int j = c; j < cc; j++) {
				if (map[i][j] == 1)
					cnt++;
				else
					return 0;
			}
		}
		return cnt;
	}

	private static int find(int x, int y) {
		int ans = 100;
		for (int i = 0; i <= 100; i++) {
			if (x + i > 100)break;
			for (int j = 0; j <= 100; j++) {
				if (y + j > 100)break;
				ans = Math.max(ans, sum(x, y, x + i, y + j));
			}
		}
		return ans;
	 
	}

//	private static int check_para(int r, int c) {
//		int para_count = c;
//		while (++c < size && map[r][c] != 0) {
//			para_count++;
//		}
//		return para_count;
//	}
//
//	private static int check_vert(int r, int c) {
//		int vert_count = r;
//		while (++r < size && map[r][c] != 0) {
//			vert_count++;
//		}
//		return vert_count;
//	}
}
