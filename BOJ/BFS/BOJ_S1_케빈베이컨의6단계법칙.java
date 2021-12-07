package M12W1;

import java.io.*;
import java.util.*;

public class BOJ_S1_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Node=0,answer=Integer.MAX_VALUE;
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int n=0;n<=N;n++) {
			list.add(new ArrayList<>());
		}
		for(int p=0;p<P;p++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			list.get(s1).add(s2);
			list.get(s2).add(s1);
		}
		for(int i=1;i<=N;i++) {
			Queue<Integer> que = new LinkedList<>();
			que.add(i);
			boolean[] isVisited = new boolean[N+1];
			isVisited[i]=true;
			int depth=1;
			int sum=0;
			while(!que.isEmpty()) {
				int size= que.size();
				for(int s=0;s<size;s++) {
					int temp = que.poll();
					for(int data:list.get(temp)) {
						if(!isVisited[data]) {
							que.add(data);
//							System.out.println(data+"ㅇㅇ");
							isVisited[data]=true;
							sum+=depth;
						}
					}
				}
				depth++;
			}
//			System.out.println(sum+" :  케킨베이컨값");
			if(answer>sum) {
				answer=sum;
				Node=i;
			}
		}
		System.out.println(Node);
	}
}
