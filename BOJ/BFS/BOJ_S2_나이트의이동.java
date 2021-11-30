package M12W1;

import java.io.*;
import java.util.*;

public class BOJ_S2_나이트의이동 {
	static int[][] vector = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	public static void main(String[] args) throws IOException {
		//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] map = new boolean[N][N];
			Queue<int[]> que = new LinkedList<>();
			st= new StringTokenizer(br.readLine());
			int startR= Integer.parseInt(st.nextToken());
			int startC= Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			int endR= Integer.parseInt(st.nextToken());
			int endC= Integer.parseInt(st.nextToken());
			
			que.add(new int[] {startR,startC});
			int depth=0;
			label: while(!que.isEmpty()) {
				int size = que.size();
				for(int i=0;i<size;i++) {
					int[] temp = que.poll();
					int r= temp[0];
					int c= temp[1];
					
					if(r==endR&&c==endC) {
						System.out.println(depth);
						break label;
					}
					
					
					for(int d=0;d<8;d++) {
						int nr = r+vector[d][0]; 
						int nc = c+vector[d][1];
						if(nr>=0&&nr<N&&nc>=0&&nc<N&&!map[nr][nc]) {
							map[nr][nc] = true;
							que.add(new int[] {nr,nc});
						}
					}
					
				}
				depth++;
			}
			
		}
		
	}
}
