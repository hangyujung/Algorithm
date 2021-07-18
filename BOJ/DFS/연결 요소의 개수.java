import java.util.*;
 
public class Main {
    
    static int spots, nodes, cnt;
    static boolean visits[];
    static boolean map[][];
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        
        spots = sc.nextInt();
        nodes = sc.nextInt();
        visits = new boolean[spots+1];
        map = new boolean[spots+1][spots+1];
        cnt = 0;
        for (int i=1; i<=nodes; i++) {
            int tmp1 = sc.nextInt();
            int tmp2 = sc.nextInt();
            
            map[tmp1][tmp2] = true;
            map[tmp2][tmp1] = true;
            
        }
        
        for(int i=1; i<=spots; i++) {
            if (!visits[i]) {
                dfs(i);
                cnt++;
            }
        }
        
        System.out.println(cnt);
        
    }
    
    private static void dfs(int start) {
        visits[start]=true;
        
        for(int i=1; i<=spots; i++) {
            if (map[start][i] && !visits[i]) {
                dfs(i);
            }
        }
    }
}
 
