package week9_4;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

//시간제한: 초
public class SWEA_D4_키순서 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int answer=0;
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			ArrayList<ArrayList<Integer>> list2 = new ArrayList<>(); 
			for(int n=0;n<=N;n++) {
				list.add(new ArrayList<Integer>());
				list2.add(new ArrayList<Integer>());
			}
			for(int m=0;m<M;m++) {
				st= new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.get(start).add(end);
				list2.get(end).add(start);
			}
			
			for(int n=1;n<=N;n++) {
				int count=0;
				Queue<Integer> que = new LinkedList<Integer>();
				Queue<Integer> que2 = new LinkedList<Integer>();
				boolean[] visited = new boolean[N+1];
				que.add(n);
				que2.add(n);
				while(!que.isEmpty()) {
					int temp = que.poll();
					for(int son:list.get(temp)) {
						if(!visited[son]) {
							que.add(son);
							count++;
							visited[son]=true;
						}
					}
				}
				Arrays.fill(visited, false);
				while(!que2.isEmpty()) {
					int temp = que2.poll();
					for(int son:list2.get(temp)) {
						if(!visited[son]) {
							que2.add(son);
							count++;
							visited[son]=true;
						}
					}
				}
				if(count==N-1) answer++;
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
		
	}
}
