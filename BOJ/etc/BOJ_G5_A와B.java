

import java.io.*;
import java.util.*;

//시간제한
public class BOJ_G5_A와B {
	static StringBuilder T;
	private static String S;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		S = br.readLine();
		T = new StringBuilder();
		T.append(br.readLine());
		dfs(T);
		System.out.println("0");
	}

	private static void dfs(StringBuilder t) {
		if(t.toString().equals(S)) {
			System.out.println(1);
			System.exit(0);

		if(t.length()==0) return;
		
		
		if(t.charAt(t.length()-1)=='A') {
			//StringBuilder temp = new StringBuilder();
			//temp.append(t);
			t.setLength(t.length()-1);
			dfs(t);
		}
		else if(t.charAt(t.length()-1)=='B') {
			t.setLength(t.length()-1);
			t.reverse();
			dfs(t);
		}
		
	}
}

