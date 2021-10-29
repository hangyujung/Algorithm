package day1004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//시간제한: 초

class Point{
    int r;
    int c;
    int step;
    boolean chance;

    public Point(int i, int j, int step, boolean d) {
        this.r = i;
        this.c = j;
        this.step = step;
        this.chance = d;
    }
}

public class BOJ_G4_벽부수고이동하기 {
	static int[][] map;
	static ArrayList<int[]> walls = new ArrayList<>();
	static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R,C;
	private static int step;
	private static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		

		for (int n = 0; n < R; n++) {
			String line = br.readLine();
			for (int m = 0; m < C; m++) {
				map[n][m] = line.charAt(m) - '0';
			}
		}
		//bfs 시작 
		
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,1,true));
		boolean[][][] visited = new boolean[R][C][2];
		boolean flag=false;
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			 if (temp.r == R - 1 && temp.c == C - 1) {
	                System.out.println(temp.step);
	                return;
	            }
			for(int d=0;d<4;d++) {
				int nr = temp.r + vector[d][0];
				int nc = temp.c + vector[d][1];
					
				if(isIn(nr,nc)&&map[nr][nc]==0) {
					if(temp.chance && !visited[nr][nc][0]) {
						q.add(new Point(nr,nc,temp.step+1,true));
						visited[nr][nc][0]=true;
					}
					else if(!temp.chance && !visited[nr][nc][1]) {
						q.add(new Point(nr,nc,temp.step+1,false));
						visited[nr][nc][1]=true;
					}
				}
				else if(isIn(nr,nc)&& map[nr][nc]==1) {
					if(temp.chance) {
						q.add(new Point(nr,nc,temp.step+1,false));
					}
				}
			
			}
		}
		System.out.println("-1");
		
	}
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}


