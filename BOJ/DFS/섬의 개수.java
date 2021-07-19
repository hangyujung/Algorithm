import java.util.Scanner;
public class Main {
	static int[][] arr;
	static boolean[][] visit;
	static int w, h;
	
	private static int dfs(int x, int y) {
		int[] dx = {0, 0, 1, -1, -1, 1, -1, 1}, dy = {1, -1, 0, 0, -1, 1, 1, -1};
		
		visit[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int xx = dx[i] + x, yy = dy[i] + y;
			if(xx > 0 && yy > 0 && xx <= h && yy <= w) {
				if(arr[xx][yy] == 1 && !visit[xx][yy]) dfs(xx, yy);
			}
		}		
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int cnt = 0;
			w = scan.nextInt(); h = scan.nextInt();
			if(w == 0 && h == 0) break;
			
			arr = new int[h+1][w+1]; visit = new boolean[h+1][w+1];
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) arr[i][j] = scan.nextInt(); 
			}
			
			for(int i = 1; i <= h; i++) {
				for(int j = 1; j <= w; j++) {
					if(arr[i][j] == 1 && !visit[i][j]) cnt += dfs(i, j);
				}
			}
			System.out.println(cnt);
		}
	}
}
