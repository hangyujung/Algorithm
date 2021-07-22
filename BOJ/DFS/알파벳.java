import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int r, c, max = 0;
	static char[][] arr;
	static boolean[] visit;
	
	private static void dfs(int x, int y, int d) {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}; // north, south, west, east
		
		visit[arr[x][y] - 'A'] = true;
		for(int i = 0; i < 4; i++) {
			int xx = x + dx[i], yy = y + dy[i];
			
			if(xx > 0 && yy > 0 && xx <= r && yy <= c) {
				if(!visit[arr[xx][yy] - 'A']) dfs(xx, yy, d + 1);
			}
		}
		visit[arr[x][y] - 'A'] = false;		
		max = Math.max(max, d);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split("\\s");
		r = Integer.parseInt(tmp[0]); c = Integer.parseInt(tmp[1]);
		arr = new char[r+1][c+1]; visit = new boolean[26];
		
		for(int i = 1; i <= r; i++) {
			String str = br.readLine();
			for(int j = 1; j <= c; j++) arr[i][j] = str.charAt(j-1);
		}
		dfs(1, 1, 1); System.out.print(max);
	}
}
