

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//시간제한: 초
class Edge2 implements Comparable<Edge2> {
	int end;
	int weight;

	public Edge2(int end, int weight) {
		super();
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge2 o) {
		return this.weight - o.weight;
	}

}

public class BOJ_G3_파티 {
	static ArrayList<ArrayList<Edge2>> list = new ArrayList<>();
	private static int N;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] answer = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for (int m = 0; m < M; m++) {
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.get(start).add(new Edge2(end, weight));
			
		}
		for(int n=1;n<=N;n++) {
			int sum=0;
			sum+=dijkstra(n,X);
			sum+=dijkstra(X,n);
			answer[n]=sum;
		}
		System.out.println(Arrays.toString(answer));
		Arrays.sort(answer);
		System.out.println(answer[N]);
	}
	private static int dijkstra(int n, int x) {
		
		int[] distances = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[n] = 0;
		PriorityQueue<Edge2> pq = new PriorityQueue<>();
		pq.offer(new Edge2(n, 0));
		while (!pq.isEmpty()) {
			Edge2 temp = pq.poll();
			if(visited[temp.end]) continue;
			visited[temp.end] = true;
			for(Edge2 next : list.get(temp.end)) {
				if(!visited[next.end] && distances[next.end]>distances[temp.end]+next.weight) {
					distances[next.end] = distances[temp.end]+next.weight;
					pq.offer(new Edge2(next.end, distances[next.end]));
				}
			}
		}
		System.out.println(Arrays.toString(distances));
		return distances[x];
	}
}
