import java.io.*;
import java.util.*;

public class BOJ_G4_스타트택시 {
    static int N, step;
    static int[][] map;
    static int[][] vector = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int number = 2;   //짝수 시작위치 홀수는 도착위치
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            int dR = Integer.parseInt(st.nextToken());
            int dC = Integer.parseInt(st.nextToken());
            map[sR][sC] = number;
            number++;
            map[dR][dC] = number;
        }
        int count =0;
        while (true) {
            count++;
            //가까운 사람 찾을떄까지
            Queue<int[]> que = new LinkedList<>();
            que.add(new int[]{startR, startC});
            boolean[][] visited = new boolean[N][N];
            visited[startR][startC] = true;
            step = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });
            while (!que.isEmpty()) {
                boolean flag = false;
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    int[] temp = que.poll();
                    int temp_r = temp[0];
                    int temp_c = temp[1];

                    if (map[temp_r][temp_c] > 1 && map[temp_r][temp_c] % 2 == 0) {
                        pq.offer(new int[]{temp_r, temp_c});
                        flag = true;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = temp_r + vector[d][0];
                        int nc = temp_c + vector[d][1];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != 1) {
                            que.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }

                }
                if (flag) break;
                step++;
            }
            //
            int selectedR = pq.poll()[0];
            int selectedC = pq.poll()[1];
            fuel -= step;
            if(fuel<0){
                System.out.println("-1");
                System.exit(0);
            }

            //선택된 사람시작위치에서 도착지까지 bfs로 최단거리 구하기
            que = new LinkedList<>();
            que.offer(new int[]{selectedR, selectedC});
            visited = new boolean[N][N];
            visited[selectedR][selectedC] = true;


            int step = 0;
            label: while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    int[] temp = que.poll();

                    if (temp[0] >=0 && temp[0] < N && temp[1] >= 0 && temp[1] < N && (map[temp[0]][temp[1]] == map[selectedR][selectedC] + 1)){
                        break label;
                    }

                    for (int d = 0; d < 4; d++) {
                        int nr = temp[0] + vector[d][0];
                        int nc = temp[1] + vector[d][1];

                        if(nr >=0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc]!=1){
                            pq.offer(new int[]{nr,nc});
                            visited[nr][nc] =true;
                        }
                    }
                }

                step++;
            }

            fuel-=step;
            if(fuel<0){
                System.out.println("-1");
                System.exit(0);
            }
            fuel+= step*2;

            if(M==count) break;

        }
        System.out.println(fuel);

    }

}