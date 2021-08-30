


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S2_트리의부모찾기 {
//	private static boolean[][] map;
	static ArrayList<Integer>[] list;
	private static int[] answers;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		answers = new int[N+1];
//		map =new boolean [N+1][N+1];
		list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
		
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
//			map[a][b]=true;
//			map[b][a]=true;
		}
		
		
//		System.out.println(Arrays.toString(list));
		answers[1]=0;
		dfs(1);
		
		for(int i=2;i<N+1;i++) {
			System.out.println(answers[i]);
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		for(int data:list[start]) {
			if(!visited[data]) {
				answers[data]=start;
				dfs(data);
			}
		}
	}
}
