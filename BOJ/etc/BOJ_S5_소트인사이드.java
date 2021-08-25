


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//시간제한: 초
public class BOJ_S5_소트인사이드 {
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] carr = br.readLine().toCharArray();
		
		Arrays.sort(carr);
		
		for(char c : carr) {
			sb.insert(0, c);
		}
		System.out.println(sb);
	}
	
}
