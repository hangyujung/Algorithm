package week9_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int weight;

	Edge(int s, int e, int w) {
		this.start = s;
		this.end = e;
		this.weight = w;
	}

	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class SWEA_D4_최소스패닝트리 {
	private static int[] no1s;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			long answer=0;
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			no1s = new int[V + 1];
			Edge[] edgeList = new Edge[E];
			for (int i = 1; i <= V; i++) {
				no1s[i] = i;
			}
			for(int e=0;e<E;e++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[e]= new Edge(start,end,weight);
			}
			Arrays.sort(edgeList);
			for(int e=0;e<E;e++) {
				if(find(edgeList[e].start)!=find(edgeList[e].end)) {
					union(edgeList[e].start,edgeList[e].end);
					answer += edgeList[e].weight;
				}
			}
			sb.append("#"+(t+1)+" "+answer+"\n");
		}
		System.out.println(sb);
	}

	private static void union(int a, int b) {
		no1s[find(b)]=no1s[find(a)];
	}

	private static int find(int a) {
		if(a==no1s[a]) return a;
		return no1s[a]=find(no1s[a]);
	}
}
