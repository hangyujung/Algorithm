


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_B2_열개씩끊어출력하기 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] carr= br.readLine().toCharArray();
		int i=0;
		while(i<carr.length) {
			sb.append(carr[i]);
			if((i+1)%10==0) sb.append("\n");
			i++;
		}
		System.out.println(sb);
		
		
	}
}
