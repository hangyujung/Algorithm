import java.io.*;
import java.util.*;

public class BOJ_G5_문자열게임2 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int answer =0;
        for (int r = 1; r <= s1.length(); r++) {
            char ch = s1.charAt(r - 1);
            for (int c = 1; c <= s2.length(); c++) {
                if (ch == s2.charAt(c - 1) ) {
                    dp[r][c] = dp[r-1][c-1]+1;
                    answer = Math.max(answer, dp[r][c]);
                }
            }
        }
        System.out.println(answer);
    }
}