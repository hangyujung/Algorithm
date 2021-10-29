


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S2_소수구하기 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[end+1];
		for(int i=2;i<=end;i++) {
			if(dp[i]==0) {
				if(i>=start) System.out.println(i);
				int x = i;
				while(x<=end) {
					dp[x]=1;
					x+=i;
				}
			}
		}
		
		
	}
}
