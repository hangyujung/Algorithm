import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int [][] arr;
	public static boolean [][] visited;
	public static ArrayList<Integer> list;
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		arr = new int[size][size];
		visited = new boolean[size][size];
		int max_inarr=0;
		for(int i = 0 ; i < size ; i ++) {
			for(int j = 0 ; j < size ; j++) {
				arr[i][j] =sc.nextInt();
				if(max_inarr < arr[i][j])
					max_inarr = arr[i][j];
			}
		}
		
		list = new ArrayList<>();
		
		
        
    
        for(int depth = 0 ; depth<= max_inarr ; depth++) {
        	int cnt = 0;
	        for(int i = 0 ; i < size ; i ++) {
	        	for(int j = 0 ; j < size ; j++) {
	        		if(arr[i][j] > depth && !visited[i][j]) {
	        			cnt++; //dfs 부를때마다 영역 수가 증가함
	        			dfs(i,j, depth);
	        			
	        		}
	        	}
	        }
	        for(boolean a[]: visited)
	        	Arrays.fill(a, false);
	        list.add(cnt);
        }
        
        int max = Collections.max(list);
		System.out.println(max);
	}	
	
	public static void dfs(int x, int y, int depth) {
		visited[x][y] = true;
		
		for(int i = 0 ; i < 4 ; i ++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
    			if(arr[nx][ny] > depth && !visited[nx][ny])
    				dfs(nx,ny, depth);
    		}
    	}
	}
}
