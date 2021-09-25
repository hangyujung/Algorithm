package week9_3;
import java.util.Scanner;

public class JO_1681_해밀턴순환회로 {
	static int N;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] map;

	public static void dfs(int startX, int idx, int cost) {
		
		if ( cost >= answer) {
			return;
		}
		if ( idx == N-1) {
			if ( map[startX][0] !=0 ) {
				answer = Math.min(answer, cost + map[startX][0]);
			}
			return;	
		}
		
		for( int i=1; i<N; i++) {
			if ( map[startX][i] != 0 && !visited[i]) { 
				visited[i] = true; 
				dfs(i, idx+1, map[startX][i] + cost);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0, 0);

		System.out.println(answer);

	}
}
