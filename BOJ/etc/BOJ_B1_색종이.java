

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_B1_색종이 {
	private static int[][] map;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int answer[] = new int[N+1];
 		map = new int[1001][1001];
		for(int n=1;n<=N;n++) {
			st= new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			for(int rr=r;rr<r+h;rr++) {
				for(int cc=c;cc<c+w;cc++) {
					map[rr][cc] = n;
				}
			}
		}
		for(int n=1;n<=N;n++) {
			for(int r=0;r<1001;r++) {
				for(int c=0;c<1001;c++) {
					if(map[r][c] == n) {
						answer[n]++;
					}
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(answer[i]);
		}
	}
}
