

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_B2_방배정 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int room = 0;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[7][2];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			map[grade][gender]++;
		}

		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				room += map[i][j] % K == 0 ? map[i][j] / K : map[i][j] / K + 1;
			}
		}
		System.out.println(room);
	}
}
