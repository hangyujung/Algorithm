

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_S2_DFS와BFS {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		arr=new ArrayList[N+1];
		for(int n=1;n<=N;n++) {
			arr[n]=new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int m=0;m<M;m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		for(int n=1;n<=N;n++) {
			Collections.sort(arr[n]);
		}
		
		dfs(start);
		visited = new boolean[N+1];
		sb.append("\n");
		bfs(start);
		System.out.println(sb);
	}
	private static void dfs(int n) {
		visited[n] = true;
		sb.append(n+" ");
		for(int data: arr[n]) {
			if(!visited[data]) {
				dfs(data);
			}
		}
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp=q.poll();
			sb.append(temp+" ");
			for(int data:arr[temp]) {
				if(!visited[data]) {
					q.add(data);
					visited[data]=true;
				}
			}
		}
	}
}
