

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author 은서파
 * @since 2021. 8. 25.
 * @see https://www.acmicpc.net/problem/1753
 * @perf 108960	1912
 * @category #다익스트라, #인접리스트
 * @고려사항
 * @입력사항
 * @출력사항
 */


class Node  { 
	int end, weight;
	public Node(int end, int weight) {
		this.end = end; 
		this.weight = weight; 
	} 
	
}


public class BJ_G5_1753_최단경로_인접리스트 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tokens;

	static int V, E, K;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	

	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(br.readLine());
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());

		K = Integer.parseInt(br.readLine());

		//graph = new int[V + 1][V + 1];
		for(int i=0;i<=V;i++) {
			list.add(new ArrayList<>());
		}
		for (int e = 0; e < E; e++) {
			tokens = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			// 유향 그래프!!!
			//graph[u][v] = w;
			list.get(u).add( new Node(v, w) );
		}
		/*
		for(int [] row: graph) {
			System.out.println(Arrays.toString(row));
		}
		*/
		dijkstra();
	}

	private static void dijkstra() {
		// 필요한 요소 준비하기
		int[] dist = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		// 자원 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		// 모든 정점에 대해서..
		for (int v = 0; v < V; v++) {
			// 미방문인 지점 중 최소 비용인 곳은??
			int minV = 0;
			int minCost = Integer.MAX_VALUE;
			for (int i = 1; i <= V; i++) {
				if (!visited[i] && dist[i] < minCost) {
					minV = i;
					minCost = dist[i];
				}
			}

			// 그점 방문해보기
			visited[minV] = true;

			/*
			// 주변 정점들 탐색하기
			for (int c = 1; c <= V; c++) {
				// 미방문이고, 그래프에서 연결되어있고, 갱신 비용이 더 작다면...
				if (!visited[c] && graph[minV][c] > 0 && dist[c] > dist[minV] + graph[minV][c]) {
					dist[c] = dist[minV] + graph[minV][c];// 그렇다면 비용이 갱신된다.
				}
			}// for
			*/
			
			for(Node next : list.get(minV)) {
				if(!visited[next.end] && dist[next.end]>dist[minV]+next.weight) {
					dist[next.end] = dist[minV]+next.weight;
				}
			}

		}
		//System.out.println(Arrays.toString(dist));
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}

}
