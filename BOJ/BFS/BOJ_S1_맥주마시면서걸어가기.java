package week9_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S1_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] market = new int[N+2][2];
			for(int n=0;n<N+2;n++) {
				st= new StringTokenizer(br.readLine());
				market[n][0] = Integer.parseInt(st.nextToken()); 
				market[n][1] = Integer.parseInt(st.nextToken());
			}
			Queue<Integer> que = new LinkedList<>();
			que.add(0);
			boolean flag=false;
			boolean visited[] = new boolean[N+2];
			while(!que.isEmpty()) {
				int temp = que.poll();
				if(temp == N+1) flag=true;
				for(int i=1;i<N+2;i++) {
					if(!visited[i]&&isOk(market[temp][0],market[temp][1],market[i][0],market[i][1])) {
						visited[i]= true;
						que.add(i);
					}
				}
			}
			if(flag) System.out.println("happy");
			else System.out.println("sad");
		}
	}

	private static boolean isOk(int r1, int c1, int r2, int c2) {
		int distance = Math.abs(r2-r1)+Math.abs(c2-c1);
		if(distance>=0 && distance <=1000) return true;
		return false;
	}
}
