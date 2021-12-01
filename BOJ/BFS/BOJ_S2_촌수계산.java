package M12W1;
import java.io.*;
import java.util.*;

public class BOJ_S2_촌수계산 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		
		ArrayList<ArrayList<Integer>> list  = new ArrayList<>(); 
		for(int i=0;i<N+1;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		
		int relation = Integer.parseInt(br.readLine());
		for(int r=0;r<relation;r++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.get(s).add(e);
			list.get(e).add(s);
		}
		Queue<Integer> que = new LinkedList<Integer>(); 
		que.add(start);
		boolean[] visited = new boolean[N+1];
		int depth=0;
		while(!que.isEmpty()) {
			int size  = que.size();
			for(int i =0;i<size;i++) {
				int temp = que.poll();
				if(temp==end) {
					System.out.println(depth);
					System.exit(0);
				}
				for(int data:list.get(temp)) {
					if(!visited[data]) {
						que.add(data);
						visited[data] =true;
					}
				}
			}
			depth++;
		}
		System.out.println(-1);
	}
}
