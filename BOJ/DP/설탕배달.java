import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<5) {
            if(n==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, 9999);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[n] > 9999) {
            System.out.println(-1);
        }else {
            System.out.println(dp[n]);
        }
    }
}
