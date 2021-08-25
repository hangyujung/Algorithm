

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge{
	int s, d, w;
	Edge(int s,int d, int w){
		this.s=s;
		this.d=d;
		this.w=w;
	}
}
public class BOJ_G5_최단경로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점 갯수
		int E = Integer.parseInt(st.nextToken()); //간선 갯수
		int start = Integer.parseInt(br.readLine());
		final int INFINITY = Integer.MAX_VALUE;
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Edge[] edge_arr =new Edge[E+1];
	
		for(int e=1;e<=E;e++) {
			st= new StringTokenizer(br.readLine());
			edge_arr[e]=new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		int min=0, current=0;
		for(int i=1; i<=V; ++i){
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=1; j<=V; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true; // 선택 정점 방문 처리
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=1; c<=E; ++c){
				if(!visited[edge_arr[c].d] && current == edge_arr[c].s && distance[edge_arr[c].d] > min+edge_arr[c].w){
					distance[edge_arr[c].d] = min+edge_arr[c].w;
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(distance[i]==INFINITY) System.out.println("INF");
			else System.out.println(distance[i]);
		}
		
	}
}
