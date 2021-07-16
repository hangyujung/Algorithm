import java.beans.Visibility;
import java.util.Scanner;

public class Main {

    static int[] dr= {-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static int m,n,baechu;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();



        for(int i=0;i<T;i++){
            m=scan.nextInt();
            n=scan.nextInt();
            baechu=scan.nextInt();


            arr= new int[m][n];
            visited = new boolean[m][n];

            for(int j=0;j<baechu;j++){
                int x= scan.nextInt();
                int y= scan.nextInt();
                arr[x][y]=1;
            }
            int count =0;

            for(int z=0;z<m;z++){
                for(int j=0;j<n;j++){
                    if(arr[z][j]==1 && !visited[z][j]){
                        count++;
                        dfs(z,j);
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void dfs(int r,int c){
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0&&nc>=0&&nr<m&&nc<n){
                if(arr[nr][nc]==1 && !visited[nr][nc]){
                    dfs(nr,nc);
                }
            }
        }
    }
}
