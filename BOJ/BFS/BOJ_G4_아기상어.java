
import java.io.*;
import java.util.*;

public class BOJ_G4_아기상어 {
    private static int[][] map;
    private static int sharkR,sharkC,sharkCount;
    private static int sharkSize=2;
    private static int N, answer,sec;
    static int[][] vector = {{-1,0},{0,-1},{0,1},{1,0}};
    static PriorityQueue<int[]> fishes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int r=0;r<N;r++) {
            st= new StringTokenizer(br.readLine());
            for(int c=0;c<N;c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c]==9) {
                    sharkR=r;
                    sharkC=c;
                    map[r][c]=0;
                }
            }
        }

        while(true) {
            if(!bfs(sharkR,sharkC)) break;
            else{
                int[] final_fish = fishes.poll();
                map[final_fish[0]][final_fish[1]]=0;
                answer+=sec;
                sharkCount++;
                if(sharkCount==sharkSize) {
                    sharkCount=0;
                    sharkSize++;
                }
                sharkR= final_fish[0];
                sharkC= final_fish[1];
            }
        }
        System.out.println(answer);

    }
    private static boolean bfs(int sr, int sc) {
        fishes = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {sr,sc});
        boolean[][] visited = new boolean[N][N];
        visited[sr][sc] = true;
        sec=0;
        boolean flag=false;
        label: while(!que.isEmpty()) {
            int size= que.size();
            for(int i=0;i<size;i++) {

                int[] temp = que.poll();

                if(map[temp[0]][temp[1]]<sharkSize && map[temp[0]][temp[1]]!=0) {  //가본게 먹을수 있는 생선이다
                    fishes.add(new int[]{temp[0],temp[1]});
                    flag=true;

                }

                for(int d=0;d<4;d++) {
                    int nr = temp[0]+vector[d][0];
                    int nc = temp[1]+vector[d][1];

                    if(nr>=0&&nr<N&&nc>=0&&nc<N&&!visited[nr][nc]&&map[nr][nc]<=sharkSize) {
                        visited[nr][nc] = true;
                        que.add(new int[] {nr,nc});
                    }
                }
            }
            if(flag) break label;
            sec++;
        }
        return flag;
    }
}

