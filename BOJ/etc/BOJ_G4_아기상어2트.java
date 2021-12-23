

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_G4_아기상어2트 {
    
    static class Node{
        int x,y,distance;
 
        public Node(int x, int y, int distance) {
            super();
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
        
    }
    
    static int [] dx = {-1,1,0,0}; //상 하 좌 우
    static int [] dy = {0,0,-1,1};
    
    static int N, shark_age, size=0, count=0, time=0;
    static int [][] map;
    static PriorityQueue<Node> feed = new PriorityQueue<>(new Comparator<Node>() {
        //가장 가깝고, 가장 위, 가장 왼쪽
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.distance==o2.distance) {
                if(o1.x==o2.x) return o1.y-o2.y;
                else return o1.x-o2.x;
            }
            return o1.distance-o2.distance;
        }
    });
    
    static Queue<Node> shark = new LinkedList<>();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9) {
                    shark.add(new Node(i,j,0));
                    map[i][j] = 0;
                }
            }
        }
        shark_age=2;
        findFeed();
 
    }
    
    public static void findFeed() {
        
        while(true) {
            
            boolean [][] visited = new boolean[N][N];
            
            while(!shark.isEmpty()) {
                Node temp = shark.poll();
                visited[temp.x][temp.y] = true;
                
                for(int i=0;i<4;i++) {
                    int nx = temp.x+dx[i];
                    int ny = temp.y+dy[i];
                    
                    if(range(nx,ny) && !visited[nx][ny]) {
                        if(0<map[nx][ny] && map[nx][ny]<7) {
                            if(map[nx][ny]<shark_age) {
                                feed.add(new Node(nx,ny,temp.distance+1));
                                shark.add(new Node(nx,ny,temp.distance+1));
                                visited[nx][ny]=true;
                            }
                            else if(map[nx][ny]==shark_age) {
                                shark.add(new Node(nx,ny,temp.distance+1));
                                visited[nx][ny]=true;
                            }
                        }
                        else if(map[nx][ny]==0) {
                            shark.add(new Node(nx,ny,temp.distance+1));
                            visited[nx][ny]=true;
                        }
                    }
                }
            }
            
            //가장 가까운 물고기 먹고
            if(!feed.isEmpty()) eat();
            else break;
        }
        System.out.println(time);
        
    }
    
    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
    
    public static void eat() {
        Node eat = feed.poll();
        
        count++;
        if(count==shark_age) {
            shark_age++;
            count=0;
        }
        
        shark.add(new Node(eat.x,eat.y,0));
        time+=eat.distance;
        map[eat.x][eat.y]=0;
        feed.clear();
    }
 
}
 
