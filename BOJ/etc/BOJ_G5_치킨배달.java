package day0813;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_G5_치킨배달 {
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[][] visited;
	static int N, min = Integer.MAX_VALUE, distance, real_distance=Integer.MAX_VALUE,real_sum;
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<int[]> chicken = new ArrayList<>();
	static int[][] answer;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		int limit = Integer.parseInt(st.nextToken());
		answer = new int[limit][2];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 2) {
					chicken.add(new int[] { r, c });
					map[r][c] = 0;
				} else
					map[r][c] = num;
			}
		}

		com(0, 0);
		sb.append(min);
		System.out.println(sb);

	}

	private static void com(int count, int start) {
		if (count == answer.length) {

			for (int i = 0; i < answer.length; i++) {
				map[answer[i][0]][answer[i][1]] = 2;
			}
			distance = 0;
			real_sum=0;
			getCityDistance();
			
			min = Math.min(real_sum, min);
			for (int i = 0; i < answer.length; i++) {
				map[answer[i][0]][answer[i][1]] = 0;
			}
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			answer[count][0] = chicken.get(i)[0];
			answer[count][1] = chicken.get(i)[1];
			com(count + 1, i + 1);
		}
	}

	private static void getCityDistance() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
//					visited = new boolean[N][N];
					real_distance = Integer.MAX_VALUE;
					for(int k=0;k <answer.length;k++) {
						distance = Math.abs(i - answer[k][0]) + Math.abs(j - answer[k][1]);	
						real_distance = Math.min(distance, real_distance);
					}
					real_sum+=real_distance;
				
						//bfs(i, j);
				}
			}
		}
	}
}
