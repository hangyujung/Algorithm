
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Main {
    static int[][] vector = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer,N,answer2;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];
        char c;

        for (int i = 0; i < N; i++) {
            String str = scan.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        //맵 찍어보기
//        for(char[] carr:map){
//            System.out.println(Arrays.toString(carr));
//        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    c = map[i][j];
                    search(i,j,c);
                    answer++;
                }
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'G')	// 초록 -> 빨강으로 변경
                    map[i][j] = 'R';
            }
        }
        visited = new boolean[N][N];	// 방문표시 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]){
                    c = map[i][j];
                    search(i,j,c);
                    answer2++;
                }
            }
        }


        System.out.println(answer +" "+answer2);
    }
    public static void search(int x, int y, char c) {
        visited[x][y] = true;		// 현재 위치 방문체크

        for(int i=0; i<4; i++) { // 상하좌우 체크
            int nx = x + vector[i][0];
            int ny = y + vector[i][1];

            if(nx>=0 && nx<N && ny>=0 && ny<N && visited[nx][ny]==false && map[nx][ny]==c){
                search(nx,ny,c);
            }
        }
    }

}
